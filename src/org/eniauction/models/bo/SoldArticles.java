package org.eniauction.models.bo;

import java.util.Date;
import java.util.List;

import org.eniauction.models.bll.ManagerAuction;

public class SoldArticles {

	private int article_nb;
    private String article_name;
    private String description;
    private Date auction_start_date;
    private Date auction_end_date;
    private int initial_price;
    private int sell_price;
    private int users_nb;
    private int category_nb;

    public SoldArticles(int article_nb, String article_name, String description, Date auction_start_date, Date auction_end_date, int initial_price, int sell_price, int users_nb, int category_nb) {      
    	this.article_nb = article_nb;
        this.article_name = article_name;
        this.description = description;
        this.auction_start_date = auction_start_date;
        this.auction_end_date = auction_end_date;
        this.initial_price = initial_price;
        this.users_nb = users_nb;
        this.category_nb = category_nb;
        
        ManagerAuction ma = ManagerAuction.getInstance();
        List<Auction> listAuction = ma.getAllAuctionById(article_nb);
        if(listAuction.size() > 0) {
        	this.sell_price = listAuction.get(0).getAmount();
        }else {
        	this.sell_price = this.initial_price;
        }
        
    }

    public int getArticle_nb() {
        return article_nb;
    }

    public void setArticle_nb(int article_nb) {
        this.article_nb = article_nb;
    }

    public String getArticle_name() {
        return article_name;
    }

    public void setArticle_name(String article_name) {
        this.article_name = article_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAuction_start_date() {
        return auction_start_date;
    }

    public void setAuction_start_date(Date auction_start_date) {
        this.auction_start_date = auction_start_date;
    }

    public Date getAuction_end_date() {
        return auction_end_date;
    }

    public void setAuction_end_date(Date auction_end_date) {
        this.auction_end_date = auction_end_date;
    }

    public int getInitial_price() {
        return initial_price;
    }

    public void setInitial_price(int initial_price) {
        this.initial_price = initial_price;
    }

    public int getSell_price() {
        return sell_price;
    }

    public void setSell_price(int sell_price) {
        this.sell_price = sell_price;
    }

    public int getUsers_nb() {
        return users_nb;
    }

    public void setUsers_nb(int users_nb) {
        this.users_nb = users_nb;
    }

    public int getCategory_nb() {
        return category_nb;
    }

    public void setCategory_nb(int category_nb) {
        this.category_nb = category_nb;
    }
}
