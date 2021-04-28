<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post"	action="insertBook.do">
	<table align="center">
		<caption>책 상세 정보</caption>
		<tr><td>책 번호</td>	<td><input type="text" name="isbn"  	/></td></tr>
		<tr><td>제목</td>		<td><input type="text" name="title"  	/></td></tr>
		<tr><td>분류</td>		<td><input type="text" name="catalogue" /></td></tr>
		<tr><td>국가</td>		<td><input type="text" name="nation"  	/></td></tr>
		<tr><td>출판일</td>	<td><input type="text" name="publish_date"  /></td></tr>
		<tr><td>출판사</td>	<td><input type="text" name="publisher" /></td></tr>
		<tr><td>저자</td>		<td><input type="text" name="author"  	/></td></tr>
		<tr><td>가격</td>		<td><input type="text" name="price"  	/></td></tr>
		<tr><td>화폐단위</td>	<td><input type="text" name="currency"  /></td></tr>
		<tr><td colspan="2">설명</td></tr>
		<tr><td colspan="2">
				<textarea rows="5" cols="30" name="description"></textarea>
			</td></tr>
		<tr><td colspan="2" align="center">
			<a href="listBook.do">목록</a>
			<input type="submit"	value="등록"/>
		</td></tr>
	</table>
	</form>
</body>
</html>