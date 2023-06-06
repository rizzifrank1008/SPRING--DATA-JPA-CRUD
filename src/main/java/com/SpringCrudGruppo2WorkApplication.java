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
	@Resource(name = "cityToUpdate")
	private City cityToUpdate;

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudGruppo2WorkApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		categoryRepository.save(categoryToInsert1);
		categoryRepository.save(categoryToInsert2);
		categoryRepository.save(categoryToInsert3);
		categoryRepository.save(categoryToUpdate);
		categoryRepository.deleteById(2);
		categoryRepository.findAll().forEach(System.out::println);
		categoryRepository.FindAllByName("Comic").forEach(System.out::println);
		countryRepository.save(countryToInsert1);
		cityToInsert1.setCountry(countryToInsert1);
		cityRepository.save(cityToInsert1);
		cityToUpdate.setCountry(countryToInsert1);
		cityRepository.save(cityToUpdate);

	}

}
