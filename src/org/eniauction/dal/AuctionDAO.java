package org.eniauction.dal;

import java.util.List;

import org.eniauction.models.bo.Categories;
import org.eniauction.models.bo.SoldArticles;

public interface AuctionDAO {

	List<SoldArticles> selectAll();

	void insertArticle(SoldArticles sold);

	List<Categories> getCategories();

}
