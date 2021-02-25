package com.identifycourses.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.identifycourses.pages.searchLanguages;

public class Write_Excel1 {
	 public static String languageTotal[][]=searchLanguages.array2D;
	 
	 
	 /***********************************----WRITE THE DATA IN THE EXCEL SHEET----****************************************/
	 public static void writeResult2()
     {
      	 try
      	 {
      	 	File file=new File(System.getProperty("user.dir")+Read_Properties.obj.getProperty("write2_ExcelPath")); 
  			FileInputStream fis=new FileInputStream(file);
  			XSSFWorkbook workbook=new XSSFWorkbook(fis);
  	        XSSFSheet sheetWrite=workbook.getSheet("Write2"); 
  	        Row row=sheetWrite.createRow(0);
  	        Cell heading=row.createCell(0);
  	        heading.setCellValue("Languages");
  	        Cell heading1=row.createCell(1);
	        heading1.setCellValue("Language Total");
	        Row row1[]=new Row[51];
  	        Cell cell[][]=new Cell[51][2];
  	        for(int i=0;i<51;i++)
  	        {
  	        	row1[i]=sheetWrite.createRow(i+1);
  	        	cell[i]=new Cell[51];
  	        	for(int j=0;j<2;j++)
  	        	{
  	        		
  	        		cell[i][j]=row1[i].createCell(j);
  	        		cell[i][j].setCellValue(languageTotal[i][j]);
  	        	}
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
