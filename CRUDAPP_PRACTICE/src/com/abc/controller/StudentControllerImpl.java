package com.abc.controller;

import com.abc.factory.StudentServiceFactory;
import com.abc.pojo.Student;
import com.abc.service.IStudentService;

public class StudentControllerImpl implements IStudentController {

	@Override
	public String save(Student student) {
		IStudentService studentService = StudentServiceFactory.getService();
		return studentService.save(student);
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
