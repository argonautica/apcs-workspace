
public class RecursionPractice {
	public static long iterations = 0;

	public static int factorial(int n) {

		if (n == 0) {
			return 1;
		} else {
			int pastFactorial = factorial(n - 1);
			return pastFactorial * n;

		}

	}

	public static int squareNumber(int n) {
		if (n == 1) {
			return n;
		} else {
			int temp = squareNumber(n - 1);
			return temp + 2 * n - 1;
		}
	}

	public static int logBase2(int n) {
		if (n == 1) {

			return 0;
		} else {

			int temp = logBase2(n / 2);

			return 1 + temp;
		}
	}

	public static int pow(int n) {
		if (n == 0) {
			return 1;
		} else {

			int temp = pow(n - 1);
			return temp * 2;
		}
	}

	public static int pentagonalNumber(int n) {
		return 0;
	}

	public static int fibonacci(int index) {
		int x = 0;
		int y = 1;
		for (int i = 0; i < index; i++) {
			int z = x + y;

			x = y;
			y = z;

			iterations++;

		}
		return x;
	}

	public static int fibonacciRecursive(int index) {
		iterations++;
		if (index == 1) {

			return 1;
		} else if (index == 0) {
			return 0;

		} else {

			int temp = (fibonacciRecursive(index - 1));
			return temp + fibonacciRecursive(index - 2);

		}
	}
	
	public static void solveHanoi(int numDisks, int fromPeg, int toPeg) {
		
		System.out.println(numDisks + " " + fromPeg + " " + toPeg);
		if ( numDisks== 1) {
			iterations++;
			System.out.println(" move disk from  " + fromPeg + "  to " + toPeg);
		} else {
			
			 int otherPeg = 6- Math.abs(fromPeg + toPeg); 
			 solveHanoi(numDisks -1 , fromPeg, otherPeg);
			 System.out.println("move disk from "  + fromPeg + " to "  + toPeg);
			 solveHanoi(numDisks - 1, otherPeg, toPeg);
iterations++;
		}
		
		
	}

// 0 1 2 3 5 8
	public static void main(String[] args) {

		
			iterations = 0;
			solveHanoi(3 , 1 , 3);

	}

}