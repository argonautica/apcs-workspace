import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/*

	Represents a 2D maze.

	Coded by:
	Modified on:

*/

public class Maze {

	private static final int rows = 20;
	private static final int cols = 20;

	private char[][] grid;

	// Constructs an empty grid
	public Maze() {
		char[][] grid = new char[rows][cols];
	}

	// Constructs the grid defined in the file specified
	public Maze(String filename) {
		
	}

	// Attempts to find a path through the maze and returns whether a path was found or not
	public boolean solve() {
	}
	
	// Private recursive version of solve()
	private boolean solve(int x, int y) {
		if ( x < 0 || x >=  rows || y < 0 || y >=  rows ) {
			
			return false;
		} else if(grid[x][y] == 'x') {
			return true;
			
		}
		else if (grid[x][y] == '#' || grid[x][y] == '!') {
			
			return false;
		}
		else {
			
			
		if(	solve(x+1, y)) return;
		
			solve(x, y+1);
			solve(x, y-1);
			solve(x-1,y);
			
			
			
			
			
			
			
			
		}
		
	}
	

	// Formats this grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
	}

		public void readData (String filename, char[][] gameData) {
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
						for(int i = 0; i < line.length(); i++)
							if (i < gameData.length && count < gameData[i].length)
								gameData[i][count] = line.charAt(i);

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

}