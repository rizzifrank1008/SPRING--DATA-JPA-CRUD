package com;

import java.util.ArrayList;
import java.util.List;

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
import com.repository.CategoryRepository;
import com.repository.CityRepository;
import com.repository.CountryRepository;
import com.service.ActorFilmService;
import com.service.ActorService;
import com.service.FilmService;

import jakarta.annotation.Resource;

@SpringBootApplication
public class SpringCrudGruppo2WorkApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(SpringCrudGruppo2WorkApplication.class, args);

	}

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private FilmService filmService;
	@Autowired
	private ActorService actorService;
	@Autowired
	private ActorFilmService actorFilmService;

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
	@Resource(name = "filmToUpdate")
	private Film filmToUpdate;

	@Resource(name = "actorFilmToInsert1")
	private ActorFilm actorFilmToInsert1;

	@Resource(name = "actorFilmPKToInsert1")
	private ActorFilmPK actorFilmPKToInsert1;

	@Resource(name = "actorFilmToInsert2")
	private ActorFilm actorFilmToInsert2;

	@Resource(name = "actorFilmPKToInsert2")
	private ActorFilmPK actorFilmPKToInsert2;

	@Resource(name = "actorFilmPKToInsert3")
	private ActorFilmPK actorFilmPKToInsert3;

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
		filmService.checkSaveOrUpdateFilm(filmToInsert1);

		// inserisco l'attore
		actorService.checkSaveOrUpdateActor(actorToInsert1);

		// attore e film uniti
		actorFilmToInsert1.setActor(actorToInsert1);
		actorFilmToInsert1.setFilm(filmToInsert1);
		actorFilmPKToInsert1.setActorId(actorToInsert1.getActorId());
		actorFilmPKToInsert1.setFilmId(filmToInsert1.getFilmId());
		actorFilmToInsert1.setId(actorFilmPKToInsert1);

		actorFilmService.checkSaveOrUpdateActorFilm(actorFilmToInsert1);

		// attore e film uniti
		// inserisco il film non relazionato
		filmService.checkSaveOrUpdateFilm(filmToInsert2);
		// Istanzio una lista di Actor da aggiungere ad un Film
		List<Actor> actorList = new ArrayList<>();
		// Popolo la lista
		actorList.add(actorToInsert2);
		actorList.add(actorToInsert3);
		// Inserisco gli attori non relazionati ad un film
		actorService.checkSaveListActor(actorList);
		// Faccio un for con lo scopo di relazionare le entita
		for (Actor actor : actorList) {
			// Imposto l'attore corrente all'entita relazionale(actorFilm)
			actorFilmToInsert2.setActor(actor);

			// Imposto il film all'entita relazionale, poiché essa si aspetta un oggetto
			// film e un oggetto attore
			actorFilmToInsert2.setFilm(filmToInsert2);
			// Popolo le primary keys dell ActorFilmPK che sono relazionate all'entita
			// relazionale ActorFilm
			actorFilmPKToInsert2.setActorId(actor.getActorId());
			actorFilmPKToInsert2.setFilmId(filmToInsert2.getFilmId());
			// Imposto l'id dell'entita ActorFilmPK all'entita relazionale ActorFilm
			actorFilmToInsert2.setId(actorFilmPKToInsert2);
			// Inserisco la tebella relazionale nel DB
			actorFilmService.checkSaveOrUpdateActorFilm(actorFilmToInsert2);
		}

		// Modifico il film il morto che cammina con the walking dead id 2
		filmService.checkSaveOrUpdateFilm(filmToUpdate);
		// Cancello il film id 1 e l'entita relazionale senza cancellare l'attore
		actorFilmService.checkDeleteActorFilm(actorFilmToInsert1);
		filmService.checkDeleteFilm(filmToInsert1);
		filmService.checkFindAllFilms();
		actorService.checkFindAllActors();
		// Imposto il film id 2 all'attore id 1 che attualmente non ha film e faccio il
		// save
		actorFilmToInsert2.setActor(actorToInsert1);
		actorFilmToInsert2.setFilm(filmToInsert2);
		actorFilmPKToInsert3.setActorId(actorToInsert1.getActorId());
		actorFilmPKToInsert3.setFilmId(filmToInsert2.getFilmId());
		actorFilmToInsert2.setId(actorFilmPKToInsert3);
		actorFilmService.checkSaveOrUpdateActorFilm(actorFilmToInsert2);
		actorService.checkSaveOrUpdateActor(actorToInsert4);
		actorFilmService.CheckFindActorByFilm(filmToUpdate.getTitle());
		actorFilmService.CheckFindActorByFilmPrefix(filmToUpdate.getTitle(), "K");

	}
}
