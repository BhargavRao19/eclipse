package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Scanner;

import com.abc.utility.JdbcUtil;
public class TransactionIsolationLevelApp {
	
	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		
		
		try {
			connection = JdbcUtil.getDbConnection();
			System.out.println(connection.getTransactionIsolation());
			connection.setTransactionIsolation(8);
			System.out.println(connection.getTransactionIsolation());
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




