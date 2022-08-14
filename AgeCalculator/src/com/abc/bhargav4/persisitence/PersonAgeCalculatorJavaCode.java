package com.abc.bhargav4.persisitence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class PersonAgeCalculatorJavaCode {
	private static final String SQL_SELECT_QUERY="SELECT dob FROM PERSONINFO WHERE PID=?;";
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3309/xyz";
		String username = "root";
		String password = "admin";

		Connection connection =null;
		PreparedStatement pstmt =null;
		Scanner scanner =null;
		ResultSet resultSet = null;
		int pid = 0;


		try {
			scanner =new Scanner(System.in);
			//Collecting pid from the user
			if(scanner !=null) {
				System.out.println("Enter the id of the person:: ");
				pid = scanner.nextInt();
			}

			//Establishing the connection by provvideing url,username,password
			connection= DriverManager.getConnection(url,username,password);
			System.out.println("Connection established with the following: "+url);

			if(connection !=null)
			{
				pstmt = connection.prepareStatement(SQL_SELECT_QUERY);
			}
			if(pstmt !=null) {
				//Setting the input value to pre-compiled query 
				pstmt.setInt(1, pid);
			}


			if(pstmt !=null)
				//Execute the query
				resultSet = pstmt.executeQuery();

			//Process the result and display the output
			if(resultSet.next()) {
				java.util.Date date = resultSet.getDate(1);///util.date => sql.Date are related through extends keyword
				long sysDateMs = new Date().getTime();
				long dobMs = date.getTime();

				System.out.println("Person age is::"+(sysDateMs-dobMs)/(1000*60*60*24*365.25f));


			}else
				System.out.println("Record not available for the given id:: "+pid);


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
				try {
					if(resultSet !=null )
					{
						resultSet.close();
					}
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}


