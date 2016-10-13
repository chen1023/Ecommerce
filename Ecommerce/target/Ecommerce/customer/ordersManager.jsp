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
		<td>状态</td>
		<td>金额</td>
		<td>地址</td>
		<td>时间</td>
		<td>商品</td>
		<td>数量</td>
	</tr>
	
<c:forEach items="${orderList}" var="order">
	<tr>
		<td>${order.order_id}</td>
		<td>${order.order_status}</td>
		<td>${order.order_amount}</td>
		<td>${order.address_id}</td>
		<td>${order.order_time}</td>
		<td>${order.oi.product_id}</td>
		<td>${order.oi.product_number}</td>
	<tr>
</c:forEach>
</table>
</body>
</html>