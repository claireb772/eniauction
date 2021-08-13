package org.eniauction.models.bll;

import org.eniauction.dal.jdbc.UsersImpl;
import org.eniauction.models.bo.Users;

public class UserManager {
	private UsersImpl userDAOimpl; 
	
	private static UserManager instance;
	private Users actualUser = null;
	
	
	
	public Users getActualUser() {
		return actualUser;
	}


	public void setActualUser(Users actualUser) {
		this.actualUser = actualUser;
	}


	public static UserManager getInstance() {
		
		 if (instance == null) {
			 instance = new UserManager();
		 }
		 return instance;
		
	}

	
	public Users getUser(int user_nb) {	
		UsersImpl ui = UsersImpl.getInstance();
		
		return ui.selectByid(user_nb);	
	}

	public boolean ConnectUser(String email, String password) {
		
		UsersImpl ui = UsersImpl.getInstance();
		Users user = ui.ConnectUser(email, password);
		
		if(user != null){
			actualUser = user;
			return true;
		}
		
		return false;
	}

}
