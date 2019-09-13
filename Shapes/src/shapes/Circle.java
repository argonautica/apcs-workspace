package shapes;
import processing.core.PApplet;

/**
 * @author sid
 *
 */
public class Circle extends Shape2D {
	private int width, height;

	public Circle() {
		super(0,0, false);
		this.width = 0;
		this.height = 0;

	}

	/**creates a circle given the various parameters
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * 
	 * @return creates a circle
	 */
	public Circle(int x, int y, int width, int height, boolean fill) {

		super(x,y, fill);
		this.width = width;

		this.height = height;
	}

/** draws the circle 
 * @param p papplet
 *
 */
public void draw(PApplet p) {
	
	
super.draw(p);
	p.ellipse((float)x, (float)y, (float)width, (float)height);
}



/** returns the area of the circle as a double
 * @return area returns the area of the circle
 */
public double getArea() {
	
	return width * width * Math.PI;
	
}


/** this function returns the circumference of the circle
 * @return returns the circumference of the circle
 */
public double getPerimeter() {
	return 2 * Math.PI * width;
}

/** this function returns the diameter of the circle
 * @return returns the diameter of the circle
 */
public double diameter() {
	return 2 * width;
}
/**
 * @return returns the area of the semicircle
 */
public double areaOfSemicircle() {
	return 1/2 * width * width * Math.PI;
}

/**
 * @return returns the perimeter of the semicircle
 */
public double perimeterOfSemicircle() {
	return Math.PI * width + width + width;
	}
}
