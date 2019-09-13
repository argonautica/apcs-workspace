
/*
 * 
 * 
 * a.7
 * b.5
 * c.3
 * d.4
 */
public class TaxForm {
	private double income, tax;
	private boolean married;

	public TaxForm(double income, boolean married) {

		this.income = income;
		this.married = married;
		this.tax = calcTax(income, married);

	}

	public double getTax() {

		return tax;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private double calcTax(double income, boolean married) {
		double tax = 0;

		if (!married) {
			if (income >= 0 && income <= 9525) {

				tax = tax + income * .1;

			} else if (income <= 38700) {

				tax = 952.5 + ((income - 9525) * .12);
			} else if (income <= 82500) {

				tax = 4453.50 + ((income - 38700) * .22);

			} else if (income <= 157500) {

				tax = 14089.50 + ((income - 82500) * .24);

			} else if (income <= 200000) {

				tax = 32089.50 + ((income - 157500) * .32);

			} else if (income <= 500000) {

				tax = 45689.50 + ((income - 200000) * .35);

			} else if (income >= 500000) {

				tax = 150689.50 + ((income - 500000) * .37);

			} else
				return 0.0;

		} else {

			if (income >= 0 && income <= 19050) {

				tax = tax + income * .1;

			} else if (income <= 77400) {

				tax = 1905 + ((income - 19050) * .12);
			} else if (income <= 165000) {

				tax = 8907.00 + ((income - 77400) * .22);

			} else if (income <= 315000) {

				tax = 28179.00 + ((income - 165000) * .24);

			} else if (income <= 400000) {

				tax = 64179.00 + ((income - 315000) * .32);

			} else if (income <= 600000) {

				tax = 91379.00 + ((income - 400000) * .35);

			} else if (income >= 600000) {

				tax = 161379.00 + ((income - 600000) * .37);

			} else
				return 0.0;

		}

		return tax;

	}

}
