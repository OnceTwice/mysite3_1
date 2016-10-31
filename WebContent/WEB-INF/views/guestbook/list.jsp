<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
	<title>mysite</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="${pageContext.request.contextPath }/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
	
		<c:import url="/WEB-INF/views/includes/header.jsp"/>
		
		<div id="content">
			<div id="guestbook">
				<h1 id="h1">방명록</h1>
				
				<form action="${pageContext.request.contextPath }/guestbook?a=add" method="post">
					<input type="hidden" name="a" value="insert">
					<table class="tbl-ex">
						<tr>
							<td>이름</td><td><input type="text" name="name" placeholder="이름을 쓰세요"></td>
							<td>비밀번호</td><td><input type="password" name="pass" placeholder="비밀번호를 쓰세요"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content"></textarea></td>		<!-- 글내용 -->
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				
				<ul>
				
				<c:forEach items="${list }" var="vo">
					<li>
						<table>
							<tr>
								<td>${vo.no }</td>
								<td>${vo.name }</td>
								<td>${vo.date }</td>
								<td><a href="${pageContext.request.contextPath }/guestbook?a=deleteform&no=${vo.no }">삭제</a></td>
							</tr>
							<tr>
								<td colspan=4>${vo.content }</td>
							</tr>
						</table>
						<br>
					</li>
				</c:forEach>

				</ul>
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value="main"/>
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp"/>
		
	</div>
</body>
</html>