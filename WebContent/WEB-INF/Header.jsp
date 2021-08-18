<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<title>Encheres Project</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
	<style><%@include file="/WEB-INF/style.css"%></style>
	<c:if test="${sessionScope.darkMode.equals('1') }">
		<style><%@include file="/WEB-INF/styleDark.css"%></style>
	</c:if>