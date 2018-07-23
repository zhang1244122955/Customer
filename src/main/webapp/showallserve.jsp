<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</head>

<body class="layui-anim layui-anim-up">
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">演示</a>
			<a> <cite>导航元素</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
		<xblock>
			<button class="layui-btn" onclick="history.go(-1)">返回</button>
		</xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th><b>服务编号</b></th><td>${Serve.serveid}</td>
					<th><b>服务名称</b></th><td>${Serve.servename}</td>
				</tr>
				<tr>
					<th><b>服务内容</b></th><td>${Serve.servecontent}</td>
					<th><b>客户编号</b></th><td>${cusname}</td>
				</tr>
				<tr>
					<th><b>服务创建人</b></th><td>${Serve.sercreateid}</td>
					<th><b>服务创建时间</b></th><td>${Serve.sercreatetime}</td> 
				</tr>
				<tr>
					<th><b>服务分配人</b></th> <td>${Serve.serassigneid}</td>
					<th><b>服务分配时间</b></th><td>${Serve.serassignetime}</td> 
				</tr>
				<tr>
					<th><b>服务处理人</b></th><td>${Serve.serdealid}</td>
					<th><b>服务处理时间</b></th><td>${Serve.serdealtime}</td>
				</tr>
				<tr>
					<th><b>服务归档时间</b></th><td>${Serve.serkeeptime}</td>
					<th><b>满意度</b></th><td>${Serve.satisfy}</td>
				</tr>
				<tr>
					<th><b>服务对象</b></th> <td>${Serve.nocusname}</td>
					<th><b>联系人电话</b></th> <td>${Serve.nocusphone}</td>
				</tr>
			</thead>
		</table>
	</div>
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