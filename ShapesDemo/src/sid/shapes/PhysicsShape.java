package sid.shapes;

import processing.core.PApplet;

import java.util.concurrent.TimeUnit;

import ivychang.shapes.*;

public class PhysicsShape {

	private TwoD s;
	double angle = 0;
	int c = 0;
	private double velocityx, velocityy;

	public PhysicsShape(TwoD abc) {

		this.s = abc;

		velocityy = 0.2;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void draw(PApplet p) {

		s.draw(p);

	}

	public void move(int x, int y) {

		// s.move(s.getX() + x, s.getY() + y);

	}

	public void moveTo(int x, int y) {

		// s.move(x, y);

		// this.moveangle(5, Math.toDegrees( Math.atan2(x - s.getX(), y - s.getY())));

		// s.move(x - s.getX(), y - s.getY());

		s.move(x, y);
	}

	public void begin() {

		velocityx = 1;
		velocityy = 0.2;
	}

	public void act() {
		


		if (s.getY() < 241) {
			
		

			s.move(s.getX(), s.getY() + 2 * velocityy);

			velocityy = velocityy * 1.15;

		} else {
			velocityy = 0.2;

			begin();

		}

		//System.out.println(" the velocity is " + velocityy);

	}

	public void moveangle(double magnitude, double a) {
		double newx = magnitude * Math.cos(Math.toRadians(a));
		double newy = magnitude * Math.sin(Math.toRadians(a));

		s.move(s.getX() + newx, s.getY() + newy);
	}

	public TwoD getBounds() {
		return this.s;
	}

}