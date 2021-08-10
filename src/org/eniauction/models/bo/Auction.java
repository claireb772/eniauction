package org.eniauction.models.bo;

import java.time.LocalDateTime;

public class Auction {

    private int user_nb;
    private int article_nb;
    private LocalDateTime auction_date;
    private int auction_amount;

    public Auction(int user_nb, int article_nb, LocalDateTime auction_date, int auction_amount) {
        this.user_nb = user_nb;
        this.article_nb = article_nb;
        this.auction_date = auction_date;
        this.auction_amount = auction_amount;
    }

    public int getUser_nb() {
        return user_nb;
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

    public LocalDateTime getAuction_date() {
        return auction_date;
    }

    public void setAuction_date(LocalDateTime auction_date) {
        this.auction_date = auction_date;
    }

    public int getAuction_amount() {
        return auction_amount;
    }

    public void setAuction_amount(int auction_amount) {
        this.auction_amount = auction_amount;
    }
}