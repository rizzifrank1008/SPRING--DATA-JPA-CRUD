package com.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;

public class ActorFilmPK implements Serializable {

	private static final long serialVersionUID = -36226883712800597L;

	@Column(name = "actor_id")
	private Integer actorId;

	@Column(name = "film_id")
	private Integer filmId;

	public ActorFilmPK() {

	}

	public ActorFilmPK(Integer actorId, Integer filmId) {
		this.actorId = actorId;
		this.filmId = filmId;
	}

	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actorId, filmId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActorFilmPK other = (ActorFilmPK) obj;
		return Objects.equals(actorId, other.actorId) && Objects.equals(filmId, other.filmId);
	}

	@Override
	public String toString() {
		return "ActorFilmPK [actorId=" + actorId + ", filmId=" + filmId + "]";
	}

}
