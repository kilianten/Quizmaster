package thequizmaster;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;

import javax.swing.JFrame;

import thequizmaster.entity.mob.Player;
import thequizmaster.entity.mob.people.Douglas;
import thequizmaster.entity.mob.people.Nolan;
import thequizmaster.graphics.Screen;
import thequizmaster.graphics.LightSource;
import thequizmaster.input.Keyboard;
import thequizmaster.level.Level;
import thequizmaster.level.RandomLevel;
import thequizmaster.level.SpawnLevel;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static int width = 350;
	public static int height = width / 16 * 9;
	public static int scale = 4;
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;

	private Screen screen;
	private Keyboard key;
	private Level level;
	private Player player;
	private LightSource light;
	private ArrayList<Player> people;
	
	public boolean printStats = false;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		level = new SpawnLevel("/levels/level01.png");
		people = new ArrayList<Player>();
		addPeople();
		player = new Douglas(key);
		addKeyListener(key);
		light = new LightSource(500, player.x, player.y);
	}
	
	private void addPeople() {
		people.add(new Nolan(key));
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double delta = 0;
		int frames = 0;
		int updates = 0;

		requestFocus();
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / Constants.NANOSECONDS;
			lastTime = now;
			while (delta >= 1){
				update();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frame.setTitle(Constants.GAME_TITLE + "                   UPS: " + updates + " | FPS:" + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public void update() {
		key.update();
		player.update();
		if(key.slashPressed) {
			printStats = !printStats;
			key.slashPressed = false;
		}
		if(key.changePlayer) {
			swapPlayer();
			key.changePlayer = false;
		}
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		
		int xScroll = player.x - screen.width / 2;
		int yScroll = player.y - screen.height / 2;
		
		level.render(xScroll, yScroll, screen);
		for(Player person: people) {
			if(person.y < player.y) {
				person.render(screen);
			}
		}
		player.render(screen);
		for(Player person: people) {
			if(person.y >= player.y) {
				person.render(screen);
			}
		}

		for(int i = 0; i < pixels.length; i++){
			pixels[i] = screen.getPixels()[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);	
		screen.renderLight((Graphics2D) g, player.x, player.y);
		if(printStats) {
			printStats(g);
		}
		//graphics end
		g.dispose();
		bs.show();
	}
	
	public void printStats(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 20));
		g.drawString("X: " + player.x + ", Y: " + player.y, 0, 20);
	}
	
	public void swapPlayer() {
		people.add(player);
		player.resetSprite();
		player = people.get(0);
		people.remove(player);
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Constants.GAME_TITLE);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
}
