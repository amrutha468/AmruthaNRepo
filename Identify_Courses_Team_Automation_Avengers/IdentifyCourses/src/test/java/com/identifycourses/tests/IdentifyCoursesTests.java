package com.identifycourses.tests;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;



import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.identifycourses.base.BaseClass;
import com.identifycourses.pages.ReadyToTransform;
import com.identifycourses.pages.searchLanguages;
import com.identifycourses.pages.searchWebDevelopment;
import com.identifycourses.utils.Read_Excel;
import com.identifycourses.utils.Read_Properties;
import com.identifycourses.utils.Write_Excel;
import com.identifycourses.utils.Write_Excel1;


public class IdentifyCoursesTests {
	public static String formData[]=new String[12];
	public static String numError="Must be a phone number."+"\n"+"503-555-1212";
	public static String emailError="Must be valid email."+"\n"+"example@yourdomain.com";
	public static String msgError="This field is required.";
	public static String insError="Please type in the full name of your institution.";
	public static Logger logger;  

	/**********************************************----READ PROPERTIES FILE----****************************************/
	/**********************************************----READ EXCEL FILE AND STORE DATA IN ARRAY ---****************************************/
	/**********************************************----INITIALIZE THE DRIVER----****************************************/
	@BeforeSuite
	public static void getData()
		{
			Read_Properties.read();
			PropertyConfigurator.configure("src/main/resources/objectRepository/log4j.properties");
			logger=Logger.getLogger("Identify Courses");
			formData=Read_Excel.setFormValue();
			BaseClass.createDriver();
		}
	
	
	/**********************************************----TEST CASE 1----****************************************/
	/*****************************************----SEARCH AND VERIFY COURSE 1----****************************************/
	@Test(priority=0)
	public static void Test_Case1()
	{
		logger.info("\n"+" Identify Courses Test Starts");
		BaseClass.setTest("Test_Case 01");
		searchWebDevelopment.searchcourse();
		BaseClass.stateinfo("The course name is searched");
		logger.info("\n"+" Web Development course is searched");
		searchWebDevelopment.addFilters();
		BaseClass.stateinfo("All the required filters are added");
		logger.info("\n"+" Filters are added");
		searchWebDevelopment.getCourses();
		BaseClass.stateinfo("Course names and rating are passed to an array");
		logger.info("\n"+" Course details are displayed on the console and stored in the array");
		String valid=searchWebDevelopment.verify1stCourse();
		Assert.assertEquals("Web development",valid);
		BaseClass.stateinfo("Course name is returned and verified");
		logger.info("\n"+" Course name is returned and verified");
		BaseClass.statepass("Test_Case 01 passed");
		logger.info("\n"+" Test_Case 01 passed");
		searchWebDevelopment.toHomepage();
	}
	
	/**********************************************----TEST CASE 2----****************************************/
	/*****************************************----SEARCH AND VERIFY COURSE 2----****************************************/
	@Test(priority=1)
	public static void Test_Case2()
	{
		BaseClass.setTest("Test_Case 02");
		logger.info("\n"+" Search for language learning");
		searchLanguages.searchLang();
		BaseClass.stateinfo("The course name is searched");
		searchLanguages.getLanguages();
		BaseClass.stateinfo("Language Names are passed to an array");
		logger.info("\n"+" Language names are passed to an array");
		searchLanguages.getLangCourse();
		BaseClass.stateinfo("Courses on each language are passed to an array");
		logger.info("\n"+" Language names are passed to an array");
		searchLanguages.get2D();
		BaseClass.stateinfo("Two 1D arrays are converted a 2D array");
		logger.info("\n"+" Two 1D arrays are converted a 2D array");
		searchLanguages.getLevels();
		BaseClass.stateinfo("Level of difficult in language are passed to an array");
		logger.info("\n"+" Level of difficulty is passed to an array");
		searchLanguages.getLevelsTotal();
		BaseClass.stateinfo("Courses on each difficulty are passed to an array");
		logger.info("\n"+" Course on each difficulty is passed to an array");
		String verify=searchLanguages.verifyCourse2();
		Assert.assertEquals("Language learning",verify);
		BaseClass.stateinfo("Course name is returned and verified");
		logger.info("\n"+" Course name is returned and verified");
		BaseClass.statepass("Test_Case 02 passed");
		logger.info("\n"+" Test_Case 02 passed");
		searchLanguages.gotoHome();
	}
	
