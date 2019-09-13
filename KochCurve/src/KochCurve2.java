import processing.core.PApplet;


/**
  @(#)KochCurve.java


  @author
  @version
*/
public class KochCurve2 {

	private int level, length;

    public KochCurve2(int level, int length) {
    	this.level = level;
    	this.length = length;
    }
    
    public void draw(PApplet marker) {
    	drawKochCurve(new MemoryDrawer(marker,100,300,0), level, length);
    }

    private void drawKochCurve(MemoryDrawer marker, int level, float length) {
    	
    	
    	if ( level <= 1) {
    		
    		marker.drawForward(length);
    	}
    	else {
    	
    	drawKochCurve (marker , level -1 , length /3);
    	
    	}
    }

}
