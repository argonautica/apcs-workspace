package shapes;

import processing.core.PApplet;

public abstract class Shape2D extends Shape {

	private boolean isFill;
	public Shape2D(int x, int y, boolean fill) {
		super(x, y);
		
		isFill = fill;
		// TODO Auto-generated constructor stub
	}

	@Override
	public  void draw(PApplet p) {
		
		super.draw(p);
		
	if (!isFill) {
	p.noFill();
	
		
	}
	}

	public abstract double getPerimeter();

	
	
	/**
	 * @return returns the area of the shape
	 */
	public abstract double getArea();

}
