<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div {
	padding: 4px;
	height: 100%;
	background-color: rgb(234, 247, 247);
	margin-left: auto;
	margin-right: auto;
	border-radius: 5px;
}

input[type=text] {
	height: 30%;
	width: 90%;
	border-radius: 3px;
}

textarea {
	height: 400px;
	width: 90%;
	margin: 1px 1px;
	resize: none;
	font-size: 30px;
}

button {
	width: auto;
	background-color: #4CAF50;
	color: white;
	padding: 10px 50px;
	margin: auto;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	display: block;
}

div.center {
	width: 100%;
	border: none;
	text-align: center;
	border-radius: 5px;
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
<body>
	<div>
		<div>
				<h1 style="text-align: center;">게시판 글작성</h1>
		</div>
		<form action="/board/write/category/${id}" method="post">
		<div class="center">
			<input type="text"name="title"
				placeholder="제목을 입력해주세요." onfocus="this.placeholder = ''"
				onblur="this.placeholder= '제목을 입력해주세요'">
		</div>
		<div class="center">
			<textarea name="content"
				placeholder="내용을 입력해주세요." onfocus="this.placeholder = ''"
				onblur="this.placeholder= '내용을 입력해주세요'" maxlength="800"></textarea>
			<!-- <input type="file" id="cos_write_file" name="cos_write_file"><br> -->
			<button type="submit">등록</button>
		</div>
		</form>
	</div>
</body>
</html>
























