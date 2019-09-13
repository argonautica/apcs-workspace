package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.util.Arrays;

public class DataSet {
	private int[] data;
	private int length;
	private static String cde;

	private static String abc;

	public void readFile(String filename) throws IOException {

		ArrayReader reader = new ArrayReader(filename);
		data = new int[1000];
		reader.fillArray(data);
		length = reader.fillArray(data);
		BufferedReader reader2 = new BufferedReader(new FileReader(filename));
		int lines = 0;
		while (reader2.readLine() != null)
			lines++;
		reader2.close();

		System.out.println(" the length is " + length);
		length = compact(0);
		System.out.println(" the length is " + length);

		cde = toString();

		abc = print();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		DataSet s = new DataSet();
		s.readFile("numbers2.txt");

		System.out.println(cde);

		System.out.println(abc);
	}

	public double getAverage() {
		double avg = 0;
		for (int e : data) {
			avg += e;
		}

		return avg / length;

	}

	public double getStdev() {

		double avg = 0;
		for (int e : data) {
			avg += e;
		}

		avg /= length;

		double total = 0;
		for (int e : data) {

			total += ((avg - e) * (avg - e));
		}

		return Math.sqrt(total / length);

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

	public String toString() {

		return Arrays.toString(data);
	}

	public String print() {
		return new String(" the average is " + getAverage() + " the mode is " + Arrays.toString(mode()) + " the standard deviation is  " + getStdev());

	}

	public void remove(int loc) {

		for (int i = loc; i < length; i++) {

			data[i] = data[i + 1];
		}

	}

	public int compact(int val) {

		for (int i = 0; i < length; i++) {
			if (data[i] == val) {

				remove(i);
				length--;
			}

		}
		return length;
	}

}