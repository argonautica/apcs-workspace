
import processing.core.PApplet;

public class Line {

	// coordinates
	private int x1, x2, y1, y2;

	// construct sets field values to coordinate
	public Line(int x1, int y1, int x2, int y2) {

		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

//sets a new val for coordinates of a point
	public void setPoint2(int x2, int y2) {

		this.x2 = x2;
		this.y2 = y2;
	}

	public void add(int x, int y) {

		this.x1 += x;
		this.x2 += x;
		this.y1 += y;
		this.y2 += y;

	}

	// checks if a num is in between a bounds
	public boolean isinbetween(int bound, double num, int bound2) {

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
			double collinearityTestForP3 = x1 * (y2 - other.y1) + x2 * (y3LessY1) + other.x1 * (y1 - y2);
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

//draws the line
	public void draw(PApplet drawer) {

		drawer.line((float) x1, (float) y1, (float) x2, (float) y2);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {

		return y2;
	}

	public int getY1() {
		return y1;
	}

}