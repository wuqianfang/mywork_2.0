﻿<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ include file="/common/currency.jsp"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8">
<title>用户登录</title>
<style type="text/css">
*{
	margin:0px;
	padding:0px;
}
html,body{
	height:90%;
 	background-size: 100%; 
}

.container {
  width: 310px;
  margin: 100px auto;
  height: 100%;
  padding: 10px 60px;
  border-radius: 4px;
   box-shadow: 0 0 15px #4E4E4E; 
}

input {
  display: block;
  width: 290px;
  line-height: 40px;
  margin: 10px 0;
  padding: 0 10px;
  outline: none;
  border:1px solid #c8cccf;
  border-radius: 4px;
  color:#6a6f77;
  text-align: center;
}

#login-error {
	text-align: center;
	font-size: 20px;
}

button {
  line-height: 40px;
  margin: 10px 10px;
  border:2px solid #c8cccf;
  border-radius: 4px;
  color:green;
  font-size:25px;
  background-color:transparent;
   box-shadow: 0 0 15px #4E4E4E;
  text-align: center;
}

h1 {
	text-align: center;
}

#div-a {
	height: 30px;
	font-size: 20px;
	color: white;
}
#div-a a{
	padding-left: 50px;
}
</style>

<script src="${ctx}/js/jquery-1.8.2.min.js"></script>
<link rel="stylesheet" href="${ctx}/css/jigsaw.css">
<jsp:include page="login-script.jsp" />
</head>

<body style="background-image: url(${ctx}/img/backgrounds-login/0.jpg)">
<form id="inputForm" action="${ctx}/user/sign-in" method="post" style="float:inherit; ">
<div class="container" >
<h1>登陆页面</h1>
	<input type="text" id="username" name="username" class="username" placeholder="请输入用户名" required="required">
	<input type="password" id="password" name="password" class="password"  placeholder="请输入密码" required="required">
	<div id="captcha" style="position: relative"></div>
	<button type="submit" style="width: 290px;">登录</button>
	<div id="div-a"><p><a href="${ctx}/user/adduser">创建账号</a><a href="${ctx}/user/adduser">找回密码</a></p></div>
	<div id="login-error" style="color: #F00">${requestScope.message}</div>
</div>
</form>
<script type="text/javascript" src="${ctx}/js/jigsaw.js"></script>
	<script type="text/javascript">
		jigsaw.init(document.getElementById('captcha'), function () { 
			isValidation = true; 
			$("#login-error").css("color","green").text("验证完成");
		}) 
	</script> 
</body>
</html>


