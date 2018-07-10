<%@ page language="java" contentType="text/html; 
charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<link rel="stylesheet" href="${pageContext.request.contextPath }/Resources/css/suggestion.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath }/Resources/css/admin.css">
<script src="${pageContext.request.contextPath }/Resources/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/Resources/js/app.js"></script>
</head>
<header class="am-topbar admin-header">
  <div class="am-topbar-brand"><img src="assets/i/logo.png"></div>

  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
    <ul class="am-nav am-nav-pills am-topbar-nav admin-header-list">

   <li class="am-dropdown tognzhi" data-am-dropdown>
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

<div class="admin">

	<div class="row">
       <div class="masonary-grids">
	       <div class="col-md-12">
	           <div class="widget-area pattern">
	               <h2 class="widget-title"><strong>Contact</strong> Us</h2>
	               <div class="contact-form">
	                   <div class="row">
	                       <div id="contact">
	                           <div id="message"></div>
	                           <form method="post" action="sendRecommendation" name="contactform" id="contactform">
	                               <div class="col-md-6">	               
	                                   <label for="theme" accesskey="E"><span class="required">*</span> Theme</label>
	                                   <input name="theme" type="text" id="theme" size="30" value="" />
	                                   <label for="phone" accesskey="P"><span class="required">*</span> Phone</label>
	                                   <input name="phone" type="text" id="phone" size="30" value="" />
	                               </div>
	                               <div class="col-md-6">
	                                   <label for="comments" accesskey="C"><span class="required">*</span> Your comments</label>
	                                   <textarea name="comments" cols="40" rows="3" id="comments"></textarea>
	                                   <p><span class="required">*</span> Are you human?</p>
	                                   <label for="verify" accesskey="V">&nbsp;&nbsp;&nbsp;3 + 1 =</label>
	                                   <input name="verify" type="text" id="verify" size="4" value="" />
	                                   <input type="hidden" name="username" value="${ sessionScope.truename }">
	                                   <input type="submit" class="submit" id="submit" value="Submit" />
	                               </div>
	                           </form>
	                       </div>
	                   </div>
	               </div>
	           </div>
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