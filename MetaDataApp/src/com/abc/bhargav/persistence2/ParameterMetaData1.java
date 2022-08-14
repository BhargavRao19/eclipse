package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.abc.utility.JdbcUtil;

public class ParameterMetaData1 {

	private static final String SQL_SELECT_QUERY = "select * from student where sid=?";

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet=null;
		Scanner scanner =null;
		try {
			connection = JdbcUtil.getDbConnection();
			if(connection !=null) {
				pstmt = connection.prepareStatement(SQL_SELECT_QUERY);		
			}
			if(pstmt !=null) {
				ParameterMetaData pametaData = pstmt.getParameterMetaData();
				System.out.println(pametaData.getParameterTypeName(1));
				resultSet = pstmt.executeQuery();
			}


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




