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

<div class="col-8 d-flex flex-column">
	<p class="text-primary">Votre profil</p>
	<div class="row mt-2">
		<div class="col-6">Pseudo :</div>
		<div class="col-6">${userProfile.pseudo}</div>
	</div>
	<div class="row mt-2">
		<div class="col-6">Nom : </div>
		<div class="col-6">${userProfile.name}</div>
	</div>
	<div class="row mt-2">
		<div class="col-6">Prénom : </div>
		<div class="col-6">${userProfile.surname}</div>
	</div>
	<div class="row mt-2">
		<div class="col-6">Email : </div>
		<div class="col-6">${userProfile.email}</div>
	</div>
	<div class="row mt-2">
		<div class="col-6">Tel : </div>
		<div class="col-6">${userProfile.phone_nb}</div>
	</div>
	<div class="row mt-2">
		<div class="col-6">Rue : </div>
		<div class="col-6">${userProfile.street}</div>
	</div>
	<div class="row mt-2">
		<div class="col-6">Code Postal : </div>
		<div class="col-6">${userProfile.postal_code}</div>
	</div>
	<div class="row mt-2">
		<div class="col-6">Ville : </div>
		<div class="col-6">${userProfile.city}</div>
		
	
	</div>
	<c:if test="${isActualUser eq true}">
	<a href="<%=request.getContextPath()%>/editProfile"><button type="button" class="btn btn-primary mt-5">Modifier mon profil</button></a>
	</c:if>
</div>
		<c:if test="${!empty message}">
			<div>${message}</div>			
		</c:if>
	
</main>
<script>
<%@ include file="/WEB-INF/fixIdDarkMode.js" %>
</script>
</body>
</html>