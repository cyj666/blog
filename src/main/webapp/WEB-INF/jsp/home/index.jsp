<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx }/static/css/index.css">
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link rel="icon" href="${ctx}/static/ico/bitbug_favicon.ico" type="image/x-icon">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>XX论坛-总有你喜欢的</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<shiro:user>			
			<span><small>欢迎，<a href="#"><span
						class="text-warning"><shiro:principal></shiro:principal></span></small></a></span> <span>
				<a href="logout"><small class="text-danger">退出登陆</small></a>				
			</span>
			</shiro:user>		
			<shiro:guest>
			<a href="/login" style="text-decoration: none;"><small><span
					class="text-danger">&emsp;登录 <span class="caret"></span>&emsp;|
				</span></small></a> <a href="/register" style="text-decoration: none;"><small><span
					class="text-warning">&emsp;注册&emsp;</span></small></a>
			
			</shiro:guest>
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
			<li class="active dropdown"><a href="/home">首页</span></a></li>
			<li><a href="/board">版块</a></li>
			<li><a href="#">xx</a></li>
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
			<div class="col-md-4 right-menu">
				<div>
					<h4>话题广场</h4>
					<p>
					<c:forEach var="b" items="${boards}">
						<a class="tag" href="/topic?boardName=${b.boardName}">${b.boardName}</a>
					</c:forEach>	
					<hr style="margin: 0; padding: 0">
					</p>
				</div>
				
				
			</div>
			<div id="myCarousel" class="col-md-7 carousel slide col-md-offset-1"
				data-interval="5000" data-ride="carousel">
				<!-- 轮播（Carousel）指标 -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
				</ol>
				<!-- 轮播（Carousel）项目 -->
				<div class="carousel-inner">
					<div class="item active tp1">
						<img class="img-responsive" src="/pic?picUrl=index/20170925-1.jpg"
							alt="1st slide">
						<div class="carousel-caption">标题 1</div>
					</div>
					<div class="item tp2">
						<img class="img-responsive" src="/pic?picUrl=index/20170925-2.jpg"
							alt="2nd slide">
						<div class="carousel-caption">标题 2</div>
					</div>
					<div class="item tp3">
						<img class="img-responsive" src="/pic?picUrl=index/20170925-3.jpg"
							alt="3rd slide">
						<div class="carousel-caption">标题 3</div>
					</div>
					<div class="item tp4">
						<img class="img-responsive" src="/pic?picUrl=index/20170929-1.jpg"
							alt="4th slide">
						<div class="carousel-caption">标题 4</div>
					</div>
				</div>
				<!-- 轮播（Carousel）导航 -->
				<a class="carousel-control left" href="#myCarousel"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span></a> <a
					class="carousel-control right" href="#myCarousel" data-slide="next"><span
					class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
			<div class="col-md-4 right-menu second">
			<shiro:guest>
				<span class="text-danger">${msg}</span>
				<div class="sider-box-title"> 登 录 </div>
				<form action="/login.do" method="post" class="">
				<label for="account" class="control-label fa fa-user">
				<input id="account" type="text" name="username" placeholder="账号" 
				autofocus="autofocus" class="form-control input-medium" required>
				</label>
				<label for="password" class="control-label fa fa-lock">
                <input id="password" type="password" name="password" 
                placeholder="密码" tabindex="2" class="form-control input-medium" required>
                </label>
                <label for="captcha" class="control-label fa fa-key">
                <input style="width: 80;display:inline-block" id="captcha" type="text" 
                name="captcha" placeholder="验证码" tabindex="2" class="form-control input-medium">
                <img id="captchaImage" src="/captcha" />
                </label><br/>
                <button style="margin-left:50px;" type="submit" tabindex="4" class="btn btn-success">登录</button>
                <a href="/register" tabindex="6" class="btn btn-link text-muted">注册</a>
				</form>
				</shiro:guest>
				<shiro:user>
					<div class="sider-box-title">用户信息  </div>
					<a href="user?username=<shiro:principal></shiro:principal>">昵称：<shiro:principal></shiro:principal></a><br>
				</shiro:user>
				<div class="bg-success context hidden">
					<marquee onMouseOut="this.start()" onMouseOver="this.stop()"
						behavior="alternate" scrolldelay="100">
						<font size=+1 color=red>公告</font>
					</marquee>

					<p class="notice text-danger"></p>
				</div>
			</div>

		</div>
		<div class="center" style="height: 550px; border: 0px solid red;">
			<div class="showbook hidden"
				style="width: 100%; height: 500px; border: 1px solid #e0dcd7;"></div>
			<div class="test randomsee pull-left"
				style="width: 680px; height: 500px; border: 1px solid #e0dcd7; margin-left: -15px; margin-top: 20px;">
			
			<div class="home-topic-list">
				<c:forEach var="t" items="${topics}">
					<div class="topic-list-detail">
						<img src="//cdn.94cb.com/upload/tag/middle/320.png" alt="功能"
							class="img-circle">
						<div class="topic-item-content">						
							<a class="text-info" href="/post?topicId=${t.topicId}"><h4>${t.posts.get(0).postTitle}</h4></a>						
							<div>						
						<span>
							<br />
							admin&nbsp;·2018-02-07&nbsp;·最后回复由admin&nbsp;</span>
							<span class="label label-primary" style="float: right;">3</span>							  
						</div>
						</div>
						
					</div>
				</c:forEach>
								
			</div>
			</div>
			<div class="ad pull-right"
				style="width: 450px; height: 500px; border: 1px solid #e0dcd7; margin-left: -15px; margin-top: 20px;">
				<ul id="myTab" class="nav nav-tabs">
					<li class="active"><a href="#cxb" data-toggle="tab"> 最新话题</a></li>
					<li><a href="#ydb" data-toggle="tab">热门话题</a></li>
					<li><a href="#hpb" data-toggle="tab">优秀话题 </a></li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class="tab-pane fade in active" id="cxb">
						<ol>
							<li>西游记</li>
							<li>xxx</li>
							<li>xxx</li>
						</ol>
					</div>
					<div class="tab-pane fade" id="ydb">
						<ol>
							<li>倾城之恋</li>
							<li>xxx</li>
							<li>xxx</li>
						</ol>
					</div>
					<div class="tab-pane fade" id="hpb">
						<ol>
							<li>孤鸟</li>
							<li>xxx</li>
							<li>xxx</li>
						</ol>
					</div>
				</div>
				<!--  <img class="center-block" src="/pic?picUrl=ad/ad1.jpg" alt="广告">-->
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
<script>
	
</script>
<script src="${ctx}/static/js/index.js"></script>
<script src="${ctx}/static/js/common.js"></script>
<script src="${ctx}/static/js/activate-power-mode.js"></script>
<script>
POWERMODE.colorful = true; // 控制开启/开启礼花特效  
POWERMODE.shake = true; // 控制开启/关闭屏幕震动特效  
document.body.addEventListener('input', POWERMODE);
</script>
<script>

$(function(){
});
	$('.test').click(function(){
		$.ajax({
			url:"/do?event=flushPosts",
			type:'GET',
			//dataType:"json",
			success:function(result){
				var obj;
				if((typeof result=='object')&&result.constructor==Object){
	                 obj=result;
	             }else{
	                 obj  = eval("("+result+")");
	             }
				$('.btn.test').next().text(obj.posts.length);
				
			},
			error:function(xhr){
				$(".randomsee").text("错误提示： " + xhr.status + " " + xhr.statusText)
			}
		});			
	}
)
	
</script>
<script type="text/javascript">
$('#captchaImage').click(function() 
		{
		  $('#captchaImage').attr("src", "captcha?timestamp=" + (new Date()).valueOf());
		  
		});
  
</script>
</html>