package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

	@Query("SELECT s FROM Student s join Course c  WHERE c.code=:code")
	public List<Student> findStudentBycourse(String code);

	@Query("DELETE FROM  WHERE COURSE_STUDENT  code=:code AND passportNumber=:passportNumber ")
	public void removeCourseByCode(String code, String passportNumber);

}
