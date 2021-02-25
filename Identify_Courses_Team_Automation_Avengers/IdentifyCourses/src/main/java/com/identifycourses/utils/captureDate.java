package com.identifycourses.utils;

import java.util.Date;

/**********************----FOR GETTING DATE TIME STAMP----******************************/
public class captureDate {
	public static String getDateTime() {
		Date date = new Date();
		return date.toString().replaceAll(":","").replaceAll(" ", "");
		}
}
