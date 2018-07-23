<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>zyd</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="/Customer/resources/css/font.css">
<link rel="stylesheet" href="/Customer/resources/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="/Customer/resources/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/Customer/resources/js/xadmin.js"></script>
</head>

<body>
	<div class="x-body">
		<div class="layui-row" style="padding-top: 20px">
			<div class="layui-col-md2">&nbsp</div>
			<div class="layui-col-md8">
				<form action="/Customer/addRole" method="post" class="layui-form">
					<div class="layui-form-item">
						<label class="layui-form-label"><span class="x-red">*</span>角色名</label>
						<div class="layui-input-inline">
							<input type="text" id="name" name="rolename" required=""
								lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"><span class="x-red">*</span>拥有权限 </label>
						<div class="layui-input-inline" style="width: 540px;">
							<div class="layui-collapse">
								<div class="layui-colla-item">
									<h2 class="layui-colla-title">机会管理权限</h2>
									<div class="layui-colla-content">
										<div class="layui-form-item">
											<input type="checkbox" class="chance" lay-skin="primary" lay-filter="chance_all" title="全选" id="chance_all" value="">
											<input type="checkbox" class="chance" lay-skin="primary" lay-filter="chance_one" title="查询机会" name="choose" value="1">
											<input type="checkbox" class="chance" lay-skin="primary" lay-filter="chance_one" title="添加机会" name="choose" value="2">
											<input type="checkbox" class="chance" lay-skin="primary" lay-filter="chance_one" title="删除机会" name="choose" value="8">
											<input type="checkbox" class="chance" lay-skin="primary" lay-filter="chance_one" title="修改机会" name="choose" value="16">
										</div>
									</div>
								</div>
								<div class="layui-colla-item">
									<h2 class="layui-colla-title">计划管理权限</h2>
									<div class="layui-colla-content">
										<div class="layui-form-item">
											<input type="checkbox" class="plan" lay-skin="primary" lay-filter="plan_all" title="全选" id="plan_all" value="">
											<input type="checkbox" class="plan" lay-skin="primary" lay-filter="plan_one" title="查询计划" name="choose" value="32">
											<input type="checkbox" class="plan" lay-skin="primary" lay-filter="plan_one" title="增加计划" name="choose" value="64">
											<input type="checkbox" class="plan" lay-skin="primary" lay-filter="plan_one" title="修改计划" name="choose" value="128">
											<input type="checkbox" class="plan" lay-skin="primary" lay-filter="plan_one" title="指派机/计" name="choose" value="4">
										</div>
									</div>
								</div>
								<div class="layui-colla-item">
									<h2 class="layui-colla-title">订单管理权限</h2>
									<div class="layui-colla-content">
										<div class="layui-form-item">
											<input type="checkbox" class="order" lay-skin="primary" lay-filter="order_all" title="全选" id="order_all" value="">
											<input type="checkbox" class="order" lay-skin="primary" lay-filter="order_one" title="查询订单" name="choose" value="256">
											<input type="checkbox" class="order" lay-skin="primary" lay-filter="order_one" title="增加订单" name="choose" value="512">
											<input type="checkbox" class="order" lay-skin="primary" lay-filter="order_one" title="修改订单" name="choose" value="1024">
											<input type="checkbox" class="order" lay-skin="primary" lay-filter="order_one" title="审核订单" name="choose" value="2048">
										</div>
									</div>
								</div>
								<div class="layui-colla-item">
									<h2 class="layui-colla-title">服务管理权限</h2>
									<div class="layui-colla-content">
										<div class="layui-form-item">
											<input type="checkbox" class="service" lay-skin="primary" lay-filter="service_all" title="全选" id="service_all" value="">
											<input type="checkbox" class="service" lay-skin="primary" lay-filter="service_one" title="查询服务" name="choose" value="4096">
											<input type="checkbox" class="service" lay-skin="primary" lay-filter="service_one" title="增加服务" name="choose" value="8192">
											<input type="checkbox" class="service" lay-skin="primary" lay-filter="service_one" title="增加服务" name="choose" value="16384">
											<input type="checkbox" class="service" lay-skin="primary" lay-filter="service_one" title="指派服务" name="choose" value="32768">
										</div>
									</div>
								</div>
								<div class="layui-colla-item">
									<h2 class="layui-colla-title">其他管理权限</h2>
									<div class="layui-colla-content">
										<div class="layui-form-item">
										<table>
										<tr><td>
											<input type="checkbox" class="else" lay-skin="primary" lay-filter="else_all" title="全选" id="else_all" value=""></td><td>
											<input type="checkbox" class="else" lay-skin="primary" lay-filter="else_one" title="管理用户" name="choose" value="65536">
											<input type="checkbox" class="else" lay-skin="primary" lay-filter="else_one" title="管理客户" name="choose" value="131072">
											<input type="checkbox" class="else" lay-skin="primary" lay-filter="else_one" title="管理角色" name="choose" value="262144"><br>
											<input type="checkbox" class="else" lay-skin="primary" lay-filter="else_one" title="管理新闻" name="choose" value="524288">
											<input type="checkbox" class="else" lay-skin="primary" lay-filter="else_one" title="管理轮播" name="choose" value="1048576">
											<input type="checkbox" class="else" lay-skin="primary" lay-filter="else_one" title="统计报表" name="choose" value="2097152"></td>
										</tr>
										</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"> </label>
						<button class="layui-btn" lay-submit="" lay-filter="add" type="submit">增加</button>
					</div>
				</form>
			</div>
			<div class="layui-col-md2">&nbsp</div>
		</div>
		<script>
			layui.use([ 'form', 'layer' ], function() {
				$ = layui.jquery;
				var form = layui.form, layer = layui.layer;
				
				//监听提交
				form.on('submit(add)', function(data) {
					console.log(data);
					// 获得frame索引
					var index = parent.layer.getFrameIndex(window.name);
					//关闭当前frame
					parent.layer.close(index);
					return true;
				});
				//机会全选
				form.on('checkbox(chance_all)', function(data){
				var a = data.elem.checked;
				if(a == true){
				$(".chance").prop("checked", true);
				form.render('checkbox');
				}else{
				$(".chance").prop("checked", false);
				form.render('checkbox');
				}
				});
				//机会有一个未选中全选取消选中
				form.on('checkbox(chance_one)', function(data){
				var item = $(".chance");
				for(var i=0;i<item.length;i++){
				if(item[i].checked == false){
				$("#chance_all").prop("checked", false);
				form.render('checkbox');
				}
				}
				});
				//计划全选
				form.on('checkbox(plan_all)', function(data){
				var a = data.elem.checked;
				if(a == true){
				$(".plan").prop("checked", true);
				form.render('checkbox');
				}else{
				$(".plan").prop("checked", false);
				form.render('checkbox');
				}
				});
				//计划有一个未选中全选取消选中
				form.on('checkbox(plan_one)', function(data){
				var item = $(".plan");
				for(var i=0;i<item.length;i++){
				if(item[i].checked == false){
				$("#plan_all").prop("checked", false);
				form.render('checkbox');
				}
				}
				});
				//订单全选
				form.on('checkbox(order_all)', function(data){
				var a = data.elem.checked;
				if(a == true){
				$(".order").prop("checked", true);
				form.render('checkbox');
				}else{
				$(".order").prop("checked", false);
				form.render('checkbox');
				}
				});
				//订单有一个未选中全选取消选中
				form.on('checkbox(order_one)', function(data){
				var item = $(".order");
				for(var i=0;i<item.length;i++){
				if(item[i].checked == false){
				$("#order_all").prop("checked", false);
				form.render('checkbox');
				}
				}
				});
				//服务全选
				form.on('checkbox(service_all)', function(data){
				var a = data.elem.checked;
				if(a == true){
				$(".service").prop("checked", true);
				form.render('checkbox');
				}else{
				$(".service").prop("checked", false);
				form.render('checkbox');
				}
				});
				//服务有一个未选中全选取消选中
				form.on('checkbox(service_one)', function(data){
				var item = $(".service");
				for(var i=0;i<item.length;i++){
				if(item[i].checked == false){
				$("#service_all").prop("checked", false);
				form.render('checkbox');
				}
				}
				});
				//其他全选
				form.on('checkbox(else_all)', function(data){
				var a = data.elem.checked;
				if(a == true){
				$(".else").prop("checked", true);
				form.render('checkbox');
				}else{
				$(".else").prop("checked", false);
				form.render('checkbox');
				}
				});
				//其他有一个未选中全选取消选中
				form.on('checkbox(else_one)', function(data){
				var item = $(".else");
				for(var i=0;i<item.length;i++){
				if(item[i].checked == false){
				$("#else_all").prop("checked", false);
				form.render('checkbox');
				}
				}
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