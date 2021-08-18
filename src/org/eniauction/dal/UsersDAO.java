package org.eniauction.dal;

import java.util.List;

import org.eniauction.dal.jdbc.DALException;
import org.eniauction.models.bo.Users;

public interface UsersDAO {

	void insert(Users user) throws DALException;

	void delete(int user_nb) throws DALException;

	List<Users> selectAll() throws DALException;;

	Users selectByid(int user_nb) throws DALException;

	void update(Users user) throws DALException;

	Users ConnectUser(String emailInput, String passwordInput) throws DALException;
}
