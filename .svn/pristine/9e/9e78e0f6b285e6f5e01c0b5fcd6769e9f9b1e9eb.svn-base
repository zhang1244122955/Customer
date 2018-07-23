<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>zyd</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
		<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="/Customer/resources/css/font.css">
		<link rel="stylesheet" href="/Customer/resources/css/xadmin.css">
		<script src="/Customer/resources/js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript" src="/Customer/resources/lib/layui/layui.js" charset="utf-8"></script>
		<script type="text/javascript" src="/Customer/resources/js/xadmin.js"></script>
	</head>

	<body>
		<div class="x-body">
			<div class="layui-row" style="padding-top: 80px">
				<div class="layui-col-md3">&nbsp</div>
				<div class="layui-col-md6">
					<form class="layui-form" action="/Customer/modifyOwn" method="post">
						<div class="layui-form-item">
							<label class="layui-form-label"> <span class="x-red">*</span>用户名
						</label>
							<div class="layui-input-inline">
								<input type="text" id="userid" name="userid" required="" value="${user.userid }" lay-verify="name" autocomplete="off" class="layui-input layui-disabled" readOnly="true">
							</div>
						</div>
						<div class="layui-form-item">
							<label for="L_pass" class="layui-form-label"><span class="x-red">*</span>密码</label>
							<div class="layui-input-inline">
								<input type="password" id="L_pass" name="userpwd" required="" lay-verify="pass" autocomplete="off" class="layui-input">
							</div>
							<div class="layui-form-mid layui-word-aux">
								6到32个字符
							</div>
						</div>
						<div class="layui-form-item">
							<label for="L_repass" class="layui-form-label"><span class="x-red">*</span>确认密码</label>
							<div class="layui-input-inline">
								<input type="password" id="L_repass" name="reuserpwd" required="" lay-verify="repass" autocomplete="off" class="layui-input">
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label"> </label>
							<button class="layui-btn" lay-filter="modify" lay-submit="" type="submit">修改</button>
						</div>
					</form>
				</div>
				<div class="layui-col-md3">&nbsp</div>
			</div>
		</div>
		<script>
			layui
				.use(
					['form', 'layer'],
					function() {
						$ = layui.jquery;
						var form = layui.form,
							layer = layui.layer;
						//自定义验证规则
						form
							.verify({
								pass: [/(.+){6,32}$/, '密码必须6到32位'],
								repass: function(value) {
									if($('#L_pass').val() != $('#L_repass').val()) {
										return '两次密码不一致';
									}
								}
							});

						//监听提交
						form.on('submit(modify)', function(data) {
							console.log(data);
							// 获得frame索引
							var index = parent.layer
								.getFrameIndex(window.name);
							//关闭当前frame
							parent.layer.close(index);
							return true;
						});
					});
		</script>
		<script>
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