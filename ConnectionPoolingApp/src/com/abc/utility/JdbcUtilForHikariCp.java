package com.abc.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.hikaricp.internal.HikariConfigurationUtil;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtilForHikariCp {
	private static Connection connection;
	private static HikariDataSource dataSource;
	
	static {
	
		String filePath = "C:\\Users\\bhargav rao\\eclipse-workspace\\ConnectionPoolingApp\\src\\com\\abc\\bhargav\\properties\\db.properties";
		
		try {
			 HikariConfig config = new HikariConfig(filePath);
			 dataSource = new HikariDataSource(config);
            
		}catch(Exception e ) {
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
