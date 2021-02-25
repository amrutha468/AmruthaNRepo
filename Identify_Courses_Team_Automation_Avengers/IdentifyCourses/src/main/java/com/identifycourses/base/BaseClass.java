package com.identifycourses.base;

import java.io.File;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.identifycourses.utils.DriverSetup;
import com.identifycourses.utils.GenerateExtentReport;
import com.identifycourses.utils.Read_Properties;
import com.identifycourses.utils.captureDate;



public class BaseClass {
	
	public static WebDriver driver;
	public static String lists[]=new String[51];
	public static String DDarray[][]=new String[51][2];
	public static ExtentReports report = GenerateExtentReport.getReportInstance();
	public static ExtentTest logger;
	
	
	/*****************************************----INTIALIZING DRIVER----************************************/
	public static void createDriver()
	{
		driver=DriverSetup.getDriver();
	}
	
	
	
	/*****************************************----REFRESH DRIVER----************************************/
	public static void navRefresh()
	{
		driver.navigate().refresh();
	}
	
	
	/*****************************************----NAVIGATE DRIVER BACK----************************************/
	public static void navBack()
	{
		driver.navigate().back();
	}
	
	
	/*****************************************----FUNCTION FOR SENDKEYS----************************************/
	public static void setKeys(String xpath,String value)
	{
		driver.findElement(By.xpath(xpath)).sendKeys(value);
	}
	
	
	/*****************************************----FUNCTION FOR CLICK----************************************/
	public static void setClick(String xpath)
	{
		driver.findElement(By.xpath(xpath)).click();
	}
	
	
	/****************************----FUNCTION FOR SELECTING VALUE IN A DROPDOWN----*******************************/
	public static void setSelect(String xpath,String value)
	{
		
		Select drptype=new Select(driver.findElement(By.xpath(xpath)));
        drptype.selectByValue(value);
	}
	
	
	/*****************************************----FUNCTION FOR DRIVER TIMEOUT----************************************/
	public static void timeOut(int time)
	{
		try {
			Thread.sleep(time);
		}
		catch(InterruptedException e)
		{
			System.out.println("error");
		}
	}
	
	
	/*****************************************----FUNCTION FOR RETRIEVING VALUE----************************************/
	public static String getValue(String xpath)
	{
		String text=driver.findElement(By.xpath(xpath)).getText();
		return text;
	}
	
	
	/*********************************----FUNCTION FOR RETREIEVING VALUES AND MESSAGES FROM WEBPAGE ----*****************************/
	public static String getAnswer(String xpath)
	{
		String text=driver.findElement(By.xpath(xpath)).getAttribute("value");
		return text;
	}
	
	
	/**********************----FUNCTION FOR RETRIEVING LIST OF VALUES AND RETURN THEM AS STRING ARRAY ----************************************/
	public static String[] getList(String Attribute1, String Attribute2)
	{
		 List<WebElement> langList = driver.findElements(By.className(Attribute1));	//using common locator to get results
			for(int i=9;i<langList.size();i++)
			{
				lists[i-9]=langList.get(i).findElements(By.className(Attribute2)).get(0).getText();
			}
		return lists;
	}
	
	
	/**********************----FUNCTION FOR RETRIEVING LIST OF VALUES AND RETURN THEM AS STRING ARRAY ----************************************/
	public static String[] getListLevel(String Attribute1, String Attribute2)
	{
		 List<WebElement> langList = driver.findElements(By.className(Attribute1));	//using common locator to get results
			for(int i=0;i<langList.size();i++)
			{
				lists[i]=langList.get(i).findElements(By.className(Attribute2)).get(0).getText();
			}
		return lists;
	}
	
	
	/**********************----TWO SINGLE ARRAY TO ONE 2D-ARRAY CONVERTOR ----*****************************/
	public static String[][] converter2D(String array1[],String array2[])
	{
		for(int i=0;i<array1.length;i++)
		{
			for(int j=0;j<2;j++)
			{
				if(j==0)
				{
					DDarray[i][j]=array1[i];
				}
				if(j==1)
				{
					DDarray[i][j]=array2[i];
				}
			}
		}
		return DDarray;
	}
	
	
	/**********************----FUNCTION FOR MOUSE HOVER----******************************/
	public static void ProductMouseHover(String xpath1)
	{
		WebElement product=driver.findElement(By.xpath(xpath1));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(product).build().perform();	
	}
	
	
	/**********************----FUNCTION FOR MULTIPLE TABS AND SWITCHING BETWEEN THEM----******************************/
	public static void WindowHandle()
	{
		String parent =driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		Iterator<String> itr = windows.iterator();
		while(itr.hasNext())
		{
			String childWindow=itr.next();
			if(!parent.equals(childWindow))
			{
				driver.switchTo().window(childWindow);
			}
		}
	}
	
	
	/**********************----FUNCTION FOR SCROLLING DOWN THE WEBPAGE----******************************/
	public static void JSE()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,4000)");
	}
	
	
	
	/****************************----REPORT CREATE TEST----**************************************/	
	public static void setTest(String Test)
	{
		logger=report.createTest(Test);
	}
	

	/****************************----REPORT STATUS INFO----**************************************/	
	public static void stateinfo(String info)
	{
		logger.log(Status.INFO,info);
	}
	
	
	/****************************----REPORT STATUS PASs----**************************************/	
	public static void statepass(String pass)
	{
		logger.log(Status.PASS,pass);
	}
	
	
	/****************************----REPORT CREATE TEST----**************************************/	
	public static void reportFlush()
	{
		report.flush();
	}
	
	
	/**********************----FUNCTION FOR TAKING SCREENSHOTS----******************************/
	public static void captureErrorText(String fileName)
	{
		TakesScreenshot tShot=(TakesScreenshot)driver;
		File srcFile=tShot.getScreenshotAs(OutputType.FILE);
		File destFile=new File(System.getProperty("user.dir")+Read_Properties.obj.getProperty("capturePath")+fileName+captureDate.getDateTime()+".jpg"); 
		try{
	    	FileHandler.copy(srcFile, destFile);
	    }catch(IOException e){
	    	e.printStackTrace();
	    }
	}
	
	
	/**********************----FUNCTION FOR QUITTING BROWSER----******************************/
	public static void closeBrowser()
	{
		driver.quit();
	}
}
