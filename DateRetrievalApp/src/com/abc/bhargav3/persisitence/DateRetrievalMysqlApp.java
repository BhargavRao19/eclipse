package com.abc.bhargav3.persisitence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateRetrievalMysqlApp {
	private static final String SQL_SELECT_QUERY="SELECT PID,PNAME,PADDRESS,DOB,DOM,DOJ FROM PERSONINFO WHERE PID=?";
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3309/xyz";
		String username = "root";
		String password = "admin";

		Connection connection =null;
		PreparedStatement pstmt =null;
		Scanner scanner =null;
		ResultSet resultSet = null;
		int pid = 0;
		java.text.SimpleDateFormat sdf=null;
		java.sql.Date sqlDob=null, sqlDom=null, sqlDoj=null;

		try {
			scanner =new Scanner(System.in);
			//Collecting pid from the user
			if(scanner !=null) {
				System.out.println("Enter the id of the person:: ");
				pid = scanner.nextInt();
			}

			//Establishing the connection by provvideing url,username,password
			connection= DriverManager.getConnection(url,username,password);
			System.out.println("Connection established with the following: "+url);

			if(connection !=null)
			{
				pstmt = connection.prepareStatement(SQL_SELECT_QUERY);
			}
			if(pstmt !=null) {
				//Setting the input value to pre-compiled query 
				pstmt.setInt(1, pid);
			}


			if(pstmt !=null)
				//Execute the query
				resultSet = pstmt.executeQuery();

			//Process the result and display the output
			if(resultSet.next()) {
				int pno = resultSet.getInt(1);
				String pname = resultSet.getString(2);
				String paddress = resultSet.getString(3);

				//Retrieving date information
				sqlDob = resultSet.getDate(4);
				sqlDom = resultSet.getDate(5);
				sqlDoj = resultSet.getDate(6);

				//Formatting the date as per the client INTERNATIONALIZATION(I18N)

				sdf = new SimpleDateFormat("dd-MM-yyyy");
				String sdob = sdf.format(sqlDob);
				String sdom = sdf.format(sqlDom);
				String sdoj = sdf.format(sqlDoj);

				System.out.println(pno+" "+pname+" "+paddress+" "+sqlDob+" "+sqlDom+" "+sqlDoj);
				System.out.println(pno+" "+pname+" "+paddress+" "+sdob+" "+sdom+" "+sdoj);

			}else
				System.out.println("Record not available for the given id:: "+pid);


		}catch(SQLException se) {
			if(se.getErrorCode()==1406)
				System.out.println("data too long for column");
			else if (se.getErrorCode() == 1062)
				System.out.println("Duplicate primary key value");
			else if (se.getErrorCode() == 1136)
				System.out.println("Insufficent values supplied by the user...");
			else if (se.getErrorCode() == 1064)
				System.out.println("Syntax error in SQL");
			else
				System.out.println("Some SQLException occured...."+se.getMessage());

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//step5:Closing the resources
			try {
				if(scanner !=null)
					scanner.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(pstmt !=null) {
					pstmt.close();
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(connection !=null )
				{
					connection.close();
				}
				try {
					if(resultSet !=null )
					{
						resultSet.close();
					}
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}


