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
	<%@ include file="/WEB-INF/navBar.jsp" %> 
</nav>
<main class="p-3 d-flex justify-content-center">
<form method="post" class="col-12 col-md-8  d-flex bg-light p-3 flex-column"  >
	<p class="text-primary">Inscription</p>
	<div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput">Pseudo</label>
	    <input required="required"  name="Pseudo" type="text" class="form-control" id="formGroupExampleInput" placeholder="Pseudo" pattern="^[a-zA-Z0-9_]*$" maxlength="15">
	  </div>
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Prenom</label>
	    <input required="required" name="Name" type="text" class="form-control" id="formGroupExampleInput2" placeholder="Prenom" maxlength="25">
	  </div>
	</div>

	<div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Mot de passe</label>
	    <input required="required"  name="Password" type="password" class="form-control" id="formGroupExampleInput2" placeholder="Password" autocomplete="current-password" maxlength="30">
	  </div>
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Confirmation</label>
	    <input required="required"  name="Confirmation" type="password" class="form-control" id="formGroupExampleInput2" placeholder="Confirmation">
	  </div>
	</div>
	  <div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Nom</label>
	    <input required="required"  name="Surname" type="text" class="form-control" id="formGroupExampleInput2" placeholder="Nom" pattern="[a-z,A-Z ]{4,20}">
	  </div>
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Tel</label>
	    <input required="required"  name="Phone" type="tel" class="form-control" id="formGroupExampleInput2" placeholder="Tel" pattern="[0-0]{1}[0-9]{9}">
	  </div>
	  </div>
	  <div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Email</label>
	    <input required="required"  name="Email" type="email" class="form-control" id="formGroupExampleInput2" placeholder="Email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$">
	  </div>
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Rue</label>
	    <input required="required"  name="Street" type="text" class="form-control" id="formGroupExampleInput2" placeholder="Rue">
	  </div>
	</div>
	  <div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Ville</label>
	    <input required="required"  name="City" type="text" class="form-control" id="formGroupExampleInput2" placeholder="Ville">
	  </div>
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Code Postal</label>
	    <input required="required"  name="PostalCode" type="text" class="form-control" id="formGroupExampleInput2" placeholder="Code Postal"  pattern="[0-9]{5}">
	  </div>
	</div>
	<div class="d-flex flex-row">
		<a href="./"  class="btn btn-outline-secondary m-3 w-50">Annuler</a>
		<button type="submit" class="btn btn-primary m-3 w-50">S'inscrire</button>
	</div>
	<c:if test="${!empty ListeErreur}">
	<div class="alert alert-danger" role="alert">
  	<c:forEach var="item" items="${ListeErreur}" >
		<p> -${item}</p>
	</c:forEach>
</div>
</c:if>
</form>

	
	
</main>
</body>
</html>