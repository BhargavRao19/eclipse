package com.abc.bhargav.persistence2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class MultipleRecordInsertionApp {

	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner = null;
		
		String url="jdbc:mysql://localhost:3309/xyz";	
		String username="root";
		String password="admin";

		try {
			connection=DriverManager.getConnection(url,username,password);
			System.out.println("The connection is been established  with  the following url: "+url);
			
			if(connection !=null) {
				//step2:Creating the preparedStatement to get PRE-COMPILED  QUERY object from the DBE
				String  sqlInsertQuery = "insert into employee(eadd,ename,esalary) values(?,?,?)";
				pstmt=connection.prepareStatement(sqlInsertQuery);
			}
			if(pstmt !=null) {
				//Collecting inputs from the user
				 scanner = new Scanner(System.in);
				 
				 while(true) {
				 System.out.println("Enter the address");
				 String address= scanner.next();
				 
				 System.out.println("Enter the name");
				 String name = scanner.next();
				 
				 System.out.println("Enter the salary");
				 float salary = scanner.nextFloat();
				 
				 //Setting the PRE-COMPLED QUERY with dynamic inputs
				 pstmt.setString(1, address);
				 pstmt.setString(2, name);
				 pstmt.setFloat(3, salary);
				 
				 //step3:Execute the query by sending the values
				 pstmt.executeUpdate();
				 System.out.println("record inserted successfully");
				 
				 System.out.println("do you want to insert more[]YES/NO");
				 String option = scanner.next();
				 
				 if(option.equalsIgnoreCase("no"))
					 break;
				 
				 }
			}
			
		} catch(SQLException se) {
			//Handling the sqlException object if generated
			if(se.getErrorCode()==1406)
				System.out.println("data too long for column");
			else if(se.getErrorCode()==1052)
				System.out.println("Duplicate primary key value");
			else if(se.getErrorCode()==1136)
				System.out.println("Insufficient values given by the  user");
			else if(se.getErrorCode()==1064)
				System.out.println("Syntax error in SQL");
			else
				System.out.println("Some SQLEXCEPTION");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(connection !=null)
					connection.close();
				if(pstmt !=null)
					pstmt.close();
				if(scanner !=null)
					scanner.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}

}
