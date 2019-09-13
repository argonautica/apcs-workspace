import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.xml.crypto.Data;

import processing.core.PApplet;

/*

	Represents a Game Of Life grid.

	Coded by:
	Modified on:

*/

public class Life {

	boolean[][] grid;
	
	boolean [][] newGrid;

	// Constructs an empty grid
	public Life() {

		grid = new boolean[20][20];
		
		newGrid = new boolean[20][20];
	}

	// Constructs the grid defined in the file specified
	public Life(String filename) throws FileNotFoundException {
grid = new boolean[20][20];
		
		newGrid = new boolean[20][20];
		readData(filename, grid);
	}

	
	public static void main(String[] args) {
		
		
	}
	// Runs a single turn of the Game Of Life
	public void step() {
		
	

		for (int i = 0; i < 20; i++) {

			for (int j = 0; j < 20; j++) {

				int neighbors = 0;

				if (j > 0) {
					if (grid[i][j - 1])
						neighbors++; // left

					if (i > 0) {
						if (grid[i - 1][j - 1])
							neighbors++; // top left

						if (i < 19) {
							if (grid[i + 1][j - 1])
								neighbors++; // bottom left
						}
					}

				}

				if (i > 0) {
					if (grid[i - 1][j])
						neighbors++;
				} // top

				if (i < 19) {
					if (grid[i + 1][j])
						neighbors++; // bottom

				}

				if (j < 19) {
					if (grid[i][j + 1])
						neighbors++; // right
					
					

					if (i > 0) {
						if (grid[i - 1][j + 1])
							neighbors++; // top right

						
					}
					
					if (i < 19) {
							if (grid[i + 1][j + 1])
								neighbors++; // bottom right
						}


				}

			
			if ( neighbors == 3 && !grid[i][j]) {
				
				newGrid[i][j] = true;
				
				
			} else if ( (neighbors == 2 || neighbors == 3) && grid[i][j]) {
				
				newGrid[i][j] = true;
			}
			
			
			else  {
				
				newGrid[i][j] = false;
				
			}
				
				
			
			
			
			//System.out.println( " object at " +j +  " , " + i + " has  neighbors " + neighbors );
			}

		}

	
	grid = newGrid;
	
	newGrid = new boolean[20][20];
	
	}

	// Runs n turns of the Game Of Life
	public void step(int n) {
		
		for ( int i = 0; i < n; i++) {
			
			step();
		}
	}

	// Formats this Life grid as a String to be printed (one call to this method
	// returns the whole multi-line grid)
	public String toString() {

		String res = "" ; 
		
		for ( int i = 0; i < 20; i++) {
			
			
			for (int j =0; j < 20; j++) {
				

if (grid[i][j]) {
	
	res += "*";
} else {
	
	res += " ";
}
			
				
			}
			
		res += "\n";	
		}
		return res;
		
		
	}

	
	
	// Reads in array data from a simple text file containing asterisks (*)
	public void readData(String filename, boolean[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
				reader = new FileReader(dataFile);
				in = new Scanner(reader);

				while (in.hasNext()) {
					String line = in.nextLine();
					for (int i = 0; i < line.length(); i++)
						if (count < gameData.length && i < gameData[count].length && line.charAt(i) == '*')
							gameData[count][i] = true;

					count++;
				}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}

		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}

	/**
	 * Optionally, complete this method to draw the grid on a PApplet.
	 * 
	 * @param marker The PApplet used for drawing.
	 * @param x      The x pixel coordinate of the upper left corner of the grid
	 *               drawing.
	 * @param y      The y pixel coordinate of the upper left corner of the grid
	 *               drawing.
	 * @param width  The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 */
	public void draw(PApplet marker, float x, float y, float width, float height) {
		float cellWidth = width/ grid[0].length;
		float cellHeight = height /grid.length;
		marker.stroke(0);
		for ( int i  =0; i  < grid.length; i++) {
			
			for ( int j = 0; j < grid[0].length; j++) {
				if ( grid[i][j] ) {
					marker.fill(0);
				} else {
					
					marker.fill(255);
				}
				
				marker.rect(j * cellWidth, i * cellHeight , cellWidth, cellHeight);
			}
		}
		
	}

	/**
	 * Optionally, complete this method to determine which element of the grid
	 * matches with a particular pixel coordinate.
	 * 
	 * @param p      A Point object representing a graphical pixel coordinate.
	 * @param x      The x pixel coordinate of the upper left corner of the grid
	 *               drawing.
	 * @param y      The y pixel coordinate of the upper left corner of the grid
	 *               drawing.
	 * @param width  The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 * @return A Point object representing a coordinate within the game of life
	 *         grid.
	 */
	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		return null;
	}

	/**
	 * Optionally, complete this method to toggle a cell in the game of life grid
	 * between alive and dead.
	 * 
	 * @param i The x coordinate of the cell in the grid.
	 * @param j The y coordinate of the cell in the grid.
	 */
	public void toggleCell(int i, int j) {
	}

}