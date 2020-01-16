<%@ page contentType="text/html;charset=UTF-8" import="java.util.*"%>
<%@ include file="/common/currency.jsp"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<title>我的博客</title>
<style type="text/css">
* {
		margin: 0px;
		padding: 0px;
}
 	html,body{ 
 		width:1920px; 
 		height: 100%; 
 	}

</style>
</head>

	
<body>

<!-- 主体 -->
<div id="body-center-div" style="height: 100%;width: 100%;">
<div style="height: 30px;background-color: black;"></div>
<!-- 左栏 -->
	<div style="width: 300px;display:inline-block;height:calc(100% - 30px);float: left;">
	<div style="text-align: center;padding-top: 10px;">
	       <img alt="" src="${ctx}/img/headportrait/top1.jpg" style="width:200px;" onclick="">
	</div>
	<div>
	<p style="text-align: center;">
		<a style="float: left;width: 50%">星级:</a><a style="float: left;width: 50%;text-align: left;">MAX</a></br>
		<a style="float: left;width: 50%">姓名:</a><a style="float: left;width: 50%;text-align: left;">${LOGIN_USER.username }</a></br>
		<a style="float: left;width: 50%">邮箱:</a><a style="float: left;width: 50%;text-align: left;">${LOGIN_USER.email }</a></br>
	</p>
	
	</div>
	<div>
	</div>
	</div>
	<!-- 右栏 -->
	
	<div style="display: inline-block;background-color: green;width: calc(100% - 310px);height:calc(100% - 30px); ">
	
	</div>
</div>


</body>

</html>


