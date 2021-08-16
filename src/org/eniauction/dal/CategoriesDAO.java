package org.eniauction.dal;

import java.util.List;

import org.eniauction.models.bo.Categories;

public interface CategoriesDAO {

	List<Categories> selectAll();

	Categories selectOne(int id);

}
