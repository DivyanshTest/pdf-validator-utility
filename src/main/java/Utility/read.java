package Utility;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.qoppa.pdf.PDFException;
import com.qoppa.pdfText.PDFText;

import io.github.bonigarcia.wdm.WebDriverManager;

public class read {

	public static void main(String[] args) throws IOException, PDFException {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//driver.get("file:///C:/Users/DivyanshAgarwal/Downloads/Assessment%20Report_Mandar%20_1H3HqU_BLANK%20(1).pdf");
//		String getURL = driver.getCurrentUrl();
//		PDDocument doc=null ;
//		BufferedInputStream file=null;
//		String output=null;
//		URL urlOfPdf = new URL(getURL);
//		BufferedInputStream fileToParse = new BufferedInputStream(urlOfPdf.openStream());
//		PDDocument document = PDDocument.load(fileToParse);
//		output = new PDFTextStripper().getText(document);
////		System.out.println("output is-" + output);
//		if (output.isEmpty()) {
//			System.out.println("not empty");
//			
//			
//		}
//		else {
//			document.close();
//			driver.quit();
//		}
		
		System.out.println(findTextInPDF("C:/Users/DivyanshAgarwal/Downloads/empty.pdf"));
	}
	public static boolean findTextInPDF(String absoluteFilePath) throws PDFException, IOException
	{
	  boolean containsText = false;
	  InputStream inputStream = new FileInputStream(absoluteFilePath);
	  PDFText pdfText = new PDFText (inputStream, null);
	  int pageCount = pdfText.getPageCount();
	  System.out.println(pageCount);
	  for(int i = 0; i < pageCount; i++)
	  {		
	   // get the text content from the current page 	
	   String pageText = pdfText.getText(i); 
	   // if the text content is not empty
	   if (pageText!=null && pageText.trim().length()>0)
	   {
	      // set the variable containsText to true
	      containsText = true;
	      break;
	   }
	  }
	  // close the file input stream
	  inputStream.close();
	  // return
	  return containsText;
	}

}
