<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jquery-3.3.1.js"></script>
<script src="resources/js/amq_jquery_adapter.js"></script>
<script src="resources/js/amq.js"></script>
<script>
	 var amq = org.activemq.Amq;
	amq.init({
		uri : 'amq',
		logging : false,
		timeout : 20,
		clientId : 'ailin'
	});
	/*var myHandler = {
		rcvMessage : function(message) {
			//接收到消息后，自己的业务处理逻辑
			
			alert(message.destination)
			alert(message.getAttribute('type'));
		}
	};
	amq.addListener('ailin', 'queue://liuzhonghui', myHandler.rcvMessage);

	window.onbeforeunload = function() {

		amq.removeListener('ailin', 'queue://liuzhonghui');
	} */
	$(function() {
		//test1为消费者的一个ID,接受到消息回调时会用到作为标识 
		//topic://msg表示主题订阅目的地

		$("#send").click(function() {
			amq.sendMessage("queue://123",$("#msg").val())
			/* $.ajax({
				type : "POST",
				url : "SendMessage",
				data : {
					"msg" : $("#msg").val()
				},
			}) */
		})

		$("#receive").click(function() {
			alert(1)
			$.ajax({
				type : "GET",
				url : "ReceiveMessage",
				success : function(data) {
					alert(data)
				}
			})
		})
	})
</script>
</head>
<body>
	<input type="text" id="msg">
	<button id="send">发送消息</button>
	<button id="receive">接收消息</button>
</body>
</html>