<%@ page language="java" contentType="text/html; 
charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/Resources/css/style.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/Resources/css/add-customer-style.css"><meta name="viewport" content="width=device-width, initial-scale=1">
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
				<h1>欢迎光临</h1>
				<a href="index.html"><img src="${pageContext.request.contextPath }/Resources/images/logo-4.png" alt="" /></a>
			</div>
			
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!--top-header-->
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
	 <br>	
	<br>
  

	<div id="container">
		<form:form action="saveTmpCustomer" modelAttribute="tmpCustomer" method="POST" >
			<!-- need to associate this data with customer id -->
			<form:hidden path="userId" />
			
			<div style="width:650px;margin:0 auto">
				<table>
					<tbody>
						<tr>
							<!-- <td><lable>编号： </lable></td> -->
							<!-- equal to setter method -->
							<td><form:hidden path="userId"/></td> 
						</tr>
						
						<tr>
							<td><lable>真实姓名： </lable></td>
							<td><form:input id="inputUserName" path="userTrueName"/></td>
						</tr>
						
						<tr>
							<td><lable>用户昵称： </lable></td>
							<td><form:input id="inputNickName" path="userNickname"/></td>
						</tr>
						
						<tr>
							<td><lable>用户密码： </lable></td>
							<td><form:input id="inputPassword" path="userPassword"/></td>
						</tr>
						
						<tr>
							<td><lable>性别： </lable></td>
							<td><form:input id="inputSex" path="userSex"/></td>
						</tr>
						
						<tr>
							<td><lable>电话号： </lable></td>
							<td><form:input id="inputPhoneNumber" path="userPhone"/></td>
						</tr>
						
						<tr>
							<td><lable>地址： </lable></td>
							<td><form:input id="inputAddress" path="userAddress"/></td>
						</tr>
						
						<tr>
							<td><lable>身份证号： </lable></td>
							<td><form:input id="idCard" path="userIdentification"/></td>
						</tr>
						
						<tr>
							<td><lable>邮箱号： </lable></td>
							<td><form:input id="inputEmail" path="userEmail"/></td>
						</tr>
						
						<tr>
							<td><lable>确认提交 </lable></td>
							<td><input type="submit" value="Save" class="save" onclick="say()"/></td>
						</tr>
					</tbody>
				</table>
			</div>
		</form:form>
	</div>	
	<!--end-footer-->
	<!--end-footer-text-->
	<div class="footer-text">
		<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	</div>
	<!--end-footer-text-->	
</body>
</html>