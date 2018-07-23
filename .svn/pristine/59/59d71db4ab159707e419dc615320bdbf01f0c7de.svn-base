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
		<xblock>
		<!-- <button class="layui-btn layui-btn-danger" onclick="make()">
			查看详情
			执行计划
		</button> -->
		<button class="layui-btn"
			onclick="window.location.href='/Customer/showAll' ">返回</button>
		</xblock>
		<table class="layui-table">
			<tbody>
				<tr>
					<th><b>ID</b></th>
					<td>${chance.chid}</td>
					<th><b>客户名称</b></th>
					<td>${chance.custname}</td>
				</tr>
				<tr>
					<th><b>成功几率</b></th>
					<td>${chance.chsuccess}</td>
					<th><b>概要</b></th>
					<td>${chance.choutline}</td>
				</tr>
				<tr>
					<th><b>联系人</b></th>
					<td>${chance.chcontact}</td>
					<th><b>联系人电话</b></th>
					<td>${chance.chcontactphone}</td>
				</tr>
				<tr>
					<th><b>机会描述</b></th>
					<td>${chance.chdescribe}</td>
					<th><b>创建人</b></th>
					<td>${chance.createid}</td>
				</tr>
				<tr>
					<th><b>创建时间</b></th>
					<td>${chance.chcreatetime}</td>
					<th><b>指派人编号</b></th>
					<td>${chance.assigneeid}</td>
				</tr>
				<tr>
					<th><b>指派时间</b></th>
					<td>${chance.chassigneetime}</td>
				</tr>
			</tbody>

		</table>
		
		<%-- <c:if test="${not empty listCh}"> --%>
		<div class="layui-row" id="pshow">
		<table class="layui-table">
			<thead>
				<tr>
					<th>计划名称</th>
					<th>计划简介</th>
					<th>计划开始时间</th>
					<th>计划结束时间</th>
					<th class="handle" ailin="4">操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${listCh}" var="Plan">
					<tr>
						<td>${Plan.planname}</td>
						<td>${Plan.planintrol}</td>
						<td>${Plan.planstarttime}</td>
						<td>${Plan.planendtime}</td>
						<td class="handle" ailin="4"><button class="layui-btn" onclick="make(${Plan.planid})"<%-- onclick="window.location.href='/Customer/executePlan?planid=${Plan.planid}' " --%>>执行计划</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		<c:if test="${empty listCh}">
			<div style="text-align: center;"><i class="layui-icon layui-icon-tips" style="font-size: 25px; color: #FF5722;"></i>
			<span style="color: #FF5722;">对不起，没有需要执行的计划！</span></div>
			<br>
		</c:if>
		<%-- </c:if> --%>
		<div class="layui-row" id="add" ailin="2">
			<form class="layui-form layui-form-pane" action="/Customer/addPlan">
				<input name="chid" type="hidden" value="${chance.chid}" id="chid">
				<div class="layui-form-item">
					<div class="layui-inline">
						<label class="layui-form-label">计划开始：</label>
						<div class="layui-input-block">
							<input name="start" class="layui-input" id="start" type="text" autocomplete="off" required lay-verify="start">
						</div>
					</div>
					
					<div class="layui-inline">
						<label class="layui-form-label">计划结束：</label>
						<div class="layui-input-block">
							<input name="end" class="layui-input" id="end" type="text" autocomplete="off" required lay-verify="end">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">计划名称：</label>
						<div class="layui-input-block">
							<input name="planname" class="layui-input" id="planname" type="text" placeholder="请输入名称" autocomplete="off" required lay-verify="planname">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">简述：</label>
						<div class="layui-input-block">
							<input name="planintro" id="planintro" class="layui-input" type="text" placeholder="请输入简述" autocomplete="off" lay-verify="title" required lay-verify="planintro">
						</div>
					</div>
				</div>
				<button class="layui-btn" id="addpl" lay-filter="addpl" style="margin: 50px 600px;">添加计划</button>
			</form>
		</div>
		
		<script>
			layui.use(['form', 'layedit', 'laydate'], function(){
			  var form = layui.form
			  ,layer = layui.layer
			  ,layedit = layui.layedit
			  ,laydate = layui.laydate;
			  
			  //日期
			  laydate.render({
			    elem: '#start'
			  });
			  laydate.render({
			    elem: '#end'
			  }); 
			  $("#addpl").click(function (){
					layer.open({
						  content: '添加成功',
						  yes: function(index, layero){
							layer.close(index); //如果设定了yes回调，需进行手工关闭
							location.href="/Customer/addPlan?chid="+$("#chid").val()+'&start='+$("#start").val()+'&end='+$("#end").val()+'&planname='+$("#planname").val()+'&planintro='+$("#planintro").val(); 
						  }
					}); 
				}) ;
			 }) 
		</script> 
		<script>
		
		/*执行计划*/
		function make(id) {
			var data = tableCheck.getData();
			layer.confirm('确认要执行计划吗？' + data, function(index) {
				//捉到所有被选中的，发异步进行删除
				layer.msg('开始执行计划', {
					icon : 1
				});
				var start = document.getElementById("start").value;
				var end = document.getElementById("end").value;
				var planname = document.getElementById("planname").value;
				var planintro = document.getElementById("planintro").value;
				location.href = "/Customer/executePlan?planid="+id;
			});
		}

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
			if(${count}==0){
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