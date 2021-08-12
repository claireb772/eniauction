<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<title>Encheres Project</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<nav class="bg-primary p-3 text-white d-flex col d-flex justify-content-between">
	<a href="./index.html" class="text-white text-decoration-none">Enchere</a>
	<div class="links justify-self-end">
		<a href="new_Auction.html" class="text-white text-decoration-none mx-2">Nouvelle Vente</a>
		<a href="#" class="text-white text-decoration-none mx-2">Admin</a>
		<a href="#" class="text-white text-decoration-none mx-2">Profil</a>
		<a href="./login.html" class="text-white text-decoration-none mx-2">Se Connecter</a>/
		<a href="./sign.html" class="text-white text-decoration-none mx-2">S'inscrire</a>
	</div>
</nav>

<main class="p-3 d-flex justify-content-center">

<div class="col-8 d-flex flex-column">
	<p class="text-primary">Votre profil</p>
	<div class="row mt-2">
		<div class="col-6">Pseudo :</div>
		<div class="col-6">${userProfile.pseudo}</div>
	</div>
	<div class="row mt-2">
		<div class="col-6">Nom : </div>
		<div class="col-6">${userProfile.name}</div>
	</div>
	<div class="row mt-2">
		<div class="col-6">Prénom : </div>
		<div class="col-6">${userProfile.surname}</div>
	</div>
	<div class="row mt-2">
		<div class="col-6">Email : </div>
		<div class="col-6">${userProfile.email}</div>
	</div>
	<div class="row mt-2">
		<div class="col-6">Tel : </div>
		<div class="col-6">${userProfile.phone_nb}</div>
	</div>
	<div class="row mt-2">
		<div class="col-6">Rue : </div>
		<div class="col-6">${userProfile.street}</div>
	</div>
	<div class="row mt-2">
		<div class="col-6">Code Postal : </div>
		<div class="col-6">${userProfile.postal_code}</div>
	</div>
	<div class="row mt-2">
		<div class="col-6">Ville : </div>
		<div class="col-6">${userProfile.city}</div>
	</div>
	<a href="<%=request.getContextPath()%>/editProfile/${userProfile.user_nb}"><button type="button" class="btn btn-primary mt-5">Modifier mon profil</button></a>
</div>
	
	
</main>
</body>
</html>