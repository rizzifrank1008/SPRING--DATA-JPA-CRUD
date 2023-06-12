package com.service;

import com.entity.Course;

public interface CourseService {
	public void checkSaveOrUpdateCourse(Course course);

	public void checkfindCoursesByStudent(String passportNumber);

	public void checkDeleteCourse(Course course);

	public void checkFindAllCourse();

}
