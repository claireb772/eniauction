package org.eniauction.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eniauction.dal.AuctionDAO;
import org.eniauction.models.bo.Categories;
import org.eniauction.models.bo.SoldArticles;

public class AuctionImpl implements AuctionDAO {
	private static AuctionImpl instance;

	public static AuctionImpl getInstance() {
		if (instance == null) {
			instance = new AuctionImpl();
		}
		return instance;
	}

	private static final String INSERT_USER = "insert into SOLD_ARTICLES(article_name, description, auction_start_date, auction_end_date, initial_price, sell_price, user_nb, category_nb) values(?,?,?,?,?,?,?,?)";

	public List<SoldArticles> selectAll() {
		List<SoldArticles> listArticles = new ArrayList<SoldArticles>();
		try {
			Connection cs = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cs.prepareStatement("Select * From SOLD_ARTICLES");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SoldArticles sa = new SoldArticles(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
				listArticles.add(sa);
			}
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticles;
	}

	public void insertArticle(SoldArticles sold) {

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT_USER);
			pstmt.setString(1, sold.getArticle_name());
			pstmt.setString(2, sold.getDescription());
			pstmt.setDate(3, convertDateToSqlData(sold.getAuction_start_date()));
			pstmt.setDate(4, convertDateToSqlData(sold.getAuction_end_date()));
			pstmt.setInt(5, sold.getSell_price());
			pstmt.setInt(6, sold.getSell_price());
			pstmt.setInt(7, sold.getUsers_nb());
			pstmt.setInt(8, sold.getCategory_nb());

			int row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private java.sql.Date convertDateToSqlData(java.util.Date date) {
		long timeInMilliSeconds1 = date.getTime();
		java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds1);
		return date1;
	}

	public List<Categories> getCategories() {

		List<Categories> listArticles = new ArrayList<Categories>();
		try {
			Connection cs = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cs.prepareStatement("Select * From CATEGORIES");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Categories sa = new Categories(rs.getInt(1), rs.getString(2));
				listArticles.add(sa);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticles;
	}
}
