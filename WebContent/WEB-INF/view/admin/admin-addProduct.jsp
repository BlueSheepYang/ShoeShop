<%@ page language="java" contentType="text/html; 
charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">

<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/Resources/css/amazeui.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/Resources/css/admin.css">
<script src="${pageContext.request.contextPath }/Resources/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/Resources/js/app.js"></script>
<style type="text/css">
        #container h1{
        	font-family:"楷体";
            color:grey;/*文本颜色*/
            text-align:center;/*对齐方式*/
            /*border:1px solid black;/*边框样式*/
            font-size:60px;
            hight:240px;
        }
        #container form{
        	font-family:"宋体";
        	font-size:20px;
        	text-align:center;/*对齐方式*/
        	font-weight:bold;
        
        }
        #container form input.style1{
            border: 1px solid #ccc;
            border-radius: 2px;
            color: #000;
            font-family: 'Open Sans', sans-serif;
            font-size: 1em;
            height: 50px;
            padding: 0 16px;
            transition: background 0.3s ease-in-out;
            width: 30%;
        }
        #container form input.style2{
		  position: relative;
		  width: 16px;
		  height: 16px;
		  background-clip: border-box;
		  -webkit-appearance: none;
		     -moz-appearance: none;
		          appearance: none;
		  margin: -0.15px 0.6px 0 0;
		  vertical-align: text-bottom;
		  border-radius: 50%;
		  background-color: #fff;
		  border: 1px solid #d7d7d7;
		}
		#container form input.style2:disabled {
		  opacity: 0.65;
		}
		#container form input.style2:before {
		  content: '';
		  display: block;
		  height: 0px;
		  width: 0px;
		  -webkit-transition: width 0.25s, height 0.25s;
		  transition: width 0.25s, height 0.25s;
		}
		#container form input.style2:checked:before {
		  height: 8px;
		  width: 8px;
		  border-radius: 50%;
		  margin: 3px 0 0 3px;
		}
		#container form input.style2:focus {
		  outline: none;
		  box-shadow: inset 0 1px 1px rgba(255,255,255,0.075), 0 0px 2px #38a7ff;
		}
		#container form input.style2:checked {
		  border: 1px solid #555;
		}
		#container form input.style2:checked:before {
		  background-color: #555;
		}
        #container form input.style2:focus {
            outline: none;
            border-color: #9ecaed;
            box-shadow: 0 0 10px #9ecaed;
        }
  
        
    </style>
</head>
<body>
<header class="am-topbar admin-header">
  <div class="am-topbar-brand"><img src="assets/i/logo.png"></div>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
    <ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">

   <li class="am-dropdown tognzhi" data-am-dropdown>
  <button class="am-btn am-btn-primary am-dropdown-toggle am-btn-xs am-radius am-icon-bell-o" data-am-dropdown-toggle> 消息管理<span class="am-badge am-badge-danger am-round">6</span></button>
  <ul class="am-dropdown-content">
  	
  	
  	
    <li class="am-dropdown-header">所有消息都在这里</li>

    

    <li><a href="#">未激活会员 <span class="am-badge am-badge-danger am-round">556</span></a></li>
    <li><a href="#">未处理汇款</a></li>
    <li><a href="#">未发放提现</a></li>
    <li><a href="#">未发货订单</a></li>
    <li><a href="#">低库存产品</a></li>
    <li><a href="#">信息反馈</a></li>
    
    
    
  </ul>
</li>

 <li class="kuanjie">
 	
 	<a href="#">会员管理</a>          
 	<a href="#">奖金管理</a> 
 	<a href="#">订单管理</a>   
 	<a href="#">产品管理</a> 
 	<a href="#">个人中心</a> 
 	 <a href="#">系统设置</a>
 </li>

 <li class="soso">
 	
<p>   
	
	<select data-am-selected="{btnWidth: 70, btnSize: 'sm', btnStyle: 'default'}">
          <option value="b">全部</option>
          <option value="o">产品</option>
          <option value="o">会员</option>
          
        </select>

</p>

<p class="ycfg"><input type="text" class="am-form-field am-input-sm" placeholder="圆角表单域" /></p>
<p><button class="am-btn am-btn-xs am-btn-default am-xiao"><i class="am-icon-search"></i></button></p>
 </li>




      <li class="am-hide-sm-only" style="float: right;"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>

