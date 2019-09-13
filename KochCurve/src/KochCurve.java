import processing.core.PApplet;


/**
  @(#)KochCurve.java


  @author
  @version
*/
public class KochCurve {
private int level;
private int length;
	// TO DO

    public KochCurve(int level, int length) {
    	this.level = level;
    	this.length = length;
    
    }
    
    public void draw(PApplet marker) {
    	drawKochCurve(marker , 60 , 60 , 0, length, level);
    }

    private void drawKochCurve(PApplet marker, int x, int y, int angle, int length, int level) {
    	
    	
    if ( level <= 1) {
    	
    	float newX = (float) (x + Math.cos(angle)*length);
		float newY = (float) (y + Math.sin(angle)*length);
		marker.line(x, y, newX, newY);
    	
    	
    	// marker.line(x, y, (float)(x + length *  Math.cos(angle * Math.PI/180) ),(float) (y + length * Math.sin(angle * Math.PI/180)));
    } else {
    	
    	length /= 3;
    	drawKochCurve(marker,  x, y, angle, length, level - 1);
    	float newX = (float) (x + Math.cos(angle)*length);
		float newY = (float) (y + Math.sin(angle)*length);
		angle -= Math.PI/3;
    	drawKochCurve(marker,  (int) newX, ( int)  newY, angle, length, level - 1);
		newX = (float) (newX + Math.cos(angle)*length);
		newY = (float) (newY + Math.sin(angle)*length);
		angle += 2*Math.PI/3;
    	drawKochCurve(marker,  (int) newX, ( int)  newY, angle, length, level - 1);
		newX = (float) (newX + Math.cos(angle)*length);
		newY = (float) (newY + Math.sin(angle)*length);
		angle -= Math.PI/3;
    	drawKochCurve(marker,  (int) newX, ( int)  newY, angle, length, level - 1);
    }

    	}
    }

