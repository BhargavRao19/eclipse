package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class DeleteRecordApp {
	public static final String SQL_DELETE_QUERY = "delete from employee  where eid=?";
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner = null;

		String url="jdbc:mysql://localhost:3309/xyz";
		String username="root";
		String password = "admin";

		try {
			// Step1 => Establishing the connection by providing URL,USERNAME,PASSWORD
			connection= DriverManager.getConnection(url,username,password);
			System.out.println("the connection is established with the following: "+url);

			if(connection !=null) {
				// Step2 => Creating the PreparedStatement to get PRE-COMPILED Query Object from DBE
				pstmt= connection.prepareStatement(SQL_DELETE_QUERY);
			}
			if(pstmt !=null) {
				//Collecting inputs from the user
				scanner = new Scanner(System.in);
				System.out.println("enter the id: ");
				int eid = scanner.nextInt();

				//Setting the input values to the query
				pstmt.setInt(1,eid);


				// Step3 => Execute the query by sending the values and process the result
				int rowCount = pstmt.executeUpdate();
				System.out.println( "No of records deleted is: "+rowCount);

				System.out.println("Resuing the same preapredStatement object for deleting another record...");

				//Collecting inputs from the user
				scanner = new Scanner(System.in);
				System.out.println("enter the id: ");
				eid = scanner.nextInt();

				//Setting the input values to the query
				pstmt.setInt(1,eid);


				// Step3 => Execute the query by sending the values and process the result
				rowCount = pstmt.executeUpdate();
				System.out.println( "No of records deleted is: "+rowCount);
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
				System.out.println("Some SQLException occured....");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//Closing the resources
			try {
			if(connection !=null) {
				connection.close();
			}
			if(pstmt !=null) {
				pstmt.close();
			}
			if(scanner !=null) {
				scanner.close();
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
		}

	}

}
