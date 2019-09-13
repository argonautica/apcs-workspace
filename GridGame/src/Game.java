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

public class Game {

	int[][] grid;
	
	int [][] newGrid;

	// Constructs an empty grid
	public Game() {

		grid = new int[4][4];
		
		newGrid = new int[4][4];
		
		
		grid[(int) (Math.random() * 4)][(int) (Math.random() * 4)] = 2;
		
		grid[(int) (Math.random() * 4)][(int) (Math.random() * 4)] = 2;
		

	}

	// Constructs the grid defined in the file specified
	
	
	public static void main(String[] args) {
		
		
	}
	
	// Runs a single turn of the Game Of Life

	
	
	
	private void up() {
		
		for ( int i = 3; i >0; i--) {
			
			for ( int j = 0; j < 4; j++) {
				
				
				if ( grid[i][j] !=0) {
					
					int temp = i;
					
				if ( grid[i-1][j] == 0) {
					
					grid[i-1][j] = grid[i][j];
					grid[i][j] = 0;
				} else if (( grid[i-1][j] == grid[i][j])) {
					
					 grid[i-1][j] = grid[i][j] * 2;
					 grid[i][j] = 0;
				}
				}
			}
			
		}
		
		
	}	
	
	private void down() {
		
		for ( int i )
		
		
		
		
	}
	/*
	 * 1 = up
	 * 2 = right 
	 * 3 = down 
	 * 4 = left 
	 * 
	 * 
	 */
	public void step(int turn ) {
		
		if ( turn == 1) {
			
		
		
			up();
			up();
			up();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		int x = (int) (Math.random() * 4);
		int y = (int) (Math.random() * 4);
		
	//	if ( grid[x][y] == 0)
		//grid[(int) (Math.random() * 4)][(int) (Math.random() * 4)] = 2;
	}

	
		
		
	

	// Formats this Life grid as a String to be printed (one call to this method
	// returns the whole multi-line grid)
	public String toString() {

		String res = "" ; 
		
		for ( int i =0; i < 4; i++) {
			
			for ( int j =0; j < 4; j++) {
				
				res += grid[i][j];
				
				
				
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
		
		/*
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
		*/
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