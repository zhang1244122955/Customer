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
			//iframe层
	    layer.open({
	        type: 2,
	        title: '修改',
	        shadeClose: false, //点击遮罩关闭
	        shade: 0.8,
	        area: ['50%', '70%'],
	        maxmin: true,
	        closeBtn: 1,
	        content: ['/Customer/fdmanagers', 'yes'], //iframe的url，yes是否有滚动条
	        //yes: function (index, layero) {
	        //    alert(index);
	        //    alert(layero);
	        //},
	        end: function () {
	        	location.reload();
	        }
	    });
		});

	  
		if (${list1.size()}!=0) {
			
			layui.use('layer', function(){
				  var layer = layui.layer;
				  
				  layer.msg("您有 "+${list1.size()}+" 个未添加的客户", {
						icon: 1,
						time: 3000
					});  
				});  
			/*  alert("您有"+${list1.size()}+"个未添加的客户");  */
		}
	
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
			<!-- <a title="编辑" href="/Customer/findmanagers"> -->
			<i class="layui-icon"></i>添加
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
					<th>地址</th>
					<th>经理人</th>
					<th>合作等级</th>
					<th>传真</th>
					<th>操作</th>

				</tr>
			</thead>
			<tbody id="">
				<c:forEach items="${list}" var="customer">
					<tr>
						<td>${customer.custid}</td>
						<td>${customer.custname}</td>
						<td>${customer.custaddress}</td>
						<td>${customer.userid}</td>
						<td>${customer.custlevel}</td>
						<td>${customer.custfax}</td>

						<td class="td-manage"><a title="编辑"
							onclick="member_modify('${customer.custid}')" href="javascript:;"
							class="remove1" ailin="3,4" id="remove1"> <i
								class="layui-icon">&#xe642;</i>
						</a> <a title="删除" onclick="member_del(this,'${customer.custid}')"
							href="javascript:;" class="remove" ailin="4"> <i
								class="layui-icon">&#xe640;</i>
						</a> <a title="历史订单"
							href="/Customer/orderInfo?custid=${customer.custid}"
							class="remove" ailin="4"> <i class="layui-icon">&#xe621;</i>
						</a></td>
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

		/*客户-修改*/
		function member_modify(custid) {
			//iframe层
			layer.open({
				type: 2,
				title: '修改客户',
				shadeClose: false, //点击遮罩关闭
				shade: 0.8,
				area: ['50%', '70%'],
				maxmin: true,
				closeBtn: 1,
				content: ['/Customer/modifyInfo?custid='+custid, 'yes'], //iframe的url，yes是否有滚动条
				//yes: function (index, layero) {
				//    alert(index);
				//    alert(layero);
				//},
				
				end: function() {
					location.reload();
				}
			});
		}
	
		/*客户-删除*/
			function member_del(obj,custid) {
				layer.confirm('确认要删除吗？', function(index) {
					//发异步删除数据

					$.ajax({
						url: "/Customer/removeCustomer",
						data: {
							"custid": custid
						},
					});

					$(obj).parents("tr").remove();
					layer.msg('已删除!', {
						icon: 1,
						time: 1000
					});
				});
			}
		/*  function member_del(custid) {
				var b = confirm("是否删除！！！");
				if (b) {
					location.href = "/Customer/removeCustomer?custid="+custid;
					
				}
			} */
 
		function delAll(argument) {

			var data = tableCheck.getData();

			layer.confirm('确认要删除吗？' + data, function(index) {
				//捉到所有被选中的，发异步进行删除
				layer.msg('删除成功', {
					icon : 1
				});
				$(".layui-form-checked").not('.header').parents('tr').remove();
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