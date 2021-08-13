package org.eniauction.models.bo;

import java.util.Date;

import org.eniauction.models.bll.ManagerCategories;
import org.eniauction.models.bll.UserManager;

public class AuctionComplete {
	private SoldArticles article;
    private Date time_left;
    private Users user;
    private Categories category;

    public AuctionComplete(SoldArticles article) {      
    	this.article = article;
    	
    	UserManager um = new UserManager();
        this.user = um.getUser(article.getUsers_nb());
        ManagerCategories cm =  ManagerCategories.getInstance();
        this.category = cm.GetCategoryById(article.getCategory_nb());
        var o = article.getAuction_end_date().getTime() - new Date().getTime();
        
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
