<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>관리자 시스템</title>
<script type="text/javascript">
	function goDetail(no) {
		f.no.value = no;
		f.action = "AdsDetail";
		f.submit();
	}

	function goDelete(no) {
		ret = confirm('you sure?');
		if (!ret)
			return;

		f.no.value = no;
		f.action = "AdsDelete";
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
				<td colspan="10" align="right"><a href="AdsAddForm">추 가</a>
				</td>
			</tr>
			<tr bordercolor="#cd853f">

				<th>광고ID</th>
				<th>전화번호</th>
				<th>사진</th>
				<th>사용여부</th>
				<th>하차역</th>
				<th>등록일자</th>
				<th>작업</th>
			</tr>
			<c:forEach var="ads" items="${AdsList}">

				<tr bordercolor="#cd853f">

					<td>${ads.adsId}</td>
					<td>${ads.phone}</td>
					<td><img src="img/${ads.photo}" height="50px">	</td>
					<td>${ads.usable}</td>
					<td>${ads.stoppedName}</td>
					<td>${ads.registerDate}</td>
					<td colspan="2"><input type="button" value="상세 정보" onclick="goDetail('${ads.adsId}')"> 
						<input type="button" value="삭 제" onclick="goDelete('${ads.adsId}')"></td>
				</tr>

			</c:forEach>
			
			<tr bordercolor="#cd853f">
				<td colspan="8">
					<input type="button" value="닫기" onclick="goReturn()">
				</td> 
			</tr>


		</table>
	</form>
</body>
</html>