package com.identifycourses.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.identifycourses.pages.searchLanguages;
import com.identifycourses.pages.searchWebDevelopment;


public class Write_Excel {
	 public static String dataWrite[]=searchWebDevelopment.courseDetails; 
	
	 
	 /***********************************----WRITE THE DATA IN THE EXCEL SHEET----****************************************/
     public static void writeResult1()
   {
    	 try
    	 {
    	 	File file=new File(System.getProperty("user.dir")+Read_Properties.obj.getProperty("write1_ExcelPath")); 
			FileInputStream fis=new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
	        XSSFSheet sheetWrite=workbook.getSheet("Write1"); 
	        Row row=sheetWrite.createRow(0);
	        Cell heading=row.createCell(0);
	        heading.setCellValue("Web Development Courses Details");
	        for(int i=0;i<dataWrite.length;i++)
	        {
	        Cell cWrite=row.createCell(i+1);
	        cWrite.setCellValue(dataWrite[i]); //writing values in the excel file
	        }
	        FileOutputStream fos=new FileOutputStream(file);
	        workbook.write(fos);
	        workbook.close();
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println("error");
    	 }
   }
}
