package org.eniauction.dal;

import java.util.List;

import org.eniauction.models.bo.Users;

public interface UsersDAO {
	
	void insert(Users user);
	void delete(int user_nb);
	List<Users> selectAll();
	Users selectByid(int user_nb);
	
	
	
}
