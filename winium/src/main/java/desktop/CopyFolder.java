package desktop;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FilenameUtils;

public class CopyFolder {
	public static void main (String [] args) throws IOException {
		
	    String FirstIndex = JOptionPane.showInputDialog("Enter First Folder Number", null);
		String LastIndex = JOptionPane.showInputDialog("Enter Last Folder Number", null);
		
		for (int i=Integer.parseInt(FirstIndex);i<=Integer.parseInt(LastIndex);i++) {
			File srcDir = new File("C:\\Program Files (x86)\\SEDCO\\SEDCO Counter Employee Software");
			File destDir = new File("C:\\\\Program Files (x86)\\\\SEDCO\\\\SEDCO Counter Employee Software"+i);
			FileUtils.copyDirectory(srcDir, destDir);
		}

	}

}
