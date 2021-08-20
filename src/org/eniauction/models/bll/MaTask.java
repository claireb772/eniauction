package org.eniauction.models.bll;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.eniauction.dal.jdbc.DALException;
import org.eniauction.models.bo.Auction;
import org.eniauction.models.bo.SoldArticles;

public class MaTask extends TimerTask {

	@Override
	public void run() {
		try {
			System.out.println("ça se lance");
			winAuction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Date getMidnight() {

		Calendar calendar = Calendar.getInstance();
		Date time = calendar.getTime();

		return time;
	}

	public void winAuction() throws DALException, Exception {
		ManagerAuction ma = ManagerAuction.getInstance();

		List<SoldArticles> listArticle = ma.getAllSoldArticles();

		for (SoldArticles soldArticles : listArticle) {

			Date date = soldArticles.getAuction_end_date();

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
