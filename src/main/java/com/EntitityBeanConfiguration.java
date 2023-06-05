package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.entity.Category;

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

}
