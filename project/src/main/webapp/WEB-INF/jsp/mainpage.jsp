<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>ȸ�� ���� ������(Ʋ �ϼ�)</h1>

	<form action="userInfoInsert.do" method="post" id="vdForm">

		<div id="checkId">
			<input type="text" id="id" name="userid" onkeydown="inputIdChk()">
			<button type="button" id="btn1" onclick="checkValue()">���̵�
				Ȯ��</button>
			<input type="hidden" id="idcheck" value="idUncheck">
			<div id="result"></div>
		</div>

		<div id="checkPw">

			<input type="text" id="userpw" name="userpw" onkeydown="inputPwChk()">
			<input type="text" id="checkuserpw" name="checkuserpw"
				onkeydown="inputPwChk()">

			<button type="button" id="btn2">��й�ȣ Ȯ��</button>

			<input type="hidden" id="pwcheck" value="pwUncheck">

			<div id="result2"></div>

		</div>

		<div>
			<button type="button" id="signin">ȸ������</button>

		</div>
	</form>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$('#btn1').on('click', function() { //���̵� �ߺ� üũ
		$.ajax({
			url : '/validationID.do',
			type : 'POST',
			data : $("#id").serialize(),
			success : function(data) {
				var check = data;
				if (check == 'TRUE') {
					document.getElementById('idcheck').value = 'checked';
					$('#result').text('��� ���� ���̵�');
				} else {

					$('#result').text('�̹� ������� ���̵�');
				}
			},
			error : function() {
				alert("error!");
			}

		});
	});

	function inputIdChk() { // ���̵� ���Է� üũ 
		document.getElementById('idcheck').value = 'idUncheck';
	}

	function inputPwChk() {
		document.getElementById('pwcheck').value = 'pwUncheck';
	}

	$('#btn2').on('click', function() {
		$.ajax({
			url : '/validationPW.do',
			type : 'POST',
			data : $('#userpw, #checkuserpw').serialize(), //�������� �Ķ���� ������
			success : function(data) {
				var check = data;
				if (check == 'TRUE') {
					document.getElementById('pwcheck').value = 'checked';
					$('#result2').text('��й�ȣ ��ġ');
				} else {
					$('#result2').text('��й�ȣ ����ġ');
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
			alert('���̵� �ߺ�üũ');
		} else if (pwflag == 'pwUncheck') {
			alert('��й�ȣ ����ġ');
		}
	});
</script>
</html>