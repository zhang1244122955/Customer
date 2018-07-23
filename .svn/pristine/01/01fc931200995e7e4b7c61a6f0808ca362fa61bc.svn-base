<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

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
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">演示</a>
			<a> <cite>导航元素</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>上传图片格式需要满足轮播图片长宽比（注：长宽比在#：#到#：#之间,完美适配：778*440）</legend>
	</fieldset>
	<div class="x-body">

		<div class="layui-row">
			<div class="layui-col-sm4">
				<div class="layui-upload-drag" id="upload1">
					<img class="layui-btn-fluid" id="OnePath" src="${list.get(0).path}">
				</div>
			</div>
			<div class="layui-col-sm8">
				<div class="layui-form-item">
					<label class="layui-form-label">跳转网址</label>
					<div class="layui-input-block">
						<input type="text" name="title" lay-verify="title"
							autocomplete="off" placeholder="请输入网址" class="layui-input"
							id="OneHref" value="${list.get(0).href}">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">轮播title</label>
					<div class="layui-input-block">
						<input type="text" name="title" lay-verify="title"
							autocomplete="off" placeholder="请输入title" class="layui-input"
							id="OneTitle" value="${list.get(0).title}">
					</div>
				</div>
			</div>
		</div>
		<div class="layui-row">
			<div class="layui-col-sm4">
				<div class="layui-upload-drag" id="upload2">
					<img class="layui-btn-fluid" id="TwoPath" src="${list.get(1).path}">
				</div>
			</div>
			<div class="layui-col-sm8">
				<div class="layui-form-item">
					<label class="layui-form-label">跳转网址</label>
					<div class="layui-input-block">
						<input type="text" name="title" lay-verify="title"
							autocomplete="off" placeholder="请输入网址" class="layui-input"
							id="TwoHref" value="${list.get(1).href}">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">轮播title</label>
					<div class="layui-input-block">
						<input type="text" name="title" lay-verify="title"
							autocomplete="off" placeholder="请输入title" class="layui-input"
							id="TwoTitle" value="${list.get(1).title}">
					</div>
				</div>
			</div>
		</div>
		<div class="layui-row">
			<div class="layui-col-sm4">
				<div class="layui-upload-drag" id="upload3">
					<img class="layui-btn-fluid" id="ThreePath" src="${list.get(2).path}">
				</div>
			</div>
			<div class="layui-col-sm8">
				<div class="layui-form-item">
					<label class="layui-form-label">跳转网址</label>
					<div class="layui-input-block">
						<input type="text" name="title" lay-verify="title"
							autocomplete="off" placeholder="请输入网址" class="layui-input"
							id="ThreeHref" value="${list.get(2).href}">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">轮播title</label>
					<div class="layui-input-block">
						<input type="text" name="title" lay-verify="title"
							autocomplete="off" placeholder="请输入title" class="layui-input"
							id="ThreeTitle" value="${list.get(2).title}">
					</div>
				</div>
			</div>
		</div>
		<div class="layui-row">
			<div class="layui-col-sm4">
				<div class="layui-upload-drag" id="upload4">
					<img class="layui-btn-fluid" id="FourPath" src="${list.get(3).path}">
				</div>
			</div>
			<div class="layui-col-sm8">
				<div class="layui-form-item">
					<label class="layui-form-label">跳转网址</label>
					<div class="layui-input-block">
						<input type="text" name="title" lay-verify="title"
							autocomplete="off" placeholder="请输入网址" class="layui-input"
							id="FourHref" value="${list.get(3).href}">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">轮播title</label>
					<div class="layui-input-block">
						<input type="text" name="title" lay-verify="title"
							autocomplete="off" placeholder="请输入title" class="layui-input"
							id="FourTitle" value="${list.get(3).title}">
					</div>
				</div>
			</div>
		</div>
		
		

		<button class="layui-btn layui-btn-fluid" id="btn">提交</button>
	</div>
	<script src="resources/lib/layui/layui.js" charset="utf-8"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
	$("#btn").click(function (){
		$.ajax({
			type : "POST",
			url : "/Customer/file/update",
			data : {
				"onehref" : $("#OneHref").val(),
				"onetitle" : $("#OneTitle").val(),
				"onepath" : $("#OnePath").attr("src"),
				"twohref" : $("#TwoHref").val(),
				"twotitle" : $("#TwoTitle").val(),
				"twopath" : $("#TwoPath").attr("src"),
				"threehref" : $("#ThreeHref").val(),
				"threetitle" : $("#ThreeTitle").val(),
				"threepath" : $("#ThreePath").attr("src"),
				"fourhref" : $("#FourHref").val(),
				"fourtitle" : $("#FourTitle").val(),
				"fourpath" : $("#FourPath").attr("src")
			},
			success : function(data) {

				layer.alert('提交成功', {icon: 6});
			}
		});
	})
		layui
				.use(
						'upload',
						function() {
							var $ = layui.jquery, upload = layui.upload;
							//拖拽上传
							upload
									.render({
										elem : '#upload1',
										method : 'post',
										url : '/Customer/file/upload',
										accept : 'images',
										acceptMime : 'image/*',
										data : {
											name : '1.'
										},
										done : function(res) {
											alert(res.name);
											$("#upload1")
													.html(
															"<img class=layui-btn-fluid id='OnePath' src=/Customer/resources/images/" + res.name + " />");
										}
									});

							//拖拽上传
							upload
									.render({
										elem : '#upload2',
										method : 'post',
										url : '/Customer/file/upload',
										accept : 'images',
										acceptMime : 'image/*',
										data : {
											name : '2.'
										},
										done : function(res) {
											alert(res.name);
											$("#upload2")
													.html(
															"<img class=layui-btn-fluid id='TwoPath' src=/Customer/resources/images/" + res.name + " />");
										}
									});

							//拖拽上传
							upload
									.render({
										elem : '#upload3',
										method : 'post',
										url : '/Customer/file/upload',
										accept : 'images',
										acceptMime : 'image/*',
										data : {
											name : '3.'
										},
										done : function(res) {
											alert(res.name);
											$("#upload3")
													.html(
															"<img class=layui-btn-fluid id='ThreePath' src=/Customer/resources/images/" + res.name + " />");
										}
									});

							//拖拽上传
							upload
									.render({
										elem : '#upload4',
										method : 'post',
										url : '/Customer/file/upload',
										accept : 'images',
										acceptMime : 'image/*',
										data : {
											name : '4.'
										},
										done : function(res) {
											alert(res.name);
											$("#upload4")
													.html(
															"<img class=layui-btn-fluid id='FourPath' src=/Customer/resources/images/" + res.name + " />");
										}
									});
						});
	</script>
</body>

</html>