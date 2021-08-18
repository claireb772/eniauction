package org.eniauction.dal;

import java.sql.SQLException;
import java.util.List;

import org.eniauction.models.bo.Categories;

public interface CategoriesDAO {

	List<Categories> selectAll();

	Categories selectOne(int id);

	void delete(int categoryId) throws SQLException;

	void update(Categories cat) throws SQLException;

	void insert(Categories cat) throws Exception;

}
