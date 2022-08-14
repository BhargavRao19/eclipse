package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.abc.utility.JdbcUtil;
public class ConnectionPoolForMysql {
	
	private static final String SQL_SELECT_QUERY="select * from employee";
	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Scanner scanner =null;
		String option=null;
		try {
			connection = JdbcUtil.getDbConnection();
			if(connection!=null) {
				statement = connection.createStatement();
			}
			if(statement !=null) {
				resultSet = statement.executeQuery(SQL_SELECT_QUERY);
			}
			if(resultSet !=null) {
				System.out.println("EID\tEADD\tENAME\tESALARY");
			}
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+ "\t" +resultSet.getString(2)+ "\t"+resultSet.getString(3)+ 
				  "\t"+resultSet.getFloat(4));
			}
			
			}catch (SQLException se) {
				se.printStackTrace();
			}
		 catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(resultSet, statement, connection);
		}
		}
	}




