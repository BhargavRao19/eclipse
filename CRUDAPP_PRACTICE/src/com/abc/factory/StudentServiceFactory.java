package com.abc.factory;

import com.abc.service.IStudentService;
import com.abc.service.StudentServiceImpl;

//FACTORY DESIGN PATTERN CODE
public class StudentServiceFactory {

	private static IStudentService studentServiceImpl;

	static {
		studentServiceImpl =  new StudentServiceImpl();
	}

	public static IStudentService getService() {
		return studentServiceImpl;
		
	}
}

