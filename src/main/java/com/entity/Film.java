package com.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	private Integer filmId;

	private String title;

	private String description;

	@UpdateTimestamp
	@Column(name = "last_update")
	private Timestamp lastUpdate;

	@OneToMany(mappedBy = "film")
	private List<ActorFilm> actors = new ArrayList<>(); // Inizializzo qui la lista in modo tale che
	// quando ci faccio delle operazioni sopra
	// non risulti null

	public Film() {

	}

	public Film(Integer filmId, String title, String description) {
		this.filmId = filmId;
		this.title = title;
		this.description = description;
	}

	// Costruttore per le insert con parametri pre impostati in modo da inserire
	// solo title e description
	public Film(String title, String description) {
		this.title = title;
		this.description = description;

	}

	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
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

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<ActorFilm> getActors() {
		return actors;
	}

	public void setActors(List<ActorFilm> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", description=" + description + ", lastUpdate="
				+ lastUpdate + "]";
	}

}