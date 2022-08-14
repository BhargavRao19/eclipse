package com.abc.bhargav.persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class InsertApp {

	public static void main(String[] args){


		Connection connection =null;
		Statement statement=null;
		Scanner scanner = null;
		String url="jdbc:mysql://localhost:3309/dbc";	
		String username="root";
		String password="admin";

		//step1:Establish the connection by providing URl,USERNAME,PASSWORD
		try {
			connection=DriverManager.getConnection(url,username,password);
			System.out.println("Connection Established with the following:"+url);

			if(connection !=null)
				//step2:Creating the statement object to transport the query to DBE
				statement =connection.createStatement();
			if(statement !=null) { 
				//Step3:Execute the query and process the result
				String sqlInsertQuery="insert into student(sid,sname,sage) values(7,'MitchellStarc',33)";
				int rowCount =statement.executeUpdate(sqlInsertQuery);
				if(rowCount >0) {
					System.out.println("row added successfully");
				}
				else {
					System.out.println("row failed to insert");
				}
			}
		}
		catch(SQLException se) {
			//Step4:Handling the SQLException object if generated
			if(se.getErrorCode()==1406)
				System.out.println("Data too long for column");
			else if(se.getErrorCode()==1062)
				System.out.println("Duplicate primary key value");
			else if(se.getErrorCode()==1136)
				System.out.println("Insufficient values supplied by the user");
			else if(se.getErrorCode()==1064)
				System.out.println("Syntax error in SQL");
			else
				System.out.println("Some SQLException occured..");

		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//step5:Closing the resources
			try {
				if(statement !=null)
					statement.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				if(connection !=null)
					connection.close();
			} catch(SQLException e) {
				e.printStackTrace();

			}

		}

	}

}
