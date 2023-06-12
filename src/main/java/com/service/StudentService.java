package com.service;

import com.entity.Country;
import com.entity.Student;

public interface StudentService {
	public void checkInsertOrUpdateStudent(Student student);

	public void checkFindStudents(Country country);

	public void checkfindStudentBycourse(String code);

	public void checkDeleteStudent(Student student);
}
