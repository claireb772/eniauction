<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Encheres Project</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
	<style><%@include file="/WEB-INF/style.css"%></style>
</head>
<body>

	

<nav class="bg-primary p-3 text-white d-flex col d-flex justify-content-between">
	<a href="/" class="text-white text-decoration-none">Enchere</a>
	<div class="links justify-self-end">
		<a href="#" class="text-white text-decoration-none mx-2">Nouvelle Vente</a>
		<a href="./NewAuction" class="text-white text-decoration-none mx-2">Nouvelle Vente</a>
		<a href="#" class="text-white text-decoration-none mx-2">Admin</a>
		<a href="profil" class="text-white text-decoration-none mx-2">Profil</a>
		<a href="login" class="text-white text-decoration-none mx-2">Se Connecter</a>/
		<a href="#" class="text-white text-decoration-none mx-2">S'inscrire</a>
		<a href="#" class="text-white text-decoration-none mx-2">Profil</a>
		<a href="./login.html" class="text-white text-decoration-none mx-2">Se Connecter</a>/
		<a href="./sign" class="text-white text-decoration-none mx-2">S'inscrire</a>
	</div>
</nav>
<main class="p-3 col-12 row ">

	<div class="input-group">
		<input placeholder="Recherche" class="form-control col-3"/>
		<button type="button" class="btn btn-primary">Rechercher</button>
	</div>
	
	<c:forEach var="item" items="${listAuction}" >
		<div class="bg-light p-3 col-12 col-md-4 enchere_container">
		<p class="text-primary m-0">${item.article.article_name }</p>
		<p class="text-secondary m-0"><small>Vendu par ${item.user.surname} dans ${item.category.wording} 
		</small></p>
		<div class="position-relative image-container">
			<img src="https://place-hold.it/300x300" class="w-100"/>
			<div class="position-absolute date-container text-primary bg-light">Fini dans ${item.article.auction_end_date}</div>
			<div class="position-absolute points-container bg-light text-danger">${item.article.sell_price } points</div>
		</div>
	</div>
	</c:forEach>
	

	
	
</main>
</body>
</html>