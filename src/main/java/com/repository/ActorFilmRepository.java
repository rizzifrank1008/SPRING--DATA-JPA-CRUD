package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.ActorFilm;

public interface ActorFilmRepository extends JpaRepository<ActorFilm, Integer> {

}
