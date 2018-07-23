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
			<form class="layui-form layui-col-md12 x-so"
				action="/Customer/showAllADServe">
				<input type="text" name="insearch" id="searchConent" placeholder="请输入相关查询" autocomplete="off" class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach"
					id="search" type="submit">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>
		<button class="layui-btn" onclick="history.go(-1) ">返回</button>
		<span class="x-right" style="line-height: 40px">共有数据：${count} 条</span>  </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>服务编号</th>
					<th>服务名称</th>
					<!-- <th>服务内容</th> -->
					<th>客户名称</th>
					<th>服务创建人</th>
					<th>服务创建时间</th> 
					 <th>服务分配人</th> 
					<!--<th>服务分配时间</th> -->
					<th>服务处理人</th>
					<!-- <th>服务处理时间</th>
					<th>服务归档时间</th>
					<th>满意度</th>  -->
					<th>服务对象</th> 
					<th>联系人电话</th> 
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="Serve" varStatus="ser">
					<tr>
						<td>${Serve.serveid}</td>
						<td>${Serve.servename}</td>
						<%-- <td>${Serve.servecontent}</td> --%>
						<c:forEach items="${listCus1}" var="cusname" varStatus="cus">
							<c:if test="${ser.index==cus.index}">
								<td>${cusname}</td>
							</c:if>
						</c:forEach>
						 <td>${Serve.sercreateid}</td>
						<td>${Serve.sercreatetime}</td> 
						<td>${Serve.serassigneid}</td>
						<%--<td>${Serve.serassignetime}</td> --%>
						<td>${Serve.serdealid}</td>
						<%--<td>${Serve.serdealtime}</td>
						<td>${Serve.serkeeptime}</td>
						<td>${Serve.satisfy}</td> --%>
						<td>${Serve.nocusname}</td>
						<td>${Serve.nocusphone}</td>
						<td><button class="layui-btn"
								onclick="window.location.href='/Customer/showServe?serveid=${Serve.serveid} ' ">查看详情</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- <div class="page">
			<div>
				<a class="prev" href="">&lt;&lt;</a> <a class="num" href="">1</a> <span
					class="current">2</span> <a class="num" href="">3</a> <a
					class="num" href="">489</a> <a class="next" href="">&gt;&gt;</a>
			</div>
		</div> -->
		<div class="page" id="demo1"></div>

	</div>
	<script type="text/javascript">
	$("#adlbtn").click(function() {
		//iframe层
		layer.open({
			type : 2,
			title : '添加',
			shadeClose : false, //点击遮罩关闭
			shade : 0.8,
			area : [ '60%', '70%' ],
			maxmin : true,
			closeBtn : 1,
			content : [ './showAllCus', 'yes' ], //iframe的url，yes是否有滚动条
			//yes: function (index, layero) {
			//    alert(index);
			//    alert(layero);
			//},
			end : function() {
				location.reload();
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
						location.href="/Customer/showAllADServe?currentPage="+obj.curr;
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