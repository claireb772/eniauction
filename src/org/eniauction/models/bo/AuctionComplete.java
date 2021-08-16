package org.eniauction.models.bo;

import java.util.Date;
import java.util.List;

import org.eniauction.models.bll.ManagerAuction;
import org.eniauction.models.bll.ManagerCategories;
import org.eniauction.models.bll.UserManager;

public class AuctionComplete {
	private SoldArticles article;
    private Date time_left;
    private Users user;
    private Categories category;
    private List<Auction> listAuction;
    private boolean isAvailable;


	public AuctionComplete(SoldArticles article) {      
    	this.article = article;
    	UserManager um = new UserManager();
        this.user = um.getUser(article.getUsers_nb());
        ManagerCategories cm =  ManagerCategories.getInstance();
        this.category = cm.GetCategoryById(article.getCategory_nb());
        ManagerAuction ma = ManagerAuction.getInstance();
        this.listAuction = ma.getAllAuctionById(article.getArticle_nb());
        var o = article.getAuction_end_date().getTime() - new Date().getTime();
        
    }
	
	public boolean checkAvailable() {
		return false;
	}
	
	public static long daysDiff(Date from, Date to) {
	    return daysDiff(from.getTime(), to.getTime());
	}
	public static long daysDiff(long from, long to) {
	    return Math.round( (to - from) / 86400000D ); //1000 * 60 * 60 * 24
	}
	
	public List<Auction> getListAuction() {
		return listAuction;
	}
	public int getSize() {
		return listAuction.size();
	}

	public void setListAuction(List<Auction> listAcution) {
		this.listAuction = listAuction;
	}
	
	public void addToListAuction(Auction auction) {
		this.listAuction.add(auction);
	}
	

    public SoldArticles getArticle() {
		return article;
	}

	public void setArticle(SoldArticles article) {
		this.article = article;
	}

	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Categories getCategory() {
		return category;
	}
	public void setCategory(Categories category) {
		this.category = category;
	}
	

    public Users getUsers_nb() {
        return user;
    }

    public void setUsers_nb(Users users_nb) {
        this.user = users_nb;
    }

    public Categories getCategory_nb() {
        return category;
    }

    public void setCategory_nb(Categories category_nb) {
        this.category = category_nb;
    }
}
