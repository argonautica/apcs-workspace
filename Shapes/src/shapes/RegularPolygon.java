package shapes;

import processing.core.PApplet;
import shapes.*;
public class RegularPolygon extends Shape2D {
	
	
	
	private int numSides , midx, midy;
	private double sideLength, radiusInscribed, radiusCircumscribed;
	
	
	double angle;

	/**
	 * @param x the x coordinate 
	 * @param y the y coordinate 
	 * @param numSides the number of sides
	 * @param sideLength the length of each side
	 * @param fill 
	 */
	public RegularPolygon(int x, int y, int numSides, double sideLength, boolean fill) {
		
		super(x, y, fill);
		angle = 180.0 * (numSides - 2.0) / numSides;
		this.numSides = numSides;
		this.sideLength = sideLength;
		
		radiusCircumscribed = 1/2 * sideLength * 1/Math.tan(Math.PI / numSides);
		
		radiusInscribed = 1/2 * sideLength * 1/Math.sin(Math.PI / numSides);

		
	
		
		
		
		
		
		// TODO Auto-generated constructor stub
	}
	
	public void drawBoundingCircles( PApplet drawer) {
		
		
		//shapes.Circle a = new Circle((int ) (getX() + radius ), (int )( getY() + radius), radius, radius, false) ;
		
		
	}
	
	public void draw(PApplet p) {
		// TODO Auto-generated method stub
		
		
		//System.out.println( " the angle is i " + angle );
		super.draw(p);
		
		double tempx = getX() +radiusCircumscribed , tempy = getY() - radiusCircumscribed ;
		
		
	//	System.out.println(" the radius is  " + radius);
		
		double  tempAngle = 270;
for (int i = 0; i < numSides; i++) {
			Line a = new Line ((int ) tempx,  ( int )tempy , tempAngle, sideLength );
			//System.out.println(tempAngle + " angle " + i);
			
			a.draw(p);
			
			tempAngle = tempAngle - (180 - angle);
			
			tempx = a.getX2();
			tempy = a.getY2();
			
			
		}
		
	}
	
	/**
	 * @return returns the length of each side of the polygon
	 */
	public double getSideLength() {
		
		return sideLength;
	}
	
	
	/**
	 * @return returns the number of sides of the polygon
	 */
	public 	int getNumSides() {
		
		
		return numSides;
	}
	
 /**
 * @return returns the value of the radius 
 */
public double getRadiusInscribed() {
		return radiusInscribed;
	}

/**
 * @return returns the radius of the circumscribed circle
 */
public  double getRadiusCircumscribed() {
	return radiusCircumscribed;
}



	/* (non-Javadoc)
	 * @see shapes.Shape2D#getPerimeter()
	 */
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return sideLength * numSides;
	}

	/* (non-Javadoc)
	 * @see shapes.Shape2D#getArea()
	 */
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * @return returns the size of each vertex angle
	 */
	public double calcVertexAngle() {
		 return  360.0/ numSides;
		
	}

}