	/**********************************************----TEST CASE 3----****************************************/
	/***********************************----SEARCH AND VERIFY ERROR IN FIRST NAME----****************************************/
	@Test(priority=2)
	public static void Test_Case3()
	{
		BaseClass.setTest("Test_Case 03");
		ReadyToTransform.navigateEnterprise();
		BaseClass.stateinfo("Driver navigates to For-Enterprise");
		logger.info("\n"+" Navigate to For-Enterprise");
		ReadyToTransform.forCampus();
		BaseClass.stateinfo("Driver hovers over Product and then clicks for campus");
		logger.info("\n"+" Mousehover on product ");
		ReadyToTransform.firstName("");
		BaseClass.stateinfo("Null value passed in first name");
		logger.info("\n"+" Field Validation with Null First name");
		ReadyToTransform.lastName(formData[1]);
		BaseClass.stateinfo("valid input in Last Name");
		logger.info("\n"+"  Valid Last name");
		ReadyToTransform.jobDescription(formData[2]);
		BaseClass.stateinfo("valid selection in Job Description");
		logger.info("\n"+"  Valid selection");
		ReadyToTransform.jobTitle(formData[3]);
		BaseClass.stateinfo("valid input in Job Title");
		logger.info("\n"+"  Valid job title");
		ReadyToTransform.eMail(formData[4]);
		BaseClass.stateinfo("valid input in email");
		logger.info("\n"+"  Valid Email");
		ReadyToTransform.phone(formData[5]);
		BaseClass.stateinfo("valid input in phone number");
		logger.info("\n"+"  Valid Phone number");
		ReadyToTransform.instituteName(formData[6]);
		BaseClass.stateinfo("valid input in Institute name");
		logger.info("\n"+"  Valid Institute Name");
		ReadyToTransform.instituteType(formData[7]);
		BaseClass.stateinfo("valid selection of institute type");
		logger.info("\n"+"  Select Valid Institute Type");
		ReadyToTransform.primaryDiscipline(formData[8]);
		BaseClass.stateinfo("valid selection in discipline");
		logger.info("\n"+"  Select Valid discipline");
		ReadyToTransform.Country(formData[9]);
		BaseClass.stateinfo("valid input of a country");
		logger.info("\n"+"  Select Valid Country");
		ReadyToTransform.State(formData[10]);
		BaseClass.stateinfo("valid input of a state");
		logger.info("\n"+"  Select Valid State");
		ReadyToTransform.help(formData[11]);
		BaseClass.stateinfo("Spceified help required");
		ReadyToTransform.submitForm();
		BaseClass.captureErrorText("firstNameErr");
		BaseClass.stateinfo("Sumbit form is clicked but there is an error screenshot is taken");
		logger.info("\n"+"  Sumbit form is clicked but there is an error screenshot is taken");
		String error=ReadyToTransform.getErrormsg();
		Assert.assertEquals(msgError,error);
		BaseClass.statepass("Test_Case 03 passed");
		logger.info("\n"+" Test_Case 03 passed");
		ReadyToTransform.REFRESH();
		
	}
	
	
	/**********************************************----TEST CASE 4----****************************************/
	/***********************************----SEARCH AND VERIFY ERROR IN LAST NAME----****************************************/
	@Test(priority=3)
	public static void Test_Case4()
	{
		BaseClass.setTest("Test_Case 04");
		ReadyToTransform.firstName(formData[0]);
		BaseClass.stateinfo("valid input passed in first name");
		logger.info("\n"+" Field Validation valid First name");
		ReadyToTransform.lastName("");
		BaseClass.stateinfo("Null value passed in last name");
		logger.info("\n"+"  NULL Last name");
		ReadyToTransform.jobDescription(formData[2]);
		BaseClass.stateinfo("valid selection in Job Description");
		logger.info("\n"+"  Valid selection");
		ReadyToTransform.jobTitle(formData[3]);
		BaseClass.stateinfo("valid input in Job Title");
		logger.info("\n"+"  Valid job title");
		ReadyToTransform.eMail(formData[4]);
		BaseClass.stateinfo("valid input in email");
		logger.info("\n"+"  Valid Email");
		ReadyToTransform.phone(formData[5]);
		BaseClass.stateinfo("valid input in phone number");
		logger.info("\n"+"  Valid Phone number");
		ReadyToTransform.instituteName(formData[6]);
		BaseClass.stateinfo("valid input in Institute name");
		logger.info("\n"+"  Valid Institute Name");
		ReadyToTransform.instituteType(formData[7]);
		BaseClass.stateinfo("valid selection of institute type");
		logger.info("\n"+"  Select Valid Institute Type");
		ReadyToTransform.primaryDiscipline(formData[8]);
		BaseClass.stateinfo("valid selection in discipline");
		logger.info("\n"+"  Select Valid discipline");
		ReadyToTransform.Country(formData[9]);
		BaseClass.stateinfo("valid input of a country");
		logger.info("\n"+"  Select Valid Country");
		ReadyToTransform.State(formData[10]);
		BaseClass.stateinfo("valid input of a state");
		logger.info("\n"+"  Select Valid State");
		ReadyToTransform.help(formData[11]);
		BaseClass.stateinfo("Spceified help required");
		ReadyToTransform.submitForm();
		BaseClass.captureErrorText("lastNameErr");
		BaseClass.stateinfo("Sumbit form is clicked but there is an error Screenshot is taken");
		logger.info("\n"+"  Sumbit form is clicked but there is an error screenshot is taken");
		String error=ReadyToTransform.getErrormsg();
		Assert.assertEquals(msgError,error);
		BaseClass.statepass("Test_Case 04 passed");
		logger.info("\n"+" Test_Case 04 passed");
		ReadyToTransform.REFRESH();
	}
	
