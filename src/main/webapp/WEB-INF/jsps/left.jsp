<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/css/dtree.css">
<title>Insert title here</title>
<style type="text/css">
.left_a {
	display:block;
}
</style>
</head>
<body>
	<a class="left_a" href="${pageContext.request.contextPath }/sale/sale.do">销售</a>
	<br>
	<a class="left_a" href="${pageContext.request.contextPath }/sale/saleinfo.do?currentPage=1">销售信息查询</a>
	<br>
	<a class="left_a" href="${pageContext.request.contextPath }/product/toInventory.do">查看库存</a>
	<br>
</body>
</html>