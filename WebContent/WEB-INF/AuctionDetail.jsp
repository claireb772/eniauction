<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/WEB-INF/Header.jsp" %> 
</head>
<body>
<nav class="bg-primary p-3 text-white d-flex col d-flex justify-content-between">
	<%@ include file="/WEB-INF/navBar.jsp" %> 
</nav>
<main class="p-3 d-flex justify-content-center">


	<div class="col-12 col-md-8  d-flex bg-light p-3 flex-column flex-md-row"  >
		<div class="d-md-flex flex-row">
		  <div class="mx-2 flex-1">
		    <p class="text-primary"><c:out value="${auction.article.getArticle_name()}"/></p>
		    <img src="https://fakeimg.pl/300x150/" class="w-100"/>
		    <p class="mt-3 text-black">Description</p>
		    <p class="text-black"><c:out value="${auction.article.getDescription()}"/></p>
		    <p class="text-danger"><c:out value="${auction.article.getSell_price()}"/> pts</p>
		    <p class="text-black"><c:out value="${auction.article.getAuction_end_date()}"/></p>
		    
		    
		  </div>
		</div>
		<div class="col-12 col-md-6 px-3">
			<p class="text-black">Vendeur <a href="./profil?id=${auction.user.getUser_nb() }">${auction.user.getPseudo() }</a></p>
		    <hr>
		    <c:if test="${auction.getListAuction().toArray()[0].getUser_nb() != sessionStore.id}">
				<form method="post" class="input-group mb-3">
					<input name="article" value="${auction.article.getArticle_nb() }" class="d-none"/>
		  			<input name="input_new_amount" type="text" class="form-control" placeholder="<c:out value="${Math.round(auction.article.getSell_price() + (auction.article.getSell_price()/20))}"/>" value="<c:out value="${Math.round(auction.article.getSell_price() + (auction.article.getSell_price()/20))}"/>" aria-label="Recipient's username" aria-describedby="basic-addon2">
				  <div class="input-group-append">
				    <button class="btn btn-primary" type="submit">Enchérir</button>
				  </div>
				</form>
			</c:if>
			<c:if test="${auction.getListAuction().toArray()[0].getUser_nb() == sessionStore.id}">
				<p>Vous êtes déjà le meilleur enchérisseur</p>
			</c:if>
			
			
			<c:if test="${auction.getSize() ==  0}">
				<p class="text-secondary">Aucun encherisseur pour cette offre</p>
			</c:if>
			<c:if test="${auction.getSize()>0 && sessionStore.id == auction.user.getUser_nb()}">
			<hr>
				<p>Liste des enchérisseurs</p>
				<table class="table table-sm  table-striped">
					<tbody id="auction_scroller">
					<c:forEach var="item" items="${auction.getListAuction()}" >
					    <tr>
					    	<td>
					    		<a href="./profil?id=${item.getUserById().getUser_nb() }" class="text-black flex-1 d-flex"><span class="flex-1 d-flex">${item.getUserById().getPseudo() }</span>${item.getAmount() } pts</a>
					    	</td>
					    	
					    </tr>
				    </c:forEach>
				    <tr>
				    	<td class="d-flex justify-content-center">
				    	<a href="#" class="flex-1 text-center">Afficher plus</a>
				    	</td>
				    </tr>
				  </tbody>
				</table>
				<hr>
			</c:if>
			<c:if test="${auction.checkAvailable() }">
				<p class="text-danger">L'enchere est terminée</p>
			</c:if>


			
			
			<c:if test="${auction.checkAvailable() }">
				<p>A récupérer au : </br><c:out value="${auction.user.getStreet()}"/> <c:out value="${auction.user.getPostal_code()}"/> <c:out value="${auction.user.getCity()}"/></p>
			</c:if>
	</div>
</div>
	</main>
</body>
</html>