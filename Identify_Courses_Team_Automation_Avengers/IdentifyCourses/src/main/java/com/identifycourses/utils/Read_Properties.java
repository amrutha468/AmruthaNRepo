package com.identifycourses.utils;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Read_Properties {
	public static String filePath= System.getProperty("user.dir")+"/src/main/resources/objectRepository/Config.properties";
	public static Properties obj = new Properties();
	
	/***********************************----READ THE DATA FROM THE PROPERTIES FILE----****************************************/
	public static void read()
	{
		
		FileInputStream objfile = null;
		try {
			objfile = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
		try {
			obj.load(objfile); 
		} catch (IOException e) {
			System.out.println("Unable to load the configuration file");
			System.exit(0);
		}
	}
}