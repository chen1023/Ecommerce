<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>萃鲜-欢迎注册</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="format-detection" content="telephone=no">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css"/>
  <style>
    .header {
      text-align: center;
    }
    .header h1 {
      font-size: 200%;
      color: #333;
      margin-top: 30px;
    }
    .header p {
      font-size: 14px;
    }
  </style>
</head>
<body>
<div class="header">
  <div class="am-g">
    <h1><a href="index.jsp">萃鲜</a></h1>
    <p>萃鲜商城<br/>您的生态生活管家</p>
  </div>
  <hr />
</div>
<div class="am-g">
  <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
      	<h2>注册</h2>
    <form action="${pageContext.request.contextPath}/customer/saveCustomer.do" method="post" class="am-form">  <!-- 获取绝对路径 -->
      <label for="customer_name">用户名:</label>
      <input type="text" name="customer_name" id="customer_name" />
      <br>
      <label for="customer_password">密码:</label>
      <input type="password" name="customer_password" id="customer_password" />
      <br>
      <label for="customer_sex">性别:</label>
      <input type="text" name="customer_sex" id="customer_sex" />
      <br>
       <label for="customer_phone">手机号:</label>
      <input type="text" name="customer_phone" id="customer_phone" />
      <br>
      <br/>
      <div class="am-cf">
        <input type="submit" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl" />
      </div>
    </form>
    <hr>
    <p>© 2015 Build by Andrew Liu</p>
  </div>
</div>
</body>
</html>