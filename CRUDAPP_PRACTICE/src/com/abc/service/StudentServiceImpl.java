package com.abc.service;

import com.abc.controller.IStudentController;
import com.abc.dao.IStudentDao;
import com.abc.factory.StudentDaoFactory;
import com.abc.pojo.Student;

public class StudentServiceImpl implements IStudentController {

	@Override
	public String save(Student student) {
		IStudentDao dao = StudentDaoFactory.getDao();
		return dao.save(student);
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
