package org.eniauction.dal.jdbc;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.eniauction.models.bll.ManagerAuction;
import org.eniauction.models.bll.ManagerCategories;
import org.eniauction.models.bll.UserManager;
import org.eniauction.models.bo.Auction;
import org.eniauction.models.bo.Categories;
import org.eniauction.models.bo.SoldArticles;
import org.eniauction.models.bo.Users;

public class FakeData {

	private static FakeData instance;

	public static FakeData getInstance() {
		if (instance == null) {
			instance = new FakeData();
		}
		return instance;
	}

	public void FakeAuction(int iteration) throws DALException {

		UserManager um = UserManager.getInstance();
		List<Users> listUsers = um.getAllUsers();
		ManagerAuction ma = ManagerAuction.getInstance();
		List<SoldArticles> listSoldArticles = ma.GetSoldArticles();

		ManagerCategories mc = ManagerCategories.getInstance();
		List<Categories> listCategories = mc.GetCategories();

		for (int i = 0; i < iteration; i++) {

			int randUser = new Random().nextInt(listUsers.size());

			int randArticle = new Random().nextInt(listSoldArticles.size());
			int randPrice = new Random()
					.nextInt(listSoldArticles.get(randArticle).getSell_price() + new Random().nextInt(50));

			Auction auction = new Auction(listUsers.get(randUser).getUser_nb(),
					listSoldArticles.get(randArticle).getArticle_nb(), new Date(), randPrice);
			ma.SetAuction(auction);
		}

	}
}
