<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request 연습</title>
</head>
<body>
<%-- 	<h2>Request연습 Form(숫자 입력은 정수형으로 입력하세요)</h2><br><hr><br>
	<form action="/webTest/requestTest02.do" method = "GET">
	<input type = "text" size = "20" name = "number1">
	<select name = "operator">
		<option value = "+">+</option>
		<option value = "-">-</option>
		<option value = "*">*</option>
		<option value = "/">/</option>
	</select>
	<input type = "text" size = "20" name = "number2">
	<input type = "submit" value = "확인">
	</form>--%>
	<h3>Request 연습 Form(입력은 정수형으로...)</h3>
	<form action = "/webTest/requestTest02.do" method = "GET">
		<table>
		<tr>
			<td><input type = "text" size = "10" name = "num1"></td>
			<td>
				<select name = "op">
					<option value = "+">+</option>
					<option value = "-">-</option>
					<option value = "*">*</option>
					<option value = "/">/</option>
					<option value = "%">%</option>
				</select>
			</td>
			<td><input type = "text" size = "10" name = "num2"></td>
			<td><input type = "submit" value = "확인"></td>
		</tr>
		
		</table>
	
	
	</form>
	
	
</body>
</html>