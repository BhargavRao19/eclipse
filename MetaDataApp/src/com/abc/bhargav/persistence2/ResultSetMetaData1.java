package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.abc.utility.JdbcUtil;

public class ResultSetMetaData1 {
	
	private static final String SQL_SELECT_QUERY = "select * from student";
	
	public static void main(String[] args) {

		Connection connection = null;
	    Statement statement = null;
	    ResultSet resultSet=null;
		try {
			connection = JdbcUtil.getDbConnection();
			if(connection !=null) {
				statement =connection.createStatement();
			}
			if(statement !=null) {
				resultSet =statement.executeQuery(SQL_SELECT_QUERY);
			}
			if(resultSet !=null) {
			ResultSetMetaData rsMetaData =resultSet.getMetaData();
			int count = rsMetaData.getColumnCount();
			System.out.println(count);
			
			for(int i=1;i<=count;i++) {
				System.out.println("Column number  : "+i);
				System.out.println("Column Name    : "+rsMetaData.getColumnName(i));
				System.out.println("Column Type    :" +rsMetaData.getColumnTypeName(i));
				System.out.println("=================================");
			}
			
			
			}
			}catch (SQLException se) {
				se.printStackTrace();
			}
		 catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, null, connection);
		}
		}
	}




