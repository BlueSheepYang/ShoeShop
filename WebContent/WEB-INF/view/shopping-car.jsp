<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Checkout</title>
<link href="${pageContext.request.contextPath }/Resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath }/Resources/js/jquery-1.11.0.min.js"></script>
<link href="${pageContext.request.contextPath }/Resources/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Free Style Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href='http://fonts.useso.com/css?family=Alegreya+Sans+SC:100,300,400,500,700,800,900,100italic,300italic,400italic,500italic,700italic,800italic,900italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="${pageContext.request.contextPath }/Resources/js/move-top.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/Resources/js/easing.js"></script>
<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>	
<!-- start menu -->
<script src="${pageContext.request.contextPath }/Resources/js/simpleCart.min.js"> </script>
<link href="${pageContext.request.contextPath }/Resources/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath }/Resources/js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>				
</head>
<body> 
	<!--top-header-->
	<div class="top-header">
	<div class="container">
		<div class="top-header-main">
			<div class="col-md-4 top-header-middle">
				<a href="index.html"><img src="${pageContext.request.contextPath }/Resources/images/logo-4.png" alt="" /></a>
			</div>
	
		</div>
	</div>
</div>
<!--top-header-->
<!--bottom-header-->
	<jsp:include page="header.jsp"></jsp:include>
	<div class="breadcrumbs">
		<div class="container">
			<div class="breadcrumbs-main">
				<ol class="breadcrumb">
					<c:url var="home" value="/customer/loginIndex"></c:url>
					<li><a href="${ home }">Home</a></li>
				</ol>
			</div>
		</div>
	</div>
	<!--end-breadcrumbs-->
	<!--start-ckeckout-->
	<div class="ckeckout">
		<div class="container">
			<div class="ckeckout-top">
			<div class=" cart-items heading">
			 <h3>My Shopping Car(温馨提示：确认订单后想取消需要联系老板)</h3>
				
				
			<div class="in-check" >
				<ul class="unit">
					<li><span>商品图标</span></li>
					<li><span>商品名</span></li>		
					<li><span>单价</span></li>
					<li><span>总数量</span></li>
					<li><span>总金额</span></li>
					<div class="clearfix"> </div>
				</ul>
				<c:forEach var="shoppingcarList" items="${shoppingcarLists}" varStatus="times">
					<ul class="cart-header">
						<c:url var="CommodityLink" value="/commodity/detail"></c:url>
						<li class="ring-in"><a href="${ CommodityLink }?id=${shoppingcarList.productId}"><img src="/images/${picLink[times.count-1] }" class="img-responsive" width="50%" height="50%"></a></li>
						<li><span>${shoppingcarList.productName}</span></li>
						<li><span>${shoppingcarList.price}</span></li>
						<li><span>${shoppingcarList.productNumber}</span></li>
						<li><span>${shoppingcarList.sum}</span></li>
						<c:url var="confirmList" value="/commodity/confirmList"></c:url>
						<li> <a href="${ confirmList }?id=${shoppingcarList.id}" class="add-cart cart-check">确认订单</a></li>
						<div class="clearfix"> </div>
					</ul>
				</c:forEach>
				
				<div id="price">
					<h3>总价是: ${ totalSum }</h3>
					<c:url var="confirmAllList" value="/commodity/confirmAllList"></c:url>
					<h3><a href="${ confirmAllList}">确认全部订单</a></h3>
				</div>
			</div>
			</div>  
		 </div>
		</div>
	</div>
	<div class="footer-text">
		<script type="text/javascript">
									$(document).ready(function() {
										/*
										var defaults = {
								  			containerID: 'toTop', // fading element id
											containerHoverID: 'toTopHover', // fading element hover id
											scrollSpeed: 1200,
											easingType: 'linear' 
								 		};
										*/
										
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
								</script>
		<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	</div>
</body>
</html>