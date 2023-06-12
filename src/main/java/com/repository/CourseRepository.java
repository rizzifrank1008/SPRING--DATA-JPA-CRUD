package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Course;

public interface CourseRepository extends JpaRepository<Course, String> {

	// i corsi a cui un determinato studente è inscritto

	@Query("SELECT c FROM Course c join Student s  WHERE s.passportNumber=:passportNumber")
	public List<Course> findCoursesByStudent(String passportNumber);

}
