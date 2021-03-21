package thequizmaster.graphics;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;

import thequizmaster.Constants;

public class LightSource {
	
	private float radius;
	private int x, y;
	
	public LightSource(int radius, int x, int y) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public void render(Graphics2D g, int x, int y) {
		Point2D center = new Point2D.Float(x * 1, y);
		float[] distance = {0.0f, 1.0f};
		Color[] colors = {new Color(0.0f, 0.0f, 0.0f, 0.0f), Color.BLACK};
		RadialGradientPaint p = new RadialGradientPaint(center, radius, distance, colors);
		g.setPaint(p);
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .95f));
		g.fillRect(0, 0, Constants.screenWidth, Constants.screenWidth);
	}
}
