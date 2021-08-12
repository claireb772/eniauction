package org.eniauction.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eniauction.models.bll.ManagerAuction;
import org.eniauction.models.bo.SoldArticles;

public class AuctionImpl {
	private static AuctionImpl instance;
	
	 public static AuctionImpl getInstance() 
	 {
       if (instance == null) {
           instance = new AuctionImpl();
       }
       return instance;
	 }
	 
	
	public List<SoldArticles> selectAll(){
		List<SoldArticles> listArticles = new ArrayList<SoldArticles>();
		try {
			 Connection cs = ConnectionProvider.getConnection();
			 PreparedStatement pstmt = cs.prepareStatement("Select * From SOLD_ARTICLES");
			 ResultSet rs = pstmt.executeQuery();
			 while(rs.next())
				{
				 //System.out.println(rs.getString(2));
				 SoldArticles sa = new SoldArticles(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
				 listArticles.add(sa);
				}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listArticles;
	}
}
