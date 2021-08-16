
package org.eniauction.models.bll;

import java.util.ArrayList;
import java.util.List;

import org.eniauction.dal.jdbc.AuctionImpl;
import org.eniauction.models.bo.Auction;
import org.eniauction.models.bo.AuctionComplete;
import org.eniauction.models.bo.Categories;
import org.eniauction.models.bo.SoldArticles;

public class ManagerAuction {

	private static ManagerAuction instance;

	public static ManagerAuction getInstance() {
		if (instance == null) {
			instance = new ManagerAuction();
		}
		return instance;
	}

	public List<AuctionComplete> GetAuction() throws Exception {
		AuctionImpl auctionImpl = AuctionImpl.getInstance();
		List<AuctionComplete> listArticles = new ArrayList<AuctionComplete>();
		for (SoldArticles item : auctionImpl.selectAll()) {
			AuctionComplete ac = new AuctionComplete(item);
			listArticles.add(ac);
		}
		return listArticles;
	}

	public List<SoldArticles> GetSoldArticles() {
		AuctionImpl auctionImpl = AuctionImpl.getInstance();
		List<SoldArticles> listArticles = auctionImpl.selectAll();
		return listArticles;
	}

	// Ajoute un soldArticle
	public void SetNewAuction(SoldArticles sa) {
		AuctionImpl ai = AuctionImpl.getInstance();
		ai.insertArticle(sa);
	}

	public List<Categories> GetCategories() {
		AuctionImpl auctionImpl = AuctionImpl.getInstance();
		List<Categories> listCategories = auctionImpl.getCategories();

		return listCategories;
	}

	public AuctionComplete getOneAuctionComplete(int id) throws Exception {
		AuctionImpl auctionImpl = AuctionImpl.getInstance();
		AuctionComplete ac = new AuctionComplete(auctionImpl.getOneArticle(id));
		return ac;
	}

	public List<Auction> getAllAuctionById(int article_nb) {
		AuctionImpl auctionImpl = AuctionImpl.getInstance();
		List<Auction> listAuction = auctionImpl.getAllAuctionById(article_nb);
		return listAuction;
	}

	// Ajoute une enchere
	public void SetAuction(Auction auction) {
		AuctionImpl ai = AuctionImpl.getInstance();
		ai.insertAuction(auction);

	}
}
