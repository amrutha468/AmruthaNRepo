package com.identifycourses.pages;


import com.identifycourses.base.BaseClass;
import com.identifycourses.utils.Read_Properties;


public class searchLanguages {
	public static String array2D[][]=new String[51][2];
	public static String langLevel[][]=new String[4][2];
	public static String Total[]=new String[51];
	public static String languageList[]=new String[51];
	public static String courseList[]=new String[51];
	public static String languageLevel[]=new String[4];
	public static String languageLevel2[]=new String[4];
	public static String languageLevelTotal[]=new String[4];
	
	/************************************----SEARCH FOR LANGUAGE LEARNING----*************************************/
	public static void searchLang()
	{
		BaseClass.timeOut(6000);
	    BaseClass.setKeys(Read_Properties.obj.getProperty("searchbar"),"Language learning");
	    BaseClass.timeOut(2000);
	    BaseClass.setClick(Read_Properties.obj.getProperty("search"));
	}
	
	
	/************************************----GETTING ALL THE LANGUAGES OFFERED TO LEARN----*************************************/
	public static void getLanguages()
	{
		BaseClass.timeOut(4000);
		BaseClass.setClick(Read_Properties.obj.getProperty("selectLang"));
		BaseClass.timeOut(2000);
		BaseClass.setClick(Read_Properties.obj.getProperty("showAll"));
		BaseClass.timeOut(2000);
		languageList=BaseClass.getList(Read_Properties.obj.getProperty("langClass"),Read_Properties.obj.getProperty("langName"));
		for(int j=0;j<51;j++)
		{
			Total[j]=languageList[j];
		}
	}
	
	/************************************----GETTING ALL THE COURSES ON THE LANGUAGES OFFERED TO LEARN----*************************************/
	public static void getLangCourse()
	{
		BaseClass.timeOut(2000);
		courseList=BaseClass.getList(Read_Properties.obj.getProperty("langClass"),Read_Properties.obj.getProperty("courseTotal"));
		BaseClass.setClick(Read_Properties.obj.getProperty("close"));
	}
	
	
	/************************************----GETTING A 2-D ARRAY BY PASSING TWO 1-D ARRAYS----*************************************/
	public static void get2D()
	{
		array2D=BaseClass.converter2D(Total,courseList);
		for(int i=0;i<51;i++)
		{
			for(int j=0;j<2;j++)
			{
				System.out.println(array2D[i][j]);
			}
		}
	}
	
	
	/************************************----GETTING THE LEVELS OF DIFFICULTY FOR THE COURSES----*************************************/
	public static void getLevels()
	{
		BaseClass.timeOut(2000);
		BaseClass.setClick(Read_Properties.obj.getProperty("selectLevel"));
		BaseClass.timeOut(2000);
		languageLevel=BaseClass.getListLevel(Read_Properties.obj.getProperty("levelClass"),Read_Properties.obj.getProperty("levelName"));
		for(int j=0;j<4;j++)
		{
			System.out.println(languageLevel[j]);
		}
	}
	
	
	/************************************----GETTING THE COURSES BASED ON THAT DIFFICULTY----*************************************/
	public static void getLevelsTotal()
	{

		BaseClass.timeOut(2000);
		languageLevelTotal=BaseClass.getListLevel(Read_Properties.obj.getProperty("levelClass"),Read_Properties.obj.getProperty("levelTotal"));
		for(int j=0;j<4;j++)
		{
			System.out.println(languageLevelTotal[j]);
		}
	}
	
	
	
	/************************************----VERIFYING THE SEARCHED COURSE SAME AS COURSE2----*************************************/
	public static String verifyCourse2()
	{
		String learn=BaseClass.getAnswer(Read_Properties.obj.getProperty("searchbar"));
		return learn;
	}
	
	
	/************************************----NAVIGATING BACK TO HOMEPAGE----*************************************/
	public static void gotoHome()
	{
		BaseClass.timeOut(2000);
		BaseClass.navBack();
	}

}
