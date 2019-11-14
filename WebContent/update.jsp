<%@page import="cn.ybzy.mvcproject.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
tr {
	height: 40px;
}

td {
	padding: 10px;
}
</style>
</head>
<body>
<% User user = (User)request.getAttribute("user"); %>
	<form action="<%=request.getContextPath()%>/updatedo.udo" method="post">
	<input type = "hidden" name = "id" value = "<%=user.getId()%>"/>
		<table
			style="margin-left: 100px; padding: 50px; border: 1px #ccc solid; width: 600px;">
			<%
				String note = (String)request.getAttribute("note");
				if(note != null && !note.equals("")){ 
			%>
			<tr>
				<td colspan="2" style="text-align: right;color:red;font-weight:bolder;"><%=note %></td>
			</tr>
			<%} %>
			<tr>
				<td style="text-align: right;">用户名：</td>
				<td style="text-align: left;"><input type="text"
					name="username" value="<%=user.getUsername()%>"/></td>
			</tr>
			<tr>
				<td style="text-align: right;">用户密码：</td>
				<td style="text-align: left;"><input type="text" name="pasword" value="<%=user.getPasword() %>"/></td>
			</tr>
			<tr>
				<td style="text-align: right;">用户地址：</td>
				<td style="text-align: left;"><input type="text" name="address" value="<%=user.getAddress()%>"/></td>
			</tr>
			<tr>
				<td style="text-align: right;">用户电话：</td>
				<td style="text-align: left;"><input type="text" name="phoneNo" value="<%=user.getPhoneNo()%>"/></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center"><input type="submit"
					value="修改用户" /></td>
			</tr>
		</table>
	</form>
</body>
</html>