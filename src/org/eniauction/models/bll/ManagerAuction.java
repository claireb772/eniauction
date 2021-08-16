
package org.eniauction.models.bll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eniauction.dal.jdbc.AuctionImpl;
import org.eniauction.models.bo.*;

public class ManagerAuction {
	
	private static ManagerAuction instance;
	
	 public static ManagerAuction getInstance() 
	 {
        if (instance == null) {
            instance = new ManagerAuction();
        }
        return instance;
	 }
	 
	 public List<AuctionComplete> GetAuction() {
		 AuctionImpl auctionImpl = AuctionImpl.getInstance();
		 List<AuctionComplete> listArticles = new ArrayList<AuctionComplete>();
		 for(SoldArticles item : auctionImpl.selectAll()){
			 AuctionComplete ac = new AuctionComplete(item);
			 listArticles.add(ac);
		 }
		 return listArticles;
	 }
	 
	 public List<AuctionComplete> GetSearch(String searchInput) {
		 AuctionImpl auctionImpl = AuctionImpl.getInstance();
		 List<AuctionComplete> listArticles = new ArrayList<AuctionComplete>();
		 for(SoldArticles item : auctionImpl.selectSearch(searchInput)){
			 AuctionComplete ac = new AuctionComplete(item);
			 listArticles.add(ac);
		 }
		 return listArticles;
	 }

	public void SetNewAuction(SoldArticles sa) {
		AuctionImpl ai = AuctionImpl.getInstance();
		ai.insertArticle(sa);
	}

	public List<Categories> GetCategories() {
		AuctionImpl auctionImpl = AuctionImpl.getInstance();
		 List<Categories> listCategories = auctionImpl.getCategories();
		 
		 return listCategories;
	}
}
