<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ include file="/common/currency.jsp"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="utf-8">
<title>创建账号</title>
<script src="${ctx}/assets/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">

// 	//手机号码验证
// 	var TEL_PHONE =/^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/;
// 	function validateTel1 (obj){
// 		var value=obj['value'];
// 		if(TEL_PHONE.test(value)){
// 			return;
// 			}
// 		$(obj).val("");
// 		return;
// 	}
// 	//用户名验证 
// 	var TEL_USERNAME =[A-Za-z0-9]{5,15};
// 	function validateTel2(obj) {
// 		var value=obj['value'];
// 		if(TEL_USERNAME.test(value)){
// 			return;
// 			}
// 		$(obj).val("");
// 		return;
// 	}
// 	//密码验证 
// 	var TEL_PASSWORD =[A-Za-z0-9]{6,12};
// 	function validateTel3(obj) {
// 		var value=obj['value'];
// 		if(TEL_PASSWORD.test(value)){
// 			return;
// 			}
// 		$(obj).val("");
// 		return;
// 	}
// 	//密码验证 
// 	var TEL_PASSWORD =[A-Za-z0-9]{6,12};
// 	function validateTel3(obj) {
// 		var value=obj['value'];
// 		if(TEL_PASSWORD.test(value)){
// 			return;
// 			}
// 		$(obj).val("");
// 		return;
// 	}
// 	function validata(obj) {
// 		var val=$("input[name='password']").val();
// 		if(!val){
// 			$(obj).val("");
// 		}
// 	}
// 	//密码验证 
// 	function validateTel4(obj) {
// 		var value=obj['value'];
// 		if(TEL_PASSWORD.test(value)){
// 			var val=$("input[name='password']").val();
// 			if(val!=value){
// 				alert("密码不同");
// 			}else{
				
// 			}
// 			}else{
// 				alert("不符合规则");
// 				$(obj).val("");
// 			}
// 	}
// 	//密码验证 
// 	var TEL_EMAIL =[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$;
// 	function validateTel5(obj) {
// 		var value=obj['value'];
// 		if(TEL_EMAIL.test(value)){
// 			return;
// 			}
// 		$(obj).val("");
// 		return;
// 	}
	
</script>
<style type="text/css">
	input{
		autocomplete:"off";
	}
</style>
</head>

<body>
	<div>
		<h1>创建账号</h1>
		<form action="${ctx}/user/insert.htm" method="post">
			<input type="text" id="username" name="username"  placeholder="请输入用户名" value='${requestScope.user.username }' ></br>
			<input type="password" id="password" name="password"  placeholder="请输入密码" value='${requestScope.user.password }' ></br>
			<input type="password" id="verification" name="verification"  value='${requestScope.user.password }' placeholder="再次确认密码"   ></br>
			<input type="text" id="email" name="email" placeholder="邮箱" value='${requestScope.user.email }' ></br>
			<input type="text" id="phone" name="phone" placeholder="手机号码" value='${phone }' ></br>
			<button type="submit">提交</button>
			<div  style="color: #F00">${requestScope.message}</div>
		</form>
	</div>

</body>

</html>


