<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<form method="post" class="col-12 col-md-8  d-flex bg-light p-3 flex-column"  >
				<p class="text-primary">Connexion</p>
				<div class="d-md-flex flex-row">
				  <div class="form-group mx-2 flex-1">
				    <label for="formGroupExampleInput">Email</label>
				    <input name="user" type="text" class="form-control" id="formGroupExampleInput" placeholder="Email" value="${remindUser}">
				  </div>
				  <div class="form-group mx-2 flex-1">
				    <label for="formGroupExampleInput2">Password</label>
				    <input name="password" type="password" class="form-control" id="formGroupExampleInput2" placeholder="Password" value="${remindPassword}" >
				  </div>
				</div>
				<div class="form-group m-2">
					<input name="remind" type="checkbox" id="formGroupCHeckbox" aria-label="Checkbox for following text input">
					<label for="formGroupCHeckbox">Se souvenir de moi</label>
				</div>
				<a href="./forgotpass" class="mx-2">Mot de passe oublié</a>
				<button type="submit" class="btn btn-primary mt-3">Se connecter</button>
				<a href="./sign" class="btn btn-outline-primary mt-3">Creer un compte</a>
			</form>
		</main>
		<c:if test="${!empty Erreur}">
			<div class="container alert alert-danger" role="alert">
				<p>${Erreur}</p>
			</div>
		</c:if>
	</body>
</html>