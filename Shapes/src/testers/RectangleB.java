package testers;

import java.awt.geom.Point2D;

import processing.core.PApplet;
import shapes.Line;
import shapes.*;

/*
 * +1 very well documented 
 * 
 * -1 using multiple lines is useless
 * 
 * delta change to rect instead of line
 * 
 * 
 * 
 * 
 * 
 */
public class RectangleB {

	private Line left, right, top, bottom;
	
	// Constructors
	// Creates a default instance of a Rectangle object with all dimensions
	//   set to zero.
	public RectangleB() {
		left = new Line();
		right = new Line();
		top = new Line();
		bottom = new Line();
	}

	// Creates a new instance of a Rectangle object with the left and right
	// edges of the rectangle at x and x + width. The top and bottom edges
	// are at y and y + height.
	public RectangleB(double x, double y, double width, double height) {
	//	left = new Line(x,y+height,x,y);
		//right = new Line(x+width,y,x+width,y+height);
		//top = new Line(x,y,x+width,y);
		//bottom = new Line(x+width,y+height,x,y+height);
	}

	// Methods
	// Calculates and returns the perimeter of the rectangle
	public double getPerimeter() {
		return 2*(left.distance()+top.distance());
	}

	// Calculates and returns the area of the rectangle
	public double getArea() {
		return left.distance()*top.distance();
	}
	
	// Returns the center point of the rectangle
/*	public Point2D.Double getCenter() {
		return new Point2D.Double((top.getX1()+top.getX2())/2,(left.getY1()+left.getY2())/2);
	} */

	// Determines whether the point x,y is contained inside this rectangle
	
	
	/*public boolean isPointInside(double x, double y) {
		return (x >= left.getX1() && y >= top.getY1() && x <= right.getX1() && y <= bottom.getY1());
	} */

	// Draws a new instance of a Rectangle object with the left and right
	// edges of the rectangle at x and x + width. The top and bottom edges
	// are at y and y + height.
	public void draw(PApplet drawer) {
		left.draw(drawer);
		right.draw(drawer);
		top.draw(drawer);
		bottom.draw(drawer);
	}

	// Sets the coordinate of the bottom right corner of the Rectangle
	
	/*
	public void setBottomRight(double x, double y) {
		top.setX2(x);
		right.setX1(x);
		right.setX2(x);
		right.setY2(y);
		bottom.setX2(x);
		bottom.setY1(y);
		bottom.setY2(y);
		left.setY1(y);
	} */
	
	
	
}
