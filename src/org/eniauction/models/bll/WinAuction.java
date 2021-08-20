package org.eniauction.models.bll;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.eniauction.dal.jdbc.DALException;
import org.eniauction.models.bo.Auction;
import org.eniauction.models.bo.SoldArticles;

public class WinAuction {
	public static Date getMidnight() {

		Calendar calendar = Calendar.getInstance();
		Date time = calendar.getTime();

		return time;
	}

	public void winAuction() throws DALException, Exception {
		ManagerAuction ma = ManagerAuction.getInstance();

		List<SoldArticles> listArticle = ma.getAllSoldArticles();

		Date date;

		for (SoldArticles soldArticles : listArticle) {

			date = soldArticles.getAuction_end_date();

			if (date == getMidnight() || date.before(getMidnight())) {
				Auction auction = ma.selectTopDonator(soldArticles.getUsers_nb());
				UserManager um = UserManager.getInstance();

				ma.transferCoins(um.getUser(auction.getUser_nb()), auction.getAmount(), soldArticles.getArticle_nb());

				soldArticles.setActive(false);

				ma.changeActive(soldArticles);

			}
		}

	}
}
