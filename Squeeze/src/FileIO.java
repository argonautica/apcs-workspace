import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

	
	public static final String fileSeperator = System.getProperty("file.seperator");
	public static final String lineSeperator = System.getProperty("line.seperator" );
	
	public static ArrayList<String> readFile (String filename) throws FileNotFoundException{
		
		Scanner a = null;
		try {
			
			 ArrayList<String> output = new  ArrayList<String>();
			
			FileReader reader = new FileReader(filename);
			 a = new Scanner(reader);
			
		while (a.hasNextLine()) {
			String line = a.nextLine();
			output.add(line);
		}
		return output;
		} finally {
			
			if( a!= null)
				a.close();
		}
		
		
		
	}
	
	
	public static void writeFile (String filename, ArrayList<String> fileData) throws IOException {
	
		
		FileWriter writer = null;
		try {
			
			
			 writer = new FileWriter(filename);
			

			
			for( String line  : fileData) {
				writer.write(line);
			}

		} finally {
			
			if (writer != null) {
				writer.close();
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
