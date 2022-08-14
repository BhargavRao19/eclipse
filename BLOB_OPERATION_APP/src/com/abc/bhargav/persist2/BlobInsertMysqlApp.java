package com.abc.bhargav.persist2;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
//import java.text.SimpleDateFormat;
//import java.util.Date;

public class BlobInsertMysqlApp {
	private static final String SQL_INSERT_QUERY="INSERT INTO SHADI_INFO(PNAME,PAGE,PADDRESS,IMAGE) VALUES(?,?,?,?)";
	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3309/xyz";
		String username = "root";
		String password = "admin";

		Connection connection =null;
		PreparedStatement pstmt =null;
		Scanner scanner =null;
		String pname=null,paddress=null,filePath=null;
		FileInputStream fis = null;
		int page=0;


		try {
			scanner =new Scanner(System.in);

			if(scanner !=null) {
				//Collecting date inputs from the user
				System.out.print("ENTER THE PNAME:: ");
				pname =scanner.next();

				System.out.print("ENTER THE PAGE:: ");
				page =scanner.nextInt();

				System.out.print("ENTER THE PADDRESS:: ");
				paddress =scanner.next();

				System.out.print("Enter the path of the image::");
				filePath = scanner.next();
				//Setting a stream to collect image path to the application
				fis = new FileInputStream(filePath);

			}
			//Establishing the connection by provvideing url,username,password
			connection= DriverManager.getConnection(url,username,password);
			System.out.println("Connection established with the following: "+url);

			if(connection !=null)
			{
				//Creating a PRE-COMPILED Query object
				pstmt = connection.prepareStatement(SQL_INSERT_QUERY);
			}
			if(pstmt !=null) {
				//Setting the input value to pre-compiled query 
				pstmt.setString(1, pname);
				pstmt.setInt(2,page);
				pstmt.setString(3,paddress);

				//Setting the stream value to PRE-COMPILED Query
				pstmt.setBinaryStream(4, fis);

				if(pstmt !=null) {
					//step3:Execute the query
					int rowCount=pstmt.executeUpdate();
					if(rowCount==0)
						System.out.println("Record insertion failed");
					else
						System.out.println("Record insertion successfully");
				}
			}
		}catch(SQLException se) {
			//step4:Handling the SQLException object if generated
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
				if(fis !=null)
					fis.close();
			}catch(IOException e) {
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
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}


