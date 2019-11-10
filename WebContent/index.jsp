<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	tr{height:40px;}
	td{padding:10px;}
</style>
</head>
<body>
	<form action="<%=request.getContextPath()%>/query.udo" method="post">
		<table
			style="margin-left: 100px; padding: 50px; border: 1px #ccc solid; width: 400px;">
			<tr>
				<td style="text-align: right;">用户名：</td>
				<td style="text-align: left;"><input type="text"
					name="username" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">用户地址：</td>
				<td style="text-align: left;"><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td style="text-align: right;">用户电话：</td>
				<td style="text-align: left;"><input type="text" name="phoneNo" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center"><input type="submit"
					value="查询用户" /></td>
			</tr>
		</table>
	</form>

	<table style="margin-left:100px;padding:50px;" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td>用户id</td>
			<td>用户名称</td>
			<td>用户密码</td>
			<td>用户电话</td>
			<td>用户地址</td>
			<td>注册日期</td>
		</tr>

		<tr>
			<td>用户id</td>
			<td>用户名称</td>
			<td>用户密码</td>
			<td>用户电话</td>
			<td>用户地址</td>
			<td>注册日期</td>
		</tr>
	</table>
</body>
</html>