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

	private static final String INSERT_USER = "insert into USERS(pseudo, name, surname, email, phone_nb, street, postal_code, city, password, credit, administrator) values(?,?,?,?,?,?,?,?,?,?,?)";

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
	public boolean insert(Users user) {


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
		} catch (Exception e) { e.printStackTrace(); 
		return false;
		}



	return true;
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

}