	/**********************************************----TEST CASE 5----****************************************/
	/***********************************----SEARCH AND VERIFY ERROR IN JOB DESCRIPTION----****************************************/
	@Test(priority=4)
	public static void Test_Case5()
	{
		BaseClass.setTest("Test_Case 05");
		ReadyToTransform.firstName(formData[0]);
		BaseClass.stateinfo("valid input passed in first name");
		logger.info("\n"+" Field Validation valid First name");
		ReadyToTransform.lastName(formData[1]);
		BaseClass.stateinfo("Valid input passed in last name");
		logger.info("\n"+"  Valid Last name");
		ReadyToTransform.jobDescription("");
		BaseClass.stateinfo("No selection in Job Description");
		logger.info("\n"+"  No selection");
		ReadyToTransform.jobTitle(formData[3]);
		BaseClass.stateinfo("valid input in Job Title");
		logger.info("\n"+"  Valid job title");
		ReadyToTransform.eMail(formData[4]);
		BaseClass.stateinfo("valid input in email");
		logger.info("\n"+"  Valid Email");
		ReadyToTransform.phone(formData[5]);
		BaseClass.stateinfo("valid input in phone number");
		logger.info("\n"+"  Valid Phone number");
		ReadyToTransform.instituteName(formData[6]);
		BaseClass.stateinfo("valid input in Institute name");
		logger.info("\n"+"  Valid Institute Name");
		ReadyToTransform.instituteType(formData[7]);
		BaseClass.stateinfo("valid selection of institute type");
		logger.info("\n"+"  Select Valid Institute Type");
		ReadyToTransform.primaryDiscipline(formData[8]);
		BaseClass.stateinfo("valid selection in discipline");
		logger.info("\n"+"  Select Valid discipline");
		ReadyToTransform.Country(formData[9]);
		BaseClass.stateinfo("valid input of a country");
		logger.info("\n"+"  Select Valid Country");
		ReadyToTransform.State(formData[10]);
		BaseClass.stateinfo("valid input of a state");
		logger.info("\n"+"  Select Valid State");
		ReadyToTransform.help(formData[11]);
		BaseClass.stateinfo("Spceified help required");
		ReadyToTransform.submitForm();
		BaseClass.captureErrorText("jDescriptionErr");
		BaseClass.stateinfo("Sumbit form is clicked but there is an error Screenshot is taken");
		logger.info("\n"+"  Sumbit form is clicked but there is an error screenshot is taken");
		String error=ReadyToTransform.getErrormsg();
		Assert.assertEquals(msgError,error);
		BaseClass.statepass("Test_Case 05 passed");
		logger.info("\n"+" Test_Case 05 passed");
		ReadyToTransform.REFRESH();
	}
	
	
	/**********************************************----TEST CASE 6----****************************************/
	/***********************************----SEARCH AND VERIFY ERROR IN JOB TITLE----****************************************/
	@Test(priority=5)
	public static void Test_Case6()
	{
		BaseClass.setTest("Test_Case 06");
		ReadyToTransform.firstName(formData[0]);
		BaseClass.stateinfo("valid input passed in first name");
		logger.info("\n"+" Field Validation valid First name");
		ReadyToTransform.lastName(formData[1]);
		BaseClass.stateinfo("Valid input passed in last name");
		logger.info("\n"+"  Valid Last name");
		ReadyToTransform.jobDescription(formData[2]);
		BaseClass.stateinfo("valid selection in Job Description");
		logger.info("\n"+"  Valid selection");
		ReadyToTransform.jobTitle("");
		BaseClass.stateinfo("Null input in Job Title");
		logger.info("\n"+"  Null input job title");
		ReadyToTransform.eMail(formData[4]);
		BaseClass.stateinfo("valid input in email");
		logger.info("\n"+"  Valid Email");
		ReadyToTransform.phone(formData[5]);
		BaseClass.stateinfo("valid input in phone number");
		logger.info("\n"+"  Valid Phone number");
		ReadyToTransform.instituteName(formData[6]);
		BaseClass.stateinfo("valid input in Institute name");
		logger.info("\n"+"  Valid Institute Name");
		ReadyToTransform.instituteType(formData[7]);
		BaseClass.stateinfo("valid selection of institute type");
		logger.info("\n"+"  Select Valid Institute Type");
		ReadyToTransform.primaryDiscipline(formData[8]);
		BaseClass.stateinfo("valid selection in discipline");
		logger.info("\n"+"  Select Valid discipline");
		ReadyToTransform.Country(formData[9]);
		BaseClass.stateinfo("valid input of a country");
		logger.info("\n"+"  Select Valid Country");
		ReadyToTransform.State(formData[10]);
		BaseClass.stateinfo("valid input of a state");
		logger.info("\n"+"  Select Valid State");
		ReadyToTransform.help(formData[11]);
		BaseClass.stateinfo("Spceified help required");
		ReadyToTransform.submitForm();
		BaseClass.captureErrorText("jTitleErr");
		BaseClass.stateinfo("Sumbit form is clicked but there is an error Screenshot is taken");
		logger.info("\n"+"  Sumbit form is clicked but there is an error screenshot is taken");
		String error=ReadyToTransform.getErrormsg();
		Assert.assertEquals(msgError,error);
		BaseClass.statepass("Test_Case 06 passed");
		logger.info("\n"+" Test_Case 06 passed");
		ReadyToTransform.REFRESH();
	}
	
	
	/**********************************************----TEST CASE 7----****************************************/
	/***********************************----SEARCH AND VERIFY ERROR IN EMAIL WHEN NULL----****************************************/
	@Test(priority=6)
	public static void Test_Case7()
	{
		BaseClass.setTest("Test_Case 07");
		ReadyToTransform.firstName(formData[0]);
		BaseClass.stateinfo("valid input passed in first name");
		logger.info("\n"+" Field Validation valid First name");
		ReadyToTransform.lastName(formData[1]);
		BaseClass.stateinfo("Valid input passed in last name");
		logger.info("\n"+"  Valid Last name");
		ReadyToTransform.jobDescription(formData[2]);
		BaseClass.stateinfo("valid selection in Job Description");
		logger.info("\n"+"  Valid selection");
		ReadyToTransform.jobTitle(formData[3]);
		BaseClass.stateinfo("valid input in Job Title");
		logger.info("\n"+"  Valid job title");
		ReadyToTransform.eMail("");
		BaseClass.stateinfo("Null value passed in email");
		logger.info("\n"+"  NULL Email");
		ReadyToTransform.phone(formData[5]);
		BaseClass.stateinfo("valid input in phone number");
		logger.info("\n"+"  Valid Phone number");
		ReadyToTransform.instituteName(formData[6]);
		BaseClass.stateinfo("valid input in Institute name");
		logger.info("\n"+"  Valid Institute Name");
		ReadyToTransform.instituteType(formData[7]);
		BaseClass.stateinfo("valid selection of institute type");
		logger.info("\n"+"  Select Valid Institute Type");
		ReadyToTransform.primaryDiscipline(formData[8]);
		BaseClass.stateinfo("valid selection in discipline");
		logger.info("\n"+"  Select Valid discipline");
		ReadyToTransform.Country(formData[9]);
		BaseClass.stateinfo("valid input of a country");
		logger.info("\n"+"  Select Valid Country");
		ReadyToTransform.State(formData[10]);
		BaseClass.stateinfo("valid input of a state");
		logger.info("\n"+"  Select Valid State");
		ReadyToTransform.help(formData[11]);
		BaseClass.stateinfo("Spceified help required");
		ReadyToTransform.submitForm();
		BaseClass.captureErrorText("nullEmailErr");
		BaseClass.stateinfo("Sumbit form is clicked but there is an error Screenshot is taken");
		logger.info("\n"+"  Sumbit form is clicked but there is an error screenshot is taken");
		String error=ReadyToTransform.getErrormsg();
		Assert.assertEquals(emailError,error);
		BaseClass.statepass("Test_Case 07 passed");
		logger.info("\n"+" Test_Case 07 passed");
		ReadyToTransform.REFRESH();
	}
	
	
	/**********************************************----TEST CASE 8----****************************************/
	/***********************************----SEARCH AND VERIFY ERROR IN EMAIL WHEN INVALID----****************************************/
	@Test(priority=7)
	public static void Test_Case8()
	{
		BaseClass.setTest("Test_Case 08");
		ReadyToTransform.firstName(formData[0]);
		BaseClass.stateinfo("valid input passed in first name");
		logger.info("\n"+" Field Validation valid First name");
		ReadyToTransform.lastName(formData[1]);
		BaseClass.stateinfo("Valid input passed in last name");
		logger.info("\n"+"  Valid Last name");
		ReadyToTransform.jobDescription(formData[2]);
		BaseClass.stateinfo("valid selection in Job Description");
		logger.info("\n"+"  Valid selection");
		ReadyToTransform.jobTitle(formData[3]);
		BaseClass.stateinfo("valid input in Job Title");
		logger.info("\n"+"  Valid job title");
		ReadyToTransform.eMail("invalid");
		BaseClass.stateinfo("Invalid value passed in email");
		logger.info("\n"+"  Invalid Email");
		ReadyToTransform.phone(formData[5]);
		BaseClass.stateinfo("valid input in phone number");
		logger.info("\n"+"  Valid Phone number");
		ReadyToTransform.instituteName(formData[6]);
		BaseClass.stateinfo("valid input in Institute name");
		logger.info("\n"+"  Valid Institute Name");
		ReadyToTransform.instituteType(formData[7]);
		BaseClass.stateinfo("valid selection of institute type");
		logger.info("\n"+"  Select Valid Institute Type");
		ReadyToTransform.primaryDiscipline(formData[8]);
		BaseClass.stateinfo("valid selection in discipline");
		logger.info("\n"+"  Select Valid discipline");
		ReadyToTransform.Country(formData[9]);
		BaseClass.stateinfo("valid input of a country");
		logger.info("\n"+"  Select Valid Country");
		ReadyToTransform.State(formData[10]);
		BaseClass.stateinfo("valid input of a state");
		logger.info("\n"+"  Select Valid State");
		ReadyToTransform.help(formData[11]);
		BaseClass.stateinfo("Spceified help required");
		ReadyToTransform.submitForm();
		BaseClass.captureErrorText("InvalidEmailErr");
		BaseClass.stateinfo("Sumbit form is clicked but there is an error Screenshot is taken");
		logger.info("\n"+"  Sumbit form is clicked but there is an error screenshot is taken");
		String error=ReadyToTransform.getErrormsg();
		Assert.assertEquals(emailError,error);
		BaseClass.statepass("Test_Case 08 passed");
		logger.info("\n"+" Test_Case 08 passed");
		ReadyToTransform.REFRESH();
	}
	
	
	/**********************************************----TEST CASE 9----****************************************/
	/***********************************----SEARCH AND VERIFY ERROR IN PHONE WHEN NULL----****************************************/
	@Test(priority=8)
	public static void Test_Case9()
	{
		BaseClass.setTest("Test_Case 09");
		ReadyToTransform.firstName(formData[0]);
		BaseClass.stateinfo("valid input passed in first name");
		logger.info("\n"+" Field Validation valid First name");
		ReadyToTransform.lastName(formData[1]);
		BaseClass.stateinfo("Valid input passed in last name");
		logger.info("\n"+"  Valid Last name");
		ReadyToTransform.jobDescription(formData[2]);
		BaseClass.stateinfo("valid selection in Job Description");
		logger.info("\n"+"  Valid selection");
		ReadyToTransform.jobTitle(formData[3]);
		BaseClass.stateinfo("valid input in Job Title");
		logger.info("\n"+"  Valid job title");
		ReadyToTransform.eMail(formData[4]);
		BaseClass.stateinfo("valid input in email");
		logger.info("\n"+"  Valid Email");
		ReadyToTransform.phone("");
		BaseClass.stateinfo("Null input in phone");
		logger.info("\n"+"  NULL Phone number");
		ReadyToTransform.instituteName(formData[6]);
		BaseClass.stateinfo("valid input in Institute name");
		logger.info("\n"+"  Valid Institute Name");
		ReadyToTransform.instituteType(formData[7]);
		BaseClass.stateinfo("valid selection of institute type");
		logger.info("\n"+"  Select Valid Institute Type");
		ReadyToTransform.primaryDiscipline(formData[8]);
		BaseClass.stateinfo("valid selection in discipline");
		logger.info("\n"+"  Select Valid discipline");
		ReadyToTransform.Country(formData[9]);
		BaseClass.stateinfo("valid input of a country");
		logger.info("\n"+"  Select Valid Country");
		ReadyToTransform.State(formData[10]);
		BaseClass.stateinfo("valid input of a state");
		logger.info("\n"+"  Select Valid State");
		ReadyToTransform.help(formData[11]);
		BaseClass.stateinfo("Spceified help required");
		ReadyToTransform.submitForm();
		BaseClass.captureErrorText("nullNumErr");
		BaseClass.stateinfo("Sumbit form is clicked but there is an error Screenshot is taken");
		logger.info("\n"+"  Sumbit form is clicked but there is an error screenshot is taken");
		String error=ReadyToTransform.getErrormsg();
		Assert.assertEquals(numError,error);
		BaseClass.statepass("Test_Case 09 passed");
		logger.info("\n"+" Test_Case 09 passed");
		ReadyToTransform.REFRESH();
	}
	
