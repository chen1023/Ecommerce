<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台管理页面</title>
<style type="text/css">
.center{
	margin:30px auto;/* 居中 这个是必须的，，其它的属性非必须 */
	width:500px;/* 给个宽度 顶到浏览器的两边就看不出居中效果了 */
}
</style>
</head>
<body>
<div class="center">
	<a href="${pageContext.request.contextPath}/customer/customerList.do">注册用户管理</a><br/>
	<a href="${pageContext.request.contextPath}/product/productList.do">商品管理</a><br/>
	<a href="orders.jsp">订单管理</a><br/>
	<a href="subscriptions.jsp">订阅管理</a><br/>
	<a href="rbac.jsp">权限管理</a>
</div>
</body>
</html>