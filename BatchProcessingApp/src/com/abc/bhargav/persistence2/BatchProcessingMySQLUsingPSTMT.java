package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.abc.utility.JdbcUtil;
public class BatchProcessingMySQLUsingPSTMT {

	private static final String SQL_INSERT_QUERY = "insert into employee(ename,eadd,esalary) values(?,?,?)";

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner = null;
		String eadd =null,ename=null,esalary=null;
		String option=null;

		try {
			//Take the connection object
			connection = JdbcUtil.getDbConnection();
			//Created preparedStatement object
			if (connection != null) {
				pstmt = connection.prepareStatement(SQL_INSERT_QUERY);
			}
			if(pstmt !=null) {
				scanner = new Scanner(System.in);

				while(true) {
					if(scanner !=null) {
						//Take the inputs
						System.out.println("Enter the employee eadd:: ");
						eadd =scanner.next();

						System.out.println("Enter the employee name:: ");
						ename =scanner.next();

						System.out.println("Enter the employee salary:: ");
						esalary =scanner.next();
					}
                    //Setting the input values
					pstmt.setString(1,eadd);
					pstmt.setString(2, ename);
					pstmt.setFloat(3,Float.parseFloat(esalary));
					
					//Adding the query with result to the batch
					pstmt.addBatch();
					System.out.println("Do you want to add one more record :[YES/NO]");
					option = scanner.next();
					if(option.equalsIgnoreCase("no")) {
						break;
					}
				}
			}
			//Execute the batch file
			pstmt.executeBatch();
			System.out.println("Records inserted successful....");
		}catch (SQLException se) {
			//Handling the exception
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, pstmt, connection);
		}
	}
}




