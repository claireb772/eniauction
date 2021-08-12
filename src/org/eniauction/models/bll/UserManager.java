package org.eniauction.models.bll;

import org.eniauction.dal.jdbc.UsersImpl;
import org.eniauction.models.bo.Users;

public class UserManager {
	
	private UsersImpl userImpl;
	
	public Users displayUser(int user_nb) {
					
			
		return this.userImpl.selectByid(user_nb);
		
		
	}
	
	

}
