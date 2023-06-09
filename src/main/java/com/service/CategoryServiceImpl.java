package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Category;
import com.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void checkSaveOrUpdateCategory(Category category) {
		try {
			categoryRepository.save(category);
			log.info("Inserimento riuscito");

		} catch (Exception e) {
			log.info("Inserimento fallito");
			e.printStackTrace();
		}
	}

	@Override
	public void checkSaveandFlushOrUpdateCategory(Category category) {
		try {
			categoryRepository.saveAndFlush(category);
			log.info("Inserimento riuscito");

		} catch (Exception e) {
			log.info("Inserimento fallito");
			e.printStackTrace();
		}
	}

	@Override
	public void checkDeleteCategoryById(Integer id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public void checkFindAllCategory() {
		try {
			categoryRepository.findAll().forEach(System.out::println);
			log.info("Lettura riuscita");
		} catch (Exception e) {
			log.info("Lettura fallita");
			e.printStackTrace();
		}

	}

	@Override
	public void checkFindAllCategoryByName(String name) {

		List<Category> categories = categoryRepository.FindAllByName(name);
		if (categories != null && !categories.isEmpty()) {
			log.info("lettura eseguita");
			categories.forEach(System.out::println);
		} else {
			log.info("lettura fallita");
		}

	}

}
