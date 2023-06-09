package com.service;

import com.entity.Category;

public interface CategoryService {

	public void checkSaveOrUpdateCategory(Category category);

	public void checkSaveandFlushOrUpdateCategory(Category category);

	public void checkDeleteCategoryById(Integer id);

	public void checkFindAllCategory();

	public void checkFindAllCategoryByName(String name);
}
