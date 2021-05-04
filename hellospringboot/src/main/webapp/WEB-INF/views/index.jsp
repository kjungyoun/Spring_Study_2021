<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${root }/css/common.css">
</head>
<body>
<img src="${root }/img/ssafy_logo.png" id="ssafy_logo">
<h1>${msg}</h1>
<a href="${root }/test">test</a>
</body>
</html>