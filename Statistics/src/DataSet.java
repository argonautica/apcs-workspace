import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class DataSet {
private int[] data;
private int length;
	
	public void readFile(String filename) throws IOException {
		
		ArrayReader reader = new ArrayReader(filename);
		data = new int[1000];
		reader.fillArray(data);
		
		BufferedReader reader2 = new BufferedReader(new FileReader(filename));
		int lines = 0;
		while (reader2.readLine() != null) lines++;
		reader2.close();
		
		length = lines;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

DataSet s = new DataSet();
s.readFile("numbers.txt");

System.out.println( " the average is " + s.getAverage());

System.out.println(" the standard deviation is " + s.getStdev());
System.out.println( " the mode(s) are " +  Arrays.toString(s.mode()));

	}
	
	public double getAverage() {
		double avg = 0;
		for ( int e : data) {
			avg += e;
		}
		
		return avg/length;
		
	}
	
	
	public double getStdev() {
		
		double avg = 0;
		for ( int e : data) {
			avg += e;
		}
		
	avg /= 1000;
		
	double total = 0;
	for ( int e : data) {
		
		total += ((avg-e)* (avg-e));
	}
	
	return Math.sqrt(total/999);
		
	}
	
	public int[] mode() {
		int[] count = new int[101];
		for (int i = 0; i < length; i++) {
			count[data[i]]++;
		}
		int max = 0;
		int templength = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] > max) {
				templength = 1;
				max = count[i];
			} else if (count[i] == max) {
				templength++;
			}
		}
		int[] out = new int[templength];
		int j = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] == max) {
				out[j] = i;
				j++;
			}
		}
		return out;
	}
		
		
	
	}