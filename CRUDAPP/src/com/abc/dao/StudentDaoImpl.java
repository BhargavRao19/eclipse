package com.abc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abc.pojo.Student;
import com.abc.utility.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {

	@Override
	public String save(Student student)   {
		Connection connection = null;
		PreparedStatement pstmt =null;
		try {
			connection = JdbcUtil.getDbConnection();
			if(connection !=null)
			{
				String SQL_INSERT_QUERY = "insert into student(sname,sage,saddress) values(?,?,?)";
				pstmt = connection.prepareStatement(SQL_INSERT_QUERY);
			}
			if(pstmt !=null) {
				pstmt.setString(1, student.getSname());
				pstmt.setInt(2, student.getSage());
				pstmt.setString(3, student.getSaddress());

				int rowCount = pstmt.executeUpdate();
				if(rowCount >0)
					return "record inserted succesfully....";	
			}
		}catch(SQLException se ) {
			se.printStackTrace();

		}catch(Exception e){
			e.printStackTrace();
		}
		return "record insertion failed try again..";

	}

	@Override
	public Student getById(int id) {
		Connection connection = null;
		PreparedStatement pstmt =null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtil.getDbConnection();
			if(connection !=null)
			{
				String SQL_SELECT_QUERY = "SELECT SID,SNAME,SAGE,SADDRESS FROM STUDENT WHERE SID=?";
				pstmt = connection.prepareStatement(SQL_SELECT_QUERY);
			}
			if(pstmt !=null) {
				pstmt.setInt(1, id);
				resultSet = pstmt.executeQuery();		
			}
			if(resultSet.next()) {
				Student student = new Student();
				student.setSid(id);
				student.setSname(resultSet.getString(2));
				student.setSage(resultSet.getInt(3));
				student.setSaddress(resultSet.getString(4));
				return student;
			}
		}catch(SQLException se ) {
			se.printStackTrace();

		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateById(Student student) {
		Connection connection = null;
		PreparedStatement pstmt =null;
		try {
			connection = JdbcUtil.getDbConnection();
			if(connection !=null)
			{
				String SQL_UPDATE_QUERY = "UPDATE STUDENT SET SNAME=?,SAGE=?,SADDRESS=? WHERE SID =?";
				pstmt = connection.prepareStatement(SQL_UPDATE_QUERY);
			}
			if(pstmt !=null) {
				
				//Setting the inputs
				pstmt.setString(1, student.getSname());
				pstmt.setInt(2, student.getSage());
				pstmt.setString(3, student.getSaddress());
				pstmt.setInt(4, student.getSid());
				
				pstmt.executeUpdate();
				return "Updated successfully";

		}
	}catch(SQLException se ) {
		se.printStackTrace();
	}
		catch(Exception e ) {
			e.printStackTrace();
		}
		return "Updation failed";
}

@Override
public String deleteById(int id) {
	Connection connection = null;
	PreparedStatement pstmt =null;
	if(getById(id) ==null)
		return "Record not available for deleting the record with the id::"+id;
	else {
		try {
			connection = JdbcUtil.getDbConnection();
			if(connection !=null)
			{
				String SQL_DELETE_QUERY = "DELETE FROM STUDENT WHERE SID=?";
				pstmt = connection.prepareStatement(SQL_DELETE_QUERY);
			}
			if(pstmt !=null) {
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
			}
		}catch(SQLException se ) {
			se.printStackTrace();
		}catch(Exception e ) {
			e.printStackTrace();
		}

	}
	return "Record Deleted successfully for the given id::"+id;
}

}

