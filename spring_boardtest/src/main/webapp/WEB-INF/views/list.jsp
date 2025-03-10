<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
<table>
	<tr>
		<th>id</th>
		<th>title</th>
		<th>writer</th>
		<th>date</th>
		<th>hits</th>
	</tr>
	<c:forEach items="${boardList}" var="board">
		<tr>
			<td>${board.id}</td>
			<td>
				<a href="/board?id=${board.id}">${board.boardTitle}</a>
			</td>
			<td>${board.boardWriter}</td>
			<td>${board.boardCreatedTime}</td>
			<td>${board.boardHits}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>