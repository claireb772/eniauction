package org.eniauction.models.bll;

import java.util.List;

import org.eniauction.dal.jdbc.UsersImpl;
import org.eniauction.models.bo.Users;

public class UserManager {

	private static UserManager instance;
	private Users actualUser = null;

	public static UserManager getInstance() {

		if (instance == null) {
			instance = new UserManager();
		}
		return instance;
	}

	public Users getActualUser() {
		return actualUser;
	}

	public void setActualUser(Users actualUser) {
		this.actualUser = actualUser;
	}

	public Users getUser(int user_nb) throws Exception {
		UsersImpl ui = UsersImpl.getInstance();
		return ui.selectByid(user_nb);
	}

	public void editProfile(Users users) throws Exception {
		UsersImpl ui = UsersImpl.getInstance();
		ui.update(users);

	}

	public void deleteProfile(int user_nb) throws Exception {
		UsersImpl ui = UsersImpl.getInstance();
		ui.delete(user_nb);
	}

	public boolean ConnectUser(String email, String password) {
		UsersImpl ui = UsersImpl.getInstance();
		Users user = ui.ConnectUser(email, password);

		if (user != null) {
			actualUser = user;
			return true;
		}

		return false;
	}

	public Users newUser(Users user) {
		UsersImpl ui = UsersImpl.getInstance();

		if (ui.insert(user)) {

			System.out.println("r�ussi");

		} else {
			System.out.println("rat�");
		}
		return user;
	}

	public List<Users> getAllUsers() {
		UsersImpl ui = UsersImpl.getInstance();
		return ui.selectAll();
	}

}
