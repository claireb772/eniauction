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
<main class="p-3 d-flex justify-content-center">

<form class="col-12 col-md-8  d-flex bg-light p-3 flex-column" action="<%=request.getContextPath()%>/editProfile" method="post" >
	<p class="text-primary">Inscription</p>
	<div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput">Pseudo</label>
	    <input type="text" name="pseudo" class="form-control" id="formGroupExampleInput" placeholder="Pseudo" value="${userProfile.pseudo}">
	  </div>
	  <div class="form-group mx-2 flex-1">
	     <label for="formGroupExampleInput2">Email</label>
	    <input type="text" name="email" class="form-control" id="formGroupExampleInput2" placeholder="Email" value="${userProfile.email}">	    
	  </div>
	</div>
		  <div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Nom</label>
	    <input type="text" name="name" class="form-control" id="formGroupExampleInput2" placeholder="Nom" value="${userProfile.name}">
	  </div>
	  <div class="form-group mx-2 flex-1">
	  <label for="formGroupExampleInput2">Prenom</label>
	    <input type="text" name="surname" class="form-control" id="formGroupExampleInput2" placeholder="Prenom" value="${userProfile.surname}">
	   
	    </div>
	  </div>
	<div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Mot de passe</label>
	    <input type="password" name="password" class="form-control" id="formGroupExampleInput2" placeholder="Password" value="${userProfile.password}">
	  </div>
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Confirmation</label>
	    <input type="password" name="confirmation" class="form-control" id="formGroupExampleInput2" placeholder="Confirmation">
	  </div>
	</div>

	  <div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	  <label for="formGroupExampleInput2">Tel</label>
	    <input type="text" name="phoneNb" class="form-control" id="formGroupExampleInput2" placeholder="Tel" value="${userProfile.phone_nb}">
	  
	  </div>
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Rue</label>
	    <input type="text" name="street" class="form-control" id="formGroupExampleInput2" placeholder="Rue" value="${userProfile.street}">
	  </div>
	</div>
	  <div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Ville</label>
	    <input type="text" name="city" class="form-control" id="formGroupExampleInput2" placeholder="Ville" value="${userProfile.city}">
	  </div>
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Code Postal</label>
	    <input type="text" name="postalCode" class="form-control" id="formGroupExampleInput2" placeholder="Code Postal" value="${userProfile.postal_code}">
	  </div>
	</div>
	<div class="d-flex flex-row">
		<button type="submit" role="button" class="btn btn-primary m-3 w-50">Enregistrer</button>
		<a href="<%=request.getContextPath()%>/deleteProfil" onclick= "return confirm('Vous êtes sûr.e de vouloir supprimer votre profil ?')" ><button type="button" class="btn btn-danger m-3 w-50">Supprimer mon compte</button></a>
	</div>
	
	<c:if test="${!empty listeErreurs}">
	<div class="alert alert-danger" role="alert">
		<c:forEach var="messageErreur" items="${listeErreurs}">
			<p> - ${messageErreur}</p>
			</c:forEach>	
			</div>		
		</c:if>
</form>
		
	
	
</main>
</body>
</html>