<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	欢迎,${sessionUser.realname}! <a href="javascript:void(0)" onclick="logout()">退出登录</a>
</body>
<script type="text/javascript">
	function logout(){
		if(confirm("确定要退出系统吗?")){
			location.href="${pageContext.request.contextPath}/user/logout.do";
		}
	}
</script>
</html>