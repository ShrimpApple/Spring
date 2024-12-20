<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.7.1.min.js"
  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
  crossorigin="anonymous">
</script>
<meta charset="UTF-8">
<title>저장</title>
</head>
<body>
	<form action="/member/save" method="post">
		<p>학번 : <input type="text"  name="id" placeholder="학번" id="id" onblur="idCheck()"></p> 
		<p id="check-result"></p>
		<p>이름 : <input type="text"  name="memberName" placeholder="이름"></p>
		<p>국어 : <input type="text"  name="memberKor" placeholder="국어"></p>
		<p>영어 : <input type="text"  name="memberEngnum" placeholder="영어"></p>
		<p>수학 : <input type="text"  name="memberMatnum" placeholder="수학"></p>
		<input type="submit" value="입력"> <button type="reset">초기화</button>
	</form>
</body>
	<button onClick="index()">메인화면</button>
<script>
	const index = () => {
		location.href = "/";
	}
</script>
<script>

    const idCheck = () => {
        const id = document.getElementById("id").value;
        const checkResult = document.getElementById("check-result");
        console.log("입력한 학번", id);
        $.ajax({
            type: "post",
            url: "/member/id-check",
            data: {
                "id": id
            },
            success: function(res) {
                console.log("요청성공", res);
                if (res == "ok") {
                    console.log("사용가능한 학번");
                    checkResult.style.color = "green";
                    checkResult.innerHTML = "사용가능한 학번";
                } else {
                    console.log("이미 사용중인 학번");
                    checkResult.style.color = "red";
                    checkResult.innerHTML = "이미 사용중인 학번";
                }
            },
            error: function(err) {
                console.log("에러발생", err);
            }
        });
    }
</script>
</html>