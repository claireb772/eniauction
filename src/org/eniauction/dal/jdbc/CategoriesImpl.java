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
				// System.out.println(rs.getString(2));
				Categories category = new Categories(rs.getInt(1), rs.getString(2));
				listCategories.add(category);
			}
			cs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
				// System.out.println(rs.getString(2));
				count = rs.getInt(1);
			}
			cs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				// System.out.println(rs.getString(2));
				count = rs.getInt(1);
			}
			cs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count == 1;
	}

	public void insert(Categories cat) throws Exception {
		try (Connection conn = ConnectionProvider.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into CATEGORIES(wording) values(?)")) {
			pstmt.setString(1, cat.getWording());

		int row = pstmt.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace(); 
			throw e;
		
		}
	}
}
