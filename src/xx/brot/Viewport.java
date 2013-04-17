package xx.brot;

import java.awt.Dimension;
import java.awt.Point;

import static xx.brot.NumberUtils.*;

public class Viewport {

	private double topX;
	private double topY;
	
	private double lowerX;
	private double lowerY;
	
	private boolean aspectRatio = false;

	public Viewport(Viewport clone) {
		topX = clone.topX;
		topY = clone.topY;
		lowerX = clone.lowerX;
		lowerY = clone.lowerY;
		aspectRatio = clone.aspectRatio;
	}
	
	public boolean isAspectRatio() {
		return aspectRatio;
	}

	public void setAspectRatio(boolean aspectRatio) {
		this.aspectRatio = aspectRatio;
	}

	public void move( double displX, double displY ) {
		topX += displX;
		topY += displY;
	}
	
	public void changeRect( double topX, double topY, double lowerX, double lowerY ) {
		this.topX = topX;
		this.topY = topY;
		this.lowerX = lowerX;
		this.lowerY = lowerY;
	}
	
	public Viewport(double topX, double topY, double lowerX, double lowerY) {
		super();
		this.topX = topX;
		this.topY = topY;
		this.lowerX = lowerX;
		this.lowerY = lowerY;
	}

	public Point convert(double x, double y, Dimension destinationDimension) {
		
		double alignedX = interpolate(x, topX, lowerX, 0, (double)destinationDimension.width);
		double alignedY = interpolate(y, topY, lowerY, 0, (double)destinationDimension.height);
		
		return new Point((int)alignedX, (int)alignedY);
	}
	
	public double convertX(Point p, Dimension fromDimension) {
		if(aspectRatio) {
			int side = Math.min(fromDimension.height, fromDimension.width);
			return interpolate(p.x, 0, side, topX, lowerX);
		} else {
			return interpolate(p.x, 0, fromDimension.width, topX, lowerX);
		}
	}

	public double convertY(Point p, Dimension fromDimension) {
		if(aspectRatio) {
			int side = Math.min(fromDimension.height, fromDimension.width);
			return interpolate(p.y, 0, side, topY, lowerY);
		} else {
			return interpolate(p.y, 0, fromDimension.height, topY, lowerY);
		}
		//return interpolate(p.y, 0, fromDimension.height, topY, lowerY);
	}

}
