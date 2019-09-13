
public class Box {

	private double d1, d2, d3, weight, largeD, smalld1, smalld2;

	public Box(double d1, double d2, double d3, double weight) {
		this.d1 = d1;
		this.d2 = d2;
		this.d3 = d3;

		this.weight = weight;

		if (d1 > d3) {

			smalld1 = d3;

			if (d1 > d2) {

				largeD = d1;
				smalld2 = d2;
			} else {

				largeD = d2;
				smalld2 = d1;
			}
		} else {

			smalld1 = d1;

			if (d3 > d2) {

				largeD = d3;
				smalld2 = d2;

			} else {

				smalld2 = d3;
				largeD = d2;
			}

		}

	}

	public void printOutput() {

		if (2 * (smalld1 + smalld2) > 100) {

			if (weight > 70) {

				System.out.println(" package is too large and too heavy ");
			} else {

				System.out.println("package is too large");
			}
		} else {

			if (weight > 70) {

				System.out.println(" package is too heavy");
			} else {

				System.out.println(" package is acceptable");
			}
		}

	}

}
