<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
	<style><%@include file="/WEB-INF/style.css"%></style>
<title>Insert title here</title>
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
		    <p class="mt-3">Description</p>
		    <p><c:out value="${auction.article.getDescription()}"/></p>
		    <p class="text-danger"><c:out value="${auction.article.getSell_price()}"/> pts</p>
		    <p><c:out value="${auction.article.getAuction_end_date()}"/></p>
		    
		    
		  </div>
		</div>
		<div class="col-12 col-md-6 px-3">
			<p>Vendeur <a href="./profil?id=${auction.user.getUser_nb() }">${auction.user.getPseudo() }</a></p>
		    <hr>
			<div class="input-group mb-3">
	  			<input type="text" class="form-control" placeholder="<c:out value="${Math.round(auction.article.getSell_price() + (auction.article.getSell_price()/20))}"/>" value="<c:out value="${Math.round(auction.article.getSell_price() + (auction.article.getSell_price()/20))}"/>" aria-label="Recipient's username" aria-describedby="basic-addon2">
			  <div class="input-group-append">
			    <button class="btn btn-primary" type="button">Enchérir</button>
			  </div>
			</div>
			<p>Liste des enchérisseurs</p>
			<hr>
			<c:if test="${auction.getSize() ==  0}">
				<p class="text-secondary">Aucun encherisseur pour cette offre</p>
			</c:if>
			<c:if test="${auction.getSize() >  0}">
				<table class="table table-sm">
					<tbody>
					<c:forEach var="item" items="${auction.getListAuction()}" >
				    <tr>
				    	<td>
				    		<a href="./profil?id=${item.getUserById().getUser_nb() }" class="text-decoration-none text-black flex-1 d-flex"><span class="flex-1 d-flex">${item.getUserById().getPseudo() }</span>${item.getAmount() } pts</a>
				    	</td>
				    	
				    </tr>
				    </c:forEach>
				  </tbody>
				</table>
			</c:if>
			<c:if test="${auction.checkAvailable() }">
				<p class="text-danger">L'enchere est terminée</p>
			</c:if>


			
			<hr>
			<c:if test="${auction.checkAvailable() }">
				<p>A récupérer au : </br><c:out value="${auction.user.getStreet()}"/> <c:out value="${auction.user.getPostal_code()}"/> <c:out value="${auction.user.getCity()}"/></p>
			</c:if>
	</div>
</div>
	</main>
</body>
</html>