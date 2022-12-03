<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		// Session값을 확인해서 로그인 여부에 따라 다른 내용이 출력되도록 한다.
		// JSP문서에서는 HttpSession객체는 'session'이라는 이름으로 이미 만들어져있다.
		
		String loginId = (String)session.getAttribute("loginID"); // 세션값 읽기
	%>
	<%
		if(loginId == null){  
	%>
	
	<form action="<%= request.getContextPath() %>/sessionLogin.do" method = "post">
		<table style = "margin : 0 auto;" border = "1">
			<tr>
				<td> ID : </td>
				<td><input type = "text" name = "userid" placeholder  = "ID를 입력하세요"></td>
				</tr>
				
				<tr>
					<td> Pass : </td>
					<td><input type = "password" name = "pass" placeholder = "Password를 입력하세요"></td>
				</tr>
				
				
				<tr>
					<td colspan="2" style = "text-align: center;"><input type = "submit"  value = "login"></td>
				</tr>
				</table>
	</form>
	
	<%
		}else{
	%>
		<h3><%=loginId %> 님 반갑습니다.</h3>
		<a href="<%=request.getContextPath() %>/sessionLogout.do">로그아웃</a>
		
	<%
		}
	%>
	
	
	
</body>
</html>