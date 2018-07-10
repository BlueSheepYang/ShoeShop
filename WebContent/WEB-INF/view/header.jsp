<%@ page language="java" contentType="text/html; 
charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
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
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>	
<!-- start menu -->
<script src="js/simpleCart.min.js"> </script>
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>				
</head>
<body>
	<div class="header-bottom">
		<div class="container">
			<div class="top-nav">
			<c:url var="index" value="/customer/loginIndex"></c:url>
				<ul class="memenu skyblue"><li class="active"><a href="${ index }">主页</a></li>
					<li class="grid"><a href="#">男士</a>
						<div class="mepanel">
							<div class="row">
								<div class="col1 me-one">
									<h4>适用人群</h4>
									<ul>
										<c:url var="findByPeople" value="/customer/showCommodityByPeople"></c:url>
										<li><a href="${findByPeople }?People=儿童&Sex=男士">儿童</a></li>
										<li><a href="${findByPeople }?People=青年&Sex=男士">青年</a></li>
										<li><a href="${findByPeople }?People=中年&Sex=男士">中年</a></li>
										<li><a href="${findByPeople }?People=老年&Sex=男士">老年</a></li>
									</ul>
								</div>
								<div class="col1 me-one">
									<h4>鞋子类型</h4>
									<ul>
									<c:url var="findByType" value="/customer/showCommodityByKind"></c:url>
									<c:forEach var="category" items="${categories }">
										<li><a href="${findByType }?Type=${category.categoryName }&Sex=男士">${category.categoryName }</a></li>
									</c:forEach>
									</ul>	
								</div>
								
							</div>
						</div>
					</li>
					<li class="grid"><a href="#">女士</a>
						<div class="mepanel">
							<div class="row">
								<div class="col1 me-one">
									<h4>适用人群</h4>
									<ul>
										<c:url var="findByPeople" value="/customer/showCommodityByPeople"></c:url>
										<li><a href="${findByPeople }?People=儿童&Sex=女士">儿童</a></li>
										<li><a href="${findByPeople }?People=青年&Sex=女士">青年</a></li>
										<li><a href="${findByPeople }?People=中年&Sex=女士">中年</a></li>
										<li><a href="${findByPeople }?People=老年&Sex=女士">老年</a></li>
									</ul>
								</div>
								<div class="col1 me-one">
									<h4>鞋子类型</h4>
									<ul>
										<c:url var="findByType" value="/customer/showCommodityByKind"></c:url>
										<c:forEach var="category" items="${categories }">
											<li><a href="${findByType }?Type=${category.categoryName }&Sex=女士">${category.categoryName }</a></li>
										</c:forEach>
									</ul>	
								</div>
							</div>
						</div>
					</li>
					<li class="grid"><a href="#">季节</a>
						<div class="mepanel">
							<div class="row">
								<div class="col1 me-one">
									<h4>季节</h4>
									<ul>
										<c:url var="findBySeason" value="/customer/showCommodityBySeason"></c:url>
										<li><a href="${findBySeason }?Season=春季">春季</a></li>
										<li><a href="${findBySeason }?Season=夏季">夏季</a></li>
										<li><a href="${findBySeason }?Season=秋季">秋季</a></li>
										<li><a href="${findBySeason }?Season=冬季">冬季</a></li>
									</ul>
								</div>
							</div>
						</div>
					</li>
					
					<li class="grid"><a href="#">特色/品牌</a>
						<div class="mepanel">
							<div class="row">
								<div class="col1 me-one">
									<h4>品牌</h4>
									<ul>
										<li><a href="products.html">蜀星王</a></li>
										<li><a href="products.html">征峰</a></li>
										<li><a href="products.html">鑫力克</a></li>
									</ul>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
</body>
</html>