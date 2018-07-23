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
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="x-body">
	<div class="layui-row" style="padding-top: 20px">
			<div class="layui-col-md3">&nbsp</div>
			<div class="layui-col-md6">
		<form class="layui-form" action="/Customer/createServe" method="post">
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>客户编号:
				</label>
				<div class="layui-input-inline">
					<select id="selectname" name="cusid" lay-search="" required="required">
					<c:forEach items="${listCustomer}" var="customer">
						<option>${customer.custid}</option>
					</c:forEach>
					</select>
				</div>
			</div> 
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>服务名称:
				</label>
				<div class="layui-input-inline">
					<input type="text" id="servename" name="servename" required="required"
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
			</div>
			<%-- <select class="tp"> <option>----请选择联系人电话---- </option></select>
			<div class="layui-form-item">
				<label for="phone" class="layui-form-label"> <span
					class="x-red">*</span>联系电话:
				</label>
				<div class="layui-input-inline">
					<select id="nocusphone" name="nocusphone" lay-search="" required="required" lay-verify="phone" autocomplete="off" class="layui-input">
					<c:forEach items="${listCustomer}" var="customer">
						<option>${customer.custid}</option>
					</c:forEach>
					</select>
				</div>
			</div> --%>
			<div class="layui-form-item layui-form-text">
				<label for="desc" class="layui-form-label"><span
					class="x-red">*</span>服务内容:</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容" id="servecontent" name="servecontent"
						class="layui-textarea"></textarea>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" id="addbtn" lay-filter="add" lay-submit="" type="submit">
					增加</button>
			</div> 
			
		</form>
		</div>
			<div class="layui-col-md3">&nbsp</div>
		</div>
		
	</div>
	<!-- <script type="text/javascript">
		/* 二级联动 */
		$(document).ready(function(){ 
			$("#selectname").change(function(){ 
				$("#selectname option").each(function(i,o){ 
					if($(this).attr("selected")) 
						{ 
							$(".tp").hide(); 
							$(".tp").eq(i).show(); 
						} 
				}); 
			}); 
			$("#selectname").change(); 
		}); 

	</script> -->
	<script>
		layui.use([ 'form', 'layer' ], function() {
			$ = layui.jquery;
			var form = layui.form, layer = layui.layer;

			//自定义验证规则
			form.verify({
				nikename : function(value) {
					if (value.length < 5) {
						return '昵称最多5个字符啊';
					}
				},
				/* pass : [ /(.+){6,12}$/, '密码必须6到12位' ],
				  repass : function(value) {
					if ($('#L_pass').val() != $('#L_repass').val()) {
						return '两次密码不一致';
					}
				}   */
			});
			layui.use('laydate', function(){
				  var laydate = layui.laydate;
				  
				  //常规用法
				  laydate.render({
				    elem: '#sercreatetime'
				  });
			});

			  //监听提交
			form.on('submit(add)', function(data) {
				console.log(data);
				// 获得frame索引
			 	var index = parent.layer.getFrameIndex(window.name);
				//关闭当前frame
				parent.layer.close(index);  
				return true;
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
