<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입 페이지(틀 완성)</h1>

	<form action="userInfoInsert.do" method="post" id="vdForm">

		<div id="checkId">
			<input type="text" id="id" name="userid" onkeydown="inputIdChk()">
			<button type="button" id="btn1" onclick="checkValue()">아이디
				확인</button>
			<input type="hidden" id="idcheck" value="idUncheck">
			<div id="result"></div>
		</div>

		<div id="checkPw">

			<input type="text" id="userpw" name="userpw" onkeydown="inputPwChk()">
			<input type="text" id="checkuserpw" name="checkuserpw"
				onkeydown="inputPwChk()">

			<button type="button" id="btn2">비밀번호 확인</button>

			<input type="hidden" id="pwcheck" value="pwUncheck">

			<div id="result2"></div>

		</div>

		<div>
			<button type="button" id="signin">회원가입</button>

		</div>
	</form>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$('#btn1').on('click', function() { //아이디 중복 체크
		$.ajax({
			url : '/validationID.do',
			type : 'POST',
			data : $("#id").serialize(),
			success : function(data) {
				var check = data;
				if (check == 'TRUE') {
					document.getElementById('idcheck').value = 'checked';
					$('#result').text('사용 가능 아이디');
				} else {

					$('#result').text('이미 사용중인 아이디');
				}
			},
			error : function() {
				alert("error!");
			}

		});
	});

	function inputIdChk() { // 아이디 재입력 체크 
		document.getElementById('idcheck').value = 'idUncheck';
	}

	function inputPwChk() {
		document.getElementById('pwcheck').value = 'pwUncheck';
	}

	$('#btn2').on('click', function() {
		$.ajax({
			url : '/validationPW.do',
			type : 'POST',
			data : $('#userpw, #checkuserpw').serialize(), //여러개의 파라미터 보낼때
			success : function(data) {
				var check = data;
				if (check == 'TRUE') {
					document.getElementById('pwcheck').value = 'checked';
					$('#result2').text('비밀번호 일치');
				} else {
					$('#result2').text('비밀번호 불일치');
				}
			},
			error : function() {
				alert("error!");
			}

		});
	});

	$('#signin').on('click', function() {
		var idflag = document.getElementById('idcheck').value;
		var pwflag = document.getElementById('pwcheck').value;

		if (idflag == 'checked' && pwflag == 'checked') {
			vdForm.submit();
		} else if (idflag == 'idUncheck') {
			alert('아이디 중복체크');
		} else if (pwflag == 'pwUncheck') {
			alert('비밀번호 불일치');
		}
	});
</script>
</html>