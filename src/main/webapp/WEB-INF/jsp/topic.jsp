<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<link rel="stylesheet"
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="${ctx }/static/css/topic.css">
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link rel="icon" href="${ctx}/static/ico/bitbug_favicon.ico"
	type="image/x-icon">
<script type="text/javascript" src="${ctx}/static/layer.js"></script>
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
			<li><a href="/home">首页</span></a></li>
			<li class="active dropdown"><a href="#">版块</a></li>
			<li><a href="/topic">xx</a></li>
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
					<a href="/home">XX论坛</a> »<a href="/board"> 话题 </a> » ${boardName}  
				</div>
				<div class="main-topic home-topic-list">
				<!--  ${page.list.get(0).posts.get(0)}-->
				<c:if test="${msg!=null}">
					<h4>${msg}</h4>
				</c:if>
				
				<c:if test="${page.list.size()>0}">
				
					<c:forEach var="i" items="${page.list}">
						<div class="topic-list-detail">
							<img src="//cdn.94cb.com/upload/tag/middle/320.png" alt="功能"
							class="img-circle">
							<div class="topic-item-content">
							<a href="/post?topicId=${i.topicId}&&boardName=${boardName }"><h4>${i.posts.get(0).postTitle}</h4></a>
							<span>&nbsp;&nbsp;${i.views}人查看 &nbsp;&nbsp;&nbsp;&nbsp;${i.replies}人回复&nbsp;&nbsp;${i.digest}人收藏  </span>
							</div>
								<div>						
								<span>
								<br />
								<span>admin</span>&nbsp;·2017-05-05&nbsp;·最后回复由admin&nbsp;</span>
								<span class="label label-primary hidden" style="float: right;">${i.topicId}</span>							  
								</div>
						 	</div>					
					</c:forEach>
					
							</c:if>	
						 </div>
		</div>
		
		
			<div class="col-md-4 right-menu">
				<div class="topic-jiesao">
					<div class="sider-box-title"> 话题：<span class="boardName">${board.boardName}</span></div>
					<img class="img-thumbnail" src="//cdn.94cb.com/upload/tag/large/320.png" alt="功能" 
					width="200" height="200">
					<div class="sider-box-content">	
					${board.boardDesc}				
					</div>
					<br>
				</div>
			
			
				<shiro:guest>
				<div class="login">
				<div class="sider-box-title"> 登 录 </div>
				<form action="/login" method="post" class="">
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
				</shiro:guest>
				<shiro:user>
					<shiro:principal></shiro:principal>
				</shiro:user>
				<hr>
				<div class="adv">
					广告
				</div>
				
		
		</div>
		
		
		<shiro:user>
		<div class="post-repliyByMe">
			<span><shiro:principal></shiro:principal></span><h4>发表新帖</h4><br/>
			<span>标题：</span><input id="postTitle" type="text" name="postTitle" placeholder="标题" class="">
				<div class="post-repliyByMe-detail">
			</div>
			<button id="submit">发帖</button>
		</div>
		</shiro:user>
		
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
 <script type="text/javascript" src="${ctx }/static/js/wangEditor.min.js"></script>
    <script type="text/javascript">
        var E = window.wangEditor

        /*var editor1 = new E('#div1', '#div2')
        editor1.create()*/

        var editor = new E('.post-repliyByMe-detail')
        editor.create();
       /* editor.txt.html('<p>用 JS 设置的内容</p>');
        editor.txt.append('<p>追加的内容</p>');	*/
        //editor.txt.clear();
        $("#submit").click(function(){
        	
        	$.ajax({
        		type:"GET",
        		//url:"/postMain?postTitle="+$("input[name='postTitle']").val()+"&&postText="+editor.txt.text(),
        		//dataType: false,
        		url:"/postMain",
        		data:'postTitle='+$("input[name='postTitle']").val()+'&&postText='+editor.txt.text()+"&&boardName="+$(".boardName").text(),
    			success:function(data, textStatus){
    				alert("发帖成功！经验+"+data); 
    			},
    			error: function(XMLHttpRequest, textStatus, errorThrown){
    				alert("发帖失败！原因:"+errorThrown);
  			}
    			
        	})
        })
        for (var i = 0; i < $(".label-primary").length; i++) {
        	$(".label-primary").eq(i).load("/count", "topicId="+$(".label-primary").eq(i).text(), function(response,status,xhr) {
            	$(this).text(response);
            	$(this).removeClass("hidden");
            })
		}
        
    </script>
</html>