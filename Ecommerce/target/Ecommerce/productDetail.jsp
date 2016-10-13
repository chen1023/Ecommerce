<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${product.product_name}</title>
<link type="text/css" href="${pageContext.request.contextPath}/css/taobao.css" />
<style type="text/css">
.container{
	width:1000px;
	margin:auto 170px;
}

.float_left{
	float:left;	
}

.float_right{
	float:right;	
}

.clear{
	clear:both;	
}

.clear_right{
	clear:right;
}

.clear_left{
	clear:left;
}

.commoditys_detailInfo_leftImg{
	padding-left:30px;
	padding-top:30px;
	padding-bottom:30px;
	padding-right:30px;
	width:356px;
	height:356px;	
}
</style>
</head>
<body>
<div class="container">
    <!--这段用面包导航 -->
     <div class="float_left commoditys_detailInfo_leftImg">
    	<img alt="" src="http://placekitten.com/350/350" />
    </div>
    <div class="float_left" style="font-size:12px;padding-left:30px;margin-top:30px;width:460px">
    	<div>
	    	<h2>${product.product_name}</h2>
	    	<small>${product.product_profile}</small>
	    </div>
		<table class="table_border_color" cellspacing="0" cellpadding="12px">
        	<tr>
            	<td style="height:40px">价&nbsp;&nbsp;格:</td>
                <td colspan="3">${product.product_amount}元</td><!-- 红色加粗 -->
            </tr>
            <tr>
            	<td>运&nbsp;&nbsp;费：</td>
                <td colspan="3">卖家承担运费</td>
            </tr>
            <tr>
            	<td>宝贝数量：</td>
                <td>${product.product_number}件</td>
            </tr>
            <tr>
            	<td>销&nbsp;&nbsp;量：</td>
                <td>${product.product_sales}次</td>
            </tr>
        </table>
    <div>
    <form action="${pageContext.request.contextPath}/order/addOrder.do" method="post">
	         购买：<input style="width:20px" type="text" name="product_number" />件
	         <input type="hidden" name="product_id" value="${product.product_id}"/>
	         <input type="hidden" name="customer_id" value="1"/>
		<input style="width:95px;height:40px;background:#14B9D5;color:#fff" type="submit" value="立即购买" />
	</form>
		<a href="${pageContext.request.contextPath}/cart/addCart.do?product_id=${product.product_id}&customer_id=1">加入购物车</a>
		<a href="${pageContext.request.contextPath}/subscription/addSubscription.do?class_id=${product.class_id}">订阅该类商品</a>
    </div>
    </div>
</div>
</body>
</html>