<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎页面-X-admin2.0</title>
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
<script type="text/javascript">
	$(function() {
		if ($("#custstate").val() == "暂缓流失") {
			$("#stopwastageinfo").attr("readonly", "readonly");

		} else if ($("#custstate").val() == "流失预警") {
			$("#stopwastageinfo1").css("display", "none");
		}

	});
</script>
</head>

<body>
	<div class="layui-row">
		<div class="layui-col-xs1">
			<div class="grid-demo grid-demo-bg1">&nbsp</div>
		</div>
		<div class="layui-col-xs10">
			<form class="layui-form" action="/Customer/stopwastage ">
				<div class="grid-demo">

					<div class="layui-row">
						<div class="layui-col-xs2">
							<div class="grid-demo grid-demo-bg1">
								<label class="layui-form-label"><span class="x-red">*</span>客户编号</label>
							</div>
						</div>
						<div class="layui-col-xs8">
							<div class="grid-demo">
								<input type="text" name="custid" lay-verify="required"
									autocomplete="off" placeholder="" class="layui-input"
									id="custid" value="${w1.custid}" readonly="readonly">
							</div>
						</div>
					</div>
					<br>
					<div class="layui-row">
						<div class="layui-col-xs2">
							<div class="grid-demo grid-demo-bg1">
								<label class="layui-form-label"><span class="x-red">*</span>客户名称</label>
							</div>
						</div>
						<div class="layui-col-xs8">
							<div class="grid-demo">
								<input type="text" name="custname" lay-verify="required"
									autocomplete="off" placeholder="" class="layui-input"
									id="custname" value="${w1.custname}" readonly="readonly">
							</div>
						</div>
					</div>
					<br>
					<div class="layui-row">
						<div class="layui-col-xs2">
							<div class="grid-demo grid-demo-bg1">
								<label class="layui-form-label"><span class="x-red">*</span>客户经理</label>
							</div>
						</div>
						<div class="layui-col-xs8">
							<div class="grid-demo">
								<input type="text" name="name" lay-verify="required"
									autocomplete="off" placeholder="" class="layui-input" id="name"
									value="${w1.name}" readonly="readonly">
							</div>
						</div>
					</div>
					<br>
					<div class="layui-row">
						<div class="layui-col-xs2">
							<div class="grid-demo grid-demo-bg1">
								<label class="layui-form-label"><span class="x-red">*</span>下单时间</label>
							</div>
						</div>
						<div class="layui-col-xs8">
							<div class="grid-demo">
								<input type="text" name="ocreatetime" lay-verify="required"
									autocomplete="off" placeholder="" class="layui-input"
									id="ocreatetime" value="${w1.ocreatetime}" readonly="readonly">
							</div>
						</div>
					</div>
					<br>
					<div class="layui-row" style="display: none;">
						<div class="layui-col-xs2">
							<div class="grid-demo grid-demo-bg1">
								<label class="layui-form-label"><span class="x-red">*</span>客户状态</label>
							</div>
						</div>
						<div class="layui-col-xs8">
							<div class="grid-demo">
								<input type="text" name="custstate" lay-verify="required"
									autocomplete="off" placeholder="" class="layui-input"
									id="custstate" value="${w1.custstate}" readonly="readonly">
							</div>
						</div>
					</div>



					<div class="layui-row">
						<div class="layui-col-xs2">
							<div class="grid-demo grid-demo-bg1">
								<label class="layui-form-label"><span class="x-red">*</span>暂缓措施</label>
							</div>
						</div>
						<div class="layui-col-xs8">
							<div class="grid-demo">
								<input type="text" name="stopwastageinfo" lay-verify=""
									autocomplete="off" placeholder="" class="layui-input"
									id="stopwastageinfo" value="${w1.stopwastageinfo}">
							</div>
						</div>
					</div>
					<br>
					<div class="layui-row" id="stopwastageinfo1">
						<div class="layui-col-xs2">
							<div class="grid-demo grid-demo-bg1">
								<label class="layui-form-label"><span class="x-red">*</span>追加措施</label>
							</div>
						</div>
						<div class="layui-col-xs8">
							<div class="grid-demo">
								<textarea id="demo" style="display: none;"
									name="stopwastageinfo1"></textarea>

							</div>
						</div>
					</div>
					<br>
					<div class="layui-row">
						<div class="layui-col-xs2">
							<div class="grid-demo grid-demo-bg1">
								<label class="layui-form-label"></label>
							</div>
						</div>
						<div class="layui-col-xs8">
							<div class="grid-demo">
								<button type="submit" class="layui-btn" lay-submit=""
									lay-filter="add" id="btn">增加</button>
							</div>
						</div>

					</div>
			</form>
		</div>

		<div class="layui-col-xs1">
			<div class="grid-demo">&nbsp</div>
		</div>
	</div>
	<script type="text/javascript">
		layui
				.use(
						[ 'form', 'layer' ],
						function() {
							$ = layui.jquery;
							var form = layui.form, layer = layui.layer;

							//自定义验证规则
							form
									.verify({

										phone : [
												/^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/,
												'手机号格式不正确' ]
									});

							//监听提交
							form.on('submit(add)', function(data) {

								console.log(data);
								// 获得frame索引
								var index = parent.layer
										.getFrameIndex(window.name);
								//关闭当前frame
								parent.layer.close(index);
								return true;
							});
						})
	</script>
	<script>
		layui.use('layedit', function() {
			var layedit = layui.layedit;
			layedit.build('demo', {//建立编辑器设置编辑器高度
				height : 180

			});
		});
	</script>

</body>

</html>