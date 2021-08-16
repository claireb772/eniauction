package org.eniauction.dal;

import java.util.List;

import org.eniauction.models.bo.Users;

public interface UsersDAO {

	
	void insert(Users user) throws Exception;


	void delete(int user_nb) throws Exception;


	List<Users> selectAll();

	Users selectByid(int user_nb) throws Exception;

	void update(Users user) throws Exception;

}
