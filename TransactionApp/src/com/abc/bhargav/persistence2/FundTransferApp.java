package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.abc.utility.JdbcUtil;
public class FundTransferApp {
	
	private static final String SQL_SELECT_QUERY = "select * from accounts";
	private static final String SQL_UPDATE_QUERY1 = "update accounts set balance=balance-5000 where name='bhargav'";
	private static final String SQL_UPDATE_QUERY2 = "update accounts set balance=balance+5000 where name='ronaldo'";
	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Scanner scanner =null;
		String option=null;
		try {
			connection = JdbcUtil.getDbConnection();
			if (connection != null) {
				statement = connection.createStatement();
			}
			if (statement != null) {
				resultSet = statement.executeQuery(SQL_SELECT_QUERY);
			}
			System.out.println("DATA BEFORE TRANSACTION");
			System.out.println("NAME\tBALANCE");
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t" +resultSet.getInt(2));
			}
			System.out.println("========================================");
			System.out.println("TRANSCATION BEGINS");
			connection.setAutoCommit(false);
			
			statement.executeUpdate(SQL_UPDATE_QUERY1);
			statement.executeUpdate(SQL_UPDATE_QUERY2);
			
			System.out.println("Can you please confirm this transaction of 5000 INR..[YES/NO]");
			scanner =new Scanner(System.in);
			if(scanner !=null) {
				System.out.println("Enter your choice..");
				option =scanner.next();
			}
			if(option.equalsIgnoreCase("yes")) {
				System.out.println("Transaction Complete...");	
			}else {
				connection.rollback();
				System.out.println("Transcation rollback");
			}
			
			System.out.println("========================================");
			System.out.println("DATA AFTER TRANSACTION");
			System.out.println("================================");

			if (statement != null) {
				resultSet = statement.executeQuery(SQL_SELECT_QUERY);
			}
			System.out.println("NAME\tBALANCE");
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1) + "\t " +resultSet.getInt(2));
			}
			
			}catch (SQLException se) {
				se.printStackTrace();
			}
		 catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, statement, connection);
		}
		}
	}




