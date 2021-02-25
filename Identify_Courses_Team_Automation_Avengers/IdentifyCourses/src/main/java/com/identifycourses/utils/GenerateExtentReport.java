package com.identifycourses.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateExtentReport {
	/**************************---FOR GENERATING EXTENT REPORT---************************/
	public static ExtentReports report;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports getReportInstance()
	{
		if(report==null)
		{
			String ReportName=captureDate.getDateTime()+".html";
			htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+ReportName);
			report=new ExtentReports();
			report.attachReporter(htmlReporter);
			
			report.setSystemInfo("OS","Windows 10");
			report.setSystemInfo("Environmnet","Eclipse");
			report.setSystemInfo("Browser","Chrome");
			
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setDocumentTitle("Test Automation Results");
			htmlReporter.config().setReportName("Test Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMMM DD YYYY HH:MM:SS");
		}
		return report;
	}
}
