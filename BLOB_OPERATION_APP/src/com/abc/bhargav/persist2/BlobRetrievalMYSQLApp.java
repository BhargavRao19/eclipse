package com.abc.bhargav.persist2;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.commons.io.IOUtils;

public class BlobRetrievalMYSQLApp {
	private static final String SQL_SELECT_QUERY="SELECT PID,PNAME,PAGE,PADDRESS,IMAGE FROM SHADI_INFO WHERE PID=?";
	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3309/xyz";
		String username = "root";
		String password = "admin";

		Connection connection =null;
		PreparedStatement pstmt =null;
		Scanner scanner =null;
		ResultSet resultSet = null;

		int pid=0;
		InputStream fis = null;
		FileOutputStream fos= null;


		try {
			scanner =new Scanner(System.in);

			if(scanner !=null) {
				//Collecting the pid value from the user
				System.out.print("ENTER THE PID:: ");
				pid =scanner.nextInt();

			}
			//Establishing the connection by provvideing url,username,password
			connection= DriverManager.getConnection(url,username,password);
			System.out.println("Connection established with the following: "+url);

			if(connection !=null)
			{
				//Creating a PRE-COMPILED Query object
				pstmt = connection.prepareStatement(SQL_SELECT_QUERY);
			}
			if(pstmt !=null) {
				//Setting the input value to pre-compiled query 
				pstmt.setInt(1,pid);


				if(pstmt !=null) {
					//step3:Execute the query and process the resultSet
					resultSet = pstmt.executeQuery();

					if(resultSet !=null)
						if(resultSet.next() == true) {
							System.out.println("PID IS : "+resultSet.getInt(1));
							System.out.println("PNAME IS : "+resultSet.getString(2));
							System.out.println("PAGE IS : "+resultSet.getString(3));
							System.out.println("PADDRESS IS : "+resultSet.getString(4));

							//Getting the image and copying it to local drive(download)
							fis = resultSet.getBinaryStream(5);
							String filelocation = "D:\\image\\sachin_copied.jpg";
							fos = new FileOutputStream(filelocation);
							//copy from inputstream to outputstream
							IOUtils.copy(fis, fos);
							System.out.println("File rendering is done in the following :"+filelocation);
						}
						else {
							System.out.println("Record not found for the given id:: "+pid);
						}
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
				if(fos !=null)
					fos.close();
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


