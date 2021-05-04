<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="root"	value='${pageContext.request.contextPath}'/>    
<!DOCTYPE html>
<html>
	<head>
	<title>상품 목록 조회</title>
	<meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script type="text/javascript">
		$(function() {
			//검색 버튼에 이벤트 연결
			$('#btn').click(function () {   
				pagelist(1);
			})
			<c:if test='${not empty param.key}'>
		 		$('#key').val('${param.key}')
			</c:if>
		})
		function pagelist(cpage){
			//input 양식의 hidden으로 선언된 page에 요청된 페이지 정보 셋팅 
			$("#pageNo").val(cpage);
			var frm = $("#frm");
			frm.attr('action',"${root}/listProduct");
			frm.submit();
		}
	  </script>
	  
	</head>
	<body>
	<div class="container">
	<jsp:include page="/WEB-INF/views/member/login.jsp"/>
	  <h2>상품 목록</h2>
	  <form class="form-inline"	id='frm'>
	  	  <input type='hidden' name='pageNo' id='pageNo'>
		  <select name='key' id='key'>
		  	<option value='all'>--선택하세요--</option>
		  	<option value='name'>상품명</option>
		  	<option value='price'>상품 가격</option>
		  </select>
		  <input type="text"  class="form-control" placeholder="Enter search word" id="word"  name='word' value='${bean.word}'>
		  <a href='#' class="btn btn-primary"  id='btn'>검색</a>
	  </form>
	  <table class="table table-hover">
	    <thead>
	      <tr>
	        <th>상품번호</th>
	        <th>상품명</th>
	        <th>가격</th>
	      </tr>
	    </thead>
	    <tbody>
	    <c:choose>
	    	<c:when test="${empty list }">
	    		<tr><td colspan="3">조회할 상품 목록이 없습니다.</td>
	    	</c:when>
			<c:otherwise>
				<c:forEach var="product" items="${list}">
					<tr>
					<td>${product.productno}</td>
					<td><a href="${root}/search?productno=${product.productno}">${product.name}</a></td>
					<td>${product.price}</td>
				</c:forEach>
			</c:otherwise>	    	
	    </c:choose>
	    </tbody>
	    <tfoot>
	    	<tr><th colspan='3' align='center'>${bean.pageLink}</th></tr>
	    </tfoot>
	  </table>
	</div>
	</body>
</html>
