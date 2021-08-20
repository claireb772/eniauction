package org.eniauction.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eniauction.dal.CategoriesDAO;
import org.eniauction.models.bo.Categories;

public class CategoriesImpl implements CategoriesDAO {
	private static CategoriesImpl instance;
	private static final String DELETE_CATEGORY_BY_ID = "DELETE FROM CATEGORIES WHERE category_nb=?";
	private static final String UPDATE_BY_ID = "UPDATE CATEGORIES set wording=? where category_nb=?";

	public static CategoriesImpl getInstance() {
		if (instance == null) {
			instance = new CategoriesImpl();
		}
		return instance;

	}

	public List<Categories> selectAll() {
		List<Categories> listCategories = new ArrayList<Categories>();
		try {
			Connection cs = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cs.prepareStatement("Select * From CATEGORIES");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Categories category = new Categories(rs.getInt(1), rs.getString(2));
				listCategories.add(category);
			}
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCategories;
	}

	public Categories selectOne(int id) {

		Categories category = null;
		try {
			Connection cs = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cs.prepareStatement("Select * From CATEGORIES where category_nb = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				category = new Categories(rs.getInt(1), rs.getString(2));
			}
			cs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}

	public int getAllCategoriesCount() {
		int count = 0;
		try {
			Connection cs = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cs.prepareStatement("Select COUNT(*) From CATEGORIES");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public boolean isCategoryExist(String name) {
		int count = 0;
		try {
			Connection cs = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cs.prepareStatement("Select COUNT(*) From CATEGORIES where wording = ?");
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count == 1;
	}

	@Override
	public void insert(Categories cat) throws Exception {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("insert into CATEGORIES(wording) values(?)")) {
			pstmt.setString(1, cat.getWording());

			int row = pstmt.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;

		}
	}

	@Override
	public void delete(int category_id) throws SQLException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_CATEGORY_BY_ID);
			pstmt.setInt(1, category_id);
			pstmt.executeUpdate();
			pstmt.close();
			cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void update(Categories cat) throws SQLException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_BY_ID);
			pstmt.setString(1, cat.getWording());
			pstmt.setInt(2, cat.getCategory());
			pstmt.executeUpdate();
			pstmt.close();
			cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
