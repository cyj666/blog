<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>

<link rel="stylesheet"
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script type="text/javascript" src="${ctx}/static/layer.js"></script>
<script src="${ctx }/static/js/register.js"></script>
<link rel="stylesheet" href="${ctx }/static/css/board.css">
<link rel="shortcut icon" href="${ctx }/static/ico/bitbug_favicon.ico">
<style type="text/css">
body {
	background-color: #efefef;
}

.container {
	position: relative;
	width: 1000px;
	padding-bottom: 55px;
	margin: 0 auto;
	background-color: #fff;
	border-radius: 6px;
	box-shadow: 0 3px 3px #cbc9c9;
}

.form-group {
	margin-top: 15px;
	margin-bottom: 30px;
}

.top {
	height: 100px;
}
</style>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>欢迎来到注册界面</title>
</head>
<body>
	<div class="row top">
		<div class="center-block" style="width: 200px;">
			<h2 class="text-primary">欢迎注册</h2>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="center-block" style="width: 700px;">
				<form:form modelAttribute="user" method="post" action="register.do"
					class="form-horizontal" role="form" enctype="multipart/form-data">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">
						用户名
						<span class="glyphicon glyphicon-ok text-success username" style="display: none"></span>
						<span class="glyphicon glyphicon-remove text-danger username" style="display: none"></span>
						</label>
						<div class="col-sm-10">
							<form:input type="text" class="form-control" id="username"
								placeholder="请输入名字" path="username" style="width:300px" />
							<span class="help-block"></span>
							<span class="text-danger"></span>
							<form:errors path="username" cssStyle="color:red"></form:errors>
						</div>
						
					</div>					
					<div class="form-group">
						<label for="password" class="col-sm-2 control-label">密码
						<span class="glyphicon glyphicon-ok text-success password" style="display: none"></span>
						<span class="glyphicon glyphicon-remove text-danger password" style="display: none"></span>
						</label>
						<div class="col-sm-10">
							<form:input type="password" class="form-control" id="password"
								placeholder="请输入密码" path="password" style="width:300px" />
							<span class="help-block"></span>
							<form:errors path="password" cssStyle="color:red"></form:errors>
						</div>
					</div>
					<div class="form-group">
						<label for="password2" class="col-sm-2 control-label">确认密码
						<span class="glyphicon glyphicon-ok text-success password2" style="display: none"></span>
						<span class="glyphicon glyphicon-remove text-danger password2" style="display: none"></span>
						</label>						
						<div class="col-sm-10">
							<input type="password" class="form-control" id="password2" name="password2"
								placeholder="请输入密码" style="width: 300px" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">上传头像</label>
						<div class="col-sm-10">
							<input type="file" name="file" class="form-control" style="width: 300px"  />

						</div>
					</div>
					<div class="form-group ">
						<div class="col-sm-offset-2 col-sm-10">						
							<input class="form-control required" type="text" id="captcha"
								placeholder="验证码" name="captcha" class="text" maxlength="5"
								style="width: 100px; display: inline" required /><img
								id="captchaImage" src="captcha.form" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<div class="checkbox">
								<label> <input type="checkbox">我同意《XX论坛用户协议》
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">提交</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$('#captchaImage').click(
			function() {
				$('#captchaImage').attr("src",
						"captcha.form?timestamp=" + (new Date()).valueOf());

			});
	$("#password2").blur(function() {
		if ($("#password").val()!=$(this).val()) {
			layer.tips("两次密码不一致",this);
			$(".password2").eq(1).css("display","inline");
			$(".password2").eq(0).css("display","none");
		}else{
			$(".password2").eq(0).css("display","inline");
			$(".password2").eq(1).css("display","none");
		}
	})
	$("#username").blur(function() {
		if (true) {
			$(".username").eq(0).css("display","inline");
			
		}
	})
	$("#username").focus(function() {
		if (true) {
			$(".username").eq(0).css("display","none");
			
		}
	})
</script>
<script src="${ctx}/static/js/common.js"></script>
<script src="${ctx}/static/js/activate-power-mode.js"></script>
<script>
POWERMODE.colorful = true; // 控制开启/开启礼花特效  
POWERMODE.shake = true; // 控制开启/关闭屏幕震动特效  
document.body.addEventListener('input', POWERMODE);
$(function(){
	var href=location.href;  
	   if(href.indexOf("message")>0){  
	      var message = decodeURI(getQueryVariable("message"));
	      if (message=="注册成功！") {
	    	  layer.alert(message, {
					icon : 1,
					skin : 'layui-layer-molv',// 样式类名
					closeBtn : 1
				});
		}else{
			layer.alert(message, {
				icon : 2,
				skin : 'layui-layer-lan',// 样式类名
				closeBtn : 1				
			});
		}
	       
	   }   
});
function getQueryVariable(variable)
{
       var query = window.location.search.substring(1);
       var vars = query.split("&");
       for (var i=0;i<vars.length;i++) {
               var pair = vars[i].split("=");
               if(pair[0] == variable){return pair[1];}
       }
       return(false);
}
</script>
</html>