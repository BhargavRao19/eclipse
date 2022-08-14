package com.abc.bhargav.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CheckCredentialsApp {

	public static void main(String[] args) {
		Connection connection =null;
		Statement statement=null;
		ResultSet resultSet=null;
		Scanner scanner=null;
		String url="jdbc:mysql://localhost:3309/credentials";	
		String username="root";
		String password="admin";

		try {
			// Step1 => Establishing the connection by providing URL,USERNAME,PASSWORD
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established with the following : " + url);

			if (connection != null) {

				// Step2 => Creating the statement object to transport the query to DBE
				statement = connection.createStatement();

				if (statement != null) {

					// Collect the inputs from the user to process in the query
					scanner = new Scanner(System.in);
					System.out.print("Ener the  username :: ");
					String uname = scanner.next();

					System.out.print("Ener the  password :: ");
					String pwd = scanner.next();

					String sqlSelectQuery = "select count(*) from userinfo where username='" + uname + "'and password='"
							+ pwd + "'";
					System.out.println(sqlSelectQuery);

					// Step3 => Execute the query and process the result
					resultSet = statement.executeQuery(sqlSelectQuery);

					if (resultSet != null) {

						//Step4 => Process the resultSet
						if (resultSet.next()) {
							int rowCount = resultSet.getInt(1);

							if (rowCount == 0) {
								System.out.println("Invalid credentials.....");
							} else {
								System.out.println("Valid credentials......");
							}
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
			else
				se.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Step5 => Closing the resources
			try {
				if (scanner != null) {
					scanner.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (resultSet != null) {
					resultSet.close();
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
