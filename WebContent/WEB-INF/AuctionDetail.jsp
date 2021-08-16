<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


	<div class="col-12 col-md-8  d-flex bg-light p-3 flex-column"  >
	<div class="d-md-flex flex-row">
	  <div class="mx-2 flex-1">
	    <p class="text-primary">Titre de l'enchere</p>
	    <p>Description</p>
	    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
	    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
	    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
	    consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
	    cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
	    proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
	    <p>Categorie de l'article</p>
	    <p class="text-danger">185 pts</p>
	    <p>18/02/2022</p>
	    <p>Vendeur</p>
	    <hr>
	    <div class="input-group mb-3">
  			<input type="text" class="form-control" placeholder="220" aria-label="Recipient's username" aria-describedby="basic-addon2">
		  <div class="input-group-append">
		    <button class="btn btn-primary" type="button">Enchérir</button>
		  </div>
		</div>
	  </div>
	</div>
	
</div>
</body>
</html>