<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form action="/member/login" method="post">
	<input type="text" name="id" placeholder="학번">
	<input type="text" name="memberName" placeholder="이름">
	<input type="submit" value="로그인">
</form>
</body>
</html>