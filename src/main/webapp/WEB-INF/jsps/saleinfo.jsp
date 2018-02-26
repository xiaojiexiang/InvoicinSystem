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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js" ></script>
		<script>
			$(function(){
				$(".saletable tr:even").css("background-color","#8e8e8e");
				$(".saletable tr:odd").css("background-color","#e7e7e7");
			});
		</script>
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
						<form action="${pageContext.request.contextPath }/sale/saleinfo.do?currentPage=1">

							<b style="margin-left: 35px;">销售信息查询:</b> <label
								style="margin-left: 280px;">排序方式:</label> 
								<select name="orderMethod">
								<c:if test="${empty pageBean.orderMethod}">
								<option value="0">销售日期
								<option value="1">单笔总价
								</c:if>
								<c:if test="${pageBean.orderMethod=='0'}">
								<option value="0">销售日期
								<option value="1">单笔总价
								</c:if>
								<c:if test="${pageBean.orderMethod=='1'}">
								<option value="1">单笔总价
								<option value="0">销售日期
								</c:if>
							</select>
							
							 <input type="submit" value="提交" style="margin-left: 10px;">
							<div style="height: 330px">
							<c:if test="${pageBean.getPageData().size()==0}">
								<h2 align="center" style="padding-top: 130px">暂时没有销售记录</h2>
							</c:if>
							<c:if test="${pageBean.getPageData().size()!=0}">
							<table class="saletable" style="text-align: center; margin-top: 10px" width="90%"
								align="center" border="2px">

								<tr>
									<td><b>ID</b></td>
									<td><b>商品</b></td>
									<td><b>单价</b></td>
									<td><b>数量</b></td>
									<td><b>总价</b></td>
									<td><b>销售日期</b></td>
									<td><b>销售员</b></td>
								</tr>
								<c:forEach items="${pageBean.getPageData()}" var="pageData">
									<tr>
										<td>${pageData.sale.saleId}</td>
										<td>${pageData.product.productName}</td>
										<td>${pageData.sale.price}</td>
										<td>${pageData.sale.quantity}</td>
										<td>${pageData.sale.totalprice}</td>
										<td><fmt:formatDate value="${pageData.sale.saledate}"
												pattern="yyyy-MM-dd" /></td>
										<td>${pageData.user.realname}</td>
									</tr>
								</c:forEach>
								<tr>
									<td colspan="7">
									<c:if test="${pageBean.currentPage!=1}">
											<li><a
												href="${pageContext.request.contextPath }/sale/saleinfo.do?currentPage=1&&orderMethod=${pageBean.orderMethod}">首页</a></li>
										</c:if>
										<c:if test="${pageBean.currentPage==1}">
											<li>首页</li>
										</c:if> |
									<c:if test="${pageBean.currentPage!=1}">
											<li><a
												href="${pageContext.request.contextPath }/sale/saleinfo.do?currentPage=${pageBean.currentPage-1 }&&orderMethod=${pageBean.orderMethod}">上一页</a></li>
										</c:if>
										<c:if test="${pageBean.currentPage==1}">
											<li>上一页</li>
										</c:if>
									|
									
											<c:if test="${pageBean.currentPage!=pageBean.totalPage}">
											<li><a
												href="${pageContext.request.contextPath }/sale/saleinfo.do?currentPage=${pageBean.currentPage+1 }&&orderMethod=${pageBean.orderMethod}">下一页</a></li>
										</c:if>
										<c:if test="${pageBean.currentPage==pageBean.totalPage}">
											<li>下一页</li>
										</c:if>
										
										
										| <c:if test="${pageBean.currentPage!=pageBean.totalPage}">
											<li><a
												href="${pageContext.request.contextPath }/sale/saleinfo.do?currentPage=${pageBean.totalPage}&&orderMethod=${pageBean.orderMethod}">末页</a></li>
										</c:if>
										<c:if test="${pageBean.currentPage==pageBean.totalPage}">
											<li>末页</li>
										</c:if>
										<li>第${pageBean.currentPage}页/共${pageBean.totalPage}页(${pageBean.totalCount}条记录)</li>
										</td>
								</tr>
							</table>
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