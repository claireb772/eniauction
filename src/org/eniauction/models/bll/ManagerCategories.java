package org.eniauction.models.bll;

import java.sql.SQLException;
import java.util.List;

import org.eniauction.dal.jdbc.CategoriesImpl;
import org.eniauction.models.bo.Categories;

public class ManagerCategories {
	private static ManagerCategories instance;

	public static ManagerCategories getInstance() {
		if (instance == null) {
			instance = new ManagerCategories();
		}
		return instance;
	}

	public void deleteCategoryById(int categoryId) throws SQLException {
		CategoriesImpl ci = CategoriesImpl.getInstance();
		ci.delete(categoryId);
	}

	public List<Categories> GetCategories() {
		CategoriesImpl ci = CategoriesImpl.getInstance();
		return ci.selectAll();
	}

	public Categories GetCategoryById(int id) {

		CategoriesImpl ci = CategoriesImpl.getInstance();
		return ci.selectOne(id);
	}

	public void insertCategories(Categories cat) throws Exception {
		CategoriesImpl ci = CategoriesImpl.getInstance();
		ci.insert(cat);
	}

	public int getAllCategoriesCount() {
		CategoriesImpl ci = CategoriesImpl.getInstance();
		return ci.getAllCategoriesCount();
	}

	public boolean isCategoryExist(String name) {
		CategoriesImpl ci = CategoriesImpl.getInstance();
		return ci.isCategoryExist(name);
	}
}
