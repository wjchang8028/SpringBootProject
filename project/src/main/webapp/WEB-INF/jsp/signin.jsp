<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인페이지</h1>

	<form action="userInfoInsert.do" method="post">
		<input type="text" id="id" name="userid">
		<button type="button" id="btn1">아이디 확인</button>
		<div id="result"></div>
		<input type="text" name="userpw" placeholder="pw">
		
		
		<input type="text" name="signData">
		<button type="submit">회원가입</button>
	</form>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$('#btn1').on('click', function() {
		$.ajax({
			url : '/validation.do',
			type : 'POST',
			data : $("#id").serialize(),
			success : function(data) {
				$('#result').text(data);
			},
			error : function() {
				alert("error!");
			}

		});
	});
</script>
</html>