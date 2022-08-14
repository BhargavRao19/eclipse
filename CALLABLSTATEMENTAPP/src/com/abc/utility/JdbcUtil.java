package com.abc.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

	public static Connection getDbConnection() throws SQLException, IOException {
	Properties properties = new Properties();	
	
	String filePath = "C:\\Users\\bhargav rao\\eclipse-workspace\\CALLABLSTATEMENTAPP\\src\\com\\abc\\properties\\application.properties";
	FileInputStream fis = new FileInputStream(filePath);
	properties.load(fis);
	
	String url = properties.getProperty("jdbc.url");
	String username = properties.getProperty("jdbc.username");
	String password = properties.getProperty("jdbc.password");
	
	
	return DriverManager.getConnection(url,username,password);

	}
	public static void close(ResultSet resultSet,Statement statement,Connection connection) {
		 //Closing JDBC Resources
		try {
			if(resultSet !=null) {
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
			if(connection !=null )
			{
				connection.close();
			}
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
