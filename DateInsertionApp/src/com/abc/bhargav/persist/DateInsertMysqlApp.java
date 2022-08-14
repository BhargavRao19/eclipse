package com.abc.bhargav.persist;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateInsertMysqlApp {
	private static final String SQL_INSERT_QUERY="INSERT INTO PERSONINFO(PNAME,PADDRESS,DOB,DOM,DOJ) VALUES(?,?,?,?,?)";
	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3309/xyz";
		String username = "root";
		String password = "admin";

		Connection connection =null;
		PreparedStatement pstmt =null;
		Scanner scanner =null;
		String pname=null,paddress=null, sdob=null, sdom=null, sdoj=null;
		java.text.SimpleDateFormat sdfdob =null,sdfdom=null;
		java.util.Date udob = null,udom = null,udoj= null;
		java.sql.Date sqlDob=null, sqlDom=null, sqlDoj=null;

		try {
			scanner =new Scanner(System.in);

			if(scanner !=null) {
				System.out.println("ENTER THE PNAME:: ");
				pname =scanner.next();
				//Collecting date inputs from the user
				System.out.println("ENTER THE PADDRESS:: ");
				paddress =scanner.next();

				System.out.println("ENTER THE DOB(dd-MM-yyyy):: ");
				sdob =scanner.next();

				System.out.println("ENTER THE DOM(MM-dd-yyyy):: ");
				sdom =scanner.next();

				System.out.println("ENTER THE DOJ(yyyy-MM-dd):: ");
				sdoj=scanner.next();

			}
			//Converting  String object to java.util.Date object
			sdfdob =new SimpleDateFormat("dd-MM-yyyy");
			if(sdob !=null) {
				udob = sdfdob.parse(sdob);
			}

			sdfdom =new SimpleDateFormat("MM-dd-yyyy");
			if(sdom !=null) {
				udom = sdfdom.parse(sdom);
			}
			//Converting java.util.Date object to java.sql.Date object
			if(udob !=null)
				sqlDob = new java.sql.Date(udob.getTime());

			if(udom !=null)
				sqlDom = new java.sql.Date(udom.getTime());
			//Directly converting java.lang.String object into java.sql.Date object
			if(sdoj !=null)
				sqlDoj = java.sql.Date.valueOf(sdoj);



			//Establishing the connection by providing url,username,password
			connection= DriverManager.getConnection(url,username,password);
			System.out.println("Connection established with the following: "+url);

			if(connection !=null)
			{
				pstmt = connection.prepareStatement(SQL_INSERT_QUERY);
			}
			if(pstmt !=null) {
				//Setting the input value to pre-compiled query 
				pstmt.setString(1, pname);
				pstmt.setString(2, paddress);

				//Setting the java .sql.Date object
				pstmt.setDate(3, sqlDob);
				pstmt.setDate(4, sqlDom);
				pstmt.setDate(5, sqlDoj);
				//Execute the query
				int rowCount=pstmt.executeUpdate();
				if(rowCount==0)
					System.out.println("Record insertion failed");
				else
					System.out.println("Record insertion successfully");
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
				//System.out.println("Some SQLException occured....");
				se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//step5:Closing the resources
			try {
				if(scanner !=null)
					scanner.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(pstmt !=null) {
					pstmt.close();
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(connection !=null )
				{
					connection.close();
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}


