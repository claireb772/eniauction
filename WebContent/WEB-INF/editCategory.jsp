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

	<form class="col-12 col-md-8  d-flex bg-light p-3 flex-column" action="<%=request.getContextPath()%>/editCategory" method="post" >
		<p class="text-primary">Modifier une catégorie</p>
		<div class="d-md-flex flex-row">
		  <div class="form-group mx-2 flex-1">
		    <input type="text" name="wording" class="form-control" id="formGroupExampleInput" placeholder="Nom de la catégorie" value="${category.wording}">
		  </div>
		</div>
		<button type="submit" role="button" class="btn btn-primary m-3 w-50">Modifier</button>
	</form>
</main>
</body>
</html>