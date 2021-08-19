<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/Header.jsp" %> 
</head>
<body>
	<nav
		class="bg-primary p-3 text-white d-flex col d-flex justify-content-between">
		<%@ include file="/WEB-INF/navBar.jsp"%>
	</nav>
	<main class="p-3 d-flex justify-content-center">


		<form method="post"
			class="col-12 col-md-8  d-flex bg-light p-3 flex-column">
			<p class="text-primary">Nouvelle Vente</p>
			<div class="d-md-flex flex-row">
				<div class="form-group mx-2 flex-1">
					<input type="text" class="form-control" id="formGroupExampleInput"
						name="product_name" placeholder="Nom de l'article" required>
					<textarea class="form-control mt-2" name="product_desc">Description</textarea>
					<select class="form-control mt-2" id="product_category"
						name="product_category">
						<c:forEach var="item" items="${listCategories}">
							<option value="${item.getCategory()}">${item.getWording()}</option>
						</c:forEach>
					</select> <input type="file" class="form-control mt-2" name="product_image"
						enctype="multipart/form-data" />
					<div class="input-group  mt-2">
						<div class="input-group-prepend">
							<div class="input-group-text mentionInput">Debut</div>
						</div>
						<input type="date" class="form-control" name="product_start" min="<c:out value="${today}"/>" value="<c:out value="${today}"/>" required>
					</div>
					<div class="input-group  mt-2">
						<div class="input-group-prepend">
							<div class="input-group-text mentionInput">Fin</div>
						</div>
						<input type="date" class="form-control" name="product_end" min="<c:out value="${today}"/>" required>
					</div>
					<div class="input-group  mt-2">
						<div class="input-group-prepend">
							<div class="input-group-text mentionInput">Prix minimum</div>
						</div>
						<input type="input" class="form-control" name="product_price" required>
					</div>
					<hr>
					<p>Retrait</p>
					<div class="input-group  mt-2">
						<div class="input-group-prepend">
							<div class="input-group-text mentionInput">Ville</div>
						</div>
						<input type="input" class="form-control" name="takeaway_city" required>
					</div>
					<div class="input-group  mt-2">
						<div class="input-group-prepend">
							<div class="input-group-text mentionInput">Rue</div>
						</div>
						<input type="input" class="form-control" name="takeaway_street" required>
					</div>
					<div class="input-group  mt-2">
						<div class="input-group-prepend">
							<div class="input-group-text mentionInput">Code Postal</div>
						</div>
						<input type="input" class="form-control"
							name="takeaway_postal_code" required>
					</div>
				</div>
				<!--fin bloc-->

			</div>
			<div class="d-flex flex-row">
				<button type="button"
					class="btn btn-outline-secondary mx-1 mt-2 flex-1">Annuler</button>
				<button type="button"
					class="btn btn-outline-secondary mx-1 mt-2 flex-1">Annuler
					la vente</button>
				<button type="submit" class="btn btn-primary mx-1 mt-2 flex-1">Enregistrer</button>
			</div>

		</form>

	</main>
</body>
</html>