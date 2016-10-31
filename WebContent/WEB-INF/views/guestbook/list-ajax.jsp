<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>mysite</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="${pageContext.request.contextPath }/assets/css/guestbook.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
	<script>
		var isEnd = false;
		var page = 0;
		
		var render = function(vo) {
			// console.log(vo);
			var htmls = "<li>" +
							"<table>" + 
								"<tr>" + 
									"<td>"+ vo.name + "</td>" + 
									"<td>"+ vo.content +"</td>" +
									"<td>"+ vo.regDate+"</td>" +
									"<td><a href=''>삭제</a></td>" +
								"</tr>"+
								"<tr>"+
									"<td colspan=4>11111111</td>"+
								"</tr>"+
							"</table>"+
							"<br>"+
						"</li>";		// js template library -> ejs
						$("#list-guestbook").append(htmls);
		}
		
		var fetchList = function() {
			if(isEnd == true) {
				return;
			}
			++page;
			$.ajax({
				url : "${pageContext.request.contextPath }/api/guestbook?a=ajax-list&p=" + page,
				type : "get",
				dataType : "json",
				data : "",
				success : function(response) {
					if(response.result != "success") {
						console.error(response.message);
						isEnd = true;
						return;
					}
					
					// rendering
					$(response.data).each(function(index, vo) {
						render(vo);
									
					});
					
					if(response.data.length < 5) {
						isEnd = true;
						$("#btn-fetch").prop("disabled", true);
					}
				},
				
				error : function(jqXHR, status, e) {
					console.error(status +  " : " + e );
				}
			});
		}
		
		$(function() {
			$("#add-form").submit(function() {
				event.preventDefault();
				
				// ajax insert
				
			});
			
			$(window).scroll(function() {
				var $window = $(this);
				var scrollTop = $window.scrollTop();
				var windowHeight = $window.height();
				var documentHeight = $(document).height();
				
				// 스크롤바가 바닥까지 왔을 때(20px 덜 왔을 때)
				if(scrollTop + windowHeight + 20 > documentHeight) {
					// console.log("call fetchList");
					fetchList();
				}
				// console.log($window.scrollTop);
				// console.log(scrollTop + " : " + windowHeight + " : " + documentHeight);
			});
			$("#btn-fetch").click(function() {
				fetchList();
			});
			
			// 1번째 리스트 가져오기
			fetchList();
		});
	</script>
</head>
<body>
	<div id="container">
	
		<c:import url="/WEB-INF/views/includes/header.jsp"/>
		
		<div id="content">
			<div id="guestbook">
				<h1 id="h1">방명록</h1>
				
				<form id="add-form" action="${pageContext.request.contextPath }/guestbook?a=add" method="post">
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
				<!-- 
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
				 -->
				</ul>
				
				<ul id="list-guestbook"></ul>
				
				<button id="btn-fetch" style="margin:20px;"> 가져오기 </button>
				
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value="guestbook-ajax"/>
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp"/>
		
	</div>
</body>
</html>