package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Category;
import com.entity.City;
import com.entity.Country;
import com.repository.CategoryRepository;
import com.repository.CityRepository;
import com.repository.CountryRepository;

import jakarta.annotation.Resource;

@SpringBootApplication
public class SpringCrudGruppo2WorkApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private CityRepository cityRepository;

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

		// nel caso si voglia fare un update che prima deve leggere le modifiche salvate
		// in un secondo momento (country id) va usato il saveAndFlush
		cityRepository.saveAndFlush(cityToUpdate);

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
		cityRepository.saveAndFlush(cityToInsert2);

		cityToInsert3.setCountry(countryToInsert1);
		cityRepository.saveAndFlush(cityToInsert3);

		cityRepository.FindCityByCountry(countryToInsert1).forEach(System.out::println);
	}

}
