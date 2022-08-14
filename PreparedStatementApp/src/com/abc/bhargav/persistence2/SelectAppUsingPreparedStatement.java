package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectAppUsingPreparedStatement {
	private static final String SQL_SELECT_QUERY ="SELECT EID,EADD,ENAME,ESALARY FROM EMPLOYEE WHERE EID=?";
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Scanner scanner = null;

		String url="jdbc:mysql://localhost:3309/xyz";	
		String username="root";
		String password="admin";

		try {
			// Step1 => Establishing the connection by providing URL,USERNAME,PASSWORD
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established with the following : " + url);

			if (connection != null) {

				// Step2 => Creating the PreparedStatement to get PRE-COMPILED Query Object from
				// DBE
				pstmt = connection.prepareStatement(SQL_SELECT_QUERY);

				if (pstmt != null) {

					// Collecting Input from the user
					scanner = new Scanner(System.in);

					System.out.print("Enter the id :");
					int eid = scanner.nextInt();
					
					// Setting the PRE-COMPILED Query with dynamic inputs
					pstmt.setInt(1, eid);
					

					// Step3 => Execute the query by sending the values and process the result
					resultSet = pstmt.executeQuery();

					if (resultSet != null) {
						System.out.println("EID\tEADD\tENAME\tESALARY");
						if (resultSet.next()) {
							System.out.print(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t"
									+ resultSet.getString(3) + "\t" + resultSet.getFloat(4));
						}
					}

				}
			}

		} catch (SQLException se) {

			// Step4 => Handling the SQLException object if generated
			if (se.getErrorCode() == 1406)
				System.out.println("Data too long for column");
			else if (se.getErrorCode() == 1062)
				System.out.println("Duplicate primary key value");
			else if (se.getErrorCode() == 1136)
				System.out.println("Insufficent values supplied by the user...");
			else if (se.getErrorCode() == 1064)
				System.out.println("Syntax error in SQL");
			else {
				se.printStackTrace();
			}
				//System.out.println("Some sql exception occured");


		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Step5 => Closing the resources
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}


