package com.abc.bhargav.persist3;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
//import org.apache.commons.io.IOUtils;

public class CLOBInsertMysqlApp {
	private static final String SQL_INSERT_QUERY="INSERT INTO NAUKRI_PROFILE(PNAME,PADDRESS,QUALIFICATION,RESUME) VALUES(?,?,?,?)";
	public static void main(String[] args) {
	String url = "jdbc:mysql://localhost:3309/xyz";
	String username = "root";
	String password = "admin";

	Connection connection =null;
	PreparedStatement pstmt =null;
	Scanner scanner =null;
	ResultSet resultSet = null;

	int pid=0;
	String pname=null,paddress=null,qualification=null;
	String filePath=null;
	//FileOutputStream fos= null;
	Reader reader = null;


	try {
		scanner =new Scanner(System.in);

		if(scanner !=null) {
			//Collecting the pid value from the user
			System.out.println("ENTER THE PNAME:: ");
			pname =scanner.next();
			
			System.out.println("ENTER THE PADDRESS:: ");
			paddress = scanner.next();
			
			System.out.println("ENTER THE QUALIFICATION:: ");
			qualification= scanner.next();
			
			System.out.println("ENTER THE PATH OF THE RESUME::");
			filePath = scanner.next();
			
			//Setting a stream to collect resume input to the application
			reader = new FileReader(filePath);
		}
		//Establishing the connection by providing url,username,password
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
			pstmt.setString(2, paddress);
			pstmt.setString(3, qualification);
			
			//Setting the stream value to PRE-COMPILED Query
			pstmt.setCharacterStream(4,reader);


			if(pstmt !=null) {
				//step3:Execute the query and process the result
				int rowCount = pstmt.executeUpdate();
				
				if(rowCount == 0)
					System.out.println("Record insertion failed");
				else
					System.out.println("Record insertion successful");
				
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
			if(reader !=null)
				reader.close();
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
