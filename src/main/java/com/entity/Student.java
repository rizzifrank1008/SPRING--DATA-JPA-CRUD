package com.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String passportNumber;

	@Column(unique = true)
	private String email;

	private String firstName;

	private String lastName;

	private Integer age;

	// configurazione del join
	@ManyToMany
	@JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "passportNumber"), inverseJoinColumns = @JoinColumn(name = "code"))
	List<Course> likedCourses;

	public Student() {
	}

	// costruttore per insert
	public Student(String email, String firstName, String lastName, Integer age) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	// costruttore per update

	public Student(String passportNumber, String email, String firstName, String lastName, Integer age) {
		this.passportNumber = passportNumber;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Course> getLikedCourses() {
		return likedCourses;
	}

	public void setLikedCourses(List<Course> likedCourses) {
		this.likedCourses = likedCourses;
	}

	@Override
	public String toString() {
		return "Student [passportNumber=" + passportNumber + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", age=" + age + "]";
	}

}
