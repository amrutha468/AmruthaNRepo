package com.identifycourses.pages;


import com.identifycourses.base.BaseClass;
import com.identifycourses.utils.Read_Properties;

public class ReadyToTransform {
	
	
	/************************************----CLICK ON FOR-ENTERPRISE ON HOMEPAGE----*************************************/
	public static void navigateEnterprise()
	{
		BaseClass.timeOut(1000);
		BaseClass.setClick(Read_Properties.obj.getProperty("Enterprise"));
	}
	
	
	/************************************----MOUSEHOVER ON PRODUCT AND CLICK ON FOR CAMPUS OPTION----*************************************/
	public static void forCampus()
	{
		BaseClass.timeOut(1000);
		BaseClass.ProductMouseHover(Read_Properties.obj.getProperty("Product"));
		BaseClass.timeOut(1000);
		BaseClass.setClick(Read_Properties.obj.getProperty("Campus"));
		BaseClass.timeOut(1000);
		BaseClass.WindowHandle();
		BaseClass.timeOut(3000);
		BaseClass.JSE();
	}
	
	
	/************************************----SENDING FIRST NAME----*************************************/
	public static void firstName(String name)
	{
		BaseClass.timeOut(2000);
		BaseClass.setKeys(Read_Properties.obj.getProperty("firstName"),name);
		BaseClass.timeOut(200);
	}
	
	/************************************----SENDING LAST NAME----*************************************/
	public static void lastName(String surname)
	{
		BaseClass.timeOut(200);
		BaseClass.setKeys(Read_Properties.obj.getProperty("lastName"),surname);
		BaseClass.timeOut(200);
	}
	
	
	/************************************----SELECTING JOB DESCRIPTION----*************************************/
	public static void jobDescription(String description)
	{
		BaseClass.timeOut(200);
		BaseClass.setClick(Read_Properties.obj.getProperty("jobFunction"));
		BaseClass.setSelect(Read_Properties.obj.getProperty("jobFunction"),description);
		BaseClass.timeOut(200);
	}
	
	
	/************************************----SENDING JOB TITLE----*************************************/
	public static void jobTitle(String title)
	{
		BaseClass.timeOut(200);
		BaseClass.setKeys(Read_Properties.obj.getProperty("jobTitle"),title);
		BaseClass.timeOut(200);
	}

	/************************************----SENDING EMAIL----*************************************/
	public static void eMail(String email)
	{
		BaseClass.timeOut(200);
		BaseClass.setKeys(Read_Properties.obj.getProperty("email"),email);
		BaseClass.timeOut(200);
	}

	
	/************************************----SENDING PHONE NUMBER----*************************************/
	public static void phone(String phoneno)
	{
		BaseClass.timeOut(200);
		BaseClass.setKeys(Read_Properties.obj.getProperty("phone"),phoneno);
		BaseClass.timeOut(200);
	}

	
	/************************************----SENDING INSTITUTE NAME----*************************************/
	public static void instituteName(String INSname)
	{
		BaseClass.timeOut(200);
		BaseClass.setKeys(Read_Properties.obj.getProperty("institutionName"),INSname);
		BaseClass.timeOut(200);
	}

	/************************************----SELECT INSTITUTE TYPE----*************************************/
	public static void instituteType(String INStype)
	{
		BaseClass.timeOut(200);
		BaseClass.setClick(Read_Properties.obj.getProperty("institutionType"));
		BaseClass.setSelect(Read_Properties.obj.getProperty("institutionType"),INStype);
		BaseClass.timeOut(200);
	}

	/************************************----SELECT PRIMARY DISCIPLINE----*************************************/
	public static void primaryDiscipline(String discipline)
	{
		BaseClass.timeOut(200);
		BaseClass.setClick(Read_Properties.obj.getProperty("discipline"));
		BaseClass.setSelect(Read_Properties.obj.getProperty("discipline"),discipline);
		BaseClass.timeOut(200);
	}

	/************************************----SELECT COUNTRY----*************************************/
	public static void Country(String country)
	{
		BaseClass.timeOut(200);
		BaseClass.setClick(Read_Properties.obj.getProperty("country"));
		BaseClass.setSelect(Read_Properties.obj.getProperty("country"),country);
		BaseClass.timeOut(200);
	}
	public static void State(String state)
	{
		BaseClass.timeOut(200);
		BaseClass.setClick(Read_Properties.obj.getProperty("state"));
		BaseClass.setSelect(Read_Properties.obj.getProperty("state"),state);
		BaseClass.timeOut(200);
	}
	
	/************************************----SELECT STATE----*************************************/
	public static void help(String helper)
	{
		BaseClass.timeOut(200);
		BaseClass.setKeys(Read_Properties.obj.getProperty("helpdesk"),helper);
		BaseClass.timeOut(200);
	}
	
	
	/************************************----SUBMITTING THE FORM----*************************************/
	public static void submitForm()
	{
		BaseClass.timeOut(200);
		BaseClass.setClick(Read_Properties.obj.getProperty("submit"));		
	}
	
	
	/************************************----RETRIEVING THE FORM----*************************************/
	public static String getErrormsg()
	{
		BaseClass.timeOut(200);
		String msg= BaseClass.getValue(Read_Properties.obj.getProperty("errormsg"));
		return msg;
	}
	
	/************************************----REFRESH THE PAGE----*************************************/
	public static void REFRESH()
	{
		BaseClass.timeOut(2000);
		BaseClass.navRefresh();
	}
	
}
