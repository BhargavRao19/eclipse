package com.abc.bhargav.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.abc.utility.JdbcUtil;

public class ConnectionPoolingPractice {
	private static String SQL_SELECT_QUERY="select * from employee";
	public static void main(String[] args) {
		Connection connection =null;
		Statement stmt=null;
		ResultSet resultSet = null;
		try {
			connection =JdbcUtil.getDbConnection();
			if(connection !=null) {
				stmt = connection.createStatement();
			}if(stmt !=null) {
				resultSet = stmt.executeQuery(SQL_SELECT_QUERY);
			}if(resultSet !=null) {
				while(resultSet.next()) {
					System.out.println("EID\tEADD\tENAME\tESALARY");
					System.out.println(resultSet.getInt(1)+"\t" +resultSet.getString(2) +"\t" +resultSet.getString(3) +"\t" +resultSet.getFloat(4));
				}
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(resultSet, stmt, connection);
		}

	}

}
