<%@ page language="java" import="com.liucheng.utils.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/nav.css" />
<link rel="stylesheet" href="css/amazeui.css" />
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/amazeui.min.js"></script>
<title>首页</title>
<style>
.am-container {
	width: 1000px !important;
	max-width: none;
}

.header .am-container a {
	font-size: 13px;
	text-decoration: none;
	color: #000;
	margin-left: 5px;
}

.header .am-container a:hover {
	color: #14B4D0;
}

.logo-search div {
	padding-top: 40px
}

.logo-search .am-u-sm-5 a {
	font-size: 13px;
	text-decoration: none;
	color: #000;
	margin-left: 5px;
}

.logo-search .am-u-sm-5 a:hover {
	color: #14B4D0;
}

.nav .am-container #class {
	height: 61px;
	padding-top: 20px;
	width: 235px;
	background: rgba(0, 0, 0, 0.8);
	padding-left: 40px;
	color: #fff;
}
</style>
</head>
<body>
	<header class="header"> 
	<div class="am-container">
		<c:if test="${empty customer_name}">
			<a style="float: left" href="login.jsp">你好，请登录</a>
			<a style="float: left" href="register.jsp">免费注册</a>
		</c:if>
		<c:if test="${!empty customer_name}">
			<a style="float: left" href="login.jsp">欢迎你，${customer_name}</a>
			<a style="float: left" href="${pageContext.request.contextPath}/customer/logout.do">注销</a>
		</c:if>
		<a style="float: right" href="#">我的订单</a>
	</div>
	</header>
	<div class="am-container logo">
		<div class="logo-img">
			<img alt="" src="http://placekitten.com/320/125" />
		</div>
		<div class="logo-search">
			<form class="am-form am-form-horizontal" action="">
				<div class="am-u-sm-5">
					<input type="text" placeholder="热门搜索"> <a href="#">万年青</a>
					<a href="#">龙虾</a> <a href="#">菜地代种</a> <a href="#">生态旅游</a> <a
						href="#">娃娃菜</a> <a href="#">草鸡蛋</a> <a href="#">更多>></a>
				</div>
				<div class="am-u-sm-1">
					<input class="am-btn am-btn-secondary" type="submit" value="搜索">
				</div>
				<div class="am-u-sm-2">
					<a class="am-btn am-btn-warning" href="#"> <i
						class="am-icon-shopping-cart"></i> 我的购物车
					</a>
				</div>
			</form>
		</div>
	</div>
	<div class="nav">
		<div class="am-container">
			<ul class="am-nav am-nav-pills">
				<li><a id="class" href="#">全部商品分类</a></li>
				<li style="padding-top: 12px"><a href="#">时令精选</a></li>
				<li style="padding-top: 12px"><a href="#">大家玩</a></li>
				<li style="padding-top: 12px"><a href="#">我爱团</a></li>
				<li style="padding-top: 12px"><a href="#">发现</a></li>
				<li style="padding-top: 12px"><a href="#">特价疯</a></li>
			</ul>
		</div>
	</div>
	<div class="am-container" id="big_banner_wrap">
		<ul id="banner_menu_wrap">
			<li id="banner_menu_wrap_items" class="active"><a id="title0"></a><a
				class="banner_menu_i">&gt;</a>
				<div class="banner_menu_content" style="top: -20px;">
					<div id="item0"></div>
				</div></li>
			<li id="banner_menu_wrap_items"><a id="title1"></a> <a
				class="banner_menu_i">&gt;</a>
				<div class="banner_menu_content" style="top: -62px;">
					<div id="item1"></div>
				</div></li>
			<li id="banner_menu_wrap_items"><a id="title2"></a> <a
				class="banner_menu_i">&gt;</a>
				<div class="banner_menu_content" style="top: -104px;">
					<div id="item2"></div>
				</div></li>
			<li id="banner_menu_wrap_items"><a id="title3"></a> <a
				class="banner_menu_i">&gt;</a>
				<div class="banner_menu_content" style="top: -146px;">
					<div id="item3"></div>
				</div></li>
			<li id="banner_menu_wrap_items"><a id="title4"></a> <a
				class="banner_menu_i">&gt;</a>
				<div class="banner_menu_content" style="top: -188px;">
					<div id="item4"></div>
				</div></li>
			<li id="banner_menu_wrap_items"><a id="title5"></a> <a
				class="banner_menu_i">&gt;</a>
				<div class="banner_menu_content" style="top: -230px;">
					<div id="item5"></div>
				</div></li>
			<li id="banner_menu_wrap_items"><a id="title6"></a> <a
				class="banner_menu_i">&gt;</a>
				<div class="banner_menu_content" style="top: -272px;">
					<div id="item6"></div>
				</div></li>
		</ul>
		<div style="float: left; margin-left: 240px; margin-top: 4px;">
			<img src="http://placekitten.com/730/325">
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			/* classList = $.ajax({
			url : "${pageContext.request.contextPath}/index/indexList.do",
				async : false,
				}); 
			$("#myDiv").html(classList.responseText);*/
			$.post("${pageContext.request.contextPath}/index/indexList.do",
				function(data, status) {obj = $.parseJSON(data);
					$.each(obj,function(index,item) {
						$('li#banner_menu_wrap_items').children(
						'a#title'+ index).html($("<a href='${pageContext.request.contextPath}/product/productClass.do?id="+item.class_id+"'>"+ item.class_name
						+ "</a>"));
						/* $('div.banner_menu_content').children('p#items'+index).html('<p>'+item.class_items+'</p>'); */
						/* for(x in item.class_items){
								$('#item'+index).append($('<a>'+item.class_items[x]+'</a>').attr("href","${pageContext.request.contextPath}/product/items.do?id="+index+""+x));
						} */
						$.each(item.class_items,function(i,its) {
							$('#item'+ index).append($("<a href='${pageContext.request.contextPath}/product/productDetail.do?product_id="+its.items_id+"'>"+ its.item_name+ '</a>'));
						});
				});
			});
		});
	</script>
	<script type="text/javascript" src="js/nav.js"></script>
</body>
</html>