package org.eniauction.models.bll;

import org.eniauction.dal.jdbc.UsersImpl;
import org.eniauction.models.bo.Users;

public class UserManager {

	private static UserManager instance;

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

	public void editProfile(Users users) {
		UsersImpl ui = UsersImpl.getInstance();
		ui.update(users);
	}

}
