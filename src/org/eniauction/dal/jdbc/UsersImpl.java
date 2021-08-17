package org.eniauction.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eniauction.dal.UsersDAO;
import org.eniauction.models.bo.Users;

public class UsersImpl implements UsersDAO {

	static Logger log = Logger.getLogger(UsersImpl.class);

	private static UsersImpl instance;

	public static UsersImpl getInstance() {

		if (instance == null) {
			instance = new UsersImpl();
		}

		return instance;
	}

	private static final String UPDATE_BY_ID = "UPDATE USERS set pseudo=?, name=?, surname=?, email=?, phone_nb=?, street=?, postal_code=?, city=?, password=? where user_nb=?";

	private static final String SELECT_BY_ID = "SELECT " + " * " + " from USERS where user_nb=?";

	private static final String SELECT_BY_EMAIL_PASSWORD = "SELECT " + " * " + " from USERS "
			+ " where email = ? and password = ? ";

	private static final String INSERT_USER = "insert into USERS(pseudo, name, surname, email, phone_nb, street, postal_code, city, password, credit, administrator) values(?,?,?,?,?,?,?,?,?,?,?)";

	private static final String DELETE_USER_BY_ID = "DELETE FROM USERS WHERE user_nb=?";

	private static final String SELECT_ALL_USERS = "select * from USERS";

	/*
	 * Fonction qui permet de récupérer un user avec son id
	 */

	public Users selectByid(int user_nb) throws DALException {

		Users users = null;

		try (Connection cnx = ConnectionProvider.getConnection())

		{

			PreparedStatement pstmt = cnx.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, user_nb);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				users = new Users(user_nb, rs.getString("pseudo"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone_nb"), rs.getString("street"),
						rs.getString("postal_code"), rs.getString("city"), rs.getString("password"),
						rs.getInt("credit"), false);

				users = new Users(user_nb, rs.getString("pseudo"), rs.getString("name"), rs.getString("surname"),
						rs.getString("email"), rs.getString("phone_nb"), rs.getString("street"),
						rs.getString("postal_code"), rs.getString("city"), rs.getString("password"),
						rs.getInt("credit"), false);

			}
			rs.close();
			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Erreur dans le SelectById ", e);
			throw new DALException("Erreur dans le SelectById ", e);
		}

		return users;
	}

	public void insert(Users user) throws DALException {

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
			// 1 } catch (SQLException e) { System.err.format("SQL State: %s\n%s",
			// e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Erreur dans l'insert ", e);
			throw new DALException("Erreur dans l'insert ", e);

		}

	}

	@Override
	public void delete(int user_nb) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(DELETE_USER_BY_ID);
			pstmt.setInt(1, user_nb);
			pstmt.executeUpdate();
			pstmt.close();
			cnx.close();

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Erreur dans le delete ", e);
			throw new DALException("Erreur dans le delete ", e);
		}

	}

	@Override
	public List<Users> selectAll() throws DALException {

		List<Users> ListUsers = new ArrayList<Users>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECT_ALL_USERS);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Users users = new Users(rs.getInt(1), rs.getString("pseudo"), rs.getString("name"),
						rs.getString("surname"), rs.getString("email"), rs.getString("phone_nb"),
						rs.getString("street"), rs.getString("postal_code"), rs.getString("city"),
						rs.getString("password"), rs.getInt("credit"), false);
				ListUsers.add(users);
			}

			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Erreur dans le select All ", e);
			throw new DALException("Erreur dans le select All ", e);
		}
		return ListUsers;

	}

	/*
	 * Fonction qui permet de faire un update de l'utilisateur
	 */

	@Override
	public void update(Users user) throws DALException {
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
			pstmt.setInt(10, user.getUser_nb());
			pstmt.executeUpdate();
			pstmt.close();
			cnx.close();

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Erreur dans l'update", e);
			throw new DALException("Erreur dans l'update ", e);
		}

	}

// Fonction permetant de rechercher dans la base de données, si un utilisateur
// existe grace à la saisie de ce dernier
// Les saisies de l'utilisateur viennent du login

	public Users ConnectUser(String emailInput, String passwordInput) throws DALException {

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
			pstmt.close();
			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Erreur dans le ConnectUser", e);
			throw new DALException("Erreur dans le connectUser ", e);
		}

		return users;
	}

}
