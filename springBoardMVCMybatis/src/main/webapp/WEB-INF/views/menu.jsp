<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<article id="logo"><img src="images/ssafy.png"/></article>
<nav id="private">
 	<ul>
	<c:choose>
	   <c:when test="${empty id}">
		<li><a href="loginform.do">로그인</a></li>
	   </c:when>
	   <c:otherwise>
	     <li><a href="logout.do">로그아웃</a></li>
	     <li><a href="memberUpdateForm.do">회원정보수정</a></li>
	     <li><a href="myPage.do">myPage</a></li>
	   </c:otherwise>
	</c:choose>
</ul>
</nav>