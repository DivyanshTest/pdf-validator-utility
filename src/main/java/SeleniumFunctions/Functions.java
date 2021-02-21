package SeleniumFunctions;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Preparation.PreparationModule1.ReadJson;
import Utility.ReadExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author DivyanshAgarwal
 * common functions to support pdf validation
 */
public class Functions {

	public static WebDriver driver;
	

	public static void downloadPdf() throws IOException {
		
		driver = setupBrowserInstance();		
		ArrayList<String> links = ReadExcel.ExcelReader("Sheet1","MultipleBatches_BatchAssessmentPerformanceReport_20638_Deloitte.xlsx");
		for (int i = 0; i < links.size(); i++) {
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			System.out.println(links.get(i));
			driver.get(links.get(i));
//			String filePath="C:\\Users\\DivyanshAgarwal\\new%20Eclipse\\PreparationModule1\\DownoadedPDF\\"+i+".pdf";
//			System.out.println(filePath);
//			URL url = new URL(links.get(i));
//	    	String command="curl -o "+filePath+" "+url;
//	    	System.out.println(command);
//	    	Process p = Runtime.getRuntime().exec(command);

		}
		System.out.println("download-completed");
		driver.quit();

	}

	public static String prepareFileURL(String filename) {

		String url = System.getProperty("user.dir") + "\\prodDeloittePDF-v1\\" + filename;
//		System.out.println(url);
		return url;

	}

	public static ArrayList<String> getFilePathFromFolder() {
		ArrayList<String> localList = new ArrayList<String>();
		String path = System.getProperty("user.dir") + "\\prodDeloittePDF-v1";
		File file = new File(path);
		File[] files = file.listFiles();
		for (File f : files) {
			localList.add(prepareFileURL(f.getName()));

		}

		return localList;

	}

	public static WebDriver setupBrowserInstance() {
		String fileDownloadPath = System.getProperty("user.dir") + "\\prodDeloittePDF-v1";
		WebDriverManager.chromedriver().setup();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", fileDownloadPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.setExperimentalOption("prefs", chromePrefs);
		driver = new ChromeDriver(options);	
		return driver;

	}
	public static void main(String...args) throws IOException {
		downloadPdf() ;
	}

}
