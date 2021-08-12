package org.eniauction.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.eniauction.models.bo.Users;

public class UsersImpl {
	
	private static final String SELECT_BY_ID = "SELECT "
			+ "pseudo, name, surname, email, phone_nb, street, postal_code, city "
			+ "from USERS"
			+ "where user_nb = ?";
	
// PAS FINI
	public Users selectByid(int user_nb){
		
		Users users = new Users();
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, user_nb);
			ResultSet rs = pstmt.executeQuery();
			boolean premiereLigne = true;

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

}
