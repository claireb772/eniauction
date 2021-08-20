<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Encheres Project</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
</head>
<body>
	<nav
		class="bg-primary p-3 text-white d-flex col d-flex justify-content-between">
		<%@ include file="/WEB-INF/navBar.jsp"%>
	</nav>
	<main class="p-3 d-flex justify-content-center">
		<form method="post"
			class="col-12 col-md-8  d-flex bg-light p-3 flex-column">
			<p class="text-primary">Mot de passe oublié</p>
			<div class="d-md-flex flex-row">
				<div class="form-group mx-2 flex-1">
					<label for="formGroupExampleInput">Email</label> 
					<input name="Email" type="text" class="form-control" id="formGroupExampleInput" placeholder="Email" value="${remindUser}">
				 <br>
				  <label for="formGroupExampleInput2">Question secrète</label> 
				  <select name="question" class="custom-select custom-select-lg mb-3">
						<c:forEach var="item" items="${listAuction}">
							<option value="${item.question_id}">${item.question}</option>
						</c:forEach>
					</select><br> <label for="formGroupExampleInput">Réponse</label> <input
						name="answer" type="text" class="form-control"
						id="formGroupExampleInput" placeholder="Réponse">

				</div>

			</div>
			<button type="submit" class="btn btn-primary mt-3">Valider</button>
		</form>
	</main>
</body>
</html>