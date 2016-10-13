<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/customer/modifyCustomer.do" method="post">
	<input name="customer_id" type="hidden" value="${c.customer_id}"/><br/>
	用户名：<input name="customer_name" type="text" value="${c.customer_name}"/><br/>
	密码：<input name="customer_password" type="text" value="${c.customer_password}"/><br/>
	性别：<input name="customer_sex" type="text" value="${c.customer_sex}"/><br/>
	手机号码：<input name="customer_phone" type="text" value="${c.customer_phone}"/><br/>
	<input type="submit" value="提交"/>
</form>
</body>
</html>