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

<form class="col-12 col-md-8  d-flex bg-light p-3 flex-column" action="<%=request.getContextPath()%>/editProfile" method="post" >
	<p class="text-primary">Inscription</p>
	<div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput">Pseudo</label>
	    <input type="text" name="pseudo" class="form-control" id="formGroupExampleInput" placeholder="Pseudo" value="${userProfile.pseudo}">
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
	    <label for="formGroupExampleInput2">Nom</label>
	    <input type="text" name="name" class="form-control" id="formGroupExampleInput2" placeholder="Nom" value="${userProfile.name}">
	  </div>
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Tel</label>
	    <input type="text" name="phoneNb" class="form-control" id="formGroupExampleInput2" placeholder="Tel" value="${userProfile.phone_nb}">
	  </div>
	  </div>
	  <div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Email</label>
	    <input type="text" name="email" class="form-control" id="formGroupExampleInput2" placeholder="Email" value="${userProfile.email}">
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
		<button type="submit" role="button" class="btn btn-primary m-3 w-50">Enregistrer</a>
		<button type="button" class="btn btn-danger m-3 w-50">Supprimer mon compte</button>
	</div>
	<c:if test="${!empty message}">
			<div>${message}</div>
			
		</c:if>
</form>
		
	
	
</main>
</body>
</html>