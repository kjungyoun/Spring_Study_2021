<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${userinfo.username }(${userinfo.userid })님이 선택하신 과일은
<c:if test="${not empty userinfo.fruit }">
	<c:forEach var="f" items="${userinfo.fruit }" varStatus="s">
		${s.count } ${f }
	</c:forEach>
	입니다.

</c:if>

<c:if test="${empty userinfo.fruit }">
	없습니다.
</c:if>
</body>
</html>