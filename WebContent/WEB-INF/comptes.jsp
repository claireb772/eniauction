<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>comptes utilisateurs</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<nav class="bg-primary p-3 text-white d-flex col d-flex justify-content-between">
	<%@ include file="/WEB-INF/navBar.jsp" %>
</nav>

<main>

<table>
<thead>
<tr>
	<th>Nom</th>
	<th>Pseudo</th>
	<th>Crédit</th>
	<th>Enchères en cours</th>
	<th>Admin</th>
	<th></th>

</tr>
<c:forEach var="item" items="${usersList}" >
<tr>
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