package Preparation.PreparationModule1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qoppa.j.d;
import com.utils.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author DivyanshAgarwal
 *
 */

public class RequestJourney {
ReadConfig rc = new ReadConfig();

@Test(dataProvider="LoginDataProvider")
public void userLogin(String email,String pwd) throws InterruptedException, IOException {
//	System.out.println(email+ "    "+ pwd);
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	driver.get(rc.getValue("baseURL1"));
	System.out.println(driver.getTitle());
	driver.findElement(By.xpath(rc.getValue("email"))).sendKeys(email);
	driver.findElement(By.xpath(rc.getValue("password"))).sendKeys(pwd);
	driver.findElement(By.xpath(rc.getValue("login"))).click();
//	Thread.sleep(3000);
	driver.get(rc.getValue("baseURL1"));
	driver.manage().window().maximize();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//div[contains(text(),'+Enroll for another journey')]")).click();
	
//	List<WebElement>element2 = driver.findElements(By.xpath(""));	
	
//	WebElement ele3 = element2.get(0);
	Thread.sleep(5000);
	List<WebElement> element2 = driver.findElements(By.className("_sq6t1r"));
	System.out.println("list size:"+element2.size());
	for(int i=0;i<element2.size();i++) {
	WebElement ele3 = element2.get(i);
	new WebDriverWait(driver, 12).until(ExpectedConditions.elementToBeClickable(ele3)).click();
	System.out.println("element clicked");
	Thread.sleep(4000);
	WebElement w=  driver.findElement(By.xpath("//div[contains(text(),'Request Access')]"));
	executor.executeScript("window.document.getElementsByClassName('_304vgh module-kjx6k6fkjebp97gwj7n2rt37uyysbrre3z666bvcb685d52zhqm61s9de6qnpny5cc6mbp1tw29ukczx1s5jvs458au5d2nt8yy57b-primaryButton-module-button-style')[0].click();");
	
	break;
	}
	System.out.println("outside the loop : journey requested");
	driver.close();
}

	@DataProvider(name = "LoginDataProvider")
	public static Object[][] getData() throws IOException {
		LinkedHashMap<String, String> data = readExcel("MOCK_DATA (22)", "MOCK_DATA 1.xlsx");
		Object[][] testdata = (Object[][]) new Object[data.size()][2];
		Set entries = data.entrySet();
		Iterator entriesIterator = entries.iterator();

		int i = 0;
		while (entriesIterator.hasNext()) {

			Map.Entry mapping = (Map.Entry) entriesIterator.next();

			testdata[i][0] = mapping.getValue();
			testdata[i][1] = mapping.getKey();

			i++;
		}

		return testdata;

	}

//	public static void main(String[] args) throws IOException {
//
//		LinkedHashMap<String, String> data = readExcel("MOCK_DATA (22)", "MOCK_DATA (22).xlsx");
//		System.out.println(Arrays.deepToString(getData()));
////		System.out.println(data.size());
////		for (String j : data.keySet()) {
////        	System.out.println("value is:" + j);
////		}
//
//	}
	public static LinkedHashMap<String, String> readExcel(String sheetname, String excelname) throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		String excelFilePath = System.getProperty("user.dir") + "\\" + excelname;
		String fileName = excelname;
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		Workbook workbook = null;
		System.out.println(fileExtensionName);
		try {
			if (fileExtensionName.equals(".xlsx")) {
				workbook = new XSSFWorkbook(inputStream);
			} else if (fileExtensionName.equals(".xls")) {
				workbook = new HSSFWorkbook(inputStream);

			}
		} catch (NullPointerException e) {
			System.out.println(e);
		}

		org.apache.poi.ss.usermodel.Sheet newsheet = workbook.getSheet(sheetname);
		int rowCount = newsheet.getLastRowNum();
		System.out.println(rowCount);
		int count = 0;
		int count1 = rowCount + 1;
		String val = "password";
		for (int i = 1; i < rowCount + 1; i++) {
			Row row = newsheet.getRow(i);
			map.put(val + count, row.getCell(2).getStringCellValue());
			count++;
//	        	System.out.print(row.getCell(2).getStringCellValue());
//	        	map.put(count, row.getCell(3).getStringCellValue());

		}

		return map;
	}

}
