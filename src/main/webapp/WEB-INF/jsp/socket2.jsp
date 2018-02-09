<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="">
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>websocketd</title>
</head>
<link rel="stylesheet"
	href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
<script src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script
	src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<body>
	<h2>websocketd 客户端的简单测试</h2>
	聊天内容
	<p id="qq" style="border: solid black 1px;">...</p>
	<input type="text">
	<button class="submit">发送</button>
	<button class="start">开始</button>
	<button class="end">结束</button>
	<pre id="log"></pre>
	<script type="text/javascript">
		$(function(){
			var ws = new WebSocket("ws://localhost:8090/");
			ws.onopen = function() {
				// Web Socket 已连接上，使用 send() 方法发送数据				
				$(".submit").click(function(){
					ws.send($(":text").val());
					console.log("数据发送中...");
				})			
			};
			ws.onerror = function(evt)  
		    {  
				console.log("出错！"+evt.reason);
		    };  
			ws.onmessage = function(evt) {
				var received_msg = evt.data;
				console.log("数据已接收..." + received_msg);
				$('#qq').text(received_msg);
			};
			ws.onclose = function(evt) {
				// 关闭 websocket
				console.log("连接已关闭..."+evt.reason);
			};
		});
		function WebSocketTest() {
			if ("WebSocket" in window) {
				alert("您的浏览器支持 WebSocket!");

				// 打开一个 web socket
				var ws = new WebSocket("ws://localhost:8090/");

				ws.onopen = function() {
					// Web Socket 已连接上，使用 send() 方法发送数据
					ws.send("how are you?");
					console.log("数据发送中...");
				};

				ws.onmessage = function(evt) {
					var received_msg = evt.data;
					console.log("数据已接收..." + received_msg);
				};

				ws.onclose = function() {
					// 关闭 websocket
					console.log("连接已关闭...");
				};
			}

			else {
				// 浏览器不支持 WebSocket
				alert("您的浏览器不支持 WebSocket!");
			}
		}
	</script>
</head>
<body>

	<div id="sse">
		<a href="javascript:WebSocketTest()">运行 WebSocket</a>
	</div>

</body>
</html>