	/**********************************************----TEST CASE 10----****************************************/
	/***********************************----SEARCH AND VERIFY ERROR IN PHONE WHEN INVALID----****************************************/
	@Test(priority=9)
	public static void Test_Case10()
	{
		BaseClass.setTest("Test_Case 10");
		ReadyToTransform.firstName(formData[0]);
		BaseClass.stateinfo("valid input passed in first name");
		logger.info("\n"+" Field Validation valid First name");
		ReadyToTransform.lastName(formData[1]);
		BaseClass.stateinfo("Valid input passed in last name");
		logger.info("\n"+"  Valid Last name");
		ReadyToTransform.jobDescription(formData[2]);
		BaseClass.stateinfo("valid selection in Job Description");
		logger.info("\n"+"  Valid selection");
		ReadyToTransform.jobTitle(formData[3]);
		BaseClass.stateinfo("valid input in Job Title");
		logger.info("\n"+"  Valid job title");
		ReadyToTransform.eMail(formData[4]);
		BaseClass.stateinfo("valid input in email");
		logger.info("\n"+"  Valid Email");
		ReadyToTransform.phone("Invalid");
		BaseClass.stateinfo("Invalid input in phone");
		logger.info("\n"+"  Invalid Phone number");
		ReadyToTransform.instituteName(formData[6]);
		BaseClass.stateinfo("valid input in Institute name");
		logger.info("\n"+"  Valid Institute Name");
		ReadyToTransform.instituteType(formData[7]);
		BaseClass.stateinfo("valid selection of institute type");
		logger.info("\n"+"  Select Valid Institute Type");
		ReadyToTransform.primaryDiscipline(formData[8]);
		BaseClass.stateinfo("valid selection in discipline");
		logger.info("\n"+"  Select Valid discipline");
		ReadyToTransform.Country(formData[9]);
		BaseClass.stateinfo("valid input of a country");
		logger.info("\n"+"  Select Valid Country");
		ReadyToTransform.State(formData[10]);
		BaseClass.stateinfo("valid input of a state");
		logger.info("\n"+"  Select Valid State");
		ReadyToTransform.help(formData[11]);
		BaseClass.stateinfo("Spceified help required");
		ReadyToTransform.submitForm();
		BaseClass.captureErrorText("nullNumErr");
		BaseClass.stateinfo("Sumbit form is clicked but there is an error Screenshot is taken");
		logger.info("\n"+"  Sumbit form is clicked but there is an error screenshot is taken");
		String error=ReadyToTransform.getErrormsg();
		Assert.assertEquals(numError,error);
		BaseClass.statepass("Test_Case 10 passed");
		logger.info("\n"+" Test_Case 10 passed");
		ReadyToTransform.REFRESH();
	}
	
	
	/**********************************************----TEST CASE 11----****************************************/
	/***********************************----SEARCH AND VERIFY ERROR IN INSTITUTE NAME----****************************************/
	@Test(priority=10)
	public static void Test_Case11()
	{
		BaseClass.setTest("Test_Case 11");
		ReadyToTransform.firstName(formData[0]);
		BaseClass.stateinfo("valid input passed in first name");
		logger.info("\n"+" Field Validation valid First name");
		ReadyToTransform.lastName(formData[1]);
		BaseClass.stateinfo("Valid input passed in last name");
		logger.info("\n"+"  Valid Last name");
		ReadyToTransform.jobDescription(formData[2]);
		BaseClass.stateinfo("valid selection in Job Description");
		logger.info("\n"+"  Valid selection");
		ReadyToTransform.jobTitle(formData[3]);
		BaseClass.stateinfo("valid input in Job Title");
		logger.info("\n"+"  Valid job title");
		ReadyToTransform.eMail(formData[4]);
		BaseClass.stateinfo("valid input in email");
		logger.info("\n"+"  Valid Email");
		ReadyToTransform.phone(formData[5]);
		BaseClass.stateinfo("valid input in phone number");
		logger.info("\n"+"  Valid Phone number");
		ReadyToTransform.instituteName("");
		BaseClass.stateinfo("Null input in Institute name");
		logger.info("\n"+"  NULL Institute Name");
		ReadyToTransform.instituteType(formData[7]);
		BaseClass.stateinfo("valid selection of institute type");
		logger.info("\n"+"  Select Valid Institute Type");
		ReadyToTransform.primaryDiscipline(formData[8]);
		BaseClass.stateinfo("valid selection in discipline");
		logger.info("\n"+"  Select Valid discipline");
		ReadyToTransform.Country(formData[9]);
		BaseClass.stateinfo("valid input of a country");
		logger.info("\n"+"  Select Valid Country");
		ReadyToTransform.State(formData[10]);
		BaseClass.stateinfo("valid input of a state");
		logger.info("\n"+"  Select Valid State");
		ReadyToTransform.help(formData[11]);
		BaseClass.stateinfo("Spceified help required");
		ReadyToTransform.submitForm();
		BaseClass.captureErrorText("InstitituteErr");
		BaseClass.stateinfo("Sumbit form is clicked but there is an error Screenshot is taken");
		logger.info("\n"+"  Sumbit form is clicked but there is an error screenshot is taken");
		String error=ReadyToTransform.getErrormsg();
		Assert.assertEquals(insError,error);
		BaseClass.statepass("Test_Case 11 passed");
		logger.info("\n"+" Test_Case 11 passed");
		ReadyToTransform.REFRESH();
	}
	
	
	/**********************************************----TEST CASE 12----****************************************/
	/***********************************----SEARCH AND VERIFY ERROR IN INSTITUTE TYPE----****************************************/
	@Test(priority=11)
	public static void Test_Case12()
	{
		BaseClass.setTest("Test_Case 12");
		ReadyToTransform.firstName(formData[0]);
		BaseClass.stateinfo("valid input passed in first name");
		logger.info("\n"+" Field Validation valid First name");
		ReadyToTransform.lastName(formData[1]);
		BaseClass.stateinfo("Valid input passed in last name");
		logger.info("\n"+"  Valid Last name");
		ReadyToTransform.jobDescription(formData[2]);
		BaseClass.stateinfo("valid selection in Job Description");
		logger.info("\n"+"  Valid selection");
		ReadyToTransform.jobTitle(formData[3]);
		BaseClass.stateinfo("valid input in Job Title");
		logger.info("\n"+"  Valid job title");
		ReadyToTransform.eMail(formData[4]);
		BaseClass.stateinfo("valid input in email");
		logger.info("\n"+"  Valid Email");
		ReadyToTransform.phone(formData[5]);
		BaseClass.stateinfo("valid input in phone number");
		logger.info("\n"+"  Valid Phone number");
		ReadyToTransform.instituteName(formData[6]);
		BaseClass.stateinfo("valid input in Institute name");
		logger.info("\n"+"  Valid Institute Name");
		ReadyToTransform.instituteType("");
		BaseClass.stateinfo("No selection of institute type");
		logger.info("\n"+"  Select nothing Institute Type");
		ReadyToTransform.primaryDiscipline(formData[8]);
		BaseClass.stateinfo("valid selection in discipline");
		logger.info("\n"+"  Select Valid discipline");
		ReadyToTransform.Country(formData[9]);
		BaseClass.stateinfo("valid input of a country");
		logger.info("\n"+"  Select Valid Country");
		ReadyToTransform.State(formData[10]);
		BaseClass.stateinfo("valid input of a state");
		logger.info("\n"+"  Select Valid State");
		ReadyToTransform.help(formData[11]);
		BaseClass.stateinfo("Spceified help required");
		ReadyToTransform.submitForm();
		BaseClass.captureErrorText("InstituteTypeErr");
		BaseClass.stateinfo("Sumbit form is clicked but there is an error Screenshot is taken");
		logger.info("\n"+"  Sumbit form is clicked but there is an error screenshot is taken");
		String error=ReadyToTransform.getErrormsg();
		Assert.assertEquals(msgError,error);
		BaseClass.statepass("Test_Case 12 passed");
		logger.info("\n"+" Test_Case 12 passed");
		ReadyToTransform.REFRESH();
	}
	
	
	/**********************************************----TEST CASE 13----****************************************/
	/***********************************----SEARCH AND VERIFY ERROR IN PRIMARY DISCIPLINE----****************************************/
	@Test(priority=12)
	public static void Test_Case13()
	{
		BaseClass.setTest("Test_Case 13");
		ReadyToTransform.firstName(formData[0]);
		BaseClass.stateinfo("valid input passed in first name");
		logger.info("\n"+" Field Validation valid First name");
		ReadyToTransform.lastName(formData[1]);
		BaseClass.stateinfo("Valid input passed in last name");
		logger.info("\n"+"  Valid Last name");
		ReadyToTransform.jobDescription(formData[2]);
		BaseClass.stateinfo("valid selection in Job Description");
		logger.info("\n"+"  Valid selection");
		ReadyToTransform.jobTitle(formData[3]);
		BaseClass.stateinfo("valid input in Job Title");
		logger.info("\n"+"  Valid job title");
		ReadyToTransform.eMail(formData[4]);
		BaseClass.stateinfo("valid input in email");
		logger.info("\n"+"  Valid Email");
		ReadyToTransform.phone(formData[5]);
		BaseClass.stateinfo("valid input in phone number");
		logger.info("\n"+"  Valid Phone number");
		ReadyToTransform.instituteName(formData[6]);
		BaseClass.stateinfo("valid input in Institute name");
		logger.info("\n"+"  Valid Institute Name");
		ReadyToTransform.instituteType(formData[7]);
		BaseClass.stateinfo("valid selection of institute type");
		logger.info("\n"+"  Select Valid Institute Type");
		ReadyToTransform.primaryDiscipline("");
		BaseClass.stateinfo("No selection in discipline");
		logger.info("\n"+"  Select no discipline");
		ReadyToTransform.Country(formData[9]);
		BaseClass.stateinfo("valid input of a country");
		logger.info("\n"+"  Select Valid Country");
		ReadyToTransform.State(formData[10]);
		BaseClass.stateinfo("valid input of a state");
		logger.info("\n"+"  Select Valid State");
		ReadyToTransform.help(formData[11]);
		BaseClass.stateinfo("Spceified help required");
		ReadyToTransform.submitForm();
		BaseClass.captureErrorText("DisciplineErr");
		BaseClass.stateinfo("Sumbit form is clicked but there is an error Screenshot is taken");
		logger.info("\n"+"  Sumbit form is clicked but there is an error screenshot is taken");
		String error=ReadyToTransform.getErrormsg();
		Assert.assertEquals(msgError,error);
		BaseClass.statepass("Test_Case 13 passed");
		logger.info("\n"+" Test_Case 13 passed");
		ReadyToTransform.REFRESH();
	}
	
