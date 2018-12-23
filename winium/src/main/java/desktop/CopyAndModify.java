package desktop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FilenameUtils;

public class CopyAndModify {
	public static void main (String [] args) throws IOException {
		
	    String FirstIndex = JOptionPane.showInputDialog("Enter First Folder Number", null);
		String LastIndex = JOptionPane.showInputDialog("Enter Last Folder Number", null);
		
		for (int i=Integer.parseInt(FirstIndex);i<=Integer.parseInt(LastIndex);i++) {
			File srcDir = new File("C:\\Program Files (x86)\\SEDCO\\SEDCO Counter Employee Software");
			File destDir = new File("C:\\Program Files (x86)\\SEDCO\\SEDCO Counter Employee Software"+i);
			FileUtils.copyDirectory(srcDir, destDir);
		}
		
    	for (int i=Integer.parseInt(FirstIndex);i<=Integer.parseInt(LastIndex);i++) {
    	String oldString = "value=\"1\"" , newString = "value=\""+i+"\"";
    	
        File fileToBeModified = new File("C:\\Program Files (x86)\\SEDCO\\SEDCO Counter Employee Software"+i+"\\Settings\\Conn.xml");
         
        String oldContent = "";
         
        BufferedReader reader = null;
         
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
             
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                 
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
             
            String newContent = oldContent.replaceAll(oldString, newString);
             
            //Rewriting the input text file with newContent
             
            writer = new FileWriter(fileToBeModified);
             
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                 
                reader.close();
                 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
		
		
		

	}

}
