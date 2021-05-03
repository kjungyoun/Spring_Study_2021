<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center">
		<caption>책 상세 정보</caption>
		<tr><td>책 번호</td><td>${book.isbn}</td></tr>
		<tr><td>제목</td><td>${book.title}</td></tr>
		<tr><td>분류</td><td>${book.catalogue}</td></tr>
		<tr><td>국가</td><td>${book.nation}</td></tr>
		<tr><td>출판일</td><td>${book.publish_date}</td></tr>
		<tr><td>출판사</td><td>${book.publisher}</td></tr>
		<tr><td>저자</td><td>${book.author}</td></tr>
		<tr><td>가격</td><td>${book.price}</td></tr>
		<tr><td>화폐단위</td><td>${book.currency}</td></tr>
		<tr><td colspan="2">설명</td></tr>
		<tr><td colspan="2">${book.description}</td></tr>
		<tr><td colspan="2" align="center">
			<a href="listBook.do">목록</a>
			<a href="removeBook.do?isbn=${book.isbn}">삭제</a>
			<a href="updateBookForm.do?isbn=${book.isbn}">수정</a>
		</td></tr>
	</table>
</body>
</html>