<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>ID</td>
		<td>姓名</td>
		<td>密码</td>
		<td>性别</td>
		<td>手机号码</td>
		<td>操作</td>
		<c:forEach items="${customerList}" var="customer">
			<tr>
				<td>${customer.customer_id}</td>
				<td>${customer.customer_name}</td>
				<td>${customer.customer_password}</td>
				<td>${customer.customer_sex}</td>
				<td>${customer.customer_phone}</td>
				<td>
					<a href="${pageContext.request.contextPath}/customer/preModify.do?customer_id=${customer.customer_id}">修改</a>
					<a href="${pageContext.request.contextPath}/customer/deleteCustomer.do?customer_id=${customer.customer_id}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</tr>
</table>
</body>
</html>