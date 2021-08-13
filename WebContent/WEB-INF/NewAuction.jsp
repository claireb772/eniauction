<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<%@ include file="/WEB-INF/navBar.jsp" %>
</nav>
<main class="p-3 d-flex justify-content-center">


	<form method="post" class="col-12 col-md-8  d-flex bg-light p-3 flex-column"  enctype="multipart/form-data">
	<p class="text-primary">Nouvelle Vente</p>
	<div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <input type="text" class="form-control" id="formGroupExampleInput" name="product_name" placeholder="Nom de l'article">
	    <textarea class="form-control mt-2" name="product_desc">Description</textarea>
	    <select class="form-control mt-2" name="product_category">
	    <c:forEach var="item" items="${listCategories}" >
	    	<option value="${item.category}">${item.wording}</option>
	    </c:forEach>
	    </select>
	    <input type="file"  class="form-control mt-2" name="product_image" enctype="multipart/form-data"/>
	    <div class="input-group  mt-2">
	        <div class="input-group-prepend">
	          <div class="input-group-text mentionInput">Debut</div>
	        </div>
        <input type="date" class="form-control" name="product_start">
      	</div>
      	<div class="input-group  mt-2">
	        <div class="input-group-prepend">
	          <div class="input-group-text mentionInput">Fin</div>
	        </div>
        <input type="date" class="form-control" name="product_end">
      	</div>
      	<div class="input-group  mt-2">
	        <div class="input-group-prepend">
	          <div class="input-group-text mentionInput">Prix minimum</div>
	        </div>
        <input type="input" class="form-control" name="product_price">
      	</div>
      <hr>
      <p>Retrait</p>
      <div class="input-group  mt-2">
	        <div class="input-group-prepend">
	          <div class="input-group-text mentionInput">Ville</div>
	        </div>
        <input type="input" class="form-control" name="takeaway_city">
      	</div>
      	<div class="input-group  mt-2">
	        <div class="input-group-prepend">
	          <div class="input-group-text mentionInput">Rue</div>
	        </div>
        <input type="input" class="form-control" name="takeaway_street">  
      	</div>
      	<div class="input-group  mt-2">
	        <div class="input-group-prepend">
	          <div class="input-group-text mentionInput">Code Postal</div>
	        </div>
        <input type="input" class="form-control" name="takeaway_postal_code">
      	</div>
	  </div><!--fin bloc-->

	</div>
	<div class="d-flex flex-row">
		<button type="button" class="btn btn-outline-secondary mx-1 mt-2 flex-1">Annuler</button>
		<button type="button" class="btn btn-outline-secondary mx-1 mt-2 flex-1">Annuler la vente</button>
		<button type="submit" class="btn btn-primary mx-1 mt-2 flex-1">Enregistrer</button>
	</div>
	
</form>
	
</main>
</body>
</html>