package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.abc.utility.JdbcUtil;
public class InsertRecordApp {
	
	private static final String SQL_INSERT_QUERY = "INSERT INTO PRODUCT(PID,PNAME,PRICE,QTY) values(nextval('pid_sequence'),?,?,?)";
	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		Scanner scanner =null;
		String pname=null,price=null,qty=null;
		String option;

		try {
			connection =JdbcUtil.getDbConnection();		
            scanner = new Scanner(System.in);
			if(connection !=null){
				pstmt = connection.prepareStatement(SQL_INSERT_QUERY);
			}
			while(true) {
			if(scanner != null) {
				
				System.out.println("Enter the PNAME");
				pname = scanner.next();
				
				System.out.println("Enter the PRICE");
				price = scanner.next();
				
				System.out.println("Enter the QUANTITY");
				qty = scanner.next();
				
			
			}
			if(pstmt !=null) {
				pstmt.setString(1, pname);
				pstmt.setInt(2, Integer.parseInt(price));
				pstmt.setInt(3, Integer.parseInt(qty));
				
				int rowCount = pstmt.executeUpdate();
				System.out.println("No of records inserted is :: " +rowCount);
			}
			
			 
			 System.out.println("record inserted successfully");
			 
			 System.out.println("do you want to insert more[]YES/NO");
			  option = scanner.next();
			 
			 if(option.equalsIgnoreCase("no"))
				 break;
			}
			
			}catch (SQLException se) {
				se.printStackTrace();
			}
		 catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, pstmt, connection);
		}
		}
	}




