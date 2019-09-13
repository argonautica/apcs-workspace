
import processing.core.PApplet;

/*
 * 1 + : House m
 * 1 - : sscale isn't good style. What does it represent? I'm assuming it's a scale, so it should be sScale. This helps people
 * understand what it represents. 
 * 1 delta : Make sscale a float. Whenever you use sscale, you're casting it to a float
 *
 */
public class House {

	private double sscale;
	public int xpos;
	public int ypos;
	public Line top, bottom, leftside, rightside;

	public boolean open = false;
	public House() {

		this.xpos = 150;
		this.ypos = 200;
		this.sscale = (float) 1.0;
	}

	public void move(int x, int y) {
// set new loc to field
		this.xpos = x;
		this.ypos = y;
	}

	public void changeScale(float scale) {
		this.sscale += scale;
	}

	
	public int getXpos() {
		return xpos;
	}
	
	public int getYpos() {
		return ypos;
	}
	/*
	 * public void setup(PApplet p) { // setup() runs once // size(200, 200);
	 * p.frameRate(30); }
	 */
	
	

	public void draw(PApplet p) { // draw() loops forever, until stopped

		p.stroke(0);

		p.pushMatrix();
		p.background(204);

		p.translate(this.xpos, this.ypos);
		p.scale((float) this.sscale, (float) this.sscale);
				

		p.translate(-100 , -150 );
	
		
		//p.translate((float)0-(p.width / 4), (float)(0-p.height / 2));
		/*
		 * 
		 * p.line(p.width / 8, 100, p.width / 2, 0); p.line(p.width / 2, 0, p.width -
		 * 50, 100);
		 * 
		 * p.line(p.width / 8,100,p.width - 50, 100); p.line(p.width / 8, 100, 50,
		 * p.height - 50); p.line(p.width - 50, 100, p.width - 50, p.height - 50);
		 * p.line( p.width / 8, p.height - 50, p.width - 50, p.height - 50);
		 * p.rect(p.width /2 -p.width / 8, p.height - 50, -(p.width / 8), (-p.height /
		 * 3) );
		 * 
		 * 
		 */
		p.triangle(100 , 100 , 300 , 100 , 200 , 25 );
		p.rect(100 , 100 , 200 , 100 );
		
		p.stroke(210);
		if (!open) {
		this.leftside = new Line(185, 150 , 185 , 200 );
		this.rightside = new Line(215 , 150 , 215 , 200 );
		this.bottom = new Line(185 , 150 , 215 , 150 );		
		this.top = new Line(185 , 150 , 215 , 150 );
		
		} else {
			
			this.leftside = new Line(185, 150 , 185 , 200 );
			this.rightside = new Line(215 , 140 , 215 , 190 );
			this.bottom = new Line(185 , 150 , 215 , 140 );		
			this.top = new Line(185 , 150 , 215 , 140 );
		}
		
		
		leftside.draw(p);
		rightside.draw(p);
		bottom.draw(p);
		top.draw(p);
		
		//p.rect(185, 150	, 30	, 50);

		

		
		p.popMatrix();

	}

}