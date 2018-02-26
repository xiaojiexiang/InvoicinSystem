<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进销存系统</title>
<style type="text/css">
.clear {
	clear: both;
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
						<h1 align="center">欢迎使用小型进销存系统</h1>
					</td>
				</tr>
			</table>

		</div>
	</div>
</body>
</html>