package com.abc.bhargav.persistence2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class InsertRecordApp {
	private static final String EXCEL_INSERT = "insert into AdvancedJava.studentdetails values(?,?,?)";
     
	public static void main(String[] args) {
		int sid=0;
	     String sname=null,saddress=null;
	    
       Scanner scanner = null;
		try {
			scanner=new Scanner(System.in);
			if(scanner !=null) {
				System.out.println("Enter the sid:: ");
				sid=scanner.nextInt();
				
				System.out.println("Enter the sname:: ");
				sname=scanner.next();
				
				System.out.println("Enter the saddress:: ");
				saddress=scanner.next();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(scanner !=null) {
				scanner.close();
			}
		}
		
		try(Connection connection = DriverManager.getConnection("jdbc:Excel:///C:\\Users\\bhargav rao\\Documents\\ABC\\JDBC"))
		{	
			try(PreparedStatement pstmt= connection.prepareStatement(EXCEL_INSERT)){
				if(pstmt !=null) {
					pstmt.setInt(1, sid);
					pstmt.setString(2, sname);
					pstmt.setString(3, saddress);
					
					int rowCount = pstmt.executeUpdate();
					if(rowCount==0) 
						System.out.println("Record not inserted");
					else
						System.out.println("Record inserted successful");	
				}
					
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}


