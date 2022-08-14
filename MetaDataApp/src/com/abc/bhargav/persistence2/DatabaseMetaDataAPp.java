package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.abc.utility.JdbcUtil;
public class DatabaseMetaDataAPp {
	
	private static final String SQL_SELECT_QUERY = "select * from accounts";
	private static final String SQL_UPDATE_QUERY1 = "update accounts set balance=balance-5000 where name='bhargav'";
	private static final String SQL_UPDATE_QUERY2 = "update accounts set balance=balance+5000 where name='ronaldo'";
	public static void main(String[] args) {

		Connection connection = null;
	
		try {
			connection = JdbcUtil.getDbConnection();
			DatabaseMetaData dbMetaData = connection.getMetaData();
			System.out.println(dbMetaData.getDatabaseProductName());
			System.out.println(dbMetaData.getDatabaseProductVersion());
			System.out.println(dbMetaData.getDatabaseMajorVersion());
			System.out.println(dbMetaData.getDatabaseMinorVersion());
			System.out.println(dbMetaData.getDriverName());
			System.out.println(dbMetaData.getDriverVersion());
			System.out.println(dbMetaData.getStringFunctions());
			System.out.println(dbMetaData.getSQLKeywords());
			System.out.println(dbMetaData.getMaxColumnsInTable());
			System.out.println(dbMetaData.getMaxColumnsInSelect());
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




