<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifications des catégories d'articles</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<nav class="bg-primary p-3 text-white d-flex col d-flex justify-content-between">
	<%@ include file="/WEB-INF/navBar.jsp" %>
</nav>
<main>

<div>
<p>Catégories <a href="<%=request.getContextPath()%>/addCategory"><button type="button" class="btn btn-primary m-3 w-50">Ajouter</button></a></p>
</div>
<table>
<c:forEach var="item" items="${categoryList}" >
<tr>
<td>${item.wording}</td>
<td><a href="<%=request.getContextPath()%>/deleteCategory?id=${item.category}" onclick= "return confirm('Vous êtes sûr.e de vouloir supprimer la catégorie ?')" ><button type="button" class="btn btn-danger m-3 w-50">Supprimer</button></a></td>
<td><a href="<%=request.getContextPath()%>/editCategory?id=${item.category}"><button type="button" class="btn btn-warning m-3 w-50">Modifier</button></a></td>
</tr>
</c:forEach>

</table>

</main>
</body>
</html>