<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>zyd</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="/Customer/resources/css/font.css">
<link rel="stylesheet" href="/Customer/resources/css/xadmin.css">
<script src="/Customer/resources/js/jquery-3.3.1.js"></script>
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="/Customer/resources/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="/Customer/resources/js/xadmin.js"></script>
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
		<!-- <div class="layui-row">
			<form class="layui-form layui-col-md12 x-so">
				<input class="layui-input" placeholder="开始日" name="start" id="start">
				<input class="layui-input" placeholder="截止日" name="end" id="end">
				<input type="text" name="username" placeholder="请输入用户名"
					autocomplete="off" class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div> -->
		<xblock style="height: 38px">
		<button class="layui-btn " type="button" id="addbtn"><i class="layui-icon"> </i>添加</button>
		<span class="x-right" style="line-height: 40px">共有数据：${pageBean.totalSize} 条</span>
		</xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>角色ID</th>
					<th>角色名</th>
					<th>拥有权限规则</th>
					<th>操作</th>
			</thead>
			<tbody>
				<c:forEach items="${pageBean.date }" var="role">
				<tr>
					<td>${role.roleid }</td>
					<td>${role.rolename }</td>
					<td>${role.power }</td>
					<!-- <td class="td-status"><span
						class="layui-btn layui-btn-normal layui-btn-mini">已启用</span></td> -->
					<td class="td-manage">
					<!--<a onclick="member_stop(this,'10001')"
						href="javascript:;" title="启用"> <i class="layui-icon">&#xe601;</i></a>  -->
						<a title="编辑" onclick="role_modify('${role.roleid }')"
						href="javascript:;"> <i class="layui-icon">&#xe642;</i>
					</a> <a title="删除" onclick="role_del(this,'${role.roleid }')"
						href="javascript:;"> <i class="layui-icon">&#xe640;</i>
					</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	<center>
		<div id="page">
<%-- 			<div>
			<c:choose>
				<c:when test="${pageBean.currentPage-1<1}">
					<a class="prev" href="/Customer/findRoles?currentPage=1">&lt;&lt;</a>
				</c:when>
				<c:otherwise>
					<a class="prev" href="/Customer/findRoles?currentPage=${pageBean.currentPage-1}">&lt;&lt;</a>
				</c:otherwise>
			</c:choose>
			<c:forEach begin="1" end="${pageBean.totalPage}" var="p">
				<a class="num" href="/Customer/findRoles?currentPage=${p}">${p}</a>
			</c:forEach>
			<c:choose>
				<c:when test="${pageBean.currentPage+1>pageBean.totalPage}">
					<a class="next" href="/Customer/findRoles?currentPage=${pageBean.totalPage}">&gt;&gt;</a>
				</c:when>
				<c:otherwise>
					<a class="next" href="/Customer/findRoles?currentPage=${pageBean.currentPage+1}">&gt;&gt;</a>
				</c:otherwise>
			</c:choose>
			</div> --%>
		</div>
 	</center>
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
		
		/* 分页 */
		layui.use(['laypage', 'layer'], function() {
			var laypage = layui.laypage,
				layer = layui.layer;

			//总页数大于页码总数
			laypage.render({
				elem: 'page',
				limit: 8,
				count: ${pageBean.totalSize},//数据总数
				curr: ${pageBean.currentPage},//当前页
				jump: function(obj, first) {
					//首次不执行
				    if(!first){
						location.href="/Customer/findRoles?currentPage="+obj.curr;
				    }
					
				}
			});
		});
	
		
		/*角色-添加*/
		$("#addbtn").click(function() {
			//iframe层
			layer.open({
				type : 2,
				title : '添加角色',
				shadeClose : false, //点击遮罩关闭
				shade : 0.8,
				area : [ '80%', '90%' ],
				maxmin : true,
				closeBtn : 1,
				content : [ './role-add.jsp', 'yes' ], //iframe的url，yes是否有滚动条
				//yes: function (index, layero) {
				//    alert(index);
				//    alert(layero);
				//},
				end : function() {
					location.reload();
				}
			});
		});
		
		/*角色-删除*/
		function role_del(obj,roleid) {
			layer.confirm('确认要删除吗？', function(index) {
				//发异步删除数据
				$.ajax({
					url: "removeRole",
					data: {
						"roleid": roleid
					},
				});
				$(obj).parents("tr").remove();
				layer.msg('已删除!', {
					icon: 1,
					time: 1000
				});
			});
		}
		
		/*角色-修改*/
		function role_modify(roleid) {
			layer.open({
				type : 2,
				title : '修改角色',
				shadeClose : false, //点击遮罩关闭
				shade : 0.8,
				area : [ '80%', '90%' ],
				maxmin : true,
				closeBtn : 1,
				content : [ 'findRole?roleid=' + roleid, 'yes' ], //iframe的url，yes是否有滚动条
				//yes: function (index, layero) {
				//    alert(index);
				//    alert(layero);
				//},
				end : function() {
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