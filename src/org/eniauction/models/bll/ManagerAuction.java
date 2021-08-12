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
}
