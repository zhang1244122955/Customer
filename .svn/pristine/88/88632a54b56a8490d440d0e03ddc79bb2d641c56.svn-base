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

<body>
	<div class="x-body">
		<form class="layui-form" action="/Customer/editOstatusRemarks"
			method="post">
			<div class="layui-form-item">
				<label class="layui-form-label"> <span class="x-red">*</span>审核
				</label>
				<div class="layui-input-block" style="width: 150px;">
					<select name="submitStatus" lay-verify="required" lay-search="">
						<option value="未通过" name="submitStatus">未通过</option>
						<option value="已通过" name="submitStatus">已通过</option>
					</select>
				</div>
			</div>
			<input type="hidden" name="oid" value="${param.oid}" /><label
				class="layui-form-label"> <span class="x-red">*</span>审核意见
			</label>
			<div class="layui-input-block" style="width: 200px;"> 
			<select name="oremark" lay-verify="required" lay-search="">
				<option value="报价太低，需重新报价" name="oremark">报价太低，需重新报价</option>
				<option value="报价太高，需重新报价" name="oremark">报价太高，需重新报价</option>
				<option value="报价合理，通过" name="oremark">报价合理，通过</option>
			</select>
			</div> <br> <br> <br>
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit=""
					type="submit">完成</button>
			</div>
		</form>
	</div>
	<script>
		layui.use([ 'form', 'layer' ], function() {
			$ = layui.jquery;
			var form = layui.form, layer = layui.layer;

			//自定义验证规则
			form.verify({
				num : [ /^\d{1,}$/, '必须为数字' ],
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