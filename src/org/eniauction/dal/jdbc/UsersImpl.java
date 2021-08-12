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
	
	private static final String SELECT_BY_EMAIL_PASSWORD = "SELECT "
			+ " email, password"
			+ "from USERS"
			+ "where email = ? and password = ?";
	
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

// Fonction permetant de rechercher dans la base de données, si un utilisateur existe
	public boolean ConnectUser(String userInput, String userPassword) {
		
		boolean authentification = false;
		
		Users users = new Users();
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_EMAIL_PASSWORD);
			pstmt.setString(1, userInput);
			pstmt.setString(2, userPassword);
			ResultSet rs = pstmt.executeQuery();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return authentification;
	}

}
