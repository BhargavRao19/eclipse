package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class InsertApp {
	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner = null;

		String url="jdbc:mysql://localhost:3309/xyz";	
		String username="root";
		String password="admin";

		try {
			// Step1 => Establishing the connection by providing URL,USERNAME,PASSWORD
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established with the following : " + url);

			if (connection != null) {

			// Step2 => Creating the PreparedStatement to get PRE-COMPILED Query Object from DBE
				
				String sqlInsertQuery = "insert into employee(eadd,ename,esalary) values(?,?,?)";
				pstmt = connection.prepareStatement(sqlInsertQuery);

				if (pstmt != null) {

					//Collecting Input from the user
					scanner = new Scanner(System.in);

					System.out.print("Enter the name :");
					String name = scanner.next();

					System.out.print("Enter the address :");
					String address = scanner.next();

					System.out.print("Enter the salary:");
					float salary = scanner.nextFloat();

					// Setting the PRE-COMPILED Query with dynamic inputs
					pstmt.setString(1, name);
					pstmt.setString(2, address);
					pstmt.setFloat(3, salary);

					// Step3 => Execute the query by sending the values and process the result
					int rowCount = pstmt.executeUpdate();

					if (rowCount != 0) {
						System.out.println("No of rows inserted is :" + rowCount);
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
			else
				System.out.println("Some SQLException occured....");

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


