import java.util.Scanner;

/* 
 * + You have both classes modeling real world objects
 * + You don't have I/O occurring in one singular class
 * - You don't have a main method so I can't run the code
 * delta Remove the main method from the TaxForm class
 * 
 * $50000 married 5619$
 * $25000 single 2809.5$
 * $300000 married 60579$
 * $170000 single 36249.5$	
 * $30000 married 3219$
 * $500000 single 150689.5$
 * $170000 married 29379$
 * $45000 single 4839$
 * $130000 Married 20479$
 * $120000 single 23089.5$ 
 */
public class IRS {

	public static void main(String[] args) {
		// TODO

		Scanner a = new Scanner(System.in);
		while (true) {

			System.out.println(" how much is the income");
			double income = a.nextDouble();

			System.out.println("is the person married ? ( true, false) ");
			boolean c = a.nextBoolean();

			TaxForm d = new TaxForm(income, c);

			System.out.println(" the tax is " + d.getTax() + " dollars");

		}

	}

}
