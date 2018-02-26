<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
					<form id="addSaleForm" >
						<h3 align="center">添加销售</h3>
						<label  style="margin-left: 250px; color: black;">商品名称：</label>
						<select id="productId" name="productId">
							<option value="">--请选择商品--
							<c:forEach items="${productList}" var="product">
								<option value="${product.productId}">--${product.productName}--
							</c:forEach>
						</select><br>
						<label style="margin-left: 250px; color: black;">销售单价：</label>
						<input type="text" name="price" id="price">
						<br><label style="margin-left: 250px; color: black;">销售数量：</label>
						<input type="text" name="quantity" id="quantity">
						<input type="hidden" name="uid" id="uid" value="${sessionUser.uid}">
						<br><input style="margin-left: 350px" type="submit" value="保存">
					</form>
					</td>
				</tr>
			</table>

		</div>
	</div>
</body>
<script type="text/javascript">
//表单验证
$(function() {
	$("#addSaleForm").validate({
						rules : {
							productId : "required",
							price : "required",
							quantity : "required"
							
						},
						messages : {
							productId : "商品不能为空",
							price : "价格不能为空",
							quantity : "数量不能为空"
						},
						submitHandler : function() {
							//提交Ajax
							 $.ajax({
										data : $("#addSaleForm").serialize(),
										dataType : "text",
										type : "post",
										url : "${pageContext.request.contextPath}/sale/addSale.do",
										success : function(data) {
											if(data=="1"){
												alert("添加成功");
												location.reload();
											}else{
												alert("添加失败");
											}	
										}
									});
						}
					});
})

</script>
</html>