package Preparation.PreparationModule1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utils.ReadConfig;

import Utility.CaptureScreenshot;
import bsh.This;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {
	public WebDriver driver;
	 static ReadConfig rf = new ReadConfig();
	
	public static WebDriver setup() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://stg-aktivplatform.knolskape.io");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//input[contains(@id,'email')]")).sendKeys("qa_vamse6@mailinator.com");
		driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("password");
		driver.findElement(By.xpath("//button[contains(@id,'signInButton')]")).click();
//		Thread.sleep(3000);
		driver.get("https://stg-aktivplatform.knolskape.io");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				return driver;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver = setup();
		List<WebElement> drp;
		Thread.sleep(25000);
		driver.findElement(By.xpath(rf.getValue("explore_journey"))).click();
		driver.findElement(By.xpath("//div[contains(@class, 'css-1hwfws3')]")).click();
//		drp = driver.findElements(By.xpath("div[contains(@class,'css-xwjg1b')]"));
		String e= driver.findElement(By.xpath("//*[contains(@class,'css-15k3avv')]")).getText();
		CaptureScreenshot.screenshot(driver, "dropdown");
		
		System.out.println(e);
		
		

	}

}
