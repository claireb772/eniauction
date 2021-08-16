package org.eniauction.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.eniauction.dal.UsersDAO;
import org.eniauction.models.bo.Users;

public class UsersImpl implements UsersDAO {

	private static UsersImpl instance;

	public static UsersImpl getInstance() {

		if (instance == null) {
			instance = new UsersImpl();
		}

		return instance;
	}

	private static final String UPDATE_BY_ID = "UPDATE users set pseudo=?, name=?, surname=?, email=?, phone_nb=?, street=?, postal_code=?, city=?, password=? where user_nb=?";

	private static final String SELECT_BY_ID = "SELECT "
			+ "pseudo, name, surname, email, phone_nb, street, postal_code, city, password, credit, administrator "
			+ "from USERS " + "where user_nb=?";

	private static final String SELECT_BY_EMAIL_PASSWORD = "SELECT " + " * " + " from USERS "
			+ " where email = ? and password = ? ";

	private static final String INSERT_USER = "insert into USERS(pseudo, name, surname, email, phone_nb, street, postal_code, city, password, credit, administrator) values(?,?,?,?,?,?,?,?,?,?,?)";

	public Users selectByid(int user_nb){

		Users users = null;

		try(Connection cnx = ConnectionProvider.getConnection())


		{

			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, user_nb);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {


				users = new Users(user_nb, rs.getString("pseudo"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone_nb"), rs.getString("street"),
						rs.getString("postal_code"), rs.getString("city"), rs.getString("password"),
						rs.getInt("credit"), false);

				users = new Users(user_nb, rs.getString("pseudo"), rs.getString("name"), rs.getString("surname"), rs.getString("email"), rs.getString("phone_nb"), rs.getString("street"), rs.getString("postal_code"), rs.getString("city"), rs.getString("password"), rs.getInt("credit"), false);

			}
			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


		return users;
	}


	public void insert(Users user) throws Exception {



		try (Connection conn = ConnectionProvider.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(INSERT_USER)) {
			pstmt.setString(1, user.getPseudo());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getSurname());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPhone_nb());
			pstmt.setString(6, user.getStreet());
			pstmt.setString(7, user.getPostal_code());
			pstmt.setString(8, user.getCity());
			pstmt.setString(9, user.getPassword());
			pstmt.setInt(10, user.getCredit());
			pstmt.setBoolean(11, false);

			int row = pstmt.executeUpdate();
			// rows affected System.out.println(row); 
			//1 } catch (SQLException e) { System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) { e.printStackTrace(); throw e;
		
		}



		
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

	@Override
	public void update(Users user) {
		try (Connection cnx = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_BY_ID);
			pstmt.setString(1, user.getPseudo());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getSurname());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPhone_nb());
			pstmt.setString(6, user.getStreet());
			pstmt.setString(7, user.getPostal_code());
			pstmt.setString(8, user.getCity());
			pstmt.setString(9, user.getPassword());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Fonction permetant de rechercher dans la base de données, si un utilisateur existe grace à la saisie de ce dernier
	// Les saisie de l'utilisateur viennent du login
	public Users ConnectUser(String emailInput, String passwordInput) {

		Users users = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_EMAIL_PASSWORD);
			pstmt.setString(1, emailInput);
			pstmt.setString(2, passwordInput);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				users = new Users(rs.getInt(1), rs.getString("pseudo"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone_nb"), rs.getString("street"),
						rs.getString("postal_code"), rs.getString("city"), rs.getString("password"),
						rs.getInt("credit"), false);

			}

			cnx.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return users;
	}

}
