package com.service;

import com.entity.Film;

public interface FilmService {
	public void checkSaveOrUpdateFilm(Film film);

	public void checkDeleteFilm(Film film);

	public void checkFindAllFilms();

}
