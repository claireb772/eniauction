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

<main>

<table class="table">
<thead>
<tr>
	<th scope="col"></th>
	<th scope="col">Nom</th>
	<th scope="col">Pseudo</th>
	<th scope="col">Crédit</th>
	<th scope="col">Enchères en cours</th>
	<th scope="col">Admin</th>
	<th scope="col"></th>

</tr>
<c:forEach var="item" items="${usersList}" >
<tr>
	<th scope="row"></th>
	<td>${item.name}</td>
	<td>${item.pseudo}</td>
	<td>${item.credit}</td>
	<td>${item.pendingChange}</td>	
	<td>
	<c:choose>
	<c:when test="${item.administrator eq true}" >
	oui
	</c:when>
	<c:otherwise>
	non
	</c:otherwise>
	</c:choose>
	</td>
	<td><a href="<%=request.getContextPath()%>/deleteProfil?id=${item.user_nb}" onclick= "return confirm('Vous êtes sûr.e de vouloir supprimer le profil ?')" ><button type="button" class="btn btn-danger m-3 w-50">Supprimer le compte</button></a></td>
	
</tr>
</c:forEach>
</table>
</main>
</body>
</html>