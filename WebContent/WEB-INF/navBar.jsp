<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<a href="./" class="text-white text-decoration-none">Enchere</a>
	<div class="links justify-self-end">
		<c:if test="${sessionScope.authentification == 1}"  >
				<c:if test="${sessionScope.isAdmin eq true}">
					<a href="<%=request.getContextPath() %>/comptes" class="text-white text-decoration-none mx-2">Comptes</a>
					<a href="<%=request.getContextPath() %>/categories" class="text-white text-decoration-none mx-2">Catégories</a>
				</c:if>
			<a href="<%=request.getContextPath() %>/NewAuction" class="text-white text-decoration-none mx-2">Nouvelle Vente</a>
			<a href="<%=request.getContextPath() %>/myauction" class="text-white text-decoration-none mx-2">Mes enchères</a>
			<a href="<%=request.getContextPath() %>/mysells" class="text-white text-decoration-none mx-2">Mes ventes</a>
			<a href="<%=request.getContextPath() %>/profil?id=${sessionScope.id}" class="text-white text-decoration-none mx-2">Profil</a>
			<a href="<%=request.getContextPath() %>/logout" class="text-white text-decoration-none mx-2">Deconnecter</a>
				
		</c:if>
		<c:if test="${sessionScope.authentification != 1}"  >
			<a href="<%=request.getContextPath() %>/login" class="text-white text-decoration-none mx-2">Se Connecter</a>/
			<a href="<%=request.getContextPath() %>/sign" class="text-white text-decoration-none mx-2">S'inscrire</a>
		</c:if>

		<a href="?darkMode=<c:out value="${sessionScope.darkMode == 1 ? 0 : 1 }"/>"><button class="text-white">A</button></a>
		<a href="<%=request.getContextPath() %>/Admin" class="text-white text-decoration-none mx-2">Admin</a>
		
	</div>