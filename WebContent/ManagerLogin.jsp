<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������ �ý���</title>
</head>
<script type="text/javascript">
	function checkPs() {
		if (f.id.value == ""){
			alert("����� ID�� �Է��ϼ���.");
		}else if (f.password.value==""){
			alert("��ȣ�� �Է��ϼ���.");
		}
		else {
			f.submit();
		} 
		
	}
</script>
<body bgcolor="#87cefa">
	<form name="f" action="CheckLogin" method="post">

		<br> <br> <br> <br> <br> <br>

		<h1 align="center" ><font color="#ffffff" face="HY�߰��">������ �α���</font></h1><br><br>
		<p align="center"><img src="img/gg.PNG" ></p>
		<br> <br> <br> <br>
		

		<table bgcolor="#f0e68c" border="0" align="center" width="300">


			<tr>
				<td align="center"><font color="#87cefa" face="HY�¹�B" size="5pt">���̵�:</font>
				</td>
				<td><input type="text" name="id">
				</td>
			</tr>
			<tr >
				<td align="center"><font color="#87cefa" face="HY�¹�B" size="5pt">��й�ȣ:</font>
				</td>
				<td><input type="password" name="password" size="21">
				</td>
			</tr>


		</table>
		

		<br> <br>

		<table border="0" align="center">
			<tr>
				<td><input type="submit" value="Ȯ��"> <input
					type="button" onclick="goClose()" value="�ݱ�"></td>
				
		</table>

	</form>
</body>
</html>