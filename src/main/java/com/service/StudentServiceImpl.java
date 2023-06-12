package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.entity.Country;
import com.entity.Student;
import com.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void checkInsertOrUpdateStudent(Student student) {
		try {
			studentRepository.save(student);
			log.info("Inserimento o aggiornamento studente riuscito");
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			log.info("Inserimento o aggiornamento studente fallito");
			e.printStackTrace();
		}

	}

	@Override
	public void checkFindStudents(Country country) {
		List<Student> students = studentRepository.findAll();
		if (students != null && !students.isEmpty()) {
			log.info("lettura eseguita");
			students.forEach(System.out::println);
		} else {
			log.info("lettura fallita");
		}
	}

	@Override
	public void checkfindStudentBycourse(String code) {
		List<Student> students = studentRepository.findStudentBycourse(code);
		if (students != null && !students.isEmpty()) {
			log.info("lettura eseguita");
			students.forEach(System.out::println);
		} else {
			log.info("lettura fallita");
		}

	}

	@Override
	public void checkDeleteStudent(Student student) {
		try {
			studentRepository.delete(student);
			log.info("cancellazione riuscita");
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			log.info("cancellazione non riuscita");
			e.printStackTrace();
		}

	}

}
