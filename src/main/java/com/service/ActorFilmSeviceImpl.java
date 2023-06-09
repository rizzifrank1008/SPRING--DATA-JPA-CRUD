package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.entity.Actor;
import com.entity.ActorFilm;
import com.repository.ActorFilmRepository;

@Service
public class ActorFilmSeviceImpl implements ActorFilmService {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ActorFilmRepository actorFilmRepository;

	@Override
	public void checkSaveOrUpdateActorFilm(ActorFilm actorFilm) {
		try {
			actorFilmRepository.save(actorFilm);
			log.info("Inserimento riuscito");
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			log.info("Inserimento fallito");
			e.printStackTrace();
		}

	}

	@Override
	public void checkDeleteActorFilm(ActorFilm actorFilm) {
		try {
			actorFilmRepository.delete(actorFilm);
			log.info("cancellazione riuscita");
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			log.info("cancellazione fallita");
			e.printStackTrace();
		}

	}

	@Override
	public void CheckFindActorByFilm(String title) {
		List<Actor> actors = actorFilmRepository.findActorByFilm(title);
		if (actors != null && !actors.isEmpty()) {
			log.info("lettura eseguita");
			actors.forEach(System.out::println);
		} else {
			log.info("lettura fallita");
		}

	}

	@Override
	public void CheckFindActorByFilmPrefix(String title, String prefix) {
		List<Actor> actors = actorFilmRepository.findActorByFilmAndActorPrefix(title, prefix + "%");
		if (actors != null && !actors.isEmpty()) {
			log.info("lettura eseguita");
			actors.forEach(System.out::println);
		} else {
			log.info("lettura fallita");
		}

	}

}
