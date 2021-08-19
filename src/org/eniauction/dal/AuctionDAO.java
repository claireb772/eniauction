package org.eniauction.dal;

import java.sql.SQLException;
import java.util.List;

import org.eniauction.models.bo.Auction;
import org.eniauction.models.bo.Categories;
import org.eniauction.models.bo.SoldArticles;

public interface AuctionDAO {

	List<SoldArticles> selectAll() throws SQLException;

	SoldArticles insertArticle(SoldArticles sold);

	List<Categories> getCategories();

	Auction selectTopAuction(int id);

}
