<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 시스템</title>

<script type="text/javascript">
	function goUpdate(no) {
		f.no.value = no;
		f.action = "ManagerUpdateForm";
		f.submit();
	}

	function goDelete(no) {
		ret = confirm('you sure?');
		if (!ret)
			return;

		f.no.value = no;
		f.action = "ManagerDelete";
		f.submit();
	}
	
	function goReturn() {
	
		f.action = "TemplatePage.jsp";
		f.submit();
	}
</script>
</head>
<body>



	<form name="f" method="post">
		<input type="hidden" name="no">

		<table border="1" bordercolor="#cd853f">
		
			<tr bordercolor="#cd853f">
				<td colspan="10" align="right"><a href="ManagerAddForm">추 가</a></td>
			</tr>
			<tr bordercolor="#cd853f">
				
				<th>관리자ID</th>
				<th>이름</th>
				<th>신분증번호</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>관리자여부</th>
				<th>사용여부</th>
				<th>작업</th>
				<th></th>
			</tr>
			<c:forEach var="manager" items="${ManagerList}" >
			
				<tr bordercolor="#cd853f">
					
					<td>${manager.managerId}</td>
					<td>${manager.name}</td>
					<td>${manager.identification}</td>
					<td>${manager.phone}</td>
					<td>${manager.address}</td>
					<td>${manager.degree}</td>
					<td>${manager.usable}</td>
					
					<td colspan="2"><input type="button" value="수 정" onclick="goUpdate(${manager.managerId})">
						 <input type="button" value="삭 제" onclick="goDelete(${manager.managerId})">
						 </td>
				</tr>
				
			</c:forEach>
			
			<tr bordercolor="#cd853f">
				<td colspan="10" align="right">
					<input type="button" value="닫기" onclick="goReturn()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>