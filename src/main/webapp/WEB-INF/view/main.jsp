<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<style>
ul li {
	list-style: none;
}

a {
	text-decoration: none;
	color: #333;
}

#menu {
	width: 100%;
	height: 50px;
	background: #ccc;
	color: skyblue;
	line-height: 50px;
	margin: 0 auto;
	text-align: center;
}

#menu>ul>li {
	float: left;
	width: 20%;
	position: relative;
}

#menu>ul>li>ul {
	width: 90%;
	display: none;
	position: absolute;
	font-size: 18px;
	background: gray;
	text-alian: center;
}

#menu>ul>li:hover>ul {
	display: block;
}

#menu>ul>li>ul>li:hover {
	background: white;
	transition: ease 1s;
}

#formsearch {
	margin: 50px float: right;
}
</style>
</head>
<body>
	<div id="formsearch">
		<c:choose>
			<c:when test="${empty login}">
				<a href='/user/login'>로그인</a>
			</c:when>
			<c:otherwise>
					<c:out value ="${nickname }"></c:out>님 환영합니다.   <a href='/user/logout'>로그아웃</a>
			</c:otherwise>
		</c:choose>

		<form action="/board/showselect" method="POST">
			<input type="text" placeholder="검색어를 입력해주세요."
				onfocus="this.placeholder = ''"
				onblur="this.placeholder= '검색어를 입력해주세요'" name="search_box">
			<button type="submit" class="">대충사진</button>
		</form>
	</div>

	<div id="menu">
		<ul>
			<li><a href="#none">카테고리</a>
				<ul>
					<li><a href="board/category/1">가전제품</a></li>
					<li><a href="board/category/2">자동차</a></li>
					<li><a href="board/category/3">PC</a></li>
				</ul></li>
		</ul>
	</div>
	<!-- main -->
	<div class="">
		<p>내용 들어갈 공오오오옹오오옹간</p>
	</div>
</body>
</html>