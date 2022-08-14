package com.abc.bhargav.persist;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateInsertPractice {
	private static final String SQL_INSERT_QUERY="INSERT INTO PERSONINFO(PNAME,PADDRESS,DOB,DOM,DOJ) VALUES(?,?,?,?,?)";
	public static void main(String[] args) {
    
	Connection connection = null;	
	PreparedStatement pstmt = null;
	Scanner scanner = null;
	String pname =null,paddress=null,sdob=null,sdom=null,sdoj=null;
	java.text.SimpleDateFormat sdfdob = null, sdfdom = null;
	java.util.Date udob=null,udom=null,udoj=null;
	java.sql.Date sqldob = null,sqldom=null,sqldoj=null;
		
	String url = "jdbc:mysql://localhost:3309/xyz";
    String username = "root";
    String password = "admin";
    
    
    
  try {
	  scanner = new Scanner(System.in);
	  
	  if(scanner !=null)
	  {
		  //Collecting the inputs from the user
		  System.out.println("ENTER THE PNAME:"+pname);
		  pname = scanner.next();
		  
		  System.out.println("ENTER THE PADDRESS:"+paddress);
		  paddress = scanner.next();
		  
		  System.out.println("ENTER THE DOB(dd-MM-yyyy):"+sdob);
		  sdob = scanner.next();
		  
		  System.out.println("ENTER THE DOM(MM-dd-yyyy):"+sdom);
		  sdom = scanner.next();
		  
		  System.out.println("ENTER THE DOJ(yyyy-MM-dd):"+sdoj);
		  sdoj = scanner.next();
		  
	  }
	  //Converting string object to java.util.Date
	  sdfdob = new SimpleDateFormat("dd-MM-yyyy");
	  if(sdob !=null)
	  udob = sdfdob.parse(sdob);
	  
	  sdfdom = new SimpleDateFormat("dd-MM-yyyy");
	  if(sdom !=null)
	  udom = sdfdom.parse(sdom);
	  
	  //Converting java.util.Date object to java.sql.Date
	       if(udob !=null)
	    	   sqldob = new java.sql.Date(udob.getTime());
	       
	       if(udom !=null)
	    	   sqldom = new java.sql.Date(udom.getTime());
	       
	     //Directly converting java.lang.String object into java.sql.Date object
	       if(sdoj !=null)
	    		sqldoj = java.sql.Date.valueOf(sdoj);
	 
	   //Establishing connection by providing the connection details   
	  connection = DriverManager.getConnection(url,username,password);
	  System.out.println("The connection has been established with the following: "+url);
	  
	  if(connection != null)
		  pstmt = connection.prepareStatement(SQL_INSERT_QUERY);
	  
	if(pstmt !=null) {
		//Setting the input value to pre-compiled query 
		pstmt.setString(1, pname);
		pstmt.setString(2, paddress);
		
		//Setting the java.sql.Date object
		pstmt.setDate(3, sqldob);
		pstmt.setDate(4, sqldom);
		pstmt.setDate(5, sqldoj);
		
		//Execute Query
		int rowCount = pstmt.executeUpdate();
		if(rowCount == 0)
			System.out.println("Insertion update failed");
		else
			System.out.println("Insertion successful!!!");
	}
	  
  }catch(SQLException se) {
	  if(se.getErrorCode()==1406)
			System.out.println("data too long for column");
		else if (se.getErrorCode() == 1062)
			System.out.println("Duplicate primary key value");
		else if (se.getErrorCode() == 1136)
			System.out.println("Insufficent values supplied by the user...");
		else if (se.getErrorCode() == 1064)
			System.out.println("Syntax error in SQL");
		else
			System.out.println("Some SQLException occured...."+se.getMessage());
			
	}catch(Exception e) {
		e.printStackTrace();
	} 
  }

	}


