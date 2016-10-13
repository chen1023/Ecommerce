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
		<td>商品名称</td>
		<td>商品价格</td>
		<td>商品描述</td>
		<td>商品数量</td>
		<td>商品类别</td>
		<td>商品销量</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${productList}" var="product">
		<tr>
			<td>${product.product_id}</td>
			<td>${product.product_name}</td>
			<td>${product.product_amount}</td>
			<td>${product.product_profile}</td>
			<td>${product.product_number}</td>
			<td>${product.class_id}</td>
			<td>${product.product_sales}</td>
			<td>
				<a href="${pageContext.request.contextPath}/product/preModify.do?customer_id=${product.product_id}">修改</a>
				<a href="${pageContext.request.contextPath}/product/deleteProduct.do?customer_id=${product.product_id}">删除</a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>