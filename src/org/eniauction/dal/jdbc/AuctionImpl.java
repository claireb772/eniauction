package org.eniauction.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eniauction.dal.AuctionDAO;
import org.eniauction.models.bo.Auction;
import org.eniauction.models.bo.Categories;
import org.eniauction.models.bo.SoldArticles;
import org.eniauction.models.bo.Withdrawals;

public class AuctionImpl implements AuctionDAO {
	private static AuctionImpl instance;

	public static AuctionImpl getInstance() {
		if (instance == null) {
			instance = new AuctionImpl();
		}
		return instance;
	}

	private static final String INSERT_ARTICLE = "insert into SOLD_ARTICLES(article_name, description, auction_start_date, auction_end_date, initial_price, sell_price, user_nb, category_nb, isActive) values(?,?,?,?,?,?,?,?,?)";
	private static final String GET_ONE_ARTICLE = "select * from SOLD_ARTICLES where article_nb = ?";
	private static final String GET_ALL_AUCTION_BY_ARTICLE_ID = "select * from AUCTION where article_nb = ?  ORDER BY auction_amount DESC";
	private static final String INSERT_AUCTION = "insert into AUCTION (user_nb, article_nb, auction_date, auction_amount) values(?,?,?,?) ";
	private static final String GET_ALL_AUCTION_COUNT = "select COUNT(*) from SOLD_ARTICLES WHERE isActive=1";
	private static final String INSERT_WITHDRAWALS = "insert into WITHDRAWALS (article_nb, street, postal_code, city) values(?,?,?,?)";
	private static final String SELECT_ALL = "Select * From SOLD_ARTICLES";

	private static final String SELECT_TOP_AUCTION_BY_ART_NB = "SELECT TOP 1 * FROM AUCTION WHERE article_nb=? ORDER BY auction_amount DESC";

	public Auction selectTopAuction(int id) {
		Auction topAuction = null;
		try {
			Connection cs = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cs.prepareStatement(SELECT_TOP_AUCTION_BY_ART_NB);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				topAuction = new Auction(rs.getInt("user_nb"), rs.getInt("article_nb"), new Date(),
						rs.getInt("auction_amount"));
			}
			pstmt.close();
			cs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return topAuction;
	}

