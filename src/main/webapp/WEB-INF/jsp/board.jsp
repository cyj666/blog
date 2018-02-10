<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<link rel="stylesheet"
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx }/static/css/board.css">
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link rel="icon" href="${ctx}/static/ico/bitbug_favicon.ico"
	type="image/x-icon">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>XX论坛-总有你喜欢的</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<%
				if (session.getAttribute("user") != null) {
			%>
			<span><small>欢迎，<a href="#"><span
						class="text-warning"> ${sessionScope.user.getuName()}</span></small></a></span> <span>
				<a href="logout"><small class="text-danger">退出登陆</small></a>
				<p class="hidden userId">${sessionScope.user.getuId()}</p>
			</span>
			<%
				} else {
			%>
			<a href="/login" style="text-decoration: none;"><small><span
					class="text-danger">&emsp;登录 <span class="caret"></span>&emsp;|
				</span></small></a> <a href="/register" style="text-decoration: none;"><small><span
					class="text-warning">&emsp;注册&emsp;</span></small></a>
			<%
				}
			%>

		</div>
		<div class="row">
			<div class="col-md-2">
				<h2 class="text-center text-danger">XX论坛</h2>
			</div>
			<div class="col-md-1 ico">
				<img src="${ctx }/static/ico/bitbug_favicon.ico">
			</div>
			<div class="input-group col-md-3"
				style="margin-top: 0px positon:relative">
				<input type="text" class="form-control" placeholder="请输入字段名"
					/ style="width: 300px; margin-top: 20px; margin-left: 200px;">
				<span class="input-group-btn">
					<button class="btn btn-info btn-search" style="margin-top: 20px;">
						<span class="glyphicon glyphicon-search"></span>查找
					</button>
				</span>
			</div>
			<div class="col-md-5 m-order">
				<span class="text-danger glyphicon glyphicon-bookmark"><a
					href="#">我的订阅</a> </span> <span
					class="text-danger glyphicon glyphicon-home"><a href="#">我的书架</a></span>
			</div>
		</div>

		<ul class="nav nav-tabs">
			<li><a href="/home">首页</span></a></li>
			<li class="active dropdown"><a href="#">版块</a></li>
			<li><a href="/board">xx</a></li>
			<li><a href="#">xx</a></li>
			<li><a href="#">xx</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> xx <span class="caret"></span>
			</a>
				<ul class="dropdown-menu">
					<li><a href="#">xx</a></li>
					<li><a href="#">xx</a></li>
					<li><a href="#">xx</a></li>
					<li class="divider"></li>
					<li><a href="#">xx</a></li>
				</ul></li>

		</ul>
		<div class="row">
			<div class="col-md-8 left-menu">
				<div class="title">
					<a href="/home">XX论坛</a> » 话题
				</div>
				<div class="main-board home-board-list">
				<c:forEach var="i" items="${page.list}">							
							<div class="board-list-detail">
						<img src="//cdn.94cb.com/upload/tag/middle/320.png" alt="功能"
							class="img-circle">
						<div class="board-item-content">
							<a href="/topic?boardName=${i.boardName}"><h4>${i.boardName}</h4></a>

							<span>&nbsp;&nbsp; ${i.topics.size()}个主题帖 &nbsp;&nbsp;&nbsp;&nbsp; 34人收藏 </span>
						</div>
						<p>
							<br />
								${i.boardDesc}							
							</div>
				</c:forEach>							
				</div>
		</div>
		
		
			<div class="col-md-4 right-menu">
			
				<div class="login">
				<div class="sider-box-title"> 登 录 </div>
				<form action="/login" mehthod="post" class="">
				<label for="account" class="control-label fa fa-user">
				<input id="account" type="text" name="username" placeholder="账号"
							autofocus="autofocus" class="form-control input-medium" required>
				</label>
				<label for="password" class="control-label fa fa-lock">
                <input id="password" type="password" name="password"
							placeholder="密码" tabindex="2" class="form-control input-medium"
							required>
                </label>
                <label for="captcha" class="control-label fa fa-key">
                <input style="width: 80;display:inline-block"
							id="captcha" type="text" name="captcha" placeholder="验证码"
							tabindex="2" class="form-control input-medium">
                <img id="captchaImage" src="/captcha" />
                </label><br />
                <button style="margin-left:50px;" type="submit"
							tabindex="4" class="btn btn-success">登录</button>
                <a href="/register" tabindex="6"
							class="btn btn-link text-muted">注册</a>
				</form>
				</div>
				<hr>
				<div class="adv">
				
				</div>
		</div>
		
		</div>
		<div class="foot" style="height: 100px; border: 0px solid red;">
		<span class="text-center">
		<p class="">
						<a  href="#" target=_blank>网站首页</a>&nbsp; &nbsp;|&nbsp;
						&nbsp;意见反馈 &nbsp; &nbsp;|&nbsp; &nbsp;联系我们 &nbsp; &nbsp;| <a  href="#"
							target=_blank>客服电话</a>&nbsp; &nbsp;|&nbsp; &nbsp;加入我们 &nbsp;
						&nbsp;|&nbsp; &nbsp;帮助中心
					</p>
					<p class=" address">
						版权所有©1997-2017
					</p>
					</span>
		</div>
	</div>

</body>
<script type="text/javascript">
$('#captchaImage').click(function() 
		{
		  $('#captchaImage').attr("src", "captcha?timestamp=" + (new Date()).valueOf());
		  
		});
  
</script>
</html>