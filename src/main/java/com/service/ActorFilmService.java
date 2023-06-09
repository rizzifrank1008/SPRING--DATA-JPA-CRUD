package com.service;

import com.entity.ActorFilm;

public interface ActorFilmService {
	public void checkSaveOrUpdateActorFilm(ActorFilm actorFilm);

	public void checkDeleteActorFilm(ActorFilm actorFilm);

	public void CheckFindActorByFilm(String title);

	public void CheckFindActorByFilmPrefix(String title, String Prefix);

}
