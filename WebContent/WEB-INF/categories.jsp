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


	<table class="table table-hover">
		<thead>
			<tr>
				<th scope="col"></th>
				<th scope="col">Categories</th>
				<th scope="col"><a href="<%=request.getContextPath()%>/addCategory"><button type="button" class="btn btn-primary m-3 w-50">Ajouter</button></a></th>
				<th scope="col"></th>
			</tr>
	</thead>
	<c:forEach var="item" items="${categoryList}" >
		<tr>
			<th scope="row"></th>
				<td>${item.wording}</td>
				<td><a href="<%=request.getContextPath()%>/deleteCategory?id=${item.category}" onclick= "return confirm('Vous êtes sûr.e de vouloir supprimer la catégorie ?')" ><button type="button" class="btn btn-danger m-3 w-50">Supprimer</button></a></td>
				<td><a href="<%=request.getContextPath()%>/editCategory?id=${item.category}"><button type="button" class="btn btn-warning m-3 w-50">Modifier</button></a></td>
		</tr>
	</c:forEach>
	
	</table>
</main>
</body>
</html>