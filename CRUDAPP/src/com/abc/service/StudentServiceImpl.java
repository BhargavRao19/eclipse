package com.abc.service;
import com.abc.dao.IStudentDao;
import com.abc.dao.StudentDaoFactory;
import com.abc.pojo.Student;
public class StudentServiceImpl implements IStudentService {

	@Override
	public String save(Student student) {

		IStudentDao dao = StudentDaoFactory.getDao();
		return dao.save(student);

	}

	@Override
	public Student getById(int id) {
		IStudentDao dao = StudentDaoFactory.getDao();
		return dao.getById(id);
	}

	@Override
	public String updateById(Student student) {
		IStudentDao dao = StudentDaoFactory.getDao();
		return dao.updateById(student);
	}

	@Override
	public String deleteById(int id) {
		IStudentDao dao = StudentDaoFactory.getDao();
		return dao.deleteById(id);
	}

	
}
