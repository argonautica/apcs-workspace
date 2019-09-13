import java.awt.geom.*;  // for Point2D.Double
import java.util.ArrayList;      // for ArrayList

import javax.swing.plaf.multi.MultiButtonUI;

import processing.core.PApplet;	// for Processing
import shapes.Line;
import shapes.Shape;

public class IrregularPolygon extends Shape {
   private ArrayList <Point2D.Double> myPolygon;
    
   // constructors
   public IrregularPolygon() { 
	   super(0, 0); 	 	
	   myPolygon = new ArrayList<Point2D.Double>();

	   
	   
	   
   }
   
   // public methods
   public void add(Point2D.Double aPoint) { 
	   
	   myPolygon.add(aPoint);
   }

   public void draw(PApplet marker) {
	   
	   if ( myPolygon.size() > 2) {
	   for ( int i = 0; i < myPolygon.size() - 1; i++) {
		 marker.line((float)myPolygon.get(i).x, (float)myPolygon.get(i).y, (float) myPolygon.get(i+1).x, (float) myPolygon.get(i+1).y);
	   }
	   
	   }
   }

   public double calcPerimeter() {  
	   
	   double perim = 0;
	   
	   for (int i = 0; i < myPolygon.size() - 2; i++ ) {
		   
		   perim += Math.sqrt(      Math.pow(myPolygon.get(i).x - myPolygon.get(i+1).x , 2)  +  Math.pow(myPolygon.get(i).y - myPolygon.get(i+1).y , 2)                    ) ;
				   
				   
				   
	   }
	   
	   
	   perim += Math.sqrt(      Math.pow(myPolygon.get(0).x - myPolygon.get(myPolygon.size() -1).x , 2)  +  Math.pow(myPolygon.get(0).y - myPolygon.get(myPolygon.size() - 1).y , 2)                    ) ;
	   
	   return perim;
   
   
   
   }

   public double calcArea() {  
	   
	   if ( myPolygon.size() >= 2) {
	   
	  double area  = 0;
	  
	  
	  
	  
	  for ( int i = 0; i < myPolygon.size() - 2; i++) {
		  
		  
		  area +=
				  
			myPolygon.get(i).x * myPolygon.get(i + 1).y;
	  }
	  area += myPolygon.get(myPolygon.size() - 1).x * myPolygon.get(0).y;
	  
	  
  for ( int i = 0; i < myPolygon.size() - 2; i++) {
		  
		  
		  area -=
				  
			myPolygon.get(i).y * myPolygon.get(i + 1).x;
	  }
	  
  area -= myPolygon.get(myPolygon.size() - 1).y * myPolygon.get(0).x;
	  
	  
	 return Math.abs(area); }
	   
   
   return 0;}
   
   
   public int getPoints() {
	   return myPolygon.size() - 1;
   }
   
   public void removePoint(int index) {
	   
	   myPolygon.remove(index);
   }
}
