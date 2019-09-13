package sid.shapes;
import processing.core.PApplet;
import javax.swing.SwingUtilities;

import java.util.concurrent.TimeUnit;

import ivychang.shapes.*;

public class DrawingSurface extends PApplet {

	PhysicsShape s;

	PhysicsShape b;
	private Rectangle wind;
	private float scaleX;
	private float scaleY;

	public DrawingSurface() {
		s = new PhysicsShape(new Circle(90, 90, 25));
		
		
		
		
		
		//this.wind = new Rectangle(20, 20, 25, 25);
		this.b = new PhysicsShape( new Rectangle(20, 20, 25, 25));
		
		
		

	}

	// The statements in the setup() function
	// execute once when the program begins
	public void setup() {

	}

	public void draw() {

		background(255);

		// PhysicsShape a = new PhysicsShape( new Circle(90, 90, 20));

		// pushMatrix();

		// this.scaleX = (this.width / 800.0F);
		// this.scaleY = (this.height / 600.0F);

		// scale(this.scaleX, this.scaleY);
		
		this.b.draw(this);
		this.s.draw(this);

		// if (this.s != this.b) {
		//// this.s.act(this.wind);
		// }

		// s.act(wind);
		// popMatrix();

		// a.draw(this);
		// a.start(this);
		
		s.act();
		
		b.act();
	}

	public void mouseDragged() { // -------STEP 4------- (try dragging with the mouse after this step)
		int currentMouseX = super.mouseX;
		int currentMouseY = super.mouseY;

		int previousMouseX = super.pmouseX;
		int previousMouseY = super.pmouseY;

		int amountMovedX = currentMouseX - previousMouseX;
		int amountMovedY = currentMouseY - previousMouseY;

		// s.moveangle(1012.0 * Math.sqrt(2), 45);

		s.moveTo(currentMouseX, currentMouseY);
		

	

		// s.act(this.wind);

		// Use any of the values above to move around the PhysicsShape in some way
	}

	@SuppressWarnings("deprecation")
	public void mousePressed() {

		
		 
		  double mouseCoordX = this.mouseX ; double mouseCoordY =
		  this.mouseY; 
		  
		  if (mouseButton == RIGHT) 

		    {
		    
			  b.moveTo(super.mouseX, super.mouseY);
			  
			  
		    }
		      
		 
		 
		  
		 
	}
}