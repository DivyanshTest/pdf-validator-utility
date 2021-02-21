package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
/**
 * 
 * @author DivyanshAgarwal
 * method name: screenshot
 */
public class CaptureScreenshot {
	
	public static void screenshot(WebDriver driver,String filename) throws IOException {
		
		// take screen shot and store it in a file format
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		// copy the screenshot file in the desired loaction ---copyfile method--
		FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\"+ "screenshots" + filename+".jpg"));
		
		
	}

}
