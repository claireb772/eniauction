package org.eniauction.models.bll;

import java.util.ArrayList;
import java.util.List;

import org.eniauction.dal.jdbc.AuctionImpl;
import org.eniauction.dal.jdbc.CategoriesImpl;
import org.eniauction.models.bo.*;

public class ManagerCategories {
	private static ManagerCategories instance;
	
	 public static ManagerCategories getInstance() 
	 {
       if (instance == null) {
           instance = new ManagerCategories();
       }
       return instance;
	 }

	 public List<Categories> GetCategories() {
		 //AuctionImpl auctionImpl = AuctionImpl.getInstance();
		 List<Categories> listCategories = new ArrayList<Categories>();
		 
		 return listCategories;
	 }
	 
	 public Categories GetCategoryById(int id) {
		 
		 CategoriesImpl ci = CategoriesImpl.getInstance();
		 return ci.selectOne(id);
	 }
}
