package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.entity.Actor;
import com.entity.ActorFilm;
import com.entity.ActorFilmPK;
import com.entity.Category;
import com.entity.City;
import com.entity.Country;
import com.entity.Film;

@Configuration
public class EntitityBeanConfiguration {

	@Bean(name = "categoryToInsert1")

	public Category getCategoryToInsert1() {
		return new Category("Horror");
	}

	@Bean(name = "categoryToInsert2")

	public Category getCategoryToInsert2() {
		return new Category("Fantasy");
	}

	@Bean(name = "categoryToInsert3")

	public Category getCategoryToInsert3() {
		return new Category("Comic");
	}

	@Bean(name = "categoryToUpdate")
	public Category getCategoryToUpdate() {
		return new Category(1, "Thriller");
	}

	@Bean(name = "countryToInsert1")

	public Country getCountryToInsert1() {
		return new Country("Italia");
	}

	@Bean(name = "countryToInsert2")

	public Country getCountryToInser21() {
		return new Country("Romania");
	}

	@Bean(name = "cityToInsert1")

	public City getCityToInsert1() {
		return new City("Roma");
	}

	@Bean(name = "cityToInsert2")

	public City getCityToInsert2() {
		return new City("Bucarest");
	}

	@Bean(name = "cityToInsert3")

	public City getCityToInsert3() {
		return new City("Grumo Appula");
	}

	@Bean(name = "cityToUpdate")
	public City getCityToUpdate() {
		return new City("Palermo", 1);
	}

	@Bean(name = "countryToUpdate")
	public Country getCountryToUpdate() {
		return new Country(2, "Albania");
	}

	@Bean(name = "actorToInsert1")
	public Actor getActorToInsert1() {
		return new Actor("Mia", "Khalifa");
	}

	@Bean(name = "actorToInsert2")
	public Actor getActorToInsert2() {
		return new Actor("Tommaso", "Crociera");
	}

	@Bean(name = "actorToInsert3")
	public Actor getActorToInsert3() {
		return new Actor("Giovanni", "Profondo");
	}

	@Bean(name = "actorToInsert4")
	public Actor getActorToInsert4() {
		return new Actor("Vincenzo", "Benzina");
	}

	@Bean(name = "actorToInsert5")
	public Actor getActorToInsert5() {
		return new Actor("Morgano", "Uomolibero");
	}

	@Bean(name = "filmToInsert1")
	public Film getFilmToInsert1() {
		return new Film("il Veloce e il furioso", "persone che corrono arrabbiate per l'aumento di benzina");
	}

	@Bean(name = "filmToUpdate")
	public Film getFilmToUpdate() {
		return new Film(2, "The Walking Dead", "persone che corrono arrabbiate per l'aumento di benzina");
	}

	@Bean(name = "filmToInsert2")
	public Film getFilmToInsert2() {
		return new Film("il morto che cammina",
				"persone zombie che corrono arrabbiate perchè gli umani sono piu veloci");
	}

	@Bean(name = "filmToInsert3")
	public Film getFilmToInsert3() {
		return new Film("Forrestiero Gomma", "persone disabile che corre arrabbiata perchè genny non glie la da");
	}

	@Bean(name = "actorFilmToInsert1")
	public ActorFilm getActorFilmToInsert1() {
		return new ActorFilm();
	}

	@Bean(name = "actorFilmToInsert2")
	public ActorFilm getActorFilmToInsert2() {
		return new ActorFilm();
	}

	@Bean(name = "actorFilmPKToInsert1")
	public ActorFilmPK getActorFilmPKToInsert1() {
		return new ActorFilmPK();
	}

	@Bean(name = "actorFilmPKToInsert2")
	public ActorFilmPK actorFilmPKToInsert2() {
		return new ActorFilmPK();
	}

	@Bean(name = "actorFilmPKToInsert3")
	public ActorFilmPK actorFilmPKToInsert3() {
		return new ActorFilmPK();
	}

}
