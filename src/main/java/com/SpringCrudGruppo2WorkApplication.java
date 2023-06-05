package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.entity.Category;
import com.repository.CategoryRepository;

import jakarta.annotation.Resource;

@SpringBootApplication
public class SpringCrudGruppo2WorkApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Resource(name = "categoryToInsert1")
	private Category categoryToInsert1;

	@Resource(name = "categoryToInsert2")
	private Category categoryToInsert2;

	@Resource(name = "categoryToInsert3")
	private Category categoryToInsert3;

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudGruppo2WorkApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		categoryRepository.save(categoryToInsert1);
		categoryRepository.save(categoryToInsert2);
		categoryRepository.save(categoryToInsert3);

	}

}
