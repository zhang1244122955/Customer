<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="/Customer/resources/css/font.css">
<link rel="stylesheet" href="/Customer/resources/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="/Customer/resources/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/Customer/resources/js/xadmin.js"></script>
<script src="/Customer/resources/js/photobooth_min.js"></script>

</head>
<body class="login-bg">
	<div class="login layui-anim layui-anim-up"><!-- <div class="message">登录</div> -->
		
		<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
			<ul class="layui-tab-title">
			<li class="layui-this" style="width:40%;">账户密码</li>
			<li style="width:40%;">人脸识别</li>
			</ul>
			<div class="layui-tab-content" style="height: 100px;">
				<div class="layui-tab-item layui-show">
					
				<form method="post" class="layui-form">
					<br><br><br><br><br>
					<input name="userid" placeholder="用户名" type="text" id="userid"
						lay-verify="required" class="layui-input">
						<hr class="hr15">
						<input name="userpwd" lay-verify="required" placeholder="密码"  id="userpwd"
						type="password" class="layui-input">
						<hr class="hr15">
						<br>
<!-- 					<input value="登录" lay-submit="" lay-filter="login" style="width: 100%;"
						type="submit"> -->
						<hr class="hr20">
					</form>
					<button id="login" type="" style="color:white; font-size:18px; background-color:#189F92; border:0px; border-radius:2px; width: 100%;height: 45px;" value="登录">登录</button>
				</div>
				<div class="layui-tab-item">
				
						<div id="example" class="photo" style="padding-left:22px; width: 100%; height: 200px;"></div>
						<hr class="hr15">
						<input name="userid" placeholder="用户名" type="text" id="faceuserid"
						lay-verify="required" class="layui-input">
						<hr class="hr15">
						<input style="display:none" name="userpwd" lay-verify="required" placeholder="密码"  id="faceuserpwd"
						type="password" class="layui-input">
						<input hidden id="facetoken" name="facetoken" />
						<hr class="hr15">
						<button id="btn_face" type="" style="color:white; font-size:18px; background-color:#189F92; border:0px; border-radius:2px; width: 100%;height: 45px;" value="登录">登录</button>
				</div>
			</div>
		</div> 
		
	</div>
 	<script type="text/javascript">
 	var tab0=true;
 	var tab1=false;
 	layui.use('element', function(){
 		  var element = layui.element;
 		  
 		  //一些事件监听
 		 element.on('tab(docDemoTabBrief)', function(data){
 			//得到当前Tab的所在下标
 		 	if(data.index == 0 && !tab0){
 		 		$('#example').data("photobooth").destroy();
 		 		tab0=true;
				tab1=false;
 		 	}else if(data.index == 1 && !tab1){
 		 		$('#example').photobooth();
				$('#example').data("photobooth").resize(267, 200);
				$('#example').on("image", function(event, dataUrl) {
				$('#facetoken').val(dataUrl);
				});
				tab1=true;
				tab0=false;
 		 	}
 	 		});
 		});
 	
 	
 	$("#btn_face").click(function() {
			//按钮a点击完成后。b也执行点击事件。
			$(".trigger").trigger('click');
			$("#btn_face").html("正在登录···");
			$("#btn_face").css("background-color", "#D7D7D7");
			$("#btn_face").attr("disabled", true);
			$.ajax({
					type: "POST",
					url: "facelogin",
					data: {
						"facetoken": $('#facetoken').val(),
						"userid": $('#faceuserid').val(),
						"userpwd": $('#faceuserpwd').val()
					},
					success: function(data) {
						$("#btn_face").html("登录");
						$("#btn_face").css(
							"background-color",
							"#189F92");
						$("#btn_face").attr("disabled",
							false);
						//alert(data);
						switch(data) {
							case '10002000':
								//登录成功
								layer.msg('登录成功', {
									icon: 1,
									time: 1000
								});
								location.href = "/Customer/index.jsp";
								break;
							case '10000001':
								//用户名不存在
								layer.msg('用户名不存在', {
									icon: 5,
									time: 1000
								});
								break;
							case '10000002':
								//用户名或密码错误
								layer.msg('用户名或密码错误', {
									icon: 5,
									time: 1000
								});
								break;
							case '10000003':
								//未开通人脸登录
								layer.msg('未开通人脸登录', {
									icon: 5,
									time: 1000
								});
								$('#faceuserpwd').css("display",
									"block");
								break;
							case '10000004':
								//用户名脸部信息匹配失败
								layer.msg('用户名脸部信息匹配失败', {
									icon: 5,
									time: 1000
								});
								break;
							case '10000010':
								//人脸有被遮挡
								layer.msg('人脸有被遮挡', {
									icon: 5,
									time: 1000
								});
								break;
							case '10000011':
								//人脸模糊
								layer.msg('人脸模糊', {
									icon: 5,
									time: 1000
								});
								break;
							case '10000012':
								//人脸光照不好
								layer.msg('人脸光照不好', {
									icon: 5,
									time: 1000
								});
								break;
							case '10000013':
								//人脸不完整
								layer.msg('人脸不完整', {
									icon: 5,
									time: 1000
								});
								break;
							case '10000014':
								//活体检测未通过
								layer.msg('活体检测未通过', {
									icon: 5,
									time: 1000
								});
								break;
							case '10000015':
								//质量检测未通过 右眼遮挡程度过高
								layer.msg('质量检测未通过 右眼遮挡程度过高', {
									icon: 5,
									time: 1000
								});
								break;
							case '10000016':
								//质量检测未通过 左眼遮挡程度过高
								layer.msg('质量检测未通过 左眼遮挡程度过高', {
									icon: 5,
									time: 1000
								});
								break;
							case '10000017':
								//质量检测未通过 右脸遮挡程度过高
								layer.msg('质量检测未通过 右脸遮挡程度过高', {
									icon: 5,
									time: 1000
								});
								break;
							case '10000018':
								//质量检测未通过 左脸遮挡程度过高
								layer.msg('质量检测未通过 左脸遮挡程度过高', {
									icon: 5,
									time: 1000
								});
								break;
							case '10000019':
								//质量检测未通过 下巴遮挡程度过高
								layer.msg('质量检测未通过 下巴遮挡程度过高', {
									icon: 5,
									time: 1000
								});
								break;
							case '10000020':
								//质量检测未通过 鼻子遮挡程度过高
								layer.msg('质量检测未通过 鼻子遮挡程度过高', {
									icon: 5,
									time: 1000
								});
								break;
							case '10000021':
								//质量检测未通过 嘴巴遮挡程度过高
								layer.msg('质量检测未通过 嘴巴遮挡程度过高', {
									icon: 5,
									time: 1000
								});
								break;
							case '10000100':
								//发现未知错误
								layer.msg('发现未知错误', {
									icon: 5,
									time: 1000
								});
								break;

							default:
								break;
						}

					}
				});
		});
 	$("#login").click(function() {
		$("#login").html("正在登录···");
		$("#login").css("background-color", "#D7D7D7");
		$("#login").attr("disabled", true);
		$.ajax({
			type : "POST",
			url : "login",
			data : {
				"userid" : $("#userid").val(),
				"userpwd" : $("#userpwd").val()
			},
			success : function(data) {
				$("#login").html("登录");
				$("#login").css(
					"background-color",
					"#189F92");
				$("#login").attr("disabled",
					false);
				if ("true"==data) {
					layer.msg('登录成功', {
						icon: 1,
						time: 1000
					});
					location.href = "/Customer/index.jsp";
				} else if("false"==data){
					layer.msg('用户名或密码错误', {
						icon: 5,
						time: 1000
					});
				}
			}
		}); 
	
 	})
	</script>
 
<!-- 	<script>
		$(function  () {
			layui.use('form', function(){
				var form = layui.form;
			// layer.msg('玩命卖萌中', function(){
			//   //关闭后的操作
			//   });
			//监听提交
				form.on('submit(login)', function(data){
					/* layer.msg(JSON.stringify(data.field),function(){
					location.href='login' */
				});
				return false;
			});
		});
    </script> -->

	<script>
    //百度统计可去掉
    var _hmt = _hmt || [];
    (function() {
      var hm = document.createElement("script");
      hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
      var s = document.getElementsByTagName("script")[0]; 
      s.parentNode.insertBefore(hm, s);
    })();
    </script>
</body>
</html>