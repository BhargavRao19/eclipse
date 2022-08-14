package com.abc.dao;
import com.abc.dao.StudentDaoImpl;
import com.abc.dao.StudentDaoImpl;

//Factory Design pattern code
public class StudentDaoFactory {

	private static IStudentDao studentDaoImpl;
	static {
		studentDaoImpl = new StudentDaoImpl();
	}
	public static IStudentDao getDao() {
		return studentDaoImpl;
	}
}
