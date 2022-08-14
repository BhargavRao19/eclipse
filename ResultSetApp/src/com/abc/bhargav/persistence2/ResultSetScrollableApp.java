package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class ResultSetScrollableApp {
	private static final String GET_STUDENT_RECORD="select sid,sname,saddress,savg from student";
	public static void main(String[] args) {
     
		Connection connection = null;
		Statement stmt = null;
		ResultSet resultSet=null;
		Scanner scanner = null;

		String url="jdbc:mysql://localhost:3309/xyz";	
		String username="root";
		String password="admin";

		try {
			// Step1 => Establishing the connection by providing URL,USERNAME,PASSWORD
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established with the following : " + url);

			if (connection != null) {
              stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			}
			if(stmt !=null) {
				resultSet = stmt.executeQuery(GET_STUDENT_RECORD);
				
			resultSet.first();
			System.out.println("First record is::"+resultSet.getString(1)+ "\t"+resultSet.getString(2) 
			+ "\t"+resultSet.getString(3) + "\t"+resultSet.getString(4));
			
			System.out.println();
			resultSet.last();
			System.out.println("Last record is::"+resultSet.getString(1)+ "\t"+resultSet.getString(2) 
			+ "\t"+resultSet.getString(3) + "\t"+resultSet.getString(4));
			
			resultSet.absolute(3);
			System.out.println(resultSet.getRow()+" record is::"+resultSet.getString(1)+ "\t"+resultSet.getString(2) 
			+ "\t"+resultSet.getString(3) + "\t"+resultSet.getString(4));
			
			
			resultSet.relative(-1);
			System.out.println(resultSet.getRow()+" record is::"+resultSet.getString(1)+ "\t"+resultSet.getString(2) 
			+ "\t"+resultSet.getString(3) + "\t"+resultSet.getString(4));
			
		   resultSet.last();
           resultSet.relative(-2);
           System.out.println(resultSet.getRow()+" record is::"+resultSet.getString(1)+ "\t"+resultSet.getString(2) 
			+ "\t"+resultSet.getString(3) + "\t"+resultSet.getString(4));
           

			}

		} catch (SQLException se) {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Step5 => Closing the resources
			
		}

	}

}


