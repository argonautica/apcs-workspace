import java.awt.Point;

import processing.core.PApplet;

public class Line {

	// coordinates
	private int x1, x2, y1, y2;

	private Point pointA, pointB;

	// construct sets field values to coordinate
	public Line(int x1, int y1, int x2, int y2) {

		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.pointA = new Point(x1, y1);
		this.pointB = new Point(x2, y2);
	}

	// sets a new val for coordinates of a point
	public void setPoint2(int x2, int y2) {

		this.x2 = x2;
		this.y2 = y2;
	}

	// checks if a num is in between a bounds
	public boolean isinbetween(int bound, int num, int bound2) {

		if (bound <= num && num <= bound2) {
			return true;
		} else if (bound2 <= num && num <= bound) {

			return true;
		} else {
			return false;
		}
	}

	// checks for intersection, returNs true / false based on if there is an
	// intersection
	public boolean intersects(Line other) {

		/*
		 * 
		 * Point start1 = this.pointA; Point end1 = this.pointB; Point start2 =
		 * other.pointA; Point end2 = other.pointB; // First find Ax+By=C values for the
		 * two lines double A1 = end1.y - start1.y; double B1 = start1.x - end1.x;
		 * double C1 = A1 * start1.x + B1 * start1.y;
		 * 
		 * double A2 = end2.y - start2.y; double B2 = start2.x - end2.x; double C2 = A2
		 * * start2.x + B2 * start2.y;
		 * 
		 * double det = (A1 * B2) - (A2 * B1);
		 * 
		 * if (det == 0) { // Lines are either parallel, are collinear (the exact same
		 * // segment), or are overlapping partially, but not fully // To see what the
		 * case is, check if the endpoints of one line // correctly satisfy the equation
		 * of the other (meaning the two // lines have the same y-intercept). // If no
		 * endpoints on 2nd line can be found on 1st, they are // parallel. // If any
		 * can be found, they are either the same segment, // overlapping, or two
		 * segments of the same line, separated by some // distance. // Remember that we
		 * know they share a slope, so there are no other // possibilities
		 * 
		 * // Check if the segments lie on the same line // (No need to check both
		 * points) if ((A1 * start2.x) + (B1 * start2.y) == C1) { // They are on the
		 * same line, check if they are in the same // space // We only need to check
		 * one axis - the other will follow if ((Math.min(start1.x, end1.x) < start2.x)
		 * && (Math.max(start1.x, end1.x) > start2.x)) return true;
		 * 
		 * // One end point is ok, now check the other if ((Math.min(start1.x, end1.x) <
		 * end2.x) && (Math.max(start1.x, end1.x) > end2.x)) return true;
		 * 
		 * // They are on the same line, but there is distance between them return
		 * false; }
		 * 
		 * // They are simply parallel return false; } else { // Lines DO intersect
		 * somewhere, but do the line segments intersect? double x = (B2 * C1 - B1 * C2)
		 * / det; double y = (A1 * C2 - A2 * C1) / det;
		 * 
		 * // Make sure that the intersection is within the bounding box of // both
		 * segments if ((x >= Math.min(start1.x, end1.x) && x <= Math.max(start1.x,
		 * end1.x)) && (y >= Math.min(start1.y, end1.y) && y <= Math.max(start1.y,
		 * end1.y))) { // We are within the bounding box of the first line segment, //
		 * so now check second line segment if ((x >= Math.min(start2.x, end2.x) && x <=
		 * Math.max(start2.x, end2.x)) && (y >= Math.min(start2.y, end2.y) && y <=
		 * Math.max(start2.y, end2.y))) { // The line segments do intersect return true;
		 * } }
		 * 
		 * // The lines do intersect, but the line segments do not return false; }
		 */
		/*
		 * 
		 * int det = (x2 - x1)*(other.y2 - other.y1) - (y1 - y1)*(other.x2 - other.x1);
		 * if (det != 0) {
		 * 
		 * 
		 * 
		 * 
		 * int detu = (other.x1 - x1)*(other.y1 - other.y1) - (other.y1 - y1)*(other.x2
		 * - other.x1); int detv = (other.x1 - x1)*(y2 - y1) - (other.x1 - x1)*(x2- x1);
		 * if (det < 0) { det = -det; detu = -detu; detv = -detv; } if (detu >= 0 &&
		 * detu <= det && detv >= 0 && detv <= det) { return true; } else { return
		 * false; } } else {
		 * 
		 * return true;
		 * 
		 * }
		 * 
		 */
		if (x1 == x2 && y1 == y2 || other.x1 == other.x2 && other.y1 == other.y2) {
			return false;
		}

		double ax = x2 - x1;
		double ay = y2 - y1;
		double bx = other.x1 - other.x2;
		double by = other.y1 - other.y2;
		double cx = x1 - other.x1;
		double cy = y1 - other.y1;

		double numeratorA = by * cx - bx * cy;
		double denom = ay * bx - ax * by;
		if (denom > 0) {
			if (numeratorA < 0 || numeratorA > denom) {
				return false;
			}
		} else if (denom < 0) {
			if (numeratorA > 0 || numeratorA < denom) {
				return false;
			}
		}
		double numeratorB = ax * cy - ay * cx;
		if (denom > 0) {
			if (numeratorB < 0 || numeratorB > denom) {
				return false;
			}
		} else if (denom < 0) {
			if (numeratorB > 0 || numeratorB < denom) {
				return false;
			}
		}
		if (denom == 0) {

			double y3LessY1 = other.y1 - y1;
			double collinearityTestForP3 = x1 * (y2 - other.y1) + x2 * (y3LessY1) + other.x1 * (y1 - y2); // see
																											// http://mathworld.wolfram.com/Collinear.html
			if (collinearityTestForP3 == 0) {
				if (x1 >= other.x1 && x1 <= other.x2 || x1 <= other.x1 && x1 >= other.x2
						|| x2 >= other.x1 && x2 <= other.x2 || x2 <= other.x1 && x2 >= other.x2
						|| other.x1 >= x1 && other.x1 <= x2 || other.x1 <= x1 && other.x1 >= x2) {
					if (y1 >= other.y1 && y1 <= other.y2 || y1 <= other.y1 && y1 >= other.y2
							|| y2 >= other.y1 && y2 <= other.y2 || y2 <= other.y1 && y2 >= other.y2
							|| other.y1 >= y1 && other.y1 <= y2 || other.y1 <= y1 && other.y1 >= y2) {
						return true;
					}
				}
			}
			return false;
		}
		return true;
	}

	// draws the line
	public void draw(PApplet drawer) {

		drawer.line((float) x1, (float) y1, (float) x2, (float) y2);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}