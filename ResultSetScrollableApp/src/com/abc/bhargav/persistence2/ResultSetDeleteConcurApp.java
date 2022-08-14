package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class ResultSetDeleteConcurApp {
	private static final String GET_STUDENT_RECORD="select sid,sname,saddress,savg from student";
	public static void main(String[] args) {
     
		Connection connection = null;
		Statement stmt = null;
		ResultSet resultSet=null;
		Scanner scanner = null;
		int count=0;

		String url="jdbc:mysql://localhost:3309/xyz";	
		String username="root";
		String password="admin";

		try {
			// Step1 => Establishing the connection by providing URL,USERNAME,PASSWORD
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established with the following : " + url);

			if (connection != null) {
              stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			}
			if(stmt !=null) 
				resultSet = stmt.executeQuery(GET_STUDENT_RECORD);
				
		   if(resultSet !=null) {
			  resultSet.last();
			  resultSet.deleteRow();
			  System.out.println("Row deleted successfully");
			  
		   }
			
		} catch (SQLException se) {
                   se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Step5 => Closing the resources
                 if(resultSet !=null) {
                	 try {
                	 resultSet.close();
                	 }catch(SQLException se) {
                		 se.printStackTrace();
                	 }
                 }
                 
                 if(stmt!=null) {
                	 try {
                	 stmt.close();
                	 }catch(SQLException se) {
                		 se.printStackTrace();
                	 }
                 }
                 
                 if(resultSet !=null) {
                	 try {
                	 resultSet.close();
                	 }catch(SQLException se) {
                		 se.printStackTrace();
                	 }
                 }
		}

	}

}


