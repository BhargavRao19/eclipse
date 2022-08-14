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
public class SavePointApp {
	
	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcUtil.getDbConnection();
			statement = connection.createStatement();
			connection.setAutoCommit(false);
			statement.executeUpdate("insert into politicians values('modi','bjp')");
			statement.executeUpdate("insert into politicians values('rahul','congress')");
			Savepoint savepoint = connection.setSavepoint();
			statement.executeUpdate("insert into politicians values('siddu','bjp')");
			System.out.println("Wrong entry!! just rollback");
			connection.rollback(savepoint);
			
			connection.commit();
			System.out.println("operations successful");
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




