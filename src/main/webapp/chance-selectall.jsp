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
	//高管，系统管理员登录时使操作按钮不显示
	 $.ajax({
		type : "POST",
		url : "powerjudge",
		data : {
			"id" : ".remove1",
			"power" : ${role.power},
			"pos" : $(".remove1").attr("ailin")
		},
		success : function(data) {
			var str = data.split(',');
			$(str[0]).attr("style",str[1]);
		}
	}); 
	//只有客户经理登录时才能显示删除按钮
	 $.ajax({
			type : "POST",
			url : "powerjudge",
			data : {
				"id" : ".remove",
				"power" : ${role.power},
				"pos" : $(".remove").attr("ailin")
			},
			success : function(data) {
				var str = data.split(',');
				$(str[0]).attr("style",str[1]);
			}
		}); 
	  
 $.ajax({
			type : "POST",
			url : "powerjudge",
			data : {
				"id" : "#btn",
				"power" : ${role.power},
				"pos" : $("#btn").attr("ailin")
			},
			success : function(data) {

				var str = data.split(',');
				$(str[0]).attr("style",str[1]);
			}
		}); 
//对弹出层的操作
 $("#btn").click(function (){
		//iframe层
     layer.open({
         type: 2,
         title: '修改',
         shadeClose: false, //点击遮罩关闭
         shade: 0.8,
         area: ['70%', '90%'],
         maxmin: true,
         closeBtn: 1,
         content: ['/Customer/findmanager', 'yes'], //iframe的url，yes是否有滚动条
         //yes: function (index, layero) {
         //    alert(index);
         //    alert(layero);
         //},
         end: function () {
         	location.reload();
         }
     });
	})
	
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
		<button class="layui-btn" id="btn" ailin="3,4">
			<!-- <a title="编辑" href="./chanceadd.jsp"> -->
			<i class="layui-icon"></i>添加</a>
		</button>
		<span class="x-right" style="line-height: 40px">共有数据：<c:out
				value="${count}"></c:out>条
		</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>机会编号</th>
					<th>客户名称</th>
					<th>概要</th>
					<th>联系人</th>
					<th>联系人电话</th>
					<th>创建人</th>
					<th>创建时间</th>
					<th>审核状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="">
				<%-- <c:forEach items="${pageBean.date}" var="chance">
					<tr>
						<td>${chance.chid}</td>
						<td>${chance.custname}</td>
						<td>${chance.choutline}</td>
						<td>${chance.chcontact}</td>
						<td>${chance.chcontactphone}</td>
						<td>${chance.createid}</td>
						<td>${chance.chcreatetime}</td>
						<td>${chance.chstatus}</td> --%>
				<c:forEach items="${list}" var="chance">
					<tr>
						<td>${chance.chid}</td>
						<td>${chance.custname}</td>
						<td>${chance.choutline}</td>
						<td>${chance.chcontact}</td>
						<td>${chance.chcontactphone}</td>
						<td>${chance.createid}</td>
						<td>${chance.chcreatetime}</td>
						<td>${chance.chstatus}</td>

						<c:choose>

							<c:when
								test="${chance.chstatus eq '等待审核' ||chance.chstatus eq '需要修改'}">
								<td class="td-manage"><a title="编辑"
									onclick="member_modify('${chance.chid}','${chance.chstatus}')"
									href="javascript:;" class="remove1" ailin="3,4" id="remove1">
										<i class="layui-icon">&#xe642;</i>
								</a> <a title="删除"
									onclick="member_del(this,'${chance.chid}','${chance.chstatus}')"
									href="javascript:;" class="remove" ailin="4"> <i
										class="layui-icon">&#xe640;</i>
								</a></td>
							</c:when>
							<c:otherwise>
								<td class="td-manage"><a title="编辑"
									onclick="member_modify('${chance.chid}','${chance.chstatus}')"
									href="javascript:;" class="remove1" ailin="3,4" id="remove1"
									hidden> <i class="layui-icon">&#xe642;</i>
								</a> <a title="删除"
									onclick="member_del(this,'${chance.chid}','${chance.chstatus}')"
									<%-- href="/Customer/removechance?chid=${chance.chid}&chstatus=${chance.chstatus}" --%>				
							href="javascript:;"
									class="remove" ailin="4"> <i class="layui-icon">&#xe640;</i>
								</a></td>

							</c:otherwise>
						</c:choose>
						<%-- <td class="td-manage"><a title="编辑"
							onclick="x_admin_show('编辑','/Customer/modifychanceinfo?chid=${chance.chid}&chstatus=${chance.chstatus}',600,450)"
							href="javascript:;" class="remove1" ailin="3,4" id="remove1">
								<i class="layui-icon">&#xe642;</i>
						</a> <a title="删除"
							href="/Customer/removechance?chid=${chance.chid}&chstatus=${chance.chstatus}"
							class="remove" ailin="4"> <i class="layui-icon">&#xe640;</i>
						</a></td> --%>




					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="demo1"></div>
		<%-- <div class="page">
			<div>
				<a class="prev"
					href="/Customer/paging?currentPage=${pageBean.currentPage-1}">&lt;&lt;</a>
				<c:forEach begin="1" end="${pageBean.totalPage}" var="p">
					<a class="num" href="/Customer/paging?currentPage=${p}">${p}</a>
				</c:forEach>
				<a class="next"
					href="/Customer/paging?currentPage=${pageBean.currentPage+1}">&gt;&gt;</a>

			</div>
		</div>

	</div> --%>

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
							location.href="/Customer/chancepage?page="+obj.curr;
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

		/* 机会-修改 */
		function member_modify(chid,chstatus) {
			
			//iframe层
			layer.open({
				type: 2,
				title: '修改机会',
				shadeClose: false, //点击遮罩关闭
				shade: 0.8,
				area: ['50%', '95%'],
				maxmin: true,
				closeBtn: 1,
				content: ['/Customer/modifychanceinfo?chid='+chid+'&chstatus='+chstatus, 'yes'], //iframe的url，yes是否有滚动条
				//yes: function (index, layero) {
				//    alert(index);
				//    alert(layero);
				//},
				end: function() {
					location.reload();
				}
			});
		};

		 /*机会-删除*/
			  function member_del(obj,chid,chstatus) {
			 
				layer.confirm('确认要删除吗？', function(index) {
					//发异步删除数据

					$.ajax({
						url: "/Customer/removechance",
						data: {
							"chid": chid,
							"chstatus":chstatus
						},
					});

					$(obj).parents("tr").remove();
					layer.msg('已删除!', {
						icon: 1,
						time: 1000
					});
				});
			}    
		    /*  function member_del(obj,chid,chstatus) {
				  alert(chid);
				alert(chstatus);
				var b = confirm("是否删除！！！");
				if (b) {
					location.href = "/Customer/removechance?chid="+chid+"&chstatus="+chstatus;
					
				}  
			
			}   */
 
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