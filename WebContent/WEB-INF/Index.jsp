<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/Header.jsp" %> 
</head>
<body>
<nav class="bg-primary p-3 text-white d-flex col d-flex justify-content-between">
	<%@ include file="/WEB-INF/navBar.jsp" %> 
</nav>
<main class="p-3 col-12 row ">
	<form  method="post" class="mb-5 mt-2">
		<div class="input-group">
			<input name="search" value="${searchInput}" placeholder="Recherche" class="form-control col-3"/>
			<button name="validSearch" type="submit" class="btn btn-primary">Rechercher</button>
			<a href="./" type="button" class="btn btn-outline-transparent text-primary">Annuler</a>
		</div>
	</form>
	<c:forEach var="item" items="${listAuction}" >
		<a class="bg-light p-3 col-12 col-md-4 enchere_container text-decoration-none" href="<%= request.getContextPath() %>/AuctionDetails?id=${item.article.article_nb}">
		<p class="text-primary m-0">${item.article.article_name }</p>
		<p class="text-secondary m-0"><small>Vendu par ${item.user.surname} dans ${item.category.wording} 
		</small></p>
		<div class="position-relative image-container">
			<img src="https://fakeimg.pl/300x300/" class="w-100"/>
			<div class="position-absolute date-container text-primary bg-light">Fini dans ${item.article.auction_end_date}</br>${item.getSize() } Enchérisseurs</div>
			<div class="position-absolute points-container bg-light text-danger">${item.article.sell_price } points</div>
		</div>
	</a>
	</c:forEach>
	<div id="pagination_container" class="w-100 d-flex justify-content-center my-5">
	<c:if test="${actualPage > 0 }">
		<button type="button" class="border-0 bg-white text-primary" onclick="window.location.href='./eniauction?page=${actualPage-1}'">Precedent</button>
	</c:if>
		<c:forEach var="button" items="${listPage}">
		
			<button type="button" class="border-0 <c:if test="${ actualPage == button.getId().toString() }">bg-primary text-white</c:if><c:if test="${ actualPage != button.getId().toString() }">bg-white text-primary</c:if> " onclick="window.location.href='./eniauction?page=${button.getId()}'">${button.getName() }</button>
		</c:forEach>
	<c:if test="${actualPage < maxPage-1 }">
		<button type="button" class="border-0 bg-white text-primary" onclick="window.location.href='./eniauction?page=${actualPage+1}'">Suivant</button>
	</c:if>
	</div>
</main>
</body>
</html>