<div class="am-cf admin-main"> 

<div class="nav-navicon admin-main admin-sidebar">
	<jsp:include page="menu.jsp"></jsp:include>
</div>
</div>

<div class=" admin-content">
	
		<div class="daohang">
			<ul>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs"> 首页 </li>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">帮助中心<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">奖金管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
				<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs">产品管理<a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close="">×</a></button></li>
				
				
			</ul>

       

	
</div>
<div class="admin">	
     <div id="container">
		<h1 style="text-align:center">商品添加</h1>
		
		<form:form action="productModelHandle" method="POST" enctype="multipart/form-data">
			
			<p>商品编号：<input type="text" class="style1" name="commodityId" id="commodityId"/></p><br>
  			<p>商品名称：<input type="text" class="style1" name="commodityName" id="commodityName"/></p><br>
			<p>商品种类：
			<input type="radio" class="style2" name="commodityType" value="布鞋" id="commodityType"/>布鞋&nbsp;
			<input type="radio" class="style2" name="commodityType" value="运动鞋" id="commodityType"/>运动鞋&nbsp;
			<input type="radio" class="style2" name="commodityType" value="皮鞋" id="commodityType"/>皮鞋&nbsp;
			<input type="radio" class="style2" name="commodityType" value="休闲鞋" id="commodityType"/>休闲鞋&nbsp;
			<input type="radio" class="style2" name="commodityType" value="棉鞋" id="commodityType"/>棉鞋&nbsp;
			<input type="radio" class="style2" name="commodityType" value="解放鞋" id="commodityType"/>解放鞋&nbsp;
			<input type="radio" class="style2" name="commodityType" value="拖鞋" id="commodityType"/>拖鞋&nbsp;</p><br>
			
			<p>商品适合人群：
			<input type="radio" class="style2" name="commodityFitPeople" value="儿童" id="commodityFitPeople"/>儿童&nbsp;
			<input type="radio" class="style2" name="commodityFitPeople" value="青年" id="commodityFitPeople"/>青年&nbsp;
			<input type="radio" class="style2" name="commodityFitPeople" value="中年" id="commodityFitPeople"/>中年&nbsp;
			<input type="radio" class="style2" name="commodityFitPeople" value="老年" id="commodityFitPeople"/>老年&nbsp;
			<input type="radio" class="style2" name="commodityFitPeople" value="皆适用" id="commodityFitPeople"/>皆适用
			</p><br>
			<p>商品颜色：<input type="text" class="style1" name="commodityColor" id="commodityColor"/></p><br>
			<p>商品适合季节：
			<input type="radio" class="style2" name="commoditySeason" value="四季" id="commoditySeason"/>四季&nbsp;&nbsp;
			<input type="radio" class="style2" name="commoditySeason" value="春" id="commoditySeason"/>春&nbsp;&nbsp;
			<input type="radio" class="style2" name="commoditySeason" value="夏" id="commoditySeason"/>夏&nbsp;&nbsp;
			<input type="radio" class="style2" name="commoditySeason" value="秋" id="commoditySeason"/>秋&nbsp;&nbsp;
			<input type="radio" class="style2" name="commoditySeason" value="冬" id="commoditySeason"/>冬&nbsp;&nbsp;
			</p><br>
			<input type="hidden" name="inStock" value="是" id="inStock"/>
			<p>商品价格：<input type="text" class="style1" name="commodityPrice" id="commodityPrice"/></p><br>
			<p>
			<input type="radio" class="style2" name="commoditySex" id="commoditySex" value="男士"/>男士&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" class="style2" name="commoditySex" id="commoditySex" value="女士"/>女士</p><br>
			<p>商品描述：<input type="text" class="style1" name="commodityDescription" id="commodityDescription"/></p><br>
			<p>商品数量：<input type="text" class="style1" name="commodityNumber" id="commodityNumber"/></p><br>
			<p>商品图片：<input type="file" class="style1" required="required" name="pic" id="exampleInputFile"/></p>
			<input type="submit" class="style1" value="Save" class="save" />	
		</form:form>
	</div>



    <div class="foods">
    	<dl><a href="" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a></dl>
    </div>

</div>

</div>


</div>

<script src="assets/js/amazeui.min.js"></script>


</body>
</html>