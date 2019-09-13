package shapes;

import processing.core.PApplet;

/*
 * +: Good method functionalities!
 * +: Nice class hierarchy(using shape 2d)
 * delta: Combine methods into one method for fill color and one for stroke color (setStrokeColor(R, G, B) and setFillColor(R, G, B))
 * 
 * other things mr. shelby mentioned: 
 * - javadoc comment at top of the class
 * - javadoc public method
 * 
 * other things that you may want to take into consideration:
 * - control whether shape is filled or not
 */
/**
 * @author skumar571
 * this is the superclass for all shapes
 *
 */
public abstract class Shape {

	/**
	 *  these are the x coordinate and the y coordinate of the first point of the shape
	 */
	protected double x, y;
	private int strokeweight;
	private int strokeR, strokeG, StrokeB;
	private int fillR, fillG, fillB;
	

	//

	/**
	 * @param p the papplet to be drawn in
	 */
	public void draw(PApplet p) {

		p.strokeWeight(strokeweight);
		p.fill(fillR, fillG, fillB);

		p.stroke(strokeR, strokeG, StrokeB);
	}

	/**
	 * @return returns the perimeter of the shape
	 */



	public void setStrokeColor(int r, int g, int b) {

		this.StrokeB = b;
		this.strokeR = r;
		this.strokeG = g;
	}

	public void setFillColor(int r, int g, int b) {

		this.fillB = b;
		this.fillG = g;
		this.fillR = r;
	}

	/**
	 * @param x the new x coordinate of the shape
	 * @param y the new y coordinate of the shape
	 * @post moves the coordinate of the shape to the new given
	 */
	public void move(double  x, double y) {

		this.x+= x;
		this.y += y;
	}

	/**
	 * @param x this is the x coordinate of the first point of the shape
	 * @param y this is the y coordinate of the first point of the shape
	 */
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
		this.strokeweight = 1;
		this.strokeR = 0;
		this.StrokeB = 0;
		this.strokeG = 0;
		this.fillB = 255;
		this.fillG = 255;
		this.fillR = 255;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getStrokeweight() {
		return strokeweight;
	}

	public void setStrokeweight(int strokeweight) {
		this.strokeweight = strokeweight;
	}

}
