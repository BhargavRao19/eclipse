package com.abc.main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainApp {

	public static void main(String[] args) throws Exception {
		// Collect the input from the end user
		String dob = "19-04-1998";

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate = sdf.parse(dob);
		System.out.println("Util date information is :: " + udate);

		//Converting util.Date object into sql.Date object
		long ms = udate.getTime();
		java.sql.Date sdate=  new java.sql.Date(ms);
		System.out.println("SQL Date Information is ::"+sdate);

		//If the entered input is in the following format  yyyy-MM-dd then directly  we can
		//convert into java.sql.Date object
		String doj ="2022-03-17";

		java.sql.Date sdate2 = java.sql.Date.valueOf(doj);
		System.out.println("SQL date information is ::"+sdate2);

		//Converting the date object into string object as per the client information
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy");
		String sDate = sdf2.format(sdate2);
		System.out.println("The string representation is::"+sDate);
	}
}
