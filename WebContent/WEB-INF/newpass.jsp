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
				<div class="d-md-flex flex-row">
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2"> Nouveau mot de passe</label>
	    <input required="required"  name="Password" type="password" class="form-control" id="formGroupExampleInput2" placeholder="Password" autocomplete="current-password" maxlength="30">
	  </div>
	  <div class="form-group mx-2 flex-1">
	    <label for="formGroupExampleInput2">Confirmation</label>
	    <input required="required"  name="Confirmation" type="password" class="form-control" id="formGroupExampleInput2" placeholder="Confirmation">
	  </div>

				</div>

			</div>
			<button type="submit" class="btn btn-primary mt-3">Valider</button>
		</form>
	</main>
</body>
</html>