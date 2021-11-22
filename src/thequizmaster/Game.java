package thequizmaster;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import thequizmaster.gamestates.GameState;
import thequizmaster.gamestates.MainGame;
import thequizmaster.gamestates.menus.MainMenu;
import thequizmaster.graphics.Screen;
import thequizmaster.input.Keyboard;

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

	public static Font digestFont;
	public static Font titleFont;

	public boolean printStats = false;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private BufferedImage HUDimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	private int[] HUDpixels = ((DataBufferInt) HUDimage.getRaster().getDataBuffer()).getData();
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		addKeyListener(key);
		gameState = new MainMenu(key);
		createFont();
	}

	private void createFont() {
		
        try {
        	digestFont = Font.createFont(Font.TRUETYPE_FONT, new File("course.otf")).deriveFont(20f);
			titleFont = Font.createFont(Font.TRUETYPE_FONT, new File("course.otf")).deriveFont(60f);
        } catch(IOException | FontFormatException e) {
        	System.out.println("Could not load custom font");
        }
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
				try {
					update();
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
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
	
	public void update() throws CloneNotSupportedException {
		if(gameState.startGame){
			gameState = new MainGame(key);
		}
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
		
		g.setColor(Color.WHITE);
		g.setFont(digestFont);
		
		if(printStats) {
			printStats(g);
		}

		if(gameState instanceof MainGame) {
			g.drawString(((MainGame) gameState).interactingMessage, 540, 520);
		}
		gameState.renderHUD(screen, g);
		
		for(int i = 0; i < pixels.length; i++){
			HUDpixels[i] = screen.getHUDPixels()[i];
		}
		
		g.drawImage(HUDimage, 0, 0, getWidth(), getHeight(), null);
		gameState.renderHUDTEXT(g);

		//graphics end
		g.dispose();
		bs.show();
	}
	
	public void printStats(Graphics g) {
		g.drawString("X: " + gameState.getPlayer().x + ", Y: " + gameState.getPlayer().y, 0, 20);
		g.drawString("XTILE: " + gameState.getPlayer().x / Constants.DEFAULT_SPRITE_SIZE + ", YTILE: " + gameState.getPlayer().y / Constants.DEFAULT_SPRITE_SIZE + "YDRAW: " + gameState.getPlayer().getDrawY(), 200, 20);
		g.drawString("Poison Rate: " + gameState.getPlayer().poisonRate + ", Poison Level: " + gameState.getPlayer().poisonLevel + ", Selection: " + gameState.getPlayer().playerSelection, 0, 40);
	}

	public void createNewGame(){
		this.gameState = new MainGame(key);
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
