package org.eniauction.models.bll;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.eniauction.dal.jdbc.DALException;
import org.eniauction.models.bo.Auction;
import org.eniauction.models.bo.SoldArticles;

public class ScheduleTask {

	public Date getMidnight() {

		Long time = new Date().getTime();
		Date midnight = new Date(time - time % (24 * 60 * 60 * 1000));

		return midnight;
	}

	public void scheduleDailyTask() {
		TimerTask closeAuction = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub de comparaison des dates de début et fin des
				// enchères

			}

		};

		Timer timer = new Timer();
		timer.schedule(closeAuction, getMidnight());

	}

	public boolean isWin() throws DALException, Exception {
		ManagerAuction ma = ManagerAuction.getInstance();

		List<SoldArticles> listArticle = ma.getAllSoldArticles();

		Date date;

		for (SoldArticles soldArticles : listArticle) {

			date = soldArticles.getAuction_end_date();

			if (date == getMidnight()) {
				Auction auction = ma.selectTopDonator(soldArticles.getUsers_nb());
				UserManager um = UserManager.getInstance();

				ma.transferCoins(um.getUser(auction.getUser_nb()), auction.getAmount(), soldArticles.getArticle_nb());

				//

			}
		}

		return false;
	}

}
