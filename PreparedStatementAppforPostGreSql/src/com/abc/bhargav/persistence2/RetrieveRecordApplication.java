package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.abc.utility.JdbcUtil;
public class RetrieveRecordApplication {
	private static final String SQL_SELECT_QUERY = "select pid,pname,price,qty from product";
	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			connection =JdbcUtil.getDbConnection();		
         
			if(connection !=null){
				pstmt = connection.prepareStatement(SQL_SELECT_QUERY);
			}
			if(pstmt !=null) {
				resultSet = pstmt.executeQuery();
			}
			
			if(resultSet !=null) {
				System.out.println("PID\t PNAME\t COST\t QUANTITY\t");
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3) + "\t" + resultSet.getInt(4));
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		}

	}




