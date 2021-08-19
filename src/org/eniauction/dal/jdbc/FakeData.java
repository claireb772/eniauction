package org.eniauction.dal.jdbc;


import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

import org.eniauction.models.bll.ManagerAuction;
import org.eniauction.models.bll.ManagerCategories;
import org.eniauction.models.bll.UserManager;
import org.eniauction.models.bo.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FakeData {
	
	private static FakeData instance;
	
	 public static FakeData getInstance() 
	 {
       if (instance == null) {
           instance = new FakeData();
       }
       return instance;
	 }
	 
	public String callAPI(String url) {
		String s ="";
		try {
			URLConnection connection = new URL(url).openConnection();
			InputStream is = connection.getInputStream();
			s = new String(is.readAllBytes(), StandardCharsets.UTF_8);
			
		}catch(Exception e) {
			
		}
		
		return s;
	}
	
	public SoldArticles newFakeSoldArticles(int nbUsers, int nbCategory) throws ParseException {
		String data = callAPI("https://fakestoreapi.com/products/1");
		JsonObject parser = new JsonParser().parse(data).getAsJsonObject();
		int currentYear = LocalDate.now().getYear();
		int currentMonth = LocalDate.now().getMonthValue();
		int currentDay = LocalDate.now().getDayOfMonth();
		int selectedMonth = new Random().nextInt((12 - currentMonth) + 1) + currentMonth;
		LocalDate  daysLimit = LocalDate.of(currentYear, selectedMonth, 1);
		int selectedDay = new Random().nextInt(daysLimit.lengthOfMonth());
		int price = new Random().nextInt(900);
		int user = new Random().nextInt(nbUsers)+1;
		int category = new Random().nextInt(nbCategory)+1;
		StringBuilder sb = new StringBuilder();
		sb.append(currentYear);
		
		if(selectedMonth < 10) {
			sb.append("0"+selectedMonth);
		}else {
			sb.append(selectedMonth);
		}
		
		if(selectedDay < 10) {
			sb.append("0"+selectedDay);
		}else {
			sb.append(selectedDay);
		}
		
		
		Date dateFin = new SimpleDateFormat( "yyyyMMdd" ).parse( sb.toString() );
		SoldArticles sa = new SoldArticles
						(
							0,
							parser.get("title").getAsString(),
							parser.get("description").getAsString(),
							new Date(),
							dateFin,
							price,
							price,
							user,
							category,
							true
						);
		return sa;
	}
	
	public Users newFakeUser() {
		
		String data = callAPI("https://random-data-api.com/api/users/random_user");
		JsonObject parser = new JsonParser().parse(data).getAsJsonObject();
		JsonObject addressParser = parser.get("address").getAsJsonObject();
		int randCredit = new Random().nextInt(5000);
		Users user = new Users
				(
						0,
						parser.get("username").getAsString(), 
						parser.get("last_name").getAsString(), 
						parser.get("first_name").getAsString(), 
						parser.get("email").getAsString(), 
						parser.get("phone_number").getAsString(), 
						addressParser.get("street_name").getAsString(), 
						addressParser.get("zip_code").getAsString(), 
						addressParser.get("city").getAsString(), 
						parser.get("password").getAsString(), 
						parser.get("last_name").getAsString(), 
						randCredit,
						0,
						1,
						true,
						
						false
				);
		
		return user;
	}
	
	private Auction newFakeAuction(int userCount, int soldArticleCount) throws Exception {
		ManagerAuction ma = ManagerAuction.getInstance();
		int randomArticle = new Random().nextInt(soldArticleCount)+1;
		SoldArticles sa = ma.getOneSoldArticles(randomArticle);
		Auction auction = new Auction
				(
						new Random().nextInt(userCount)+1,
						sa.getArticle_nb(),
						new Date(),
						sa.getSell_price()+new Random().nextInt(50)
				);
		return auction;
		
	}
	
	private Categories newFakeCategory() {
		String data = callAPI("https://random-data-api.com/api/lorem_ipsum/random_lorem_ipsum");
		JsonObject parser = new JsonParser().parse(data).getAsJsonObject();
		Categories category = new Categories
				(
						0,
						parser.get("word").getAsString()
				);
		return category;
	}
	
	private Withdrawals newFakeWithDrawals(int nbArticle) {
		String data = callAPI("https://random-data-api.com/api/users/random_user");
		JsonObject parser = new JsonParser().parse(data).getAsJsonObject();
		JsonObject addressParser = parser.get("address").getAsJsonObject();
		ManagerAuction ma = ManagerAuction.getInstance();
		int article = new Random().nextInt(nbArticle)+1;
		if(!ma.isWithdrawalsExist(article)) {
			Withdrawals wd = new Withdrawals
					(
							article,
							addressParser.get("street_name").getAsString(),
							addressParser.get("zip_code").getAsString(),
							addressParser.get("city").getAsString()
					);
			return wd;
		}else {
			return null;
		}
		
		
		
	}
	

	public void FakeAuction() throws Exception {
		
		UserManager um = UserManager.getInstance();
		ManagerCategories mc = ManagerCategories.getInstance();
		ManagerAuction ma = ManagerAuction.getInstance();
		
		for(int i = 0; i < 150; i++) {
			Users user = newFakeUser();
			um.newUser(user);
		}
		
		System.out.println("USERS OK");
		
		
		for(int i = 0; i<8; i++) {
			Categories category = newFakeCategory();
			
			if(!mc.isCategoryExist(category.getWording())) {
				mc.insertCategories(category);
			}
		}
		
		System.out.println("CATEGORIES OK");
		
		int userCount = um.getAllUserCount();
		int categoryCount = mc.getAllCategoriesCount();
		
		for(int i = 0; i<70;i++) {
			SoldArticles sa = newFakeSoldArticles(userCount,categoryCount);
			ma.SetNewAuction(sa);
		}
		
		System.out.println("ARTICLES OK");
		
		int soldArticleCount = ma.GetAllSoldArticlesCount();
		for(int i = 0; i<150; i++) {
			Auction auction = newFakeAuction(userCount,soldArticleCount);
			ma.SetAuction(auction);
		}
		
		System.out.println("AUCTION OK");
		
		for(int i = 0; i<60; i++) {
			Withdrawals wd = newFakeWithDrawals(soldArticleCount);
			if(wd != null) {	
				ma.setWithdrawals(wd);
			}
		}
		
		System.out.println("LOCALISATIONS OK");

		
		
	}

	

	
}
