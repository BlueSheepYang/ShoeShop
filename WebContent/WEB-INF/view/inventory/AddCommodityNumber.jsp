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
<link rel="stylesheet" href="${pageContext.request.contextPath }/Resources/css/admin.css">
<link href="${pageContext.request.contextPath }/Resources/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<link href="${pageContext.request.contextPath }/Resources/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath }/Resources/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/Resources/js/app.js"></script>
<script type="text/javascript">
function sub(){
	<c:url var="AddCommodityNumber" value="/admin/HandleCommodityNumber"></c:url>
    var content = document.getElementById("commodityId").value;
    var num = document.getElementById("commodityNumber").value;
    var con = "${AddCommodityNumber}" + "?id=" + content + "&" + "number=" + num;
    window.location.href=con;
}
</script>
</head>
<body>
<header class="am-topbar admin-header">
  <div class="am-topbar-brand"><img src="images/logo.png"></div>

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
	<form class="am-form am-g">
        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
          <thead>
            <tr class="am-success">
              <th class="table-id am-text-center">ID</th>
              <th class="table-title">数量</th>
              <th width="163px" class="table-set">操作</th>
            </tr>
          </thead>
          <tbody>
          
			<tr class="CustomerStyle">
				<td width="20%"><input type="text" id="commodityId"/></td>
				<td width="20%"><input type="text" id="commodityNumber"/></td>
				<td><c:url var="categoryAdd" value="/admin/categoryAdd"></c:url>
	            <a href="javascript:sub();" onclick="if (!(confirm('你确定要添加这项库存吗?'))) return false">添加此库存</a>          
				</td>
		</tr>
	</tbody>
	</table>
	</form>
      
    <div class="foods">
    	<dl><a href="" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a></dl>
    </div>

</div>

</div>


<script src="assets/js/amazeui.min.js"></script>


</body>
</html>