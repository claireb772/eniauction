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

<form method="post" class="col-12 col-md-8  d-flex bg-light p-3 flex-column"  >
	<p class="text-primary">Inscription</p>
	<div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput">Pseudo</label>
	    <input name="Pseudo" type="text" class="form-control" id="formGroupExampleInput" placeholder="Pseudo">
	  </div>
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Prenom</label>
	    <input name="Name" type="text" class="form-control" id="formGroupExampleInput2" placeholder="Prenom">
	  </div>
	</div>

	<div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Mot de passe</label>
	    <input name="Password" type="password" class="form-control" id="formGroupExampleInput2" placeholder="Password">
	  </div>
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Confirmation</label>
	    <input name="Confirmation" type="password" class="form-control" id="formGroupExampleInput2" placeholder="Confirmation">
	  </div>
	</div>
	  <div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Nom</label>
	    <input name="Surname" type="text" class="form-control" id="formGroupExampleInput2" placeholder="Nom">
	  </div>
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Tel</label>
	    <input name="Phone" type="text" class="form-control" id="formGroupExampleInput2" placeholder="Tel">
	  </div>
	  </div>
	  <div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Email</label>
	    <input name="Email" type="text" class="form-control" id="formGroupExampleInput2" placeholder="Email">
	  </div>
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Rue</label>
	    <input name="Street" type="text" class="form-control" id="formGroupExampleInput2" placeholder="Rue">
	  </div>
	</div>
	  <div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Ville</label>
	    <input name="City" type="text" class="form-control" id="formGroupExampleInput2" placeholder="Ville">
	  </div>
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Code Postal</label>
	    <input name="PostalCode" type="text" class="form-control" id="formGroupExampleInput2" placeholder="Code Postal">
	  </div>
	</div>
	<div class="d-flex flex-row">
		<button type="button" class="btn btn-outline-secondary m-3 w-50">Annuler</button>
		<button type="submit" class="btn btn-primary m-3 w-50">S'inscrire</button>
	</div>
</form>

	
	
</main>
</body>
</html>