package com.identifycourses.utils;

import java.io.File;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel {
	public static String data[]=new String[12];
	
	/***********************************----READ THE DATA FROM THE EXCEL SHEET----****************************************/
	public static String[] setFormValue()
	{
		try {
		File file= new File(System.getProperty("user.dir")+Read_Properties.obj.getProperty("read_ExcelPath"));
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet= workbook.getSheet("Sheet1");
		XSSFRow row= sheet.getRow(0);
		XSSFCell cell= row.getCell(0);
		for(int i=0;i<12;i++)
		{
				data[i]=row.getCell(i).getStringCellValue();
		}
		}catch(Exception e)
		{
			System.out.println("Caught error");
		}
		return data;
	}
}
