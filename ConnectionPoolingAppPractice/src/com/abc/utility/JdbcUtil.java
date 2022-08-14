package com.abc.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	//private static Connection connection;
	public static Connection getDbConnection() throws SQLException,IOException{
		Properties properties = new Properties();
		String path="C:\\Users\\bhargav rao\\eclipse-workspace\\ConnectionPoolingAppPractice\\src\\com\\abc\\properties\\application.properties";
		FileInputStream fis =null;
		

		fis=new FileInputStream(path);
		properties.load(fis);
		String url=properties.getProperty("jdbc.url");
		String username=properties.getProperty("jdbc.username");
		String password=properties.getProperty("jdbc.password");
         
		
		return DriverManager.getConnection(url,username,password);
	}
	public static void close(ResultSet resultSet,Statement statement,Connection connection) {
		try {
			if(resultSet != null) {
				resultSet.close();
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			if(statement !=null) {
				statement.close();
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			if(resultSet !=null) {
				resultSet.close();
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
	}
}

}

