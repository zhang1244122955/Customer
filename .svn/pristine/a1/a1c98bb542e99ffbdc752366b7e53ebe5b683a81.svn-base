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
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so" action="/Customer/showAll">
				<input type="text" name="insreach" id="insreach" placeholder="请输入相关查询" autocomplete="off" class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach" id="search" type="submit">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>
		<div id="pl" ailin="3,22">
			<button class="layui-btn layui-btn-danger"
				onclick="window.location.href='/Customer/showAllPlan ' ">查看所有计划项</button>
		</div>
		 <span class="x-right" style="line-height: 40px">共有数据：${count} 条</span>  </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>ID</th>
					<th>客户名称</th>
					<th>成功几率</th>
					<th>概要</th>
					<!-- <th>联系人</th>
					<th>联系人电话</th> -->
					<th>机会描述</th>
					<!-- <th>创建人</th> -->
					<th>创建时间</th>
					<th>指派人编号</th>
					<th>指派时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="Chance">
					<tr>
						<td>${Chance.chid}</td>
						<td>${Chance.custname}</td>
						<td>${Chance.chsuccess}</td>
						<td>${Chance.choutline}</td>
						<%-- <td>${Chance.chcontact}</td>
					<td>${Chance.chcontactphone}</td> --%>
						<td>${Chance.chdescribe}</td>
						<%-- <td>${Chance.createid}</td> --%>
						<td>${Chance.chcreatetime}</td>
						<td>${Chance.assigneeid}</td>
						<td>${Chance.chassigneetime}</td>
						<td><button class="layui-btn"
								onclick="window.location.href='/Customer/markPlan?chid=${Chance.chid} ' ">查看详情</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="page" id="demo1"></div>

	</div>
	<script type="text/javascript">
	$(function() {
		/* 查看所有计划项 */
		$.ajax({
			type : "POST",
			url : "powerjudge",
			data : {
				"id" : "#pl",
				"power" : ${role.power},
				"pos" : $("#pl").attr("ailin")
			},
			success : function(data) {
				var str = data.split(',');
				$(str[0]).attr("style",str[1]);
			}
		});
	});
	</script>
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
						location.href="/Customer/showAll?currentPage="+obj.curr;
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