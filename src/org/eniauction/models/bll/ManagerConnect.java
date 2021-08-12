package org.eniauction.models.bll;

import java.util.ArrayList;
import java.util.List;

import org.eniauction.models.bo.Users;

/**
 * @author ldautricourt2020
 *
 */
public class ManagerConnect {
	
	private static ManagerConnect instance;
	
	public static ManagerConnect getInstance(){
		
      if (instance == null) {
          instance = new ManagerConnect();
      }
      return instance;
	}
	 
	 public List<Users> GetUsers() {
		 List<Users> listUsers = new ArrayList<Users>();
			Users user = new Users(1, "test", "test", "test", "test", "test", "test", "test", "test", "123", 0, false);
		 listUsers.add(user);
		 return listUsers;
	 }


}
