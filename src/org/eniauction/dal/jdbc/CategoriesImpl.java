package org.eniauction.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eniauction.models.bo.Categories;
import org.eniauction.models.bo.SoldArticles;

public class CategoriesImpl {
	private static CategoriesImpl instance;
	
	 public static CategoriesImpl getInstance() 
	 {
      if (instance == null) {
          instance = new CategoriesImpl();
      }
      return instance;
	 }
	 
	
	public List<Categories> selectAll(){
		List<Categories> listCategories = new ArrayList<Categories>();
		try {
			 Connection cs = ConnectionProvider.getConnection();
			 PreparedStatement pstmt = cs.prepareStatement("Select * From CATEGORIES");
			 ResultSet rs = pstmt.executeQuery();
			 while(rs.next())
				{
				 //System.out.println(rs.getString(2));
				 Categories category = new Categories(rs.getInt(1), rs.getString(2));
				 listCategories.add(category);
				}
			 
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
			 
			 while(rs.next())
				{
				 category = new Categories(rs.getInt(1), rs.getString(2));
				}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return category;
	}
}
