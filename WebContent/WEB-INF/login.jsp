<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Encheres Project</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
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
				    <input name="user" type="text" class="form-control" id="formGroupExampleInput" placeholder="Email">
					
					
					<%-- Script récuperation de login inseré dans les cookies "Se souvenir de moi"  
					<% 
					Cookie cookies [] = request.getCookies();
				    String remindUser = null;
				   	String remindPassword = null;
				    if (cookies != null){
				        for (int i = 0; i < cookies.length; i++) {
				            if (cookies [i].getName() == "userCookie"){
				            	remindUser = cookies [i].getValue();
				            }
				            if (cookies [i].getName() == "passwordCookie"){
				            	remindPassword = cookies [i].getValue();
				            }
				        }
				    }
				    %> 
				    --%>
				    
				  	<c:if test="${!empty remindUser}">
				  		value"remindUser"
					</c:if>
				    
				  </div>
				  <div class="form-group mx-2 flex-1">
				    <label for="formGroupExampleInput2">Password</label>
				    <input name="password" type="password" class="form-control" id="formGroupExampleInput2" placeholder="Password"
				    
				  	<c:if test="${!empty remindPassword}">
				  		value"remindPassword"
					</c:if>
					>
				  </div>
				</div>
				<div class="form-group m-2">
					<input name="remind" type="checkbox" id="formGroupCHeckbox" aria-label="Checkbox for following text input">
					<label for="formGroupCHeckbox">Se souvenir de moi</label>
				</div>
				<a href="#" class="mx-2">Mot de pass oublié</a>
				<button type="submit" class="btn btn-primary mt-3">Se connecter</button>
				<a href="./sign" class="btn btn-outline-primary mt-3">Creer un compte</a>
			</form>
		</main>
	</body>
</html>