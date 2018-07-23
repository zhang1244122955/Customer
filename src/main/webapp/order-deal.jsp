<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a> <cite>订单管理</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so">
				<input type="text" name="username" placeholder="请输入客户名称"
					autocomplete="off" class="layui-input">

				<button class="layui-btn" lay-submit="" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>
		<span class="x-right" style="line-height: 40px">共有数据：${dealOrders.size()}条
		</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>ID</th>
					<th>客户名称</th>
					<!-- <th>商品名称</th>
					<th>商品数量</th>
					<th>报价</th> -->
					<th>创建时间</th>
					<th>审核时间</th>
					<th>审核人</th>
					<th>审核状态</th>
					<!-- <th>审核意见</th> -->
					<th>查看详情</th>
				</tr>
			</thead>
			<tbody id="tbody">
				<c:if test="${empty  dealOrders }">
					<tr>
						<td colspan="9"><span
							style="color: red; font-size: 16px; display: inline-block; width: 1000px; text-align: center;">您没有待处理的订单哦</span></td>
					</tr>
				</c:if>
				<c:if test="${ not empty  dealOrders }">
					<c:forEach items="${dealOrders}" var="orders">
						<tr>
							<td>${orders.getOid() }</td>
							<td>${orders.getCustname() }</td>
							<%-- <td>${orders.getGname() }</td>
							<td>${orders.getGnum() }</td>
							<td>${orders.getOoffer() }</td> --%>
							<td><fmt:formatDate value='${orders.getOcreatetime()}'
									pattern='yyyy-MM-dd hh:mm:ss' /></td>
							<td><fmt:formatDate value='${orders.getOchecktime()}'
									pattern='yyyy-MM-dd hh:mm:ss' /></td>
							<%-- <td>${orders.getName() }</td> --%>
							<td>${orders.getCheckName() }</td>
							<td>${orders.getOstatus() }</td>
							<td class="td-manage"><a href="/Customer/showDealOrder?orderId=${orders.getOid()}" class="layui-btn layui-btn-warm">查看详情</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<div class="page" id="demo1"></div>

	</div>
	<script src="resources/js/jquery-3.3.1.js" charset="utf-8"></script>
	<script src="/static/build/layui.js"></script>
	<script>
		layui.use(['laypage', 'layer'], function() {
			var laypage = layui.laypage,
				layer = layui.layer;

			//总页数大于页码总数
			laypage.render({
				elem: 'demo1',
				limit: 8,
				count: ${count},//数据总数
				curr: ${page},
				jump: function(obj, first) {
					//首次不执行
				    if(!first){
						location.href="/Customer/dealOrdersShow?currentPage="+obj.curr;
				    }
					
				}
			});
		});
		</script>
	<script>
		$("#addbtn").click(function() {
			//iframe层
			layer.open({
				type : 2,
				title : '添加用户',
				shadeClose : false, //点击遮罩关闭
				shade : 0.8,
				area : [ '80%', '90%' ],
				maxmin : true,
				closeBtn : 1,
				content : [ '/Customer/AllName', 'yes' ], //iframe的url，yes是否有滚动条
				end : function() {
					location.reload();
				}
			
			});
		});
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

		/* 订单-提交  */
		function order_submit(obj, id) {
			layer.confirm('提交后不可修改，确认要提交吗？', function(index) {
				//发异步提交数据
				window.location.href="/Customer/submitOrder?oid="+id;
				layer.msg('已提交!', {
					icon : 1,
					time : 1000
				});
			});
		}

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