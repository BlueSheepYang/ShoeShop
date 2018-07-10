<%@ page language="java" contentType="text/html; 
charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div class="nav-navicon admin-main admin-sidebar">  
	    <div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;">欢迎用户：${ sessionScope.uname }</div>
	    <div class="sideMenu">
	   
	      <h3 class="am-icon-flag"><em></em> <a href="#">基本信息管理</a></h3>
	      <ul>
	      	<c:url var="modifyInfo" value="/customer/modifyInfo"></c:url>
	      	<li><a href="${ modifyInfo }">基本信息修改</a></li>
	        
	        <c:url var="showInfo" value="/customer/showInfo"></c:url>
	        <li><a href="${ showInfo }">查看基本信息</a></li>
	      </ul>
	      <c:url var="toReturn" value="/customer/loginIndex"></c:url>
	      <h3 class="am-icon-cart-plus"><em></em> <a href="#"> 订单管理</a></h3>
	      <ul>
	      	<c:url var="showNotHandleOrder" value="/customer/showUnfinshedList"></c:url>
	      	<li><a href="${ showNotHandleOrder }">未处理的订单列表</a></li>
	      	
	      	<c:url var="showAllOrder" value="/customer/showAllList"></c:url>
	      	<li><a href="${ showAllOrder }">显示所有订单</a></li>
	      	
	      	<c:url var="showFinishOrder" value="/customer/showFinishList"></c:url>
	      	<li><a href="${ showFinishOrder }">显示已处理的订单</a>
	        <!--  <li>发货单列表</li>
	        <li>换货单列表</li> -->
	      </ul>
	      <h3 class="am-icon-users"><em></em> <a href="#">会员功能</a></h3>
	      <ul>
	      	<c:url var="suggestion" value="/customer/showRecommendation"></c:url>
	      	<li><a href="${ suggestion }">投诉建议</a></li>
	      	
	      	<c:url var="showShopping" value="/customer/showShoppingCar"></c:url>
	      	<li><a href="${ showShopping }">查看购物车</a>
	      	
	      </ul>
	      <h3 class="am-icon-volume-up"><em></em> <a href="#">信息通知</a></h3>
	      <ul>
	        <c:url var="showReply" value="/customer/showReply"></c:url>
	      	<li><a href="${ showReply }">查看回复</a>
	      	
	      	<c:url var="contact" value="/customer/contact"></c:url>
	      	<li><a href="${contact }">联系老板</a>
	        <!-- <li>短信</li>
	        <li>邮件</li>
	        <li>微信</li>
	        <li>客服</li> -->
	      </ul>
	      <h3><a href="${toReturn }"> 返回商品首页</a></h3>
	      <!-- 
	      <h3 class="am-icon-gears"><em></em> <a href="#">系统设置</a></h3>
	      <ul>
	        <li>数据备份</li>
	        <li>邮件/短信管理</li>
	        <li>上传/下载</li>
	        <li>权限</li>
	        <li>网站设置</li>
	        <li>第三方支付</li>
	        <li>提现 /转账 出入账汇率</li>
	      </ul>
	       -->
	    </div>
	    <!-- sideMenu End --> 
	    
	    <script type="text/javascript">
				jQuery(".sideMenu").slide({
					titCell:"h3", //鼠标触发对象
					targetCell:"ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
					effect:"slideDown", //targetCell下拉效果
					delayTime:300 , //效果时间
					triggerTime:150, //鼠标延迟触发时间（默认150）
					defaultPlay:true,//默认是否执行效果（默认true）
					returnDefault:true //鼠标从.sideMen移走后返回默认状态（默认false）
					});
			</script> 
	    
	</div>
</body>
</html>