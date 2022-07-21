<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>작성자: ${nickname }</th>
		</tr>

		<tr>
			<th>글 제목: ${b.title }</th>
		</tr>
		<tr>
			<th>${b.content }</th>
		</tr>
		<tr>
			<th>작성일: <fmt:formatDate value="${b.writtenDate.time }"
					pattern="yyMMdd HH:mm:ss" /></th>
		</tr>
		<tr>
			<th>수정일: <fmt:formatDate value="${b.updatedDate.time }"
					pattern="yyMMdd HH:mm:ss" /></th>
		</tr>
	</table>
	<c:if test="${b.writerId eq logInId }">
		<a href="/board/update/${b.id }">수정하기</a>
		<a href="/board/delete/${b.id }">삭제하기</a>
	</c:if>
	<br />
	<a href="/board/category/${categoryId }/1">목록으로</a>
	<div>
		<form action="/reply/selectOne/${id }" method="POST">
			<input type="text" name="content"
				placeholder="타인의 권리를 침해하거나 명예를 훼손하는 댓글은 운영원칙 및 관련 법률에 제재를 받을 수 있습니다.
				Shift+Enter 키를 동시에 누르면 줄바꿈이 됩니다"
				onfocus="this.placeholder = ''"
				onblur="this.placeholder= '
				타인의 권리를 침해하거나 명예를 훼손하는 댓글은 운영원칙 및 관련 법률에 제재를 받을 수 있습니다.
				Shift+Enter 키를 동시에 누르면 줄바꿈이 됩니다'">
			<button type="submit">등록</button>
		</form>
		<table>
			<thead>
				<tr>
					<th>작성자</th>
					<th>댓글 내용</th>
				</tr>
			</thead>
			<c:forEach items="${r }" var="r">
				<tr>
					<td>${nicknameMap[r.writerId] }</td>
					<td>${r.content }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>















