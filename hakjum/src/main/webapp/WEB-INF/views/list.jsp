<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>리스트</title>
</head>
<body>
    <table>
        <tr>
            <th>학번</th>
            <th>이름</th>
            <th>국어</th>
            <th>영어</th>
            <th>수학</th>
            <th>조회</th>
            <th>삭제</th>
        </tr>
        <c:forEach items="${memberList}" var="member">
            <tr>
                <td>${member.id}</td>
                <td>

                    <a href="/member?id=${member.id}">${member.memberName}</a>
                </td>
                
                <td>${member.memberKor}</td>
                <td>${member.memberEngnum}</td>
                <td>${member.memberMatnum}</td>
                <td>
                    <a href="/member?id=${member.id}">조회</a>
                </td>
                <td>
                    <button onclick="deleteMember('${member.id}')">삭제</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
<script>
    const deleteMember = (id) => {
        console.log(id);
        location.href = "/member/delete?id="+id;
    }
</script>
</html>