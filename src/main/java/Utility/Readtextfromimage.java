package Utility;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.utils.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Readtextfromimage {

	static WebDriver driver;
	static ReadConfig rc = new ReadConfig();

	public static void loginToPlatform() throws IOException, InterruptedException {

		driver = setupBrowserInstance();
		Actions ac = new Actions(driver);
		driver.get("https://stg-aktivplatform.knolskape.io/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(rc.getValue("email"))).sendKeys("stg_support9@mailinator.com");
		driver.findElement(By.xpath(rc.getValue("password"))).sendKeys("password");
		driver.findElement(By.xpath(rc.getValue("login"))).click();
		Thread.sleep(30000);
		driver.get("https://stg-aktivplatform.knolskape.io/#/batch/4392");
		Thread.sleep(8000);
		driver.findElement(By.xpath(rc.getValue("linkedinButton"))).click();
		Thread.sleep(15000);
//		WebElement e = driver.findElement(By.xpath("//body[contains(@class,'system-fonts')]"));
		String parentWindow = driver.getWindowHandle();
		System.out.println("befroe switching " + parentWindow);
//		ac.keyDown(Keys.ALT).keyDown(Keys.TAB).build().perform();
//		ac.sendKeys(Keys.chord(Keys.ALT,Keys.TAB));
//		ac.sendKeys(Keys.chord(Keys.CONTROL, "T")).build().perform();

		System.out.println("new child window title:: " + driver.getTitle());
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles.size());

		Iterator<String> ith = handles.iterator();
		while (ith.hasNext()) {
			System.out.println(ith.next());
			driver.switchTo().window(ith.next().toString());
			System.out.println("new child window title:: " + driver.getTitle());

		}
//		   for(String windowHandle  : handles)
//		       {
//			   System.out.println(windowHandle);
//			   Thread.sleep(8000);
//			   System.out.println("after switching child " +windowHandle);
//		          driver.switchTo().window(windowHandle);
//		          System.out.println("inside linkedin window");
//		          System.out.println("Window title is : "+driver.getTitle());
//		          JavascriptExecutor js = (JavascriptExecutor)driver;
//		          js.executeScript("document.getElementsByTagName(\"input\")[1].value='divyansh.agarwal41@gmail.com'");
//		          driver.findElement(By.xpath("//div[contains(@class,'form__input--floating')]/input[contains(@id,'username')]")).sendKeys("divyansh.agarwal41@gmail.com");
//		          driver.findElement(By.xpath("//input[@id= 'password']")).sendKeys("divyansh@01");
//		          driver.findElement(By.xpath("//button[@class= 'btn__primary--large from__button--floating']")).click();

//		       }

	}

	public static WebDriver setupBrowserInstance() {
//		String fileDownloadPath = System.getProperty("user.dir") + "\\prodDeloittePDF-v1";
		WebDriverManager.chromedriver().setup();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
//		chromePrefs.put("download.default_directory", fileDownloadPath);
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
		options.setExperimentalOption("prefs", chromePrefs);
		driver = new ChromeDriver();
		return driver;

	}

	/**
	 * Method Description: this is the method which calls all the sub methods and gets the extracted Journey name and Completion date
	 */
	public static void extractDetailsFromImage() {
// pass the image folder location in the constructor param
		File file = new File("./certificate_image");
		File[] files = file.listFiles();
		System.out.println("Extracted RAW data string without processing " + getImageURL(prepareFileURL(files[0].getName())));
		String extractedImageData = getImageURL(prepareFileURL(files[0].getName())).replace("\n", "");
		String journeyName = extractJourneyName(extractedImageData);
		String completionDate = extractJourneyCompletionDate(extractedImageData, journeyName);
		System.out.println("journey completion date: " + completionDate + " & " + "journeyname: " + journeyName);
	}

	/**
	 * Method description: this method creates a file directory location url,appends
	 * the filename to the file location directory
	 * 
	 * @param filename
	 * @return url
	 */
	public static File prepareFileURL(String filename) {
		File url = new File(System.getProperty("user.dir") + "\\certificate_image\\" + filename);
//		System.out.println(url);
		return url;
	}

	/**
	 * Method Description: takes the file location of image as input and using
	 * Tesseract Api extracts the image text. In the tessdata folder store the
	 * eng.traineddata file and pass the file location to setDatapath method
	 * Download the file from here: https://github.com/tesseract-ocr/tessdata Tess4j
	 * wrapper mvn repo:
	 * https://mvnrepository.com/artifact/net.sourceforge.tess4j/tess4j Dependency
	 * version used: 4.2.1
	 * 
	 * @param stringurl
	 * @return String extracted image data
	 */
	public static String getImageURL(File stringurl) {
		String imageData = null;
		ITesseract instancedata = new Tesseract();
		instancedata.setDatapath("./tessdata");
		try {

			imageData = instancedata.doOCR(stringurl);

		} catch (TesseractException e) {
			System.out.println("an error has occurred in the image folder" + " " + e.getMessage());
		}

		return imageData;
	}

	/**
	 * Method Description: This function does string manipulation and extracts the
	 * journey name from the raw image data.
	 * 
	 * @param rawstringdata
	 * @return String journey name
	 */
	public static String extractJourneyName(String rawstringdata) {
		String journeyName = rawstringdata.split("Completing")[1].split("]")[0];
		return journeyName;

	}

	/**
	 * Method Description: This function does string manipulation and extracts the
	 * JourneyCompletionDate from the extracted raw data.
	 * 
	 * @param rawstring
	 * @param journeyName
	 * @return String JourneyCompletionDate
	 */
	public static String extractJourneyCompletionDate(String rawstring, String journeyName) {
		String journeyCompletionDate = rawstring.substring(rawstring.lastIndexOf(journeyName)).split("@")[1]
				.split(" ")[1].replaceAll("[A-Za-z]", "");
		return journeyCompletionDate;
	}

	public static void main(String... args) throws IOException, InterruptedException {
//		loginToPlatform();
		extractDetailsFromImage();
	}
}
