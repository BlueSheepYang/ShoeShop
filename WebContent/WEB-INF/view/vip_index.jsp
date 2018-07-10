<%@ page language="java" contentType="text/html; 
charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link href="${pageContext.request.contextPath }/Resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath }/Resources/js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="${pageContext.request.contextPath }/Resources/css/freestyle.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Free Style Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.useso.com/css?family=Alegreya+Sans+SC:100,300,400,500,700,800,900,100italic,300italic,400italic,500italic,700italic,800italic,900italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
<!--//fonts-->
<script type="text/javascript" src="${pageContext.request.contextPath }/Resources/js/move-top.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/Resources/js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
	function linkSrc(str1,str2){
		var src = "";
		src = str1 + "/Resources/images/" + str2 + "jpg";
		return src;
	}
	
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
			<div class="col-md-4 top-header-left">
				<div class="search-bar">
					<input type="text" value="Search" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Search';}">
					<input type="submit" value="">
				</div>
			</div>
			<div class="col-md-4 top-header-middle">
				<h1>欢迎光临: ${ Customer }</h1>
				<img src="${pageContext.request.contextPath }/Resources/images/logo-4.png" alt="" /></a>
			</div>
			<div class="col-md-4 top-header-right">
				<div class="cart box_1">
						<a href="checkout.html">
						<h3> <div class="total">
							<span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> items)</div>
							<img src="${pageContext.request.contextPath }/Resources/images/cart-1.png" alt="" />
						</a>
						<c:url var="shoppingCar" value="/commodity/showShoppingCar"></c:url>
						<p><a href="${ shoppingCar }" class="simpleCart_empty">购物车</a></p>
						<c:url var="customerCenter" value="/customer/InfoCenter?username=${ Customer }"></c:url>
						<a href="${ customerCenter }?username=${ Customer }">用户中心</a>
						<c:url var="loginOut" value="/customer/loginOut"></c:url>
						<a href="${ loginOut }">注销</a>
						<div class="clearfix"> </div>
				</div>
				<br><br>
		
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!--top-header-->
	<!--bottom-header-->
	<jsp:include page="header.jsp"></jsp:include>
	<!--banner-starts-->
	<div class="bnr" id="home">
		<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider4">
			    <li>
					<div class="banner-1"></div>
				</li>
				<li>
					<div class="banner-2"></div>
				</li>
				<li>
					<div class="banner-3"></div>
				</li>
			</ul>
		</div>
		<div class="clearfix"> </div>
	</div>
	<!--banner-ends--> 
	<!--Slider-Starts-Here-->
				<script src="js/responsiveslides.min.js"></script>
			 <script>
			    // You can also use "$(window).load(function() {"
			    $(function () {
			      // Slideshow 4
			      $("#slider4").responsiveSlides({
			        auto: true,
			        pager: true,
			        nav: false,
			        speed: 500,
			        namespace: "callbacks",
			        before: function () {
			          $('.events').append("<li>before event fired.</li>");
			        },
			        after: function () {
			          $('.events').append("<li>after event fired.</li>");
			        }
			      });
			
			    });
			  </script>
			  
		<div class="shoes">
			<div class="container">
				<div class="product-one">
					<c:forEach var="commodity" items="${commodities}">
					<div class="col-md-3 product-left"> 
						<div class="p-one simpleCart_shelfItem">
							<c:url var="CommodityLink" value="/commodity/detail"></c:url>
							<a href="${ CommodityLink }?id=${commodity.commodityId}">
							<img src= "/images/${commodity.commodityPictureLink}" width="50" height="140" />
								<div class="mask">
										<span>Quick View</span>
								</div>
							</a>
							<h4>${commodity.commodityName }</h4>
							<p><a class="item_add" href="#"><i></i> <span class=" item_price">${commodity.commodityPrice}</span></a></p>
						</div>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
	<!--end-footer-->
	<!--end-footer-text-->
	<div class="footer-text">
		<script type="text/javascript">
			$(document).ready(function() {
				$().UItoTop({ easingType: 'easeOutQuart' });
				
			});
		</script>
		<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	</div>
	<!--end-footer-text-->	
</body>
</html>
