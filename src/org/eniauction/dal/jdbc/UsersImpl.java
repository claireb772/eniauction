package org.eniauction.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.eniauction.dal.UsersDAO;
import org.eniauction.models.bll.UserManager;
import org.eniauction.models.bo.Users;

public class UsersImpl implements UsersDAO {
	
	private static UsersImpl instance;
	
	public static UsersImpl getInstance() {
		
		 if (instance == null) {
			 instance = new UsersImpl();
		 }
		 return instance;	
	}
	
	private static final String SELECT_BY_ID = "SELECT "
			+ "pseudo, name, surname, email, phone_nb, street, postal_code, city, password, credit, administrator "
			+ "from USERS "
			+ "where user_nb=?";
	
<<<<<<< HEAD
	private static final String SELECT_BY_EMAIL_PASSWORD = "SELECT "
			+ " email, password"
			+ "from USERS"
			+ "where email = ? and password = ?";
	
// PAS FINI
=======
>>>>>>> d87440f547da26d73b9320ecd6abeeaff50545ba
	public Users selectByid(int user_nb){
		
		Users users = null;
		
		try(Connection cnx = ConnectionProvider.getConnection())
		
		{
			
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, user_nb);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				users = new Users(user_nb, rs.getString("pseudo"), rs.getString("name"), rs.getString("surname"), rs.getString("email"), rs.getString("phone_nb"), rs.getString("street"), rs.getString("postal_code"), rs.getString("city"), rs.getString("password"), rs.getInt("credit"), false);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public void insert(Users user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int user_nb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Users> selectAll() {
		// TODO Auto-generated method stub
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
