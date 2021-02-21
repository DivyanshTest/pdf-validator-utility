package com.listners;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestEvents implements ITestListener{

	ExtentReports instExtent= ExtentReportsManage.createReportInstance();
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		
		test = instExtent.createTest(result.getTestClass().getName() + " : " + result.getMethod().getMethodName());
		System.out.println("inside test listener started");
//		test.log(result.SUCCESS 10, "no of blank pdf");
	}

	public void onTestSuccess(ITestResult result) {
		String logtext = "<b>test Method" + result.getMethod().getMethodName() + "Successful </b>" ;
		Markup mk = MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
		test.assignAuthor("Divyansh");
		test.log(Status.PASS,mk);
		
		
		

	}

	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName());
		String re =   Arrays.toString(result.getThrowable().getStackTrace());
		test.fail("summary: \n" + re);
		String logtext = "<b>test Method:" +result.getMethod().getMethodName() + ":Failed </b>" ;
		Markup mk = MarkupHelper.createLabel(logtext, ExtentColor.RED);
		test.log(Status.FAIL,mk);
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		if(instExtent !=null) {
			instExtent.flush();
		}
	
	}

}
