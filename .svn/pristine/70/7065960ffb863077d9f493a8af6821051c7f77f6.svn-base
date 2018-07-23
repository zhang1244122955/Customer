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
		<button class="layui-btn layui-btn-danger" id="addbtn"
			<%-- onclick="x_admin_show('重新报价','./order-oofer.jsp?oid=${orders.oid}')"  --%>
			href="javascript:;">
			修改报价
			<!-- 执行计划 -->
		</button>
		<button class="layui-btn"
			onclick="window.location.href='/Customer/dealOrdersShow' ">返回</button>
		</xblock>
		<table class="layui-table">
			<tbody>
				<tr>
					<th><b>订单ID</b></th>
					<td>${orders.oid}</td>
					<th><b>客户名称</b></th>
					<td>${orders.custname}</td>
				</tr>
				<tr>
					<th><b>商品名称</b></th>
					<td>${orders.gname}</td>
					<th><b>商品数量</b></th>
					<td>${orders.gnum}</td>
				</tr>
				<tr>
					<th><b>商品成本价格</b></th>
					<td>${orders.gcostprice}</td>
					<th><b>商品市值价格</b></th>
					<td>${orders.gmarketprice}</td>
				</tr>
				<tr>
					<th><b>审核时间</b></th>
					<td><fmt:formatDate value='${orders.ochecktime}'
							pattern='yyyy-MM-dd hh:mm:ss' /></td>
					<th><b>审核人姓名</b></th>
					<td>${orders.checkName}</td>
				</tr>
				<tr>
					<th><b>订单报价</b></th>
					<td>${orders.ooffer}</td>
					<th><b>审核意见</b></th>
					<td>${orders.oremarks}</td>
				</tr>
			</tbody>

		</table>
		<button class="layui-btn" lay-filter="add" lay-submit="" onclick="location.href='/Customer/editoofferorderCheck?oid=${orders.oid}'">提交</button>
	</div>
	<script>
		$("#addbtn").click(function() {
			//iframe层
			layer.open({
				type : 2,
				title : '修改订单报价',
				shadeClose : false, //点击遮罩关闭
				shade : 0.8,
				area : [ '80%', '90%' ],
				maxmin : true,
				closeBtn : 2,
				content : [ './order-oofer.jsp?oid=${orders.oid}', 'yes' ], //iframe的url，yes是否有滚动条
				end : function() {
					location.reload();
				}
			
			});
		});
	</script>
	<script>
		/* 添加机会的权限判断 */
			$(function() {
				 $('#addpl').click(function() {
					
			         window.loction.href="页面名字";

			         });
				$.ajax({
					type : "POST",
					url : "powerjudge",
					data : {
						"id" : "#add",
						"power" : ${role.power},
						"pos" : $("#add").attr("ailin")
					},
					success : function(data) {
						var str = data.split(',');
						$(str[0]).attr("style",str[1]);
					}
				});
			/* 执行机会的机会 */	
				$.ajax({
					type : "POST",
					url : "powerjudge",
					data : {
						"id" : ".handle",
						"power" : ${role.power},
						"pos" : $(".handle").attr("ailin")
					},
					success : function(data) {
						var str = data.split(',');
						$(str[0]).attr("style",str[1]);
					}
				});
			});
		</script>
	<script type="text/javascript">
		$(function() {
			if(${listasize}==0){
				$("#pshow").css("display","none");
			}
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