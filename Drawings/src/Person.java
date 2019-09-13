
import processing.core.PApplet;

/*
 * 1 + :
 * 1 - : Person should have do one more action. You're adding a lot of this.x this.y for no reason. You don't want fields to have short names
 * such as x and y.
 * 1 delta :
 */
public class Person {
	private int x;
	private int y;
	private int height;
	public Line left, right;
	

	public Person() {
		this.setX(60);
		this.y = 160;
	}

	
	// set new loc to field
	public void moveBy(int x, int y) {
		this.setX(this.getX() + x);
		this.y += y;
		

	}
	
	// draw
	
	
	/*public void hide(PApplet p) {
		
p.stroke(204);
	}
	*/

	public void draw(PApplet p) {
		p.stroke(0);
		
		
	this.left = new Line(-15, -5, 15, 40);
	
	this.right = new Line(0, -5, -15, 40);


		//p.pushMatrix();
		//p.pushStyle();
		
		p.translate(this.getX(), this.y);
		//this.left.add(this.getX(), this.y);
		//this.right.add(this.getX(), this.y);

		p.fill(255);
		p.line(0.0F, 20.0F, 0.0F, 0.0F);
		p.line(0.0F, 20.0F, -15.0F, 40.0F);
		p.line(0.0F, 20.0F, 15.0F, 40.0F);
		p.line(-10.0F, 10.0F, 10.0F, 10.0F);
		p.ellipse(0.0F, 0.0F, 10f, 10f);
		
		
		//p.stroke(153);

//p.line(-15.0f, -5.0f, -15.0f, 40.0f);
		
		//p.line((float)left.getX1(), (float)left.getY1(), (float)left.getX2(), (float) left.getY2());
		
		//left.draw(p);
		//right.draw(p);


		//p.popStyle();
		//p.popMatrix();
	}




public int getY() {
	return y;
}
	public void setX(int x) {
		this.x = x;
	}


	public int getX() {
		// TODO Auto-generated method stub
		return x;
	}
}