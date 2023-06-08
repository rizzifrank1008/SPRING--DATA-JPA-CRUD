package com.service;

import java.util.List;

import com.entity.Actor;

public interface ActorService {
	public void checkSaveOrUpdateActor(Actor actor);

	public void checkSaveListActor(List<Actor> actorList);

	public void checkFindAllActors();

}
