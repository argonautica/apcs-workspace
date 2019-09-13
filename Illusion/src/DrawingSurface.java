

import processing.core.PApplet;
import shapes.Circle;
import shapes.Rectangle;



public class DrawingSurface extends PApplet {

	public DrawingSurface() {
																									
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {

	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
noFill();


for (int i = 0; i < 25; i++) {
	
	
	 Circle c = new Circle(200, 150, i * 10, i * 10);
	 c.draw(this);
}

Rectangle d = new Rectangle(100, 50, 200	, 200);

d.draw(this);


		
	}
	
	

	
	
}










