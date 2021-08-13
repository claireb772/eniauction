<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Encheres Project</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
	<style><%@include file="/WEB-INF/style.css"%></style>
</head>
<body>
<nav class="bg-primary p-3 text-white d-flex col d-flex justify-content-between">
	<a href="./index.html" class="text-white text-decoration-none">Enchere</a>
	<div class="links justify-self-end">
		<a href="new_Auction" class="text-white text-decoration-none mx-2">Nouvelle Vente</a>
		<a href="#" class="text-white text-decoration-none mx-2">Admin</a>
		<a href="#" class="text-white text-decoration-none mx-2">Profil</a>
		<a href="./login.html" class="text-white text-decoration-none mx-2">Se Connecter</a>/
		<a href="./sign.html" class="text-white text-decoration-none mx-2">S'inscrire</a>
	</div>
</nav>
<main class="p-3 d-flex justify-content-center">


	<form class="col-12 col-md-8  d-flex bg-light p-3 flex-column"  >
	<p class="text-primary">Nouvelle Vente</p>
	<div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Nom de l'article">
	    <textarea class="form-control mt-2">Description</textarea>
	    <select class="form-control mt-2">
	    	<option>Categorie 1</option>
	    	<option>Categorie 2</option>
	    	<option>Categorie 3</option>
	    	<option>Categorie 4</option>
	    </select>
	    <input type="file"  class="form-control mt-2"/>
	    <div class="input-group  mt-2">
	        <div class="input-group-prepend">
	          <div class="input-group-text mentionInput">Debut</div>
	        </div>
        <input type="date" class="form-control">
      	</div>
      	<div class="input-group  mt-2">
	        <div class="input-group-prepend">
	          <div class="input-group-text mentionInput">Fin</div>
	        </div>
        <input type="date" class="form-control">
      	</div>
      <hr>
      <p>Retrait</p>
      <div class="input-group  mt-2">
	        <div class="input-group-prepend">
	          <div class="input-group-text mentionInput">Ville</div>
	        </div>
        <input type="input" class="form-control">
      	</div>
      	<div class="input-group  mt-2">
	        <div class="input-group-prepend">
	          <div class="input-group-text mentionInput">Rue</div>
	        </div>
        <input type="input" class="form-control">
      	</div>
      	<div class="input-group  mt-2">
	        <div class="input-group-prepend">
	          <div class="input-group-text mentionInput">Code Postal</div>
	        </div>
        <input type="input" class="form-control">
      	</div>
	  </div><!--fin bloc-->

	</div>
	<div class="d-flex flex-row">
		<button type="button" class="btn btn-outline-secondary mx-1 mt-2 flex-1">Annuler</button>
		<button type="button" class="btn btn-outline-secondary mx-1 mt-2 flex-1">Annuler la vente</button>
		<button type="button" class="btn btn-primary mx-1 mt-2 flex-1">Enregistrer</button>
	</div>
	
</form>
	
</main>
</body>
</html>