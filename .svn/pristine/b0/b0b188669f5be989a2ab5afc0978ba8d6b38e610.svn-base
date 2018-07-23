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
<script src="/Customer/resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="/Customer/resources/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/Customer/resources/js/xadmin.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

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
		<button class="layui-btn" id="btn" ailin="3,4" type="button"
			style="background-color: #f2f2f2;">
			<!-- <a title="编辑" href="/Customer/findmanagers"> -->
			<i class="layui-icon"></i>
			<!-- </a> -->
		</button>
		<span class="x-right" style="line-height: 40px">共有数据：<c:out
				value="${count}"></c:out>条
		</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>客户编号</th>
					<th>客户名称</th>
					<th>客户经理</th>
					<th>下单时间</th>
					<th>状态</th>
					<th>操作</th>

				</tr>
			</thead>
			<tbody id="">
				<c:forEach items="${list1}" var="wastage">
					<tr>
						<td>${wastage.custid}</td>
						<td>${wastage.custname}</td>
						<td>${wastage.name}</td>
						<td>${wastage.ocreatetime}</td>
						<td>${wastage.custstate}</td>
<c:choose>

						<c:when
							test="${wastage.custstate eq '确认流失'}">
							<td></td>
						</c:when>
						 <c:otherwise>
							<td class="td-manage">
								<button class="layui-btn" id="btn1" ailin="3,4" type="button"
									onclick="btn1('${wastage.custid}')">暂缓流失</button>
								<button class="layui-btn" id="btn2" ailin="3,4" type="button"
									onclick="btn2('${wastage.custid}')">确认流失</button>
							</td>
						</c:otherwise>
					</c:choose>


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
							location.href="/Customer/findCustomer?currentpage="+obj.curr;
					    }
						
					}
				});
			});
		
			
		</script>

		<script>
	
		layui.use('laydate', function() {
			var laydate = layui.laydate;

			//执行一个laydate实例
			laydate.render({
				elem : '#start' //指定元素
			});

			//执行一个laydate实例
			laydate.render({
				elem : '#end' //指定元素
			});
		});
		function btn1(custid) {
			//iframe层
			layer.open({
				type: 2,
				title: '暂缓流失',
				shadeClose: false, //点击遮罩关闭
				shade: 0.8,
				area: ['75%', '95%'],
				maxmin: true,
				closeBtn: 1,
				content: ['/Customer/stopwastageinfo?custid='+custid, 'yes'], //iframe的url，yes是否有滚动条
				//yes: function (index, layero) {
				//    alert(index);
				//    alert(layero);
				//},
				end: function() {
					location.reload();
				}
			});
	};
	function btn2(custid) {
		//iframe层
		layer.open({
			type: 2,
			title: '确认流失',
			shadeClose: false, //点击遮罩关闭
			shade: 0.8,
			area: ['50%', '95%'],
			maxmin: true,
			closeBtn: 1,
			content: ['/Customer/dmwastageinfo?custid='+custid, 'yes'], //iframe的url，yes是否有滚动条
			//yes: function (index, layero) {
			//    alert(index);
			//    alert(layero);
			//},
			end: function() {
				location.reload();
			}
		});
};
 
		
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