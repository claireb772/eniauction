package org.eniauction.models.bll;

import org.eniauction.models.bo.Users;

public class UserManager {
	
	public Users displayUser() {
		
		Users userProfile = new Users(
				2,
				"toto",
				"Roger",
				"Martin",
				"roger.martin@gmail.com",
				"0152021564",
				"10 rue Franklin",
				"44000",
				"Nantes",
				"pouet",
				0,
				false);
			
		return userProfile;
		
		
	}
	
	

}
