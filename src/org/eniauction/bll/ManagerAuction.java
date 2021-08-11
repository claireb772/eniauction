package org.eniauction.bll;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	 
	 public List<SoldArticles> GetAuction() {
		 List<SoldArticles> listArticles = new ArrayList<SoldArticles>();
		 Date date = new Date();
		 SoldArticles sa1e1 = new SoldArticles(1, "Chaise", "moche", date, date, 12, 54, 1, 3);
		 SoldArticles sa1e2 = new SoldArticles(2, "Souris", "glissante", date, date, 80, 90, 2, 3);
		 listArticles.add(sa1e1);
		 listArticles.add(sa1e2);
		 return listArticles;
	 }
}
