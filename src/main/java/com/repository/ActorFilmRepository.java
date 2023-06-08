package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.Actor;
import com.entity.ActorFilm;

public interface ActorFilmRepository extends JpaRepository<ActorFilm, Integer> {
	@Query("SELECT a FROM Actor a join actorFilm af join film f WHERE f.title=:title")
	public List<Actor> findActorByFilm(String title);

	@Query("SELECT a FROM Actor a join actorFilm af join film f WHERE f.title=:title and a.lastName like :prefix")
	public List<Actor> findActorByFilmAndActorPrefix(String title, String prefix);
}
