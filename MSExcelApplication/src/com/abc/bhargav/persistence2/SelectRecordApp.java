package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class SelectRecordApp {
	private static final String EXCEL_SELECT = "select * from AdvancedJava.studentdetails";

	public static void main(String[] args) {

		try(Connection connection = DriverManager.getConnection("jdbc:Excel:///C:\\Users\\bhargav rao\\Documents\\ABC\\JDBC")) {
			try(PreparedStatement pstmt= connection.prepareStatement(EXCEL_SELECT)){
			try(ResultSet resultSet = pstmt.executeQuery())	{
				System.out.println("SNO\tSNAME\tSADDRESS");
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+ "\t"+resultSet.getString(2)
					+ "\t"+resultSet.getString(3));
				}
			}
			}
		}catch(SQLException se) {
			System.out.println(se.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}


