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
<script type="text/javascript"
	src="/Customer/resources/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/Customer/resources/js/xadmin.js"></script>
</head>

<body>
	<div class="x-body">
		<div class="layui-row" style="padding-top: 20px">
			<div class="layui-col-md3">&nbsp</div>
			<div class="layui-col-md6">
				<form class="layui-form" action="/Customer/addNews" method="post">
					<div class="layui-form-item">
						<label class="layui-form-label"> <span class="x-red">*</span>新闻标题
						</label>
						<div class="layui-input-inline">
							<input type="text" id="name" name="newstitle" required=""
								lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label"><span class="x-red">*</span>新闻时间</label>
						<div class="layui-inline">
							<input type="text" class="layui-input" id="hiredate"
								name="newsdate">
						</div>
						<script>
							layui.use('laydate', function() {
								var laydate = layui.laydate;
								//执行一个laydate实例
								laydate.render({
									elem : '#hiredate' //指定元素
									,type: 'datetime' //日期和时间
									//,format: 'yyyy-MM-dd HH:mm' //指定格式
								});
							});
						</script>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"> <span class="x-red">*</span>新闻状态
						</label>
						<div class="layui-input-inline">
							<input type="checkbox" name="newsstatus" lay-text="开启|停用"
									lay-skin="switch" lay-filter="switch" value="0"
									checked>
						</div>
					</div>
					
					<div class="layui-form-item">
						<label class="layui-form-label"> </label>
						<button class="layui-btn" lay-filter="add" lay-submit="" type="submit">
							添加</button>
					</div>
				</form>
			</div>
			<div class="layui-col-md3">&nbsp</div>
		</div>

	</div>
	<script>
	
 	 /*  $("#btn").click(function(){
		//当你在iframe页面关闭自身时
		var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		parent.layer.close(index); //再执行关闭 
	})  */ 
		layui.use([ 'form', 'layer' ], function() {
			$ = layui.jquery;
			var form = layui.form, layer = layui.layer;


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