import java.io.FileNotFoundException;

public class LifeTester {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
Life test = new Life("life100.txt");
test.step(7);

System.out.println(test.toString());
	}

}
