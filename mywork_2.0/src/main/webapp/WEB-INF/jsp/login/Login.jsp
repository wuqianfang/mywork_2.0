<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/currency.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Work Login</title>
<link rel="stylesheet" href="${ctx}/css/jigsaw.css">
<style>
html,body {
  background-size: 100%;
  background-image: url(${ctx}/images/1.jpg);
}
.container {
  width: 310px;
  margin: 100px auto;
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
}
#msg {
  width: 100%;
  line-height: 40px;
  font-size: 14px;
  text-align: center;
}
a:link,a:visited,a:hover,a:active {
  margin-left: 100px;
  color: #0366D6;
}
</style>


</head>
<body>

<div class="container">
	<input value="admin" readonly/>
	<input type="password" value="1234567890" readonly/>
	<div id="captcha" style="position: relative"></div>
	<div id="msg"></div>
</div>

<script type="text/javascript" src="${ctx}/js/jigsaw.js"></script>
<script type="text/javascript">
jigsaw.init(document.getElementById('captcha'), function () {
	document.getElementById('msg').innerHTML = '登录成功！'
})
</script>

</body>
</html>