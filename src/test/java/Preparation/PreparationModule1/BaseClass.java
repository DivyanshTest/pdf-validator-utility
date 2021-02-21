package Preparation.PreparationModule1;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import Preparation.PreparationModule1.ReadJson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;

	@BeforeClass
	void setiupBrowser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://stg-aktivplatform.knolskape.io");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(dataProvider="dp")
	 void launchWebPage(String data) {
		String loginCred[] = data.split(",");
		System.out.println(loginCred);
		driver.findElement(By.xpath("//*[contains(@id,'email')]")).sendKeys(loginCred[0]);
		driver.findElement(By.xpath("//*[contains(@id,'password')]")).sendKeys(loginCred[1]);
		driver.findElement(By.xpath("//*[contains(@id,'signInButton')]")).click();
		driver.findElement(By.xpath("//*[contains(@value,'SKIP')]")).click();

	}

	@AfterClass
	void tear() {
		driver.close();
	}

	@DataProvider(name = "dp")
	public String[] jsonData() throws IOException, ParseException {

		JSONParser jp = new JSONParser();
		FileReader reader = new FileReader(
				"C:\\Users\\DivyanshAgarwal\\new Eclipse\\PreparationModule1\\JsonFiles\\data.json");
		Object obj = jp.parse(reader);
		JSONObject userData = (JSONObject) obj;
		JSONArray usersCred = (JSONArray) userData.get("users");

		String array[] = new String[usersCred.size()];
		for (int i = 0; i < usersCred.size(); i++) {
			JSONObject users = (JSONObject) usersCred.get(i);
			String username = (String) users.get("username");
			String pwd = (String) users.get("password");
			array[i] = username + "," + pwd;
		}

		return array;

	}

}
