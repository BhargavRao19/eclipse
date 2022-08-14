package com.abc.bhargav.persist3;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.commons.io.IOUtils;

import com.abc.utility.JdbcUtil;

public class CLOBRetrievalMysqlApp {
	private static final String SQL_SELECT_QUERY="SELECT PID,PNAME,PADDRESS,QUALIFICATION,RESUME FROM NAUKRI_PROFILE WHERE PID=?";
	public static void main(String[] args) {
	
		Connection connection =null;
		PreparedStatement pstmt =null;
		Scanner scanner =null;
		ResultSet resultSet = null;

		int pid=0;
		Reader reader = null;
		FileWriter writer = null;


		try {
			scanner =new Scanner(System.in);

			if(scanner !=null) {
				//Collecting the pid value from the user
				System.out.print("ENTER THE PID:: ");
				pid =scanner.nextInt();

			}
			//Establishing the connection by using utility method
			connection=JdbcUtil.getDbConnection();
			
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
							System.out.println("PADDRESS IS : "+resultSet.getString(3));
							System.out.println("QUALIFICATION IS : "+resultSet.getString(4));

							//Getting the resume details and copying it to local drive(download)
							reader = resultSet.getCharacterStream(5);
							String filelocation = "D:\\image\\resume_copied.txt";
							writer = new FileWriter(filelocation);

							//copy from Reader Stream to Writer Stream
							IOUtils.copy(reader,writer);
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
			
			//step5:Closing the application specific resources

			try {
				if(scanner !=null)
					scanner.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(reader !=null && writer !=null) {
					reader.close();
					writer.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
            //Closing JDBC Resources
			JdbcUtil.close(resultSet, pstmt, connection);
		}

	}

}
