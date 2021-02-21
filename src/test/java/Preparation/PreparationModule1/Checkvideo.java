package Preparation.PreparationModule1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFunctions.Functions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkvideo {
	public WebDriver driver;

//	public static void jsFunction() {
//		document.getElementsByTagName("button");
//	}

	public static WebDriver setup() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://stg-aktivplatform.knolskape.io");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[contains(@id,'email')]")).sendKeys("vid2@mailinator.com");
		driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("passwoRD@123");
		driver.findElement(By.xpath("//button[contains(@id,'signInButton')]")).click();
//		Thread.sleep(3000);
		driver.get("https://stg-aktivplatform.knolskape.io");
		driver.manage().window().maximize();

		return driver;

	}

	public static void main(String[] args) throws InterruptedException {
		WebElement element1;
		WebElement iframe;
		WebElement e;
		WebDriver driver = setup();
		WebElement searchbox = null;
//		List<WebElement> searchbox=null;
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[contains(@class,'_1em9a9b') and starts-with(text(),'Continue Learning')]"))
				.click();

		e = driver.findElement(
				By.xpath("//*[contains(@class,'module-3nsu7s2tengyn99vkf824h64584x7c7w7m3qtnc3czsg277muzpxu"
						+ "xu3fs8vj9cmvw5p8n93yq1zs1qw918j3ya6ws96zeuzhbd6qsy-moduleItemCard-module-desc-and-competency-cnt "
						+ "module-3cszs2uw7188fetxtaf6cufsj9qjz63seybg6yd2at4qta9k45k97xjtas74a179sqwfpe4sky4av152t2yef52rz4y4gk621h2fse3-moduleItemCard-module-item-desc-cnt')]/div"));
		wait.until(ExpectedConditions.visibilityOf(e));
		e.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		iframe = driver.findElement(By.xpath("//iframe[contains(@id,'video-player-container_ifp')]"));
		System.out.println(iframe.getAttribute("id"));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframe);
//		System.out.println(iframe.getAttribute("id"));
		
//		element = (List<WebElement>) js.executeScript("return document.getElementsByTagName(\"button\");");
//		element1 = driver.findElement(By.xpath("//div[contains(@class,'controlBarContainer hover open')]//div[contains(@class,'controlsContainer')]/button[1]"));
//		element1 = driver.findElement(By.xpath("//div[contains(@class,'videoHolder hover')]//a[contains(@class,'icon-play  comp largePlayBtn  largePlayBtnBorder')]"));
		
		
//		js.executeScript("document.getElementsByClassName('icon-play  comp largePlayBtn  largePlayBtnBorder')[0].click();");
//		"document.querySelector('" + str + "').addEventListener('click', function(){alert('text')});"
		
//	Thread.sleep(4000);
		js.executeScript("alert('success');");
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );
		js.executeScript("document.querySelector('.icon-play  comp largePlayBtn  largePlayBtnBorder').click();");

	System.out.println("success");
		
//		wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
//		 searchbox = (WebElement) js.executeScript("return document.getElementById('video-player-container');", searchbox);
//		 searchbox.click();
//		WebElement pls= driver.findElement(By.cssSelector("div[id*='video-player-container']"));
//		System.out.println(pls.getTagName());
		
//searchbox.click();
	
//		 List<WebElement> elements1 = driver.findElements(By.tagName("iframe"));
////		 WebElement n = driver.findElement(By.xpath("//*[contains(@class,'videoHolder hover')]/div/video[contains(@class,'persistentNativePlayer nativeEmbedPlayerPid')]"));
////		 WebElement n = driver.findElement(By.xpath("//div[contains(@class,'videoHolder hover')]//a[contains(@class,'icon-play  comp largePlayBtn  largePlayBtnBorder')]"));
//		 for(int i=0;i<elements1.size();i++) {
//			 System.out.println("frame is:" +elements1.get(i).toString());
////		     driver.switchTo().defaultContent();
////		     driver.switchTo().frame(elements1[1]);
////		     if (driver instanceof JavascriptExecutor) {
////		    	
////		    	 try {
////		    		 Thread.sleep(5000);
////		    		 WebElement n = driver.findElement(By.xpath("//*[@name='video-player-container_ifp']"));
////		    		 js.executeScript("arguments[0].click();",n);
//////		    		 ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('btn comp playPauseBtn display-high icon-play')[0].click();");
////				} catch (Exception e2) {
//////					e2.printStackTrace();
////					System.out.println("error msg:" +e2.getMessage());
////					continue ;
////				}
////	         System.out.println("video started");
////	     }
// }
//	 
//////		System.out.println(searchbox.getTagName());
}

} 
