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
	
	private static final String SELECT_BY_EMAIL_PASSWORD = "SELECT "
			+ " email, password"
			+ "from USERS"
			+ "where email = ? and password = ?";
	
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

// Fonction permetant de rechercher dans la base de données, si un utilisateur existe grace à la saisie de ce dernier
// Les saisie de l'utilisateur viennent du login
	public Users ConnectUser(String emailInput, String passwordInput) {
		
		Users users = new Users();
		users = null;
		
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_EMAIL_PASSWORD);
			pstmt.setString(1,emailInput);
			pstmt.setString(2, passwordInput);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				users = new Users(rs.getInt("user_nb"), rs.getString("pseudo"), rs.getString("name"), rs.getString("surname"), rs.getString("email"), rs.getString("phone_nb"), rs.getString("street"), rs.getString("postal_code"), rs.getString("city"), rs.getString("password"), rs.getInt("credit"), rs.getBoolean("administrator"));
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return users;
	}

}
