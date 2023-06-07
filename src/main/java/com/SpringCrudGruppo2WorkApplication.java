package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Actor;
import com.entity.ActorFilm;
import com.entity.ActorFilmPK;
import com.entity.Category;
import com.entity.City;
import com.entity.Country;
import com.entity.Film;
import com.repository.ActorFilmRepository;
import com.repository.ActorRepository;
import com.repository.CategoryRepository;
import com.repository.CityRepository;
import com.repository.CountryRepository;
import com.repository.FilmRepository;

import jakarta.annotation.Resource;

@SpringBootApplication
public class SpringCrudGruppo2WorkApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private ActorFilmRepository actorFilmRepository;

	@Resource(name = "categoryToInsert1")
	private Category categoryToInsert1;

	@Resource(name = "categoryToInsert2")
	private Category categoryToInsert2;

	@Resource(name = "categoryToInsert3")
	private Category categoryToInsert3;

	@Resource(name = "categoryToUpdate")
	private Category categoryToUpdate;

	@Resource(name = "countryToInsert1")
	private Country countryToInsert1;
	@Resource(name = "cityToInsert1")
	private City cityToInsert1;
	@Resource(name = "cityToInsert2")
	private City cityToInsert2;
	@Resource(name = "cityToInsert3")
	private City cityToInsert3;
	@Resource(name = "cityToUpdate")
	private City cityToUpdate;

	@Resource(name = "countryToUpdate")
	private Country countryToUpdate;

	@Resource(name = "countryToInsert2")
	private Country countryToInsert2;

	@Resource(name = "actorToInsert1")
	private Actor actorToInsert1;

	@Resource(name = "actorToInsert2")
	private Actor actorToInsert2;

	@Resource(name = "actorToInsert3")
	private Actor actorToInsert3;

	@Resource(name = "actorToInsert4")
	private Actor actorToInsert4;

	@Resource(name = "actorToInsert5")
	private Actor actorToInsert5;

	@Resource(name = "filmToInsert1")
	private Film filmToInsert1;

	@Resource(name = "filmToInsert2")
	private Film filmToInsert2;

	@Resource(name = "filmToInsert3")
	private Film filmToInsert3;

	@Resource(name = "actorFilmToInsert1")
	private ActorFilm actorFilmToInsert1;

	@Resource(name = "actorFilmPKToInsert1")
	private ActorFilmPK actorFilmPKToInsert1;

	@Resource(name = "actorFilmPKToInsert2")
	private ActorFilmPK actorFilmPKToInsert2;

	@Resource(name = "actorFilmPKToInsert3")
	private ActorFilmPK actorFilmPKToInsert3;

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudGruppo2WorkApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		categoryRepository.save(categoryToInsert1);
		categoryRepository.save(categoryToInsert2);
		categoryRepository.save(categoryToInsert3);
		categoryRepository.saveAndFlush(categoryToUpdate);
		categoryRepository.deleteById(2);
		categoryRepository.findAll().forEach(System.out::println);
		categoryRepository.FindAllByName("Comic").forEach(System.out::println);
		countryRepository.save(countryToInsert1);
		cityToInsert1.setCountry(countryToInsert1);
		cityRepository.save(cityToInsert1);

		cityToUpdate.setCountry(countryToInsert1);

		cityRepository.save(cityToUpdate);

//		// caso delete senza cascadeRemove
//
//		countryRepository.save(countryToInsert2); // inserisco Romania
//		cityRepository.deleteById(1); // non avendo il cascade remove devo rimuovere prima il figlio
//		countryRepository.deleteById(1); // rimuovo italia

		// caso delete con cascadeRemove

		countryRepository.save(countryToInsert2); // inserisco Romania
//		countryRepository.deleteById(1); // rimuovo italia

		// stampiamo tutte le città d'italia (palermo e grumo appula)
		cityToInsert2.setCountry(countryToInsert2);
		cityRepository.save(cityToInsert2);

		cityToInsert3.setCountry(countryToInsert1);
		cityRepository.save(cityToInsert3);

		cityRepository.FindCityByCountry(countryToInsert1).forEach(System.out::println);

		// insert della many to many

		// inserisco il film
		filmRepository.save(filmToInsert1);

		// inserisco l'attore
		actorRepository.save(actorToInsert1);

		// attore e film uniti
		actorFilmToInsert1.setActor(actorToInsert1);
		actorFilmToInsert1.setFilm(filmToInsert1);
		actorFilmPKToInsert1.setActorId(actorToInsert1.getActorId());
		actorFilmPKToInsert1.setFilmId(filmToInsert1.getFilmId());
		actorFilmToInsert1.setId(actorFilmPKToInsert1);

		actorFilmRepository.save(actorFilmToInsert1);

		// attore e film uniti
		// inserisco il film
		filmRepository.save(filmToInsert2);

		// inserisco gli attori
		actorRepository.save(actorToInsert2);
		actorRepository.save(actorToInsert3);

		actorFilmToInsert2.setActor(actorToInsert2);
		actorFilmToInsert1.setActor(actorToInsert3);
		actorFilmToInsert1.setFilm(filmToInsert2);

		actorFilmPKToInsert1.setActorId(actorToInsert2.getActorId());
		actorFilmPKToInsert1.setFilmId(filmToInsert2.getFilmId());
		actorFilmToInsert1.setId(actorFilmPKToInsert1);

		actorFilmRepository.save(actorFilmToInsert1);
	}

}
