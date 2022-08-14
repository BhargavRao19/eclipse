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

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class JdbcUtil {
	private static Connection connection;
	static MysqlConnectionPoolDataSource dataSource;
	static {
		Properties properties = new Properties();
		String filePath = "C:\\Users\\bhargav rao\\eclipse-workspace\\ConnectionPoolingApp\\src\\com\\abc\\bhargav\\properties\\application.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(filePath);
			properties.load(fis);
			String url = properties.getProperty("jdbc.url");
			String username = properties.getProperty("jdbc.username");
			String password = properties.getProperty("jdbc.password");
            
			 //Getting logocal connection
             dataSource = new MysqlConnectionPoolDataSource();
             dataSource.setUrl(url);
             dataSource.setUser(username);
             dataSource.setPassword(password);
            System.out.println("Connection established with following::"+url);
            
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	
	public static Connection getDbConnection() throws SQLException {
		if(dataSource !=null) {
			return dataSource.getConnection();
		}
	return connection;
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
