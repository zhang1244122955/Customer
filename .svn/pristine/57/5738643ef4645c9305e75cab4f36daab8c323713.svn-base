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
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so">
				<input class="layui-input" placeholder="开始日" name="start" id="start">
				<input class="layui-input" placeholder="截止日" name="end" id="end">
				<div class="layui-input-inline">
					<select name="contrller">
						<option>支付状态</option>
						<option>已支付</option>
						<option>未支付</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select name="contrller">
						<option>支付方式</option>
						<option>支付宝</option>
						<option>微信</option>
						<option>货到付款</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select name="contrller">
						<option value="">订单状态</option>
						<option value="0">待确认</option>
						<option value="1">已确认</option>
						<option value="2">已收货</option>
						<option value="3">已取消</option>
						<option value="4">已完成</option>
						<option value="5">已作废</option>
					</select>
				</div>
				<input type="text" name="username" placeholder="请输入订单号"
					autocomplete="off" class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>

		<button id="btn_addNews" class="layui-btn" lay-submit=""
			lay-filter="sreach">
			<i class="layui-icon"></i>添加新闻
		</button>
		<span class="x-right" style="line-height: 40px">共有数据：88 条</span> </xblock>
		<table class="layui-table layui-form">
			<thead>
				<tr>
					<th width="70">新闻ID</th>
					<th>新闻标题</th>
					<th>新闻日期</th>
					<th width="65">开启/停用</th>
					<th width="180">操作</th>
			</thead>
			<tbody>

				<c:forEach items="${list}" var="news">
					<tr>
						<td>${news.newsid}</td>
						<td>${news.newstitle}</td>
						<td>${news.newsdate}</td>
						<c:choose>

							<c:when test="${news.newsstatus == 0 }">
								<!--如果 -->
								<td><input type="checkbox" name="switch" lay-text="开启|停用"
									lay-skin="switch" lay-filter="switch" value="${news.newsid}"
									checked></td>
							</c:when>

							<c:otherwise>
								<!--否则 -->
								<td><input type="checkbox" name="switch" lay-text="开启|停用"
									lay-skin="switch" lay-filter="switch" value="${news.newsid}"></td>
							</c:otherwise>

						</c:choose>

						<td class="td-manage">
							<button class="layui-btn layui-btn layui-btn-xs"
								onclick="member_modify(${news.newsid})">
								<i class="layui-icon">&#xe642;</i>编辑
							</button>
							<button class="layui-btn-danger layui-btn layui-btn-xs"
								onclick="member_del(this,${news.newsid})" href="javascript:;">
								<i class="layui-icon">&#xe640;</i>删除
							</button>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div id="demo1"></div>
	</div>
	<style type="text/css">
</style>

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
							location.href="/Customer/news?page="+obj.curr;
					    }
						
					}
				});
			});
		</script>

	<script>
			/*用户-添加*/
			$("#btn_addNews").click(function() {
				//iframe层
				layer.open({
					type: 2,
					title: '添加用户',
					shadeClose: false, //点击遮罩关闭
					shade: 0.8,
					area: ['40%', '90%'],
					maxmin: true,
					closeBtn: 1,
					content: ['./news-add.jsp', 'yes'], //iframe的url，yes是否有滚动条
					//yes: function (index, layero) {
					//    alert(index);
					//    alert(layero);
					//},
					end: function() {
						location.reload();
					}
				});
			});

			layui.use(['form'], function() {
				form = layui.form;

				form.on('switch(switch)', function(data) {
					if(data.elem.checked) {
						$.ajax({
							url: "modifyNews",
							data: {
								"newsid": data.value,
								"newsstatus": 0
							},
						});
						layer.msg('已开启', {
							icon: 1,
							time: 1000
						});
					} else {
						$.ajax({
							url: "modifyNews",
							data: {
								"newsid": data.value,
								"newsstatus": 1
							},
						});
						layer.msg('已停用', {
							icon: 4,
							time: 1000
						});
					}

					//console.log(data.elem); //得到checkbox原始DOM对象
					//console.log(data.elem.checked); //开关是否开启，true或者false
					//console.log(data.value); //开关value值，也可以通过data.elem.value得到
					//console.log(data.othis); //得到美化后的DOM对象
				});

			});

			/*新闻-删除*/
			function member_del(obj, id) {
				layer.confirm('确认要删除吗？', function(index) {
					//发异步删除数据

					$.ajax({
						url: "removeNews",
						data: {
							"newsid": id
						},
					});

					$(obj).parents("tr").remove();
					layer.msg('已删除!', {
						icon: 1,
						time: 1000
					});
				});
			}

			/*新闻-修改*/
			function member_modify(id) {
				//iframe层
				layer.open({
					type: 2,
					title: '添加用户',
					shadeClose: false, //点击遮罩关闭
					shade: 0.8,
					area: ['40%', '90%'],
					maxmin: true,
					closeBtn: 1,
					content: ['./beforeModify?newsid=' + id, 'yes'], //iframe的url，yes是否有滚动条
					//yes: function (index, layero) {
					//    alert(index);
					//    alert(layero);
					//},
					end: function() {
						location.reload();
					}
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