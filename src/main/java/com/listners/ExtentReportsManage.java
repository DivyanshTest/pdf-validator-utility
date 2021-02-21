package com.listners;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsManage {
	
	
	static ExtentReports extent;
	
	public static ExtentReports createReportInstance() {
		String path = System.getProperty("user.dir") + "\\reports\\" +"extent_1" + ".html" ;
		System.out.println(path);
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		reporter.config().setEncoding("utf-8");
		reporter.config().setDocumentTitle("pdf validation report");
		reporter.config().setReportName("Test validation report");
		reporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(reporter);
		
		return extent;
	}
	
//	public static void newFileName() {
//		Date d = new Date();
//		d.
//	}

}
