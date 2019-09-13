package ivychang.demoshape;
import processing.core.PApplet;
import shapes.Circle;
import shapes.Line;
import shapes.Rectangle;

//FEEDBACK FOR SID (IS POINT INSIDE METHOD DOES NOT WORK FOR RECT)

/**
 * Circle has a gravity. If dropped on the box, it will stop. If dropped outside the window (400, 300) bounds, it will stop as well.
 * @author ivychang
 *
 */
public class DrawingSurface extends PApplet {
	private PhysicsShape shape;
	private Rectangle shape2;
	
	private final int SCREEN_WIDTH = 400, SCREEN_HEIGHT = 300;
	
	public DrawingSurface() {
		shape = new PhysicsShape(new Circle (200, 50, 25, 25, true));
		shape2 = new Rectangle(100, 100, 100, 50, true);
		
	}
	
	//The statement in the setup() function
	//execute once when the program begins
	public void setup() {
		
	}
	
	//The statement in the draw() function
	//are executed 60 times per second until the
	//program is stopped.
	public void draw() { 
		background(255);
		
		shape.draw(this);
		shape2.draw(this);
		
		
		if ((shape2.isPointInside(shape.getX(), shape.getY()))) 
		{
			shape.setVelocity(0, 0);
		}
		else if (!isInsideWidth(shape))
		{
			shape.setVelocity(0, shape.getYVelocity());
		}
		else if (!isInsideHeight(shape))
		{
			shape.setVelocity(shape.getXVelocity(), 0);
		}
		else
		{
			shape.act(); 
			
		}	
	}
	
	private boolean isInsideWidth(PhysicsShape s) {
		if (s.getX() < SCREEN_WIDTH && s.getX() > 0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	private boolean isInsideHeight(PhysicsShape s) {
		if (s.getY() < SCREEN_HEIGHT && s.getY() > 0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public void mouseDragged() {
		shape.move(super.mouseX, super.mouseY);
		shape.accelerate(0, super.mouseX * 0.0001);
	}
	
}

