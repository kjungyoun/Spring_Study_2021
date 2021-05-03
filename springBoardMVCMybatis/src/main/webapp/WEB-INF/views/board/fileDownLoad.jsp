<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/basic.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/title.jsp" />
	<article id="content">
		<jsp:include page="/WEB-INF/views/aside.jsp" />
		<article id="mainContent">
  <form method="post" action="filedown.do">
  	<input type="hidden" name="realFileName" value="${realFileName}">
  	<input type="hidden" name="fileName" value="${fileName}">
  	${fileName}
  	<input type="submit"  value="다운 받기">
  </form>
  <%-- <a href="filedown.do?realFileName=${realFileName}&fileName=${fileName}">${fileName}</a> --%>
  <a href="../upload/${realFileName }">${fileName}</a>

  </article>
	<jsp:include page="/WEB-INF/views/copyright.jsp" />
</body>
</html>







