package com.abc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.abc.controller.IStudentController;
import com.abc.factory.StudentDaoFactory;
import com.abc.pojo.Student;
import com.abc.utility.JdbcUtil;

public class StudentDaoImpl implements IStudentController {

	@Override
	public String save(Student student) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
		connection = JdbcUtil.getDbConnection();
		if(connection !=null)
		{    
			String SQL_INSERT_QUERY= "insert into student1 values(?,?,?)";
			connection.prepareStatement(SQL_INSERT_QUERY);
		}
		
		if(pstmt !=null) {
	      pstmt.setString(1, student.getSname());
	      pstmt.setInt(2, student.getSage());
	      pstmt.setString(3, student.getSaddress());
	      
	     int rowCount =  pstmt.executeUpdate();
	     if(rowCount > 0)
	    	 return "Record inserted successfully";
		}
		
			
		
		
		}catch(SQLException  e)  {
			e.printStackTrace();
			
		}finally {
			JdbcUtil.close(null,pstmt,connection);
			return "Record insertion failed try again!!";
		}
		
		
	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateById(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
