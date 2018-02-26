<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
li {
	display: inline;
	font-size: 20px;
	margin-right: 10px;
}

.pro-name-a:link {
	color: gray;
	text-decoration: none;
}

.pro-name-a:visited {
	color: purple;
}

.pro-name-a:hover {
	color: #f56293;
	text-decoration: underline;
}

.pro-name-a:active {
	color: cornflowerblue;
}
</style>
</head>
<body>

	<div
		style="width: 100%; height: 400px; margin: 20px auto; padding: 50px">
		<div><jsp:include page="top.jsp"></jsp:include></div>

		<div align="left" style="margin-top: 50px; width: 100px; float: left;">
			<jsp:include page="left.jsp"></jsp:include>
		</div>
		<div align="left" style="margin-top: 50px; float: left;">

			<table style="margin-left: 200px;" bordercolor="blue">
				<tr>
					<td style="height: 400px; width: 700px;">
						<form action="${pageContext.request.contextPath }/product/toInventory.do">

							<b style="margin-left: 35px;">查看库存:</b> <label
								style="margin-left: 280px;">商品名称:</label> 
						<c:if test="${empty selectProduct}">
						<select id="productId" name="productId">
							<option value="">--请选择商品--
							<c:forEach items="${productList}" var="product">
								<option value="${product.productId}">--${product.productName}--
							</c:forEach>
						</select> 
						</c:if>
						<c:if test="${!empty selectProduct}">
						<select id="productId" name="productId">
							<option value="${selectProduct.productId}">--${selectProduct.productName}--
							<c:forEach items="${productList}" var="product">
								<c:if test="${product.productId!=selectProduct.productId}">
									<option value="${product.productId}">--${product.productName}--
								</c:if>
							</c:forEach>
						</select> 
						</c:if>
						
						<input type="submit" value="查询" style="margin-left: 10px;">
							<div style="height: 330px">
							<c:if test="${!empty selectProduct}">
								<h2 align="center" style="padding-top: 130px">该商品的库存量是:${selectProduct.quantity}</h2>
							</c:if>
							
							
							</div>
						</form>
					</td>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>