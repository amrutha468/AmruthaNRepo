package com.identifycourses.pages;

import org.openqa.selenium.WebDriver;

import com.identifycourses.base.BaseClass;
import com.identifycourses.utils.Read_Properties;


public class searchWebDevelopment {
	
	public static WebDriver driver;
	public static String search="Web development";
	public static String courseDetails[]=new String[12];

	
	/************************************----SEARCH FOR WEB DEVELOPMENT----*************************************/
	public static void searchcourse()
	{
		BaseClass.timeOut(2000);
	    BaseClass.setKeys(Read_Properties.obj.getProperty("searchbar"),search);
	    BaseClass.timeOut(2000);
	    BaseClass.setClick(Read_Properties.obj.getProperty("search"));
	}
	
	/**********************************************----ADD FILTERS----****************************************/
	public static void addFilters()
	{
	//language selection
		BaseClass.timeOut(3000);
	   BaseClass.setClick(Read_Properties.obj.getProperty("languagefilter")); 
	   BaseClass.setClick(Read_Properties.obj.getProperty("englishoption"));
	   BaseClass.timeOut(2000);
	   BaseClass.setClick(Read_Properties.obj.getProperty("levelfilter"));
	   BaseClass.setClick(Read_Properties.obj.getProperty("beginneroption"));	  
	   BaseClass.timeOut(2000);
	   BaseClass.setClick(Read_Properties.obj.getProperty("durationfilter"));
	   BaseClass.setClick(Read_Properties.obj.getProperty("monthsoption"));
	   BaseClass.timeOut(2000);
	}
	
	/************************************----GETTING THE FIRST TWO DISPLAYED COURSES----****************************************/
	public static void getCourses()
	{
		courseDetails[0]="1st Course Name:-";
	   courseDetails[1]=BaseClass.getValue(Read_Properties.obj.getProperty("course1"));
	   BaseClass.stateinfo("Retrieving Course name from webpage");
	   BaseClass.timeOut(2000);

	   courseDetails[2]="Rating:- ";
	   BaseClass.timeOut(2000);
	   courseDetails[3]=BaseClass.getValue(Read_Properties.obj.getProperty("rating1"));
	   BaseClass.stateinfo("Retrieving Course rating from webpage");
	   BaseClass.timeOut(2000);
	   courseDetails[4]="Duration:- ";
	   courseDetails[5]=BaseClass.getValue(Read_Properties.obj.getProperty("duration"));
	   BaseClass.stateinfo("Retrieving Course duration from webpage");
	   BaseClass.timeOut(2000);
	   //2nd course name
	    courseDetails[6]="2nd Course Name:-";
	    courseDetails[7]=BaseClass.getValue(Read_Properties.obj.getProperty("course2"));
	    BaseClass.stateinfo("Retrieving Course name from webpage");
	    BaseClass.timeOut(2000);

	  //rating
	    courseDetails[8]="Rating:- ";

	  courseDetails[9]=BaseClass.getValue(Read_Properties.obj.getProperty("rating2"));
	  BaseClass.stateinfo("Retrieving Course rating from webpage");
	  BaseClass.timeOut(2000);
	  courseDetails[10]="Duration:- ";
	   courseDetails[11]=BaseClass.getValue(Read_Properties.obj.getProperty("duration"));
	   BaseClass.stateinfo("Retrieving Course duration from webpage");
	   BaseClass.timeOut(2000);
	  for(int i=0;i<12;i++)
		  System.out.println(courseDetails[i]);
	  BaseClass.timeOut(2000);
	}
	
	
	/**********************************************----VERIFYING THE COURSE SEARCHED IS SAME----****************************************/
	public static String verify1stCourse()
	{
		String valid=BaseClass.getAnswer(Read_Properties.obj.getProperty("searchbar"));
		return valid;
	}
	
	/**********************************************----NAVIGATING BACK TO HOMEPAGE----****************************************/
	public static void toHomepage()
	{
		BaseClass.timeOut(2000);
		BaseClass.navBack();
		BaseClass.timeOut(2000);
		BaseClass.navBack();
		BaseClass.timeOut(2000);
		BaseClass.navBack();
		BaseClass.timeOut(2000);
		BaseClass.navBack();
		BaseClass.timeOut(10000);
	}
}

