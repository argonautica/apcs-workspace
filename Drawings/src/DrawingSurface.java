import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

/*
 * 
 * + Pretty cool how the door to the house opens for the person, it looks 3D and stuff
 * + Nice intersect method in the line class, very easy to follow
 * + Cool mouse
 * 
 * - Some more comments would be nice, such as explaining certain variables and fields
 * - In the DrawingSurface class, lines 50-77 contains a huge paragraph that is hard to follow
 * 
 * Delta: Make the person's hitbox stay with the person, the problem is that it is being placed relative to the person, 
 *        so the x and y values for the hitbox never need to change because the person is already moving it
 * 
 * Delta: Add some sort of instructions, it took me a while to discover that the door actually opens, 
 *        maybe have a little text box at the top of the window or something
 */

public class DrawingSurface extends PApplet {
	private House house;
	private Person person;

	public DrawingSurface() {
		house = new House();
		person = new Person();
	}

	// draw
	public void draw() {

		float xRatio = this.width / 400.0F;
		float yRatio = this.height / 300.0F;

		scale(xRatio, yRatio);

		this.house.draw(this);
		this.person.draw(this);

		// System.out.println("this person x" + this.person.left.getX1());

		/*
		 * if (this.person.right.intersects(this.house.leftside) ||
		 * this.person.right.intersects(this.house.rightside) ||
		 * this.person.right.intersects(this.house.top) ||
		 * this.person.right.intersects(this.house.bottom) ||
		 * this.person.left.intersects(this.house.leftside) ||
		 * this.person.left.intersects(this.house.rightside) ||
		 * this.person.left.intersects(this.house.top) ||
		 * this.person.left.intersects(this.house.bottom)) {
		 */

		if (this.person.right.intersects(new Line(this.house.leftside.getX1() + this.house.getXpos(),
				this.house.leftside.getY1() + this.house.getYpos(), this.house.leftside.getX2() + this.house.getXpos(),
				this.house.leftside.getY2() + this.house.getYpos()))
				|| this.person.right.intersects(new Line(this.house.rightside.getX1() + this.house.getXpos(),
						this.house.rightside.getY1() + this.house.getYpos(),
						this.house.rightside.getX2() + this.house.getXpos(),
						this.house.rightside.getY2() + this.house.getYpos()))
				|| this.person.right.intersects(new Line(this.house.top.getX1() + this.house.getXpos(),
						this.house.top.getY1() + this.house.getYpos(), this.house.top.getX2() + this.house.getXpos(),
						this.house.top.getY2() + this.house.getYpos()))
				|| this.person.right.intersects(new Line(this.house.bottom.getX1() + this.house.getXpos(),
						this.house.bottom.getY1() + this.house.getYpos(),
						this.house.bottom.getX2() + this.house.getXpos(),
						this.house.bottom.getY2() + this.house.getYpos()))
				||this.person.left.intersects(new Line(this.house.leftside.getX1() + this.house.getXpos(),
						this.house.leftside.getY1() + this.house.getYpos(), this.house.leftside.getX2() + this.house.getXpos(),
						this.house.leftside.getY2() + this.house.getYpos()))
						|| this.person.left.intersects(new Line(this.house.rightside.getX1() + this.house.getXpos(),
								this.house.rightside.getY1() + this.house.getYpos(),
								this.house.rightside.getX2() + this.house.getXpos(),
								this.house.rightside.getY2() + this.house.getYpos()))
						|| this.person.left.intersects(new Line(this.house.top.getX1() + this.house.getXpos(),
								this.house.top.getY1() + this.house.getYpos(), this.house.top.getX2() + this.house.getXpos(),
								this.house.top.getY2() + this.house.getYpos()))
						|| this.person.left.intersects(new Line(this.house.bottom.getX1() + this.house.getXpos(),
								this.house.bottom.getY1() + this.house.getYpos(),
								this.house.bottom.getX2() + this.house.getXpos(),
								this.house.bottom.getY2() + this.house.getYpos()))) {

			this.house.open = true;

		} else if (new Line(this.person.getX(), this.person.getY(), this.person.getX() - 50, this.person.getY() - 50)
				.intersects(this.house.leftside)) {
			this.house.open = true;

		}

		else if (new Line(this.person.getX(), this.person.getY(), this.person.getX() + 50, this.person.getY() + 50)
				.intersects(this.house.leftside)) {
			this.house.open = true;

		} else {
			this.house.open = false;
		}

		// System.out.println(this.person.right.getX1() + " " +
		// this.person.right.getX2() + " " + this.person.right.getY1() );

	}

	// keys pressed
	public void keyPressed() {

		if (this.key == 65535) {
			if (this.keyCode == 38) {
				this.house.changeScale((float) 0.01);

			} else if (this.keyCode == 40) {

				this.house.changeScale((float) -0.01);
			}

		} else if (this.key == 'w') {

			this.person.moveBy(00, -5);

		} else if (this.key == 'a') {

			this.person.moveBy(-5, 0);
		} else if (this.key == 's') {

			this.person.moveBy(0, 5);
		} else if (this.key == 'd') {

			this.person.moveBy(5, 0);

			// System.out.println("h=this person x" + this.person.getX() + " the line x " +
			// this.person.right.getX1() + " other " + this.person.right.getX2());
		}
	}

	public void mousePressed() {

		this.house.move((int) (this.mouseX / (this.width / width)), (int) (this.mouseY / (this.height / height)));
	}
}
