package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Actor;
import com.entity.Course;

public interface CourseRepository extends JpaRepository<Course, String> {

	// i corsi a cui un determinato studente è inscritto

	@Query("SELECT s FROM Student s join Course c  WHERE c.title=:title")
	public List<Actor> findCoursesByStudent(String title);

}
