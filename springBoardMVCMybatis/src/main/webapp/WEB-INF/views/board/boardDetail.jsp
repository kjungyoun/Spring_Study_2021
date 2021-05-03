<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link  rel="stylesheet" type="text/css" href="css/basic.css"  />
<script type="text/javascript">
	function init(){
		var writeBoard = document.getElementById("writeBoard");
		writeBoard.style.display="none";
		var viewBoard = document.getElementById("viewBoard");
		viewBoard.style.display="";
	}
	function updateForm(){
		var writeBoard = document.getElementById("writeBoard");
		writeBoard.style.display="";
		document.getElementById("viewBoard").style.display="none";
	}
	function updateBoard(){
		var frm = document.getElementById("updatefrm");
		frm.action="boardUpdate.do";
		frm.submit();
	}
	function deleteBoard(){
		var frm = document.getElementById("frm");
		frm.action="boardDelete.do";
		frm.submit();
	}
	function listBoard(){
		location.href="listBoard.do?<%=request.getQueryString()%>";
	}
	function resetBoard(){
		var frm = document.getElementById("updatefrm");
		frm.title.value="";
		frm.content.value="";
	}
</script>
</head>
<body onload="init()">
<jsp:include page="/WEB-INF/views/title.jsp" />
	<article id="content">
	<jsp:include page="/WEB-INF/views/aside.jsp" />
	<article id="mainContent">
    <c:if test="${msg != null }"> 
    	<script type="text/javascript">  alert('${msg}');</script>
    </c:if>
	<div class="main"  id="viewBoard" style="display:none">
	 	<form id="frm"  >
	 	    <input type ="hidden" name="no" value="${board.no}" id="no" />
	 	    <input type ="hidden" name="query" value="<%=request.getQueryString()%>" id="query" />
			<table border="1" align="center">
				<tbody>
					<tr><td><label for="title">제목</label></td>
					    <td>${board.title}</td>
					</tr>
					<tr><td colspan="2">내용 &nbsp;&nbsp;글쓴이:${board.id}
										&nbsp;&nbsp; 게시일:${board.regdate}</td></tr>
					<c:if test="${not empty  board.fileBean}"	>
					  <tr><td>파일</td>
					  <td>									
					<c:forEach  var="file" items='${board.fileBean}'>
						<a href="filedown.do?filename=${file.filename}&rfilename=${file.rfilename}">${file.rfilename}</a><br/>
					</c:forEach>
					</td>								
					</c:if>		
					<tr><td colspan="2"  valign="top" height="200">
							<pre>${board.contents}</pre>
						</td></tr>
				</tbody>
				<tfoot>
					<tr><td colspan="2" align="center">
						<a href="#" onclick="listBoard('frm')">목록</a>
						
							<a href="#" onclick="updateForm()">수정</a>
							<a href="#" onclick="deleteBoard()">삭제</a>
					
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	<div class="main" id="writeBoard" style="display:none">
	 	<form  id="updatefrm">
	 	    <input type ="hidden" name="no" value="${board.no}" id="no" />
	 	    <input type ="hidden" name="query" value="<%=request.getQueryString()%>" id="query" /> 
			<table border="1" align="center">
				<caption>게시글 작성</caption>
				<tbody>
					<tr><td><label for="title">제목</label></td>
					    <td><input type="text" name="title" id="title" value="${board.title}"/></td>
					</tr>
					<tr><td colspan="2">내용</td></tr>
					<tr><td colspan="2">
						<textarea name="content" id="content" cols="30" rows="10">${board.content}</textarea>
						</td></tr>
				</tbody>
				<tfoot>
					<tr><td colspan="2" align="center">
						<a href="#" onclick="updateBoard()"> 수정 </a> 
						<a href="#" onclick="resetBoard()"> 다시 쓰기</a> 
						<a href="#" onclick="listBoard()">목 록</a>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	</article>
	<jsp:include page="/WEB-INF/views/copyright.jsp" />
</body>
</html>