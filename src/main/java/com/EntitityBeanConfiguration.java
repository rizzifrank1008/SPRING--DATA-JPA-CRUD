package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.entity.Category;
import com.entity.City;
import com.entity.Country;

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

	@Bean(name = "cityToInsert1")

	public City getCityToInsert1() {
		return new City("Roma");
	}

	@Bean(name = "cityToUpdate")
	public City getCityToUpdate() {
		return new City("Palermo", 1);
	}
}
