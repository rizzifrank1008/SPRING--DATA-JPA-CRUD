package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.entity.Course;
import com.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void checkSaveOrUpdateCourse(Course course) {
		try {
			courseRepository.save(course);
			log.info("Inserimento corso o aggiornamento riuscito");
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			log.info("Inserimento corso o aggiornamento fallito");
			e.printStackTrace();
		}

	}

	@Override
	public void checkfindCoursesByStudent(String passportNumber) {
		List<Course> courses = courseRepository.findCoursesByStudent(passportNumber);
		if (courses != null && !courses.isEmpty()) {
			log.info("lettura eseguita");
			courses.forEach(System.out::println);
		} else {
			log.info("lettura fallita");
		}

	}

	@Override
	public void checkDeleteCourse(Course course) {
		courseRepository.delete(course);

	}

	@Override
	public void checkFindAllCourse() {
		List<Course> courses = courseRepository.findAll();
		if (courses != null && !courses.isEmpty()) {
			log.info("lettura eseguita");
			courses.forEach(System.out::println);
		} else {
			log.info("lettura fallita");
		}

	}

}
