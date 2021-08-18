<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="./" class="text-white text-decoration-none">Enchere</a>
	<div class="links justify-self-end">
		<c:if test="${sessionScope.authentification == 1}"  >
			<a href="./NewAuction" class="text-white text-decoration-none mx-2">Nouvelle Vente</a>
			<a href="<%=request.getContextPath() %>/profil?id=${sessionScope.id}" class="text-white text-decoration-none mx-2">Profil</a>

			<a href="./logout" class="text-white text-decoration-none mx-2">Deconnecter</a>
		</c:if>
		<c:if test="${sessionScope.authentification != 1}"  >
			<a href="./login" class="text-white text-decoration-none mx-2">Se Connecter</a>/
			<a href="./sign" class="text-white text-decoration-none mx-2">S'inscrire</a>
		</c:if>

		<a href="./Admin" class="text-white text-decoration-none mx-2">Admin</a>
		<a href="./">
			<button class="text-white" onclick="<c:set var="darkMode" scope="session" value="${darkMode == '1'? '0':'1'}" />">A</button>
		</a>
	</div>