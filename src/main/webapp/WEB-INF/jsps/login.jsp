<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进销存管理系统</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/messages_zh.js"></script>

<style type="text/css">
label {
	clear: left;
	color: red;
	margin-top: 13px;
	width: 60px;
	font: 600 10px 宋体;
}
</style>
</head>
<body>
	<div align="center" style="background-color: #e7e7e7; width: 70%;height: 300px;margin:100px auto;padding: 50px " >
		<h2 align="center" >小型进销存系统</h2>
		<form id="userForm">
			用户名：<input type="text" id="username" name="username"><br>
			密码：<input type="password" id="password" name="password"><br>
			<input type="submit" value="登录"><br>
			<b><font color="red" id="message" /></font></b>
		</form>
	</div>
</body>
<script type="text/javascript">
//表单验证
$(function() {
	$("#userForm").validate({
						rules : {
							username : "required",
							password : "required"
						},
						messages : {
							username : "用户名不能为空",
							password : "密码不能为空"
						},
						submitHandler : function() {
							//提交Ajax
							 $.ajax({
										data : $("#userForm").serialize(),
										dataType : "text",
										type : "post",
										url : "${pageContext.request.contextPath}/user/login.do",
										success : function(data) {
											if(data=="0"){
												$("#message").html("用户名或密码错误");
											}else{
												location.href = "${pageContext.request.contextPath}/user/toindex.do"
											}	
										}
									});
						}
					});
})

</script>
</html>