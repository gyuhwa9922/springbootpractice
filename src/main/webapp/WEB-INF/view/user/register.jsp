<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<style>
html, body {
	height: 100%;
}

body {
	display: flex;
	align-items: center;
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
}
</style>
<title>Insert title here</title>
</head>
<body>
<main class="form-signin w-100 m-auto">
		<form action="/user/register" method="post">
			<div class="mb-6">
				아이디: <input type="text" name="username" class="form-control">
			</div>
			<div class="mb-6">
				비밀번호: <input type="password" name="password" class="form-control">
			</div>
			<div class="mb-6">
				닉네임: <input type="text" name="nickname" class="form-control">
			</div>
			<div class="row justify-content-center">
				<div class="col-6">
					<button type="submit" class="btn btn-primary">회원 가입하기</button>
				</div>
			</div>
		</form>
	</main>
</body>
</html>