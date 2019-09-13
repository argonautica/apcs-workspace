package ivychang.demoshape;
import processing.core.PApplet;
import shapes.*;

public class PhysicsShape {

	private Shape s;
	
	private double vx, vy;
	
	public PhysicsShape(Shape s) {
		this.s = s;
		this.vx = 0;
		this.vy = 0;
	}
	
	//Pass A Long Method
	public void draw(PApplet draw) {
		s.draw(draw);
	}
	
	//Pass A Long Method
	//Takes in where the new mouse coordinate is(not how much to move by)
	public void move(double x, double y) {
		double bigx = Math.max(x, s.getX());
		double smallx = Math.min(x, s.getX());
		double bigy = Math.max(y, s.getY());
		double smally = Math.min(y, s.getY());
		
		if(bigx == x)
		{
			if(bigy == y)
			{
				s.move(bigx - smallx, bigy - smally);
			}
			else if(smally == y)
			{
				s.move(bigx - smallx, - (bigy - smally));
			}
		}
		else if(smallx == x)
		{
			if(bigy == y)
			{
				s.move(-(bigx - smallx), bigy - smally);
			}
			else if(smally == y)
			{
				s.move(-(bigx - smallx), - (bigy - smally));
			}
		}
	}
	
	public void act() {		
		move(s.getX() + vx, s.getY() + vy);
		
		vy += 0.001;
	}
	
	public void accelerate(double x, double y) {
		vx += x;
		vy += y;
		
	}
	
	public void setVelocity(double x, double y) {
		vx = x;
		vy = y;
	}
	
	public double getXVelocity() {
		return vx;
	}
	
	public double getYVelocity() {
		return vy;
	}
	
	public double getX() {
		return s.getX();
	}
	
	public double getY() {
		return s.getY();
	}

}
