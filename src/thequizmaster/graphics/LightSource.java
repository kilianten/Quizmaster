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
	
}
