<%@ page language="java" contentType="text/html; 
charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;"> 欢迎系统管理员：</div>
    <div class="sideMenu">
      <h3 class="am-icon-flag"><em></em> <a href="#">商品管理</a></h3>
      <ul>
      	<c:url var="showAllCommodity" value="/admin/showCommodityList"></c:url>
      	<li><a href="${ showAllCommodity }">商品列表</a></li>
      	<c:url var="addproduct" value="/admin/addProduct"></c:url>
      	<li><a href="${ addproduct }">添加新商品</a></li>
      	<c:url var="editCategory" value="/admin/editCategory"></c:url>
        <li><a href="${ editCategory }">编辑分类</a></li>
      </ul>
      <h3 class="am-icon-cart-plus"><em></em> <a href="#"> 订单管理</a></h3>
      <ul>
      	<c:url var="showNotHandleOrder" value="/admin/showList"></c:url>
      	<li><a href="${ showNotHandleOrder }">未处理的订单列表</a></li>
      	
      	<c:url var="showAllOrder" value="/admin/showAllList"></c:url>
      	<li><a href="${ showAllOrder }">显示所有订单</a></li>
      	
      	<c:url var="showFinishOrder" value="/admin/showFinishList"></c:url>
      	<li><a href="${ showFinishOrder }">显示已处理的订单</a>
        <!-- <li>订单打印</li>
        <li>发货单列表</li>
        <li>换货单列表</li> -->
      </ul>
      <h3 class="am-icon-users"><em></em> <a href="#">会员管理</a></h3>
      <ul>
      	<c:url var="showCustomer" value="/admin/showSuperCustomer"></c:url>
      	<li><a href="${ showCustomer }">会员列表</a></li>
      	<c:url var="addCustomer" value="/admin/showRegisterCustomer"></c:url>
        <li><a href="${ addCustomer }">未激活会员</a></li>
      </ul>
      <h3 class="am-icon-volume-up"><em></em> <a href="#">信息通知</a></h3>
      <ul>
        <c:url var="showSuggestion" value="/admin/showUnfinshedSuggestion"></c:url>
      	<li><a href="${ showUnfinshedSuggestion }">处理投诉建议</a></li>
      	<c:url var="showAllSuggestion" value="/admin/showAllSuggestion"></c:url>
      	<li><a href="${ showAllSuggestion }">显示所有投诉建议</a></li>
        <!-- <li>邮件</li>
        <li>微信</li>
        <li>客服</li>-->
      </ul>
      <h3 class="am-icon-gears"><em></em> <a href="#">统计信息</a></h3>
      <ul>
        <c:url var="monthAmount" value="/admin/monthAmount"></c:url>
      	<li><a href="${ monthAmount }">月销售额统计</a></li>
        <c:url var="daysAmount" value="/admin/daysAmount"></c:url>
        <li><a href="${ daysAmount }">最近七天销售额统计</a></li>
        <c:url var="kindsAmount" value="/admin/kindsAmount"></c:url>
        <li><a href="${ kindsAmount }">按商品种类销售额统计</a></li>
        <c:url var="customerAmount" value="/admin/customerAmount"></c:url>
        <li><a href="${ customerAmount }">按客户销售额统计</a></li>
      </ul>
      <h3 class="am-icon-gears"><em></em> <a href="#">库存管理</a></h3>
	      <ul>
	      	<c:url var="ShowAllCommodityNumber" value="/admin/ShowAllCommodityNumber"></c:url>
	      	<li><a href="${ ShowAllCommodityNumber }">查看当前所有库存</a></li>
	      	<c:url var="ShowInadequateNumber" value="/admin/ShowInadequateNumber"></c:url>
	      	<li><a href="${ ShowInadequateNumber }">查看缺乏库存</a></li>
	      	<c:url var="AddCommodityNumber" value="/admin/AddCommodityNumber"></c:url>
	      	<li><a href="${ AddCommodityNumber }">添加库存</a></li>
      	  </ul>
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
</body>
</html>