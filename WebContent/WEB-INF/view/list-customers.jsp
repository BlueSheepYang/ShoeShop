<%@ page language="java" contentType="text/html; 
charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List Customers</title>
	
	<!-- reference our style sheet -->
	
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/style.css"/>
	
	
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		<!-- put new button: Add Customer -->
		<input type="button" value="添加顾客" onclick="window.location.href='showFormForAdd';return false;" class="add-button"/>
		
		<!-- add our html table here -->
			<table>
				<tr>
					<th>编号</th>
					<th>真实姓名</th>
					<th>账户昵称</th>
					<th>密码</th>
					<th>性别</th>
					<th>电话号码</th>
					<th>地址</th>
					<th>身份证号</th>
					<th>邮箱地址</th>
					<th>操作</th>
				</tr>
				
				<!-- loop over and print customers -->
				<c:forEach var="tempCustomer" items="${customers }">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.userId }" />
					</c:url>
					
					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customer/showFormForDelete">
						<c:param name="customerId" value="${tempCustomer.userId }" />
					</c:url>
				
					<tr>
						<td>${tempCustomer.userId }</td>
						<td>${tempCustomer.userTrueName }</td>
						<td>${tempCustomer.userNickname }</td>
						<td>${tempCustomer.userPassword }</td>
						<td>${tempCustomer.userSex }</td>
						<td>${tempCustomer.userPhone }</td>
						<td>${tempCustomer.userAddress }</td>
						<td>${tempCustomer.userIdentification }</td>
						<td>${tempCustomer.userEmail }</td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink }">更新</a>
							|
							<a href="${deleteLink }" onclick="if (!(confirm('你确定要删除这位顾客的信息吗?'))) return false">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	
	</div>
</body>
</html>