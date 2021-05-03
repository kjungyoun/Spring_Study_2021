<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post"	action="updateBook.do">
	<table align="center">
		<caption>책 상세 정보</caption>
		<tr><td>책 번호</td><td><input type="text" name="isbn"  	value="${book.isbn}"/></td></tr>
		<tr><td>제목</td><td><input type="text" name="title"  	value="${book.title}"/></td></tr>
		<tr><td>분류</td><td><input type="text" name="catalogue" value="${book.catalogue}"/></td></tr>
		<tr><td>국가</td><td><input type="text" name="nation"  	value="${book.nation}"/></td></tr>
		<tr><td>출판일</td><td><input type="text" name="publish_date"  value="${book.publish_date}"/></td></tr>
		<tr><td>출판사</td><td><input type="text" name="publisher" value="${book.publisher}"/></td></tr>
		<tr><td>저자</td><td><input type="text" name="author"  	value="${book.author}"/></td></tr>
		<tr><td>가격</td><td><input type="text" name="price"  	value="${book.price}"/></td></tr>
		<tr><td>화폐단위</td><td><input type="text" name="currency"  value="${book.currency}"/></td></tr>
		<tr><td colspan="2">설명</td></tr>
		<tr><td colspan="2">${book.description}</td></tr>
		<tr><td colspan="2" align="center">
			<a href="listBook.do">목록</a>
			<input type="submit"	value="수정"/>
		</td></tr>
	</table>
	</form>
</body>
</html>