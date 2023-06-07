package com.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class ActorFilm {

	@EmbeddedId
	ActorFilmPK id;

	@ManyToOne
	@MapsId("actorId")
	@JoinColumn(name = "actor_id")
	Actor actor;

	@ManyToOne
	@MapsId("filmId")
	@JoinColumn(name = "film_id")
	Film film;

	public ActorFilm() {

	}

	public ActorFilm(Actor actor, Film film) {

		this.actor = actor;
		this.film = film;
	}

	public ActorFilm(ActorFilmPK id, Actor actor, Film film) {
		this.id = id;
		this.actor = actor;
		this.film = film;
	}

	public ActorFilmPK getId() {
		return id;
	}

	public void setId(ActorFilmPK id) {
		this.id = id;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	@Override
	public String toString() {
		return "ActorFilm [id=" + id + ", actor=" + actor + ", film=" + film + "]";
	}

}
