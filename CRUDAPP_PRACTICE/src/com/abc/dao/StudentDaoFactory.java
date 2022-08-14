package com.abc.dao;
import com.abc.dao.IStudentDao;
import com.abc.dao.StudentDaoImpl;

//FACTORY DESIGN PATTERN CODE
public class StudentDaoFactory {

	private static IStudentDao studentDaoImpl;

	static {
		studentDaoImpl = (IStudentDao) new StudentDaoImpl();
	}

	public static IStudentDao getDao() {
		return studentDaoImpl;
	}

}


