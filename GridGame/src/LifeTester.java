import java.io.FileNotFoundException;

public class LifeTester {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
Game test = new Game();


System.out.println(test.toString());

test.step(1);
System.out.println(test.toString());
	}

}
