import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
public class main {

	public static void main(String[] args) {
		 JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "JPG & GIF Images", "jpg", "gif");
		    chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	
		    	
		    	
		    	/*
		       System.out.println("You chose to open this file: " +
		            chooser.getSelectedFile().getName());
		            
		            */
		    	try {
		    			ArrayList<String> fileData = FileIO.readFile(chooser.getSelectedFile().getAbsolutePath());
		    			for ( String s : fileData) {
		    				
		    				System.out.println(s);
		    			}
		    	} catch(IOException e) {
		    		
		    	}
		    
		    }
	}

}
