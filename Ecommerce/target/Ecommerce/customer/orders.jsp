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
<form action="${pageContext.request.contextPath}/order/saveOrder.do" method="post">
配送至：
<table>
	<tr>
		<td></td>
		<td>地址</td>
		<td>收件人</td>
		<td>手机号</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${addressList}" var="address">
		<td><input type="radio" name="address_id" value="${address.address_id}"></td>
		<td>${address.address_content}</td>
		<td>${address.address_people}</td>
		<td>${address.address_phone}</td>
		<td>
			<a href="#">修改</a>
			<a href="#">删除</a>
		</td>
	</c:forEach>
</table>
 	<div>
    	<img alt="" src="${pageContext.request.contextPath}/img/p_mycar.gif" />
    </div>
    <table>
        <tr>
          <td></td>
          <td>商品名</td>
          <td>价格</td>
          <td>数量</td>
          <td>操作</td>
        </tr>
        <c:forEach items="${productList}" var="p">
        <tr>
          <td><input type="checkbox" name="product_id" value="${p.product_id}"></td>
          <td>${p.product_name}</td>
          <td>${p.product_amount}</td>
          <td><input type="text" style="width:20px" value="${product_number}" name="product_number"/></td>
          <td><a href="#">删除</a></td>
        </tr>
        <input type="hidden" name="product_amount" value="${p.product_amount}" />
        </c:forEach>
    </table>
    <input type="hidden" name="customer_id" value="1" />
    <input style="width:95px;height:40px;background:#14B9D5;color:#fff" type="submit" value="提交订单" />
</form>  
</body>
</html>