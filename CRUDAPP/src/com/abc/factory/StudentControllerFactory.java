package com.abc.factory;

import com.abc.controller.IStudentController;
import com.abc.controller.StudentControllerImpl;

//Factory Design pattern code
public class StudentControllerFactory {

	private static IStudentController studentController;
	
	static {
		studentController = new StudentControllerImpl();
	}
	
	public static IStudentController getController() {
		return studentController;
	}
}