	public List<SoldArticles> selectAll() {
		List<SoldArticles> listArticles = new ArrayList<SoldArticles>();
		try {
			Connection cs = ConnectionProvider.getConnection();

			PreparedStatement pstmt = cs.prepareStatement("Select * From SOLD_ARTICLES Where isActive = 1");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SoldArticles sa = new SoldArticles(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10));
				listArticles.add(sa);
			}
			pstmt.close();
			cs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticles;
	}

	public List<SoldArticles> selectMyAuction(int idUser) {
		List<SoldArticles> listArticles = new ArrayList<SoldArticles>();
		try {
			Connection cs = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cs.prepareStatement(
					"SELECT SA.article_nb, SA.article_name, SA.description, SA.auction_start_date, SA.auction_end_date, SA.initial_price, SA.sell_price, SA.user_nb, SA.category_nb, SA.isActive"
							+ " FROM AUCTION A " + " INNER JOIN SOLD_ARTICLES SA ON SA.article_nb = A.article_nb "
							+ " WHERE A.user_nb = ? ");
			pstmt.setInt(1, idUser);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SoldArticles sa = new SoldArticles(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10));
				listArticles.add(sa);
			}
			pstmt.close();
			cs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticles;
	}

	public List<SoldArticles> selectMySells(int idUser) {
		List<SoldArticles> listArticles = new ArrayList<SoldArticles>();
		try {
			Connection cs = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cs.prepareStatement(

					" SELECT SA.article_nb, SA.article_name, SA.description, SA.auction_start_date, SA.auction_end_date, SA.initial_price, SA.sell_price, SA.user_nb, SA.category_nb, SA.isActive "
							+ " FROM SOLD_ARTICLES SA " + " WHERE SA.user_nb = ?  ");

			pstmt.setInt(1, idUser);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SoldArticles sa = new SoldArticles(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10));
				listArticles.add(sa);
			}
			pstmt.close();
			cs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticles;
	}

	public List<SoldArticles> selectSearch(String searchInput, int page) {
		List<SoldArticles> listArticles = new ArrayList<SoldArticles>();
		try {
			Connection cs = ConnectionProvider.getConnection();

			PreparedStatement pstmt = cs.prepareStatement(
					"Select * From SOLD_ARTICLES where article_name like ? ORDER BY article_nb OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY ");
			pstmt.setString(1, "%" + searchInput + "%");
			int realPage = page * 9;
			pstmt.setInt(2, realPage);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				SoldArticles sa = new SoldArticles(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10));
				listArticles.add(sa);
			}
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticles;
	}

	public SoldArticles insertArticle(SoldArticles sold) {

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, sold.getArticle_name());
			pstmt.setString(2, sold.getDescription());
			pstmt.setDate(3, convertDateToSqlData(sold.getAuction_start_date()));
			pstmt.setDate(4, convertDateToSqlData(sold.getAuction_end_date()));
			pstmt.setInt(5, sold.getSell_price());
			pstmt.setInt(6, sold.getSell_price());
			pstmt.setInt(7, sold.getUsers_nb());
			pstmt.setInt(8, sold.getCategory_nb());
			pstmt.setBoolean(9, true);
			pstmt.executeUpdate();
			ResultSet keys = pstmt.getGeneratedKeys();

			while (keys.next()) {
				sold.setArticle_nb(keys.getInt(1));
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sold;
	}

	private java.sql.Date convertDateToSqlData(java.util.Date date) {
		long timeInMilliSeconds1 = date.getTime();
		java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds1);
		return date1;
	}

	public SoldArticles getOneArticle(int id) {
		Connection cs;
		SoldArticles sa = null;
		try {
			cs = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cs.prepareStatement(GET_ONE_ARTICLE);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				sa = new SoldArticles(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10)

				);
			}
			pstmt.close();
			cs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return sa;
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
			pstmt.close();
			cs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticles;
	}

	public List<Auction> getAllAuctionById(int article_nb) {
		Connection cs;
		List<Auction> listAuction = new ArrayList<Auction>();
		try {
			cs = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cs.prepareStatement(GET_ALL_AUCTION_BY_ARTICLE_ID);
			pstmt.setInt(1, article_nb);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Auction auction = new Auction(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4));
				listAuction.add(auction);
			}
			pstmt.close();
			cs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listAuction;
	}

	public void insertAuction(Auction auction) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT_AUCTION);
			if (TransfertPointToPending(auction)) {
				pstmt.setInt(1, auction.getUser_nb());
				pstmt.setInt(2, auction.getArticle_nb());
				pstmt.setDate(3, convertDateToSqlData(auction.getAuction_date()));
				pstmt.setInt(4, auction.getAmount());

				int row = pstmt.executeUpdate();
			}

			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean TransfertPointToPending(Auction auction) {
		int credit = 0;
		int pending = 0;
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT credit,pending FROM USERS WHERE user_nb = ?");
			pstmt.setInt(1, auction.getUser_nb());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				credit = rs.getInt("credit");
				pending = rs.getInt("pending");
			}
			if (credit > auction.getAmount()) {

				pstmt = conn.prepareStatement("UPDATE USERS SET credit = ?, pending = ? where user_nb = ? ");
				pstmt.setInt(1, credit - auction.getAmount());
				pstmt.setInt(2, pending + auction.getAmount());
				pstmt.setInt(3, auction.getUser_nb());
				pstmt.executeUpdate();
				pstmt.close();
				conn.close();
				return true;
			} else {

				pstmt.close();
				conn.close();
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int getAllSoldArticlesCount() {
		Connection cs;
		int count = 0;
		try {
			cs = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cs.prepareStatement(GET_ALL_AUCTION_COUNT);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
			pstmt.close();
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public void insertWithDrawals(Withdrawals wd) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT_WITHDRAWALS);
			pstmt.setInt(1, wd.getArticle_nb());
			pstmt.setString(2, wd.getStreet());
			pstmt.setString(3, wd.getPostal_code());
			pstmt.setString(4, wd.getCity());

			int row = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isWithdrawalsExist(int id) {
		Connection cs;
		int count = 0;
		try {
			cs = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cs.prepareStatement("SELECT COUNT(*) FROM WITHDRAWALS WHERE article_nb = ? ");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
			pstmt.close();
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count == 1;
	}

	public boolean isAuctionExist(Auction auction) {
		Connection cs;
		int count = 0;
		try {
			cs = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cs
					.prepareStatement("SELECT COUNT(*) FROM AUCTION WHERE article_nb = ? AND user_nb = ?");
			pstmt.setInt(1, auction.getArticle_nb());
			pstmt.setInt(2, auction.getUser_nb());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
			pstmt.close();
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count == 1;
	}

	public void updateAuction(Auction auction) {
		Connection cs;
		try {
			cs = ConnectionProvider.getConnection();

			if (TransfertPointToPending(auction)) {
				PreparedStatement pstmt = cs.prepareStatement(
						"UPDATE AUCTION set auction_amount=?, auction_date=? where user_nb = ? AND article_nb = ? ");
				pstmt.setInt(1, auction.getAmount());
				pstmt.setDate(2, convertDateToSqlData(auction.getAuction_date()));
				pstmt.setInt(3, auction.getUser_nb());
				pstmt.setInt(4, auction.getArticle_nb());

				pstmt.executeUpdate();
				pstmt.close();
				cs.close();
			} else {
				cs.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateIsActive(SoldArticles sa) {
	}

}
