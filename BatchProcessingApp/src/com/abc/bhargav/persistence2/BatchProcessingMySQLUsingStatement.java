package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.abc.utility.JdbcUtil;
public class BatchProcessingMySQLUsingStatement {
	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = JdbcUtil.getDbConnection();
			if (connection != null) {
				statement = connection.createStatement();
			}
			if(statement !=null) {
			//Add query to batch file
			statement.addBatch("insert into employee(eadd,ename,esalary) values('SRH','Warner',85000)");
			statement.addBatch("update employee set esalary=esalary+5000 where eadd='rcb'");
			statement.addBatch("delete from employee where eadd='RR'");
			
			//Executing the batch file
			int [] arr = statement.executeBatch();
			int rowCount=0;
			for(int rowAffected :arr) {
				rowCount += rowAffected;
			}
			System.out.println("Number of records affected is:: " +rowCount);
			
			}
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




