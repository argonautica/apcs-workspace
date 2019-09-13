package shapes;

import java.awt.geom.Point2D;

import processing.core.PApplet;

/**
 * @author sid
 *
 */

public class Line extends Shape {

	private int x2;
	private int y2;

	public Line() {
		super(0, 0);
		setX2(0);
		setY2(0);
	}

	/**
	 * @param x1 x coordinate 1
	 * @param y1 y coordinate 1
	 * @param x2 x coordinate 2
	 * @param y2 y coordinate 2
	 */
	public Line(int x1, int y1, int x2, int y2) {
		super(x1, y1);
		this.setX2(x2);
		this.setY2(y2);
	}
	
	
	public Line ( int x1, int y1, double angle, double length) {
		
		super(x1, y1);
		
		
		
		
		this.setX2((int) (Math.sin(Math.toRadians(angle)) * length) + x1);
		this.setY2((int) (Math.cos(Math.toRadians(angle)) * length) + y1);

	}

	/**
	 * @param x1 x coordinate 1
	 * @param y1 y coordinate 1
	 */
	public void setPoint1(int x1, int y1) {
		super.setX(x1);
		super.setY(y1);
	}

	/**
	 * @param x2 x coordinate 2
	 * @param y2 y coordinate 2
	 */
	public void setPoint2(int x2, int y2) {
		this.setX2(x2);
		this.setY2(y2);
	}

	/**
	 * @return distance of line
	 */
	public double distance() {
		double xdif = getX2() - x;
		double ydif = getY2() - y;
		return Math.sqrt(xdif * xdif + ydif * ydif);
	}

	/**
	 * @param other the other line
	 * @return true if intersects, false if doesnt intersect
	 */
	public boolean intersects(Line other) {

		Point2D.Double hit = calculateIntersectionPoint(other);
		if (hit == null)
			return false;

		double bigX = Math.max(x, getX2());
		double bigX2 = Math.max(other.x, other.getX2());
		double upperX = Math.min(bigX, bigX2);

		double smallX = Math.min(x, getX2());
		double smallX2 = Math.min(other.x, other.getX2());
		double lowerX = Math.max(smallX, smallX2);

		double bigY = Math.max(y, getY2());
		double bigY2 = Math.max(other.y, other.getY2());
		double upperY = Math.min(bigY, bigY2);

		double smallY = Math.min(y, getY2());
		double smallY2 = Math.min(other.y, other.getY2());
		double lowerY = Math.max(smallY, smallY2);

		if (lowerX <= hit.x + 0.000001 && hit.x - 0.000001 <= upperX && lowerY <= hit.y + 0.000001
				&& hit.y - 0.000001 <= upperY)
			return true;
		else
			return false;

	}

	/**
	 * @param other the other line
	 * @return returns intersection point
	 */
	public Point2D.Double calculateIntersectionPoint(Line other) {

		double denom = (x - getX2()) * (other.y - other.getY2())
				- (y - getY2()) * (other.x - other.getX2());
		if (denom == 0)
			return null;

		double xHit = ((x * getY2() - y * getX2()) * (other.x - other.getX2())
				- (x - getX2()) * (other.x * other.getY2() - other.y * other.getX2())) / denom;
		double yHit = ((x * getY2() - y * getX2()) * (other.y - other.getY2())
				- (y - getY2()) * (other.x * other.getY2() - other.y * other.getX2())) / denom;

		return new Point2D.Double(xHit, yHit);

	}

	/**
	 * @param drawer papplet to draw in
	 * 
	 */
	public void draw(PApplet drawer) {
		
		super.draw(drawer);
		drawer.noFill();
		drawer.line((float) x, (float) y, (float) getX2(), (float) getY2());
	}

	

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
public double getLength() {
	return Math.sqrt(Math.pow(x - x2, 2)+ Math.pow(y- y2, 2));
	
}
}
