package thequizmaster.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {

	public String path;
	public final int SIZE;
	public int[] pixels;

	// SpriteSheet
	public static SpriteSheet tileSheet = new SpriteSheet("/textures/tiles.png", 512);
	public static SpriteSheet douglasSheet = new SpriteSheet("/entities/douglas/douglas.png", 1280);
	public static SpriteSheet nolanSheet = new SpriteSheet("/entities/nolan/nolan.png", 1280);

	
	public SpriteSheet(String path, int size) {
		this.path = path;
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();
	}

	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResourceAsStream(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			System.out.println("Could not find Spritesheet at " + path);
		}
	}

}
