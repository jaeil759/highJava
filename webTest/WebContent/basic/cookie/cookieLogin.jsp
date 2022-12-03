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
		// Cookie에 저장된 ID 정보 가져오기
		String cookieUserId = "";
		String chk = "";
		
		// JSP문서에는 HttpServletRequest객체는 request라는 이름으로 저장되잉ㅆ음
		
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie cookie : cookies){
				if("USERID".equals(cookie.getName())){
					cookieUserId = cookie.getValue();
					chk = "checked";
				}
			}
		}
	%>

	<form action="<%= request.getContextPath() %>/cookieLoginServlet.do" method = "post">
		<table style = "margin : 0 auto;">
			<tr>
				<td> ID : </td>
				<td><input type = "text" name = "userid" value = "<%=cookieUserId %>" placeholder  = "ID를 입력하세요"></td>
				</tr>
				
				<tr>
					<td> Pass : </td>
					<td><input type = "password" name = "pass" placeholder = "Password를 입력하세요"></td>
				</tr>
				
				<tr>
					<td colspan="2"><input type = "checkbox" name = "chkid" value = "check" <%=chk %>>ID 기억하기</td>
				</tr>
				
				<tr>
					<td colspan="2" style = "text-align: center;"><input type = "submit"  value = "login"></td>
				</tr>
				
				
				
				
				
				
					
		</table>
	</form>
</body>
</html>