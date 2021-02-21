package Preparation.PreparationModule1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerAlgo extends BaseClass {

	public static WebDriver driver;
	public static void main(String...args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.makemytrip.com/");
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//*[@class = 'lbl_input latoBold appendBottom10']")).click();
	
	String month = "March 2020";
	String date = "15";
	
	while(true) { 
		WebElement e = driver.findElement(By.xpath("//div[starts-with(@class,'DayPicker-Caption')]/div"));
		System.out.println(e.getText());
		if (month.equals(e.getText())) {
			System.out.println("identified");
		 break;	
		}
		else {
			driver.findElement(By.xpath("//*[starts-with(@class,'DayPicker-NavButton DayPicker-NavButton--next')]")).click();
		}
	}
	List<WebElement> em = driver.findElements(By.xpath("//*[@class='DayPicker-Week']//*[starts-with(@class,'DayPicker-Day')]/div/p[1]"));
	for(WebElement ele:em) {
		System.out.println(ele.getText());
		if (ele.getText().equals(date)) {
			ele.click();
			System.out.println("elem clicked");
			break;
			
		}
	}
	

	}

}
