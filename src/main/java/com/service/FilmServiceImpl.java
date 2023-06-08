package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.entity.Film;
import com.repository.FilmRepository;

@Service

public class FilmServiceImpl implements FilmService {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FilmRepository filmRepository;

	@Override
	public void checkSaveOrUpdateFilm(Film film) {

		try {
			filmRepository.save(film);
			log.info("Inserimento riuscito");
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			log.info("Inserimento fallito");
			e.printStackTrace();
		}
	}

	@Override
	public void checkDeleteFilm(Film film) {
		try {
			filmRepository.delete(film);
			log.info("cancellazione riuscita");
		} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
			log.info("cancellazione non riuscita");
			e.printStackTrace();
		}

	}

	@Override
	public void checkFindAllFilms() {
		List<Film> films = filmRepository.findAll();
		if (films != null && !films.isEmpty()) {
			log.info("lettura eseguita");
			films.forEach(System.out::println);
		} else {
			log.info("lettura fallita");
		}

	}
}
