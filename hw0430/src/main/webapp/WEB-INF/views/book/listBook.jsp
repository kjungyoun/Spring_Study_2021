<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#btn').on('click', function(){
			pagelist(1);
		})
		<c:if test="${not empty param.key}">
			$('#key').val('${param.key}');
		</c:if>
	})
	function pagelist(cpage){
		$('#pageNo').val(cpage);
		var frm = $('#frm');
		frm.attr('action', 'listBook.do');
		frm.submit();
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<h2>도서 목록</h2>
	<form class="form-inline" id="frm">
		<input type="hidden" name="pageNo" id="pageNo">
		<label for="key">검색 컬럼 :</label>
		<select name="key" id="key">
			<option value="all">전체</option>
			<option value="title">제목</option>
			<option value="author">저자</option>
		</select>
		<label for="word">검색어 : </label>
		<input type="text" class="form-control" placeholder="Enter search word" id="word" name="word" value="${bean.word}">
		<button class="btn btn-primary" id="btn">검색</button>
		
	</form>
	<table	align="center">
		<thead>
			<tr><td colspan="4" align="right"><a href="insertBookForm.do">책 등록 하기</a></td></tr>	
			<tr><td width="150">isbn</td>
				<td width="150">제목</td>
				<td width="100">저자</td>
				<td width="100">출판사</td>
			</tr>
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${not empty list }">
			<c:forEach  var="book"		items="${list}">
				<tr>
					<td width="150">${book.isbn}</td>
					<td width="150"><a href="searchBook.do?isbn=${book.isbn}">${book.title}</a></td>
					<td width="100">${book.author}</td>
					<td width="100">${book.publisher}</td>
				</tr>	
			</c:forEach>
			</c:when>
			<c:otherwise>
				<tr><td colspan="4" style="color: red">조회할 책 목록이 없습니다.</td>
			</c:otherwise>
		</c:choose>
		</tbody>
		<tfoot>
			<tr><td colspan="4" align="center">${bean.pageLink }</td></tr>
		</tfoot>
	</table>
	</div>
</body>
</html>