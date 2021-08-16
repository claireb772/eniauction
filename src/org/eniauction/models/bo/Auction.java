package org.eniauction.models.bo;

import java.util.Date;

import org.eniauction.models.bll.UserManager;

public class Auction {
	private int user_nb;
	private int article_nb;
	private Date auction_date;
	private int amount;

	public Auction(int user_nb, int article_nb, Date auction_date, int amount) {
		super();
		this.user_nb = user_nb;
		this.article_nb = article_nb;
		this.auction_date = auction_date;
		this.amount = amount;
	}

	public int getUser_nb() {
		return user_nb;
	}

	public Users getUserById() throws Exception {
		UserManager um = UserManager.getInstance();
		return um.getUser(user_nb);
	}

	public void setUser_nb(int user_nb) {
		this.user_nb = user_nb;
	}

	public int getArticle_nb() {
		return article_nb;
	}

	public void setArticle_nb(int article_nb) {
		this.article_nb = article_nb;
	}

	public Date getAuction_date() {
		return auction_date;
	}

	public void setAuction_date(Date auction_date) {
		this.auction_date = auction_date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
