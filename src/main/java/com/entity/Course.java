package com.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
		@NamedQuery(name = "Course.findCodeByTitle", query = "SELECT c.code FROM Course c WHERE c.title = :title") })

public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String code;

	@Column(unique = true)
	private String title;

	private String description;

	@ManyToMany(mappedBy = "likedCourses")
	List<Student> likes;

	public Course() {
	}

	public Course(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public Course(String code, String title, String description) {
		this.code = code;
		this.title = title;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Student> getLikes() {
		return likes;
	}

	public void setStudents(List<Student> likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Course [code=" + code + ", title=" + title + ", description=" + description + "]";
	}

}
