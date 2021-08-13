<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<title>Encheres Project</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

</head>
<body>
<nav class="bg-primary p-3 text-white d-flex col d-flex justify-content-between">
	<a href="./index.html" class="text-white text-decoration-none">Enchere</a>
	<div class="links justify-self-end">
		<a href="new_Auction.html" class="text-white text-decoration-none mx-2">Nouvelle Vente</a>
		<a href="#" class="text-white text-decoration-none mx-2">Admin</a>
		<a href="#" class="text-white text-decoration-none mx-2">Profil</a>
		<a href="login" class="text-white text-decoration-none mx-2">Se Connecter</a>/
		<a href="sign" class="text-white text-decoration-none mx-2">S'inscrire</a>
	</div>
</nav>
<main class="p-3 d-flex justify-content-center">

<form method="post" class="col-12 col-md-8  d-flex bg-light p-3 flex-column"  >
	<p class="text-primary">Connexion</p>
	<div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput">Email</label>
	    <input name="user" type="text" class="form-control" id="formGroupExampleInput" placeholder="Email">
	  </div>
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Password</label>
	    <input name="password" type="password" class="form-control" id="formGroupExampleInput2" placeholder="Password">
	  </div>
	</div>
	<div class="form-group m-2">
		
		<input type="checkbox" id="formGroupCHeckbox" aria-label="Checkbox for following text input">
		<label for="formGroupCHeckbox">Se souvenir de moi</label>


	</div>
	<a href="#" class="mx-2">Mot de pass oublié</a>
	
	<button type="submit" class="btn btn-primary mt-3">Se connecter</button>
	<button type="button" class="btn btn-outline-primary mt-3">Creer un compte</button>
</form>

	
	
</main>
</body>
</html>