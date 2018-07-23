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
<script type="text/javascript" src="/Customer/resources/lib/layui/layui.js"
	charset="utf-8"></script>
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
		<table class="layui-table">
			<tbody>
				<tr>
					<th><b>ID</b></th>
					<td>${ch.chid}</td>
					<th><b>客户名称</b></th>
					<td>${ch.custname}</td>
				</tr>
				<tr>
					<th><b>联系人</b></th>
					<td>${ch.chcontact}</td>
					<th><b>联系人电话</b></th>
					<td>${ch.chcontactphone}</td>
				</tr>
				<tr>
					<th><b>指派人编号</b></th>
					<td>${ch.assigneeid}</td>
					<th><b>指派时间</b></th>
					<td>${ch.chassigneetime}</td>
				</tr>
				<tr>
					
					<th><b>计划名称</b></th>
					<td>${plan.planname}</td>
					<th><b>计划概要</b></th>
					<td>${plan.planintrol}</td>
				</tr>
				<tr>
					<th><b>计划开始时间</b></th>
					<td>${plan.planstarttime}</td>
					<th><b>计划结束时间</b></th>
					<td>${plan.planendtime}</td>
				</tr>
			</tbody>
		</table>
		
		<form class="layui-form layui-form-pane" action="/Customer/updatePlan">
			<input name="planid" type="hidden" value="${plan.planid}">
			<input name="chid" type="hidden" value="${ch.chid}">
			<label class="layui-form-label">执行结果：</label>
				<div class="layui-input-inline">
			      <select name="planback" id="planback">
			        <option value="请选择">请选择</option>
			        <option value="开发成功">开发成功</option>
			        <option value="开发中">开发中</option>
			        <option value="开发失败">开发失败</option>
			      </select>
			    </div>
			    <div style="margin: 0 auto; width: 216px;">
      				<button class="layui-btn layui-btn-fluid" type="submit">提交</button>
   			 	</div>
		    </form>
		

	</div>
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
	</script>
	<script type="text/javascript">
	/* $(function() {
		layer.open({
			  content: '提交成功',
			  yes: function(index, layero){
			    //do something
			    layer.close(index); //如果设定了yes回调，需进行手工关闭
			  }
			}); 

	}); */
		/* 查看所有计划项 */
		$.ajax({
			type : "POST",
			url : "powerjudge",
			data : {
				"id" : "#showP",
				"power" : ${role.power},
				"pos" : $("#showP").attr("ailin")
			},
			success : function(data) {
				var str = data.split(',');
				$(str[0]).attr("style",str[1]);
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

