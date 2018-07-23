<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript">
$(function () {
	//对弹出层的操作
	$("#btn").click(function (){
		location.href="/Customer/findCustomer";
	})
})

</script>

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
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so">
				<input class="layui-input" placeholder="开始日" name="start" id="start">
				<input class="layui-input" placeholder="截止日" name="end" id="end">
				<input type="text" name="username" placeholder="请输入用户名"
					autocomplete="off" class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>
		<button class="layui-btn" id="btn" ailin="3,4" type="button">
			 <!-- <a title="编辑" href="customer-selectall.jsp"> -->
			<i class="layui-icon">&#xe65a;</i>返回
			<!-- </a> -->
		</button>
		<span class="x-right" style="line-height: 40px">共有数据：<c:out
				value="${count}"></c:out>条
		</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>订单编号</th>
					<th>商品编号</th>
					<th>需要商品数量</th>
					<th>订单创建时间</th>
					<th>订单状态</th>
					<th>订单报价</th>


				</tr>
			</thead>
			<tbody id="">
				<c:forEach items="${list}" var="order">
					<tr>
						<td>${order.oid}</td>
						<td>${order.gid}</td>
						<td>${order.gnum}</td>
						<td>${order.ocreatetime}</td>
						<td>${order.ostatus}</td>
						<td>${order.ooffer}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="demo1"></div>

		<script>
		/* 分页 */
			layui.use(['laypage', 'layer'], function() {
				var laypage = layui.laypage,
					layer = layui.layer;

				//总页数大于页码总数
				laypage.render({
					elem: 'demo1',
					limit: 8,
					count: ${count},//数据总数
					curr: ${currentpage},
					jump: function(obj, first) {
						//首次不执行
					    if(!first){
							location.href="/Customer/historyorder?currentpage="+obj.curr;
					    }
						
					}
				});
			}); 
		</script>
</body>

</html>