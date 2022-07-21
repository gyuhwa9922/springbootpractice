<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title></title>
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
	<div class="container">
	
	</div>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>글 제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>수정일</th>
				</tr>
			</thead>

			<c:forEach items="${list}" var="b">
				<tr onclick="location.href='/board/selectOne/${b.id }'">
					<td>${b.title }</td>
					<td>${nicknameMap[b.writerId] }</td>
					<td><fmt:formatDate value="${b.writtenDate.time }"
							pattern="yy-MM-dd HH:mm:ss" /></td>
					<td><fmt:formatDate value="${b.updatedDate.time }"
							pattern="yy-MM-dd HH:mm:ss" /></td>
				</tr>
			</c:forEach>
		</table>
		<div class="row">
			<div class="col-md-3" style="float: none; margin: 0 auto;">
				<a href="/board/category/${id }/1"> [<c:out value="<<"></c:out>]
				</a>
				<c:choose>
					<c:when test="${currentPage < 3}">
						<c:forEach begin="1" end="5" var="i">
							<c:choose>
								<c:when test="${i ne currentPage }">
									<a href="/board/category/${id }/${i }">${i }</a>
								</c:when>
								<c:otherwise>
									<a>${i }</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:when>


					<c:when test="${currentPage >=3 and currentPage < lastPageNo-2 }">
						<c:forEach begin="${currentPage -2 }" end="${currentPage + 2 }"
							var="i">
							<c:choose>
								<c:when test="${i ne currentPage }">
									<a href="/board/category/${id }/${i }">${i }</a>
								</c:when>
								<c:otherwise>
									<a>${i }</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>

						<c:forEach begin="${lastPageNo -4 }" end="${lastPageNo }" var="i">
							<c:choose>
								<c:when test="${i ne currentPage }">
									<a href="/board/category/${id }/${i }">${i }</a>
								</c:when>
								<c:otherwise>
									<a>${i }</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>

					</c:otherwise>
				</c:choose>
				<a href='/board/category/${id }/${lastPageNo }'> [>>] </a>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<div class="btn btn-primary"
					onclick="location.href = '/board/write/category/${id }'">글 작성하기</div>
			</div>
		</div>
	</div>
</body>
</html>