	/**********************************************----TEST CASE 11----****************************************/
	/***********************************----SEARCH AND VERIFY ERROR IN COUNTRY----****************************************/
	@Test(priority=13)
	public static void Test_Case14()
	{
		BaseClass.setTest("Test_Case 14");
		ReadyToTransform.firstName(formData[0]);
		BaseClass.stateinfo("valid input passed in first name");
		logger.info("\n"+" Field Validation valid First name");
		ReadyToTransform.lastName(formData[1]);
		BaseClass.stateinfo("Valid input passed in last name");
		logger.info("\n"+"  Valid Last name");
		ReadyToTransform.jobDescription(formData[2]);
		BaseClass.stateinfo("valid selection in Job Description");
		logger.info("\n"+"  Valid selection");
		ReadyToTransform.jobTitle(formData[3]);
		BaseClass.stateinfo("valid input in Job Title");
		logger.info("\n"+"  Valid job title");
		ReadyToTransform.eMail(formData[4]);
		BaseClass.stateinfo("valid input in email");
		logger.info("\n"+"  Valid Email");
		ReadyToTransform.phone(formData[5]);
		BaseClass.stateinfo("valid input in phone number");
		logger.info("\n"+"  Valid Phone number");
		ReadyToTransform.instituteName(formData[6]);
		BaseClass.stateinfo("valid input in Institute name");
		logger.info("\n"+"  Valid Institute Name");
		ReadyToTransform.instituteType(formData[7]);
		BaseClass.stateinfo("valid selection of institute type");
		logger.info("\n"+"  Select Valid Institute Type");
		ReadyToTransform.primaryDiscipline(formData[8]);
		BaseClass.stateinfo("valid selection in discipline");
		logger.info("\n"+"  Select Valid discipline");
		ReadyToTransform.Country("");
		BaseClass.stateinfo("Null input of a country");
		logger.info("\n"+"  Select no Country");
		ReadyToTransform.help(formData[11]);
		ReadyToTransform.submitForm();
		BaseClass.captureErrorText("CountryErr");
		BaseClass.stateinfo("Sumbit form is clicked but there is an error Screenshot is taken");
		logger.info("\n"+"  Sumbit form is clicked but there is an error screenshot is taken");
		String error=ReadyToTransform.getErrormsg();
		Assert.assertEquals(msgError,error);
		BaseClass.statepass("Test_Case 14 passed");
		logger.info("\n"+" Test_Case 14 passed");
		ReadyToTransform.REFRESH();
	}
	
	
	/**********************************************----TEST CASE 11----****************************************/
	/***********************************----SEARCH AND VERIFY ERROR IN STATE----****************************************/
	@Test(priority=14)
	public static void Test_Case15()
	{
		BaseClass.setTest("Test_Case 15");
		ReadyToTransform.firstName(formData[0]);
		BaseClass.stateinfo("valid input passed in first name");
		logger.info("\n"+" Field Validation valid First name");
		ReadyToTransform.lastName(formData[1]);
		BaseClass.stateinfo("Valid input passed in last name");
		logger.info("\n"+"  Valid Last name");
		ReadyToTransform.jobDescription(formData[2]);
		BaseClass.stateinfo("valid selection in Job Description");
		logger.info("\n"+"  Valid selection");
		ReadyToTransform.jobTitle(formData[3]);
		BaseClass.stateinfo("valid input in Job Title");
		logger.info("\n"+"  Valid job title");
		ReadyToTransform.eMail(formData[4]);
		BaseClass.stateinfo("valid input in email");
		logger.info("\n"+"  Valid Email");
		ReadyToTransform.phone(formData[5]);
		BaseClass.stateinfo("valid input in phone number");
		logger.info("\n"+"  Valid Phone number");
		ReadyToTransform.instituteName(formData[6]);
		BaseClass.stateinfo("valid input in Institute name");
		logger.info("\n"+"  Valid Institute Name");
		ReadyToTransform.instituteType(formData[7]);
		BaseClass.stateinfo("valid selection of institute type");
		logger.info("\n"+"  Select Valid Institute Type");
		ReadyToTransform.primaryDiscipline(formData[8]);
		BaseClass.stateinfo("valid selection in discipline");
		logger.info("\n"+"  Select Valid discipline");
		ReadyToTransform.Country(formData[9]);
		BaseClass.stateinfo("valid input of a country");
		logger.info("\n"+"  Select Valid Country");
		ReadyToTransform.State("");
		BaseClass.stateinfo("Null input of a state");
		logger.info("\n"+"  Select no State");
		ReadyToTransform.help(formData[11]);
		ReadyToTransform.submitForm();
		BaseClass.captureErrorText("StateErr");
		BaseClass.stateinfo("Sumbit form is clicked but there is an error Screenshot is taken");
		logger.info("\n"+"  Sumbit form is clicked but there is an error screenshot is taken");
		String error=ReadyToTransform.getErrormsg();
		Assert.assertEquals(msgError,error);
		BaseClass.statepass("Test_Case 15 passed");
		logger.info("\n"+" Test_Case 15 passed");
		ReadyToTransform.REFRESH();
	}
	
	
	/***************************************----FLUSH THE REPORT GENERTATED----****************************************/
	/*******************************************----CLOSE THE BROWSER----****************************************/
	/***********************************----WRITE THE DATA IN THE EXCEL SHEET1----****************************************/
	/***********************************----WRITE THE DATA IN THE EXCEL SHEET2----****************************************/
	@AfterSuite
	public static void after_suite()
	{
		BaseClass.reportFlush();
		BaseClass.closeBrowser();
		Write_Excel.writeResult1();
		Write_Excel1.writeResult2();
	}
}
