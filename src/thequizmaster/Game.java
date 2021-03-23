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
import thequizmaster.gamestates.GameState;
import thequizmaster.gamestates.MainGame;
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
	private GameState gameState;
	
	public boolean printStats = false;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		addKeyListener(key);
		gameState = new MainGame(key);
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
		gameState.update();
		if(key.slashPressed) {
			printStats = !printStats;
			gameState.devMode = !gameState.devMode;
			key.slashPressed = false;
		}

	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		gameState.render(screen);
		
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = screen.getPixels()[i];
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);	
		
		if(gameState instanceof MainGame) {
			screen.renderLight((Graphics2D) g, gameState.getPlayer().x, gameState.getPlayer().y);
		}
		
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
		g.drawString("X: " + gameState.getPlayer().x + ", Y: " + gameState.getPlayer().y, 0, 20);
		g.drawString("XTILE: " + gameState.getPlayer().x / Constants.DEFAULT_SPRITE_SIZE + ", YTILE: " + gameState.getPlayer().y / Constants.DEFAULT_SPRITE_SIZE, 200, 20);
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
