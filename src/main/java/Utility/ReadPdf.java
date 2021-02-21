package Utility;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;

import com.qoppa.n.o.sy;
import com.qoppa.pdf.PDFException;
import com.qoppa.pdfText.PDFText;

import SeleniumFunctions.Functions;

public class ReadPdf  {
	static int countOfEmptyPdf = 0;
	public static int pdfReader() throws IOException, PDFException   {
		PDDocument doc=null ;
		String PDFText=null;
		BufferedInputStream file=null;	
		int pdfNotEmpty = 0;
		
		ArrayList<String> filePath = Functions.getFilePathFromFolder();
		for(int i=0; i< filePath.size(); i++) {
			System.out.println("reading file-" +filePath.get(i));	
			pdfNotEmpty = pdfParser(filePath.get(i));
			
		}
		System.out.println("All pdf's are validated");
		return pdfNotEmpty;
	}
	
public static int pdfParser(String pdfFilePath) throws IOException, PDFException {
	
	  boolean pdfcontainsText = false;
	  InputStream inputStream = new FileInputStream(pdfFilePath);
	  long filesize = inputStream.available();
	  long filesizeInKB = filesize / 1024;
	  System.out.println(filesizeInKB);
	  PDFText pdfText = new PDFText (inputStream, null);
	  int pageCount = pdfText.getPageCount();
	  for(int i = 0; i < pageCount; i++)
	  {		 	
	   String pageText = pdfText.getText(i); 
	   if (filesizeInKB>200 && pageText !=null ){
//		   pageText.trim().length();
	      pdfcontainsText = true;
	      System.out.println("pdfisnotEmpty:" + "page-no"+ i + " " + pdfcontainsText);
//	      break;
	   }
	   else {
		   System.out.println("pdfisEmpty at filePath:"+pdfFilePath +" " + "condition of pdf:" +pdfcontainsText);
		   countOfEmptyPdf ++;
		   break;
		   
	   }
	  }	
	  inputStream.close();
//	  System.out.println("total count of empty pdfs::" + countOfEmptyPdf);
	  return countOfEmptyPdf;
	}



public static void main(String...args) throws IOException, PDFException {
	System.out.println(pdfReader());
}
}



