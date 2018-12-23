package desktop;

//import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
//import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class LoginCES {
	
	public static void main (String [] args) throws MalformedURLException, InterruptedException {
		
		String FirstIndex = JOptionPane.showInputDialog("Enter First Index", null);
		String LastIndex = JOptionPane.showInputDialog("Enter Last Index", null);
		
		DesktopOptions option = new DesktopOptions();
		
		for (int i=Integer.parseInt(FirstIndex);i<=Integer.parseInt(LastIndex);i++) {
			try {
			option.setApplicationPath("C:\\Program Files (x86)\\SEDCO\\SEDCO Counter Employee Software"+i+"\\CVMEmployeeSoftware.exe");
			option.setArguments("notsingleton");
			option.toCapabilities();
			JFrame frame = new JFrame("test");
			frame.setAlwaysOnTop(true);	
			
			WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"),option);

			Thread.sleep(10000);
			
			String Username= "user";
			String Password = "1234";
			
			driver.findElement(By.id("txtLoginName")).sendKeys(Username+i);
			
			driver.findElement(By.id("txtPassword")).sendKeys(Password);
			
			driver.findElement(By.id("btnLogin")).click();
			
			if(driver.findElement(By.id("frmMsgBox")).isEnabled()){
				System.out.print("OK");
				 Robot rb = new Robot();
				 rb.keyPress(KeyEvent.VK_ALT);
				 rb.keyPress(KeyEvent.VK_O);
				 rb.keyRelease(KeyEvent.VK_ALT);
			}
			
			}catch (Exception e) {
				int newIndex = i+1;
				for (int j=newIndex;j<=Integer.parseInt(LastIndex);j++) {
					try {
						option.setApplicationPath("C:\\Program Files (x86)\\SEDCO\\SEDCO Counter Employee Software"+j+"\\CVMEmployeeSoftware.exe");
						option.setArguments("notsingleton");
						
						WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"),option);
						
						
						Thread.sleep(10000);
						
						
						String Username= "user";
						String Password = "1234";
						
						driver.findElement(By.id("txtLoginName")).sendKeys(Username+j);
						
						driver.findElement(By.id("txtPassword")).sendKeys(Password);
						
						driver.findElement(By.id("btnLogin")).click();
						
						i = j;
						
						}catch (Exception r) {
							JOptionPane.showMessageDialog(null, "Failed");
							System.exit(1);
						}
					
				}

			}

		}

	}

}
