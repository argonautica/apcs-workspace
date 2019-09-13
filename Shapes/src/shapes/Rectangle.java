package shapes;
import processing.core.PApplet;
	
/**				
 * @author sid
 *
 */
public class Rectangle extends Shape2D {	
 //private int super.x;
 //private int super.y;

 private double width;
 private double height;	
	
	
	public Rectangle() {
		super(0,0, false);
		width = 0;
		height = 0;	
		
	}
	/**
	 * @param x this is the x coordinate of the top left corner of the  rectangle
	 * @param y this is the y coordinate of the top left corner of the rectangle
	 * @param width this is the width of the rectangle
	 * @param height this is the height of the rectangle
	 */
	public Rectangle(int x, int y, double width, double height, boolean fill) {
		
		super(x, y, fill);
		this.width = width;
		this.height = height;
		
	}
	
	/**
	 * @return returns the perimeter of the rectangle
	 */
	public double getPerimeter() {
		return (Math.abs(width) + Math.abs(height))*2;
	}
	/**
	 * @return returns the area of the rectangle
	 */
	public double getArea() {
		return Math.abs(width * height);
	}
	/**
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return true if the point is inside, false if isnt
	 */
	public boolean isPointInside(double x, double y) {
		
		if (x  <= Math.max(super.x, super.x + width ) && x >= Math.min(super.x, super.x + width) && y>= Math.min(super.y, super.y + width) && y<= Math.max(y, y + height)) {
			
			return true;
		} else return false;
	}
	
	/**
	 * @param marker this is the PApplet to draw in
	 */
	public void draw(PApplet  marker) {
		marker.noFill();
		
		marker.rect((float)super.x, (float)super.y,(float) width,(float) height);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
