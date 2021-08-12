package org.eniauction.models.bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eniauction.dal.jdbc.ConnectionProvider;
import org.eniauction.models.bo.*;

public class ManagerAuction {
	
	private static ManagerAuction instance;
	
	 public static ManagerAuction getInstance() 
	 {
        if (instance == null) {
            instance = new ManagerAuction();
        }
        return instance;
	 }

	 public List<SoldArticles> GetAuction() {
		 List<SoldArticles> listArticles = new ArrayList<SoldArticles>();
		 Date date = new Date();
		 
		 
		 try {
			 Connection cs = ConnectionProvider.getConnection();
			 PreparedStatement pstmt = cs.prepareStatement("Select * From CATEGORIES");
			 ResultSet rs = pstmt.executeQuery();
			 while(rs.next())
				{
				 System.out.println(rs.getString(2));
				 //SoldArticles sa = new SoldArticles(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
				 //listArticles.add(sa);
				}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return listArticles;
	 }
}
