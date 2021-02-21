package Preparation.PreparationModule1;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import com.qoppa.pdf.PDFException;

import SeleniumFunctions.Functions;
import Utility.ReadPdf;
@Listeners(com.listners.TestEvents.class)
public class PDFtestvalidation extends Functions{

	@Test(priority=0)
	void loadPdf() throws IOException  {

		Functions.downloadPdf();
	}
	 @Test(priority=1)
	 void validateIfEmptyIsPdf() throws IOException, PDFException {
//		 Assert.assertEquals("one or more pdf pages are blank", ReadPdf.pdfReader());
		 int result = ReadPdf.pdfReader();
		 System.out.println("total count of empty pdfs:" + result);
//		 System.out.println("from test 1");
//		 assertTrue(false);
		 
		 assertTrue(result ==0, "one or more pdf pages are blank");
	
	 }
}
