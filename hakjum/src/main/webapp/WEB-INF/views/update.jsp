<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
</head>
<body>
    <form action="/member/update" method="post" name="updateForm">
        <p>학번: <input type="text" name="id" id="id"></p>
        <p>이름: <input type="text" name="memberName" value="${member.memberName}" disabled></p>
        <p>국어: <input type="text" name="memberKor" value="${member.memberKor}"></p>
        <p>영어: <input type="text" name="memberEngnum" value="${member.memberEngnum}"></p>
        <p>수학: <input type="text" name="memberMatnum" value="${member.memberMatnum}"></p>
        <input type="button" value="수정" onclick="update()">
    </form>
    <button onClick="index()">메인화면</button>
    <button onclick="deleteMember('${member.id}')">삭제</button>

<script>
    const index = () => {
        location.href = "/";
    }

    const update = () => {
        const idDB = '${member.id}';  // 서버에서 넘어온 학번 값
        const id = document.getElementById("id").value;  // 입력된 학번 값
        if (idDB === id) {  // 학번이 일치하면 폼을 제출
            console.log("학번 일치");
            console.log("입력된 학번: ", id);
            document.updateForm.submit();  // 폼을 서버로 전송
        } else {
            alert("학번이 일치하지 않습니다!");
        }
    }

    const deleteMember = (id) => {
        console.log("삭제할 학번: ", id);
        location.href = "/member/delete?id=" + id;
    }
</script>

</body>
</html>
