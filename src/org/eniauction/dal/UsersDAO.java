package org.eniauction.dal;

import java.util.List;

import org.eniauction.models.bo.Users;

public interface UsersDAO {

	boolean insert(Users user);

	void delete(int user_nb) throws Exception;

	List<Users> selectAll();

	Users selectByid(int user_nb) throws Exception;

	void update(Users user) throws Exception;

}
