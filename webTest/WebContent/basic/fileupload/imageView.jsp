<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>IMG태그의 src속성에 Servlet으로 처리하기</h3>
	<img src = "../images/별빛등대.png" width="300"><br><br>
	<img src = "<%=request.getContextPath() %>/basic/images/별빛등대.png" width="300"><br><br>
	<img src = "<%=request.getContextPath() %>/images/imageView.do?fileno=3" width="300"><br><br>
	
</body>
</html>