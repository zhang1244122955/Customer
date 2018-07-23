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
		<meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
		<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" href="/Customer/resources/css/font.css">
		<link rel="stylesheet" href="/Customer/resources/css/xadmin.css">
		<script src="/Customer/resources/js/jquery-3.3.1.js"></script>
		<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript" src="/Customer/resources/lib/layui/layui.js" charset="utf-8"></script>
		<script type="text/javascript" src="/Customer/resources/js/xadmin.js"></script>
	</head>

	<body>
		<div class="x-body">
			<div class="layui-row" style="padding-top: 20px">
				<div class="layui-col-md3">&nbsp</div>
				<div class="layui-col-md6">
					<form class="layui-form" action="/Customer/modifyUser" method="post">
						<div class="layui-form-item">
							<label class="layui-form-label"> <span class="x-red">*</span>用户名
						</label>
							<div class="layui-input-inline">
								<input type="text" id="userid" name="userid" required="" value="${u.userid }" lay-verify="username" autocomplete="off" class="layui-input layui-disabled" readOnly="true">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label"> <span class="x-red">*</span>职位
						</label>
							<div class="layui-input-block" style="width: 150px;">
								<select name="roleid" lay-verify="required">
									<option value="${u.role.roleid }">${u.role.rolename }</option>
									<c:forEach items="${roles }" var="role">
										<c:if test="${u.role.rolename != role.rolename }">
											<option value="${role.roleid }">${role.rolename }</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label"> <span class="x-red">*</span>姓名
						</label>
							<div class="layui-input-inline">
								<input type="text" id="name" name="name" required="" value="${u.name }" lay-verify="name" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label"> <span class="x-red">*</span>性别
						</label>
							<div class="layui-input-block">
								<c:choose>
									<c:when test="${u.sex.equals('男') }">
										<input type="radio" name="sex" value="男" title="男" checked>
										<input type="radio" name="sex" value="女" title="女">
									</c:when>
									<c:otherwise>
										<input type="radio" name="sex" value="男" title="男">
										<input type="radio" name="sex" value="女" title="女" checked>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label"> <span class="x-red">*</span>手机
						</label>
							<div class="layui-input-inline">
								<input type="text" id="phone" name="phone" required="" value="${u.phone }" lay-verify="phone" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label"> <span class="x-red">*</span>邮箱
						</label>
							<div class="layui-input-inline">
								<input type="text" id="email" name="email" required="" value="${u.email }" lay-verify="email" autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label"><span class="x-red">*</span>入职时间</label>
							<div class="layui-inline">
								<input type="text" class="layui-input" id="hiredate" value="${u.hiredate }" name="hiredate">
							</div>
							<script>
								layui.use('laydate', function() {
									var laydate = layui.laydate;
									//执行一个laydate实例
									laydate.render({
										elem: '#hiredate' //指定元素
									});
								});
							</script>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label"><span class="x-red">*</span>出生日期</label>
							<div class="layui-inline">
								<input type="text" class="layui-input" id="birthday" value="${u.birthday }" name="birthday">
							</div>
							<script>
								layui.use('laydate', function() {
									var laydate = layui.laydate;
									//执行一个laydate实例
									laydate.render({
										elem: '#birthday' //指定元素
									});
								});
							</script>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label"> </label>
							<button class="layui-btn" lay-filter="modify" lay-submit="" type="submit">修改</button>
						</div>
					</form>
				</div>
				<div class="layui-col-md3">&nbsp</div>
			</div>
		</div>
		<script>
			layui
				.use(
					['form', 'layer'],
					function() {
						$ = layui.jquery;
						var form = layui.form,
							layer = layui.layer;

						//自定义验证规则
						form
							.verify({
								phone: [
									/^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/,
									'手机号格式不正确'
								],
								name: function(value) {
									if(value.length < 2) {
										return '用户名至少2个字符';
									}
									
									var year = 12 * 30 * 24 * 60 * 60 *1000;
									var month = 30 * 24 * 60 * 60 *1000;
									//获取当前日期
									var d = new Date();
									var nowyear = d.getFullYear();
									var nowmonth = d.getMonth()+1;
									var nowday = d.getDate();
									var checkNowdate = new Date();
									checkNowdate.setFullYear(nowyear, nowmonth-1, nowday);
									var checkNow = checkNowdate.getTime();
									//获取入职日期
									var hiredateArr = $('#hiredate').val().split("-");
									var checkHiredate = new Date();
									checkHiredate.setFullYear(hiredateArr[0], hiredateArr[1]-1, hiredateArr[2]);
									var checkHire = checkHiredate.getTime();
									//获取出生日期
									var birthdayArr = $('#birthday').val().split("-");
									var checkBirthday = new Date();
									checkBirthday.setFullYear(birthdayArr[0], birthdayArr[1]-1, birthdayArr[2]);
									var checkBirth = checkBirthday.getTime();
									//判断入职日期
									var h = (checkNow - checkHire)/month;
									if (h >= 1 || h <= -1) {
										return '入职日期需在一个月内';
									}
									//判断出生日期
									var b = (checkNow - checkBirth)/year;
									if (b <= 18) {
										return '用户未满18周岁';
									}
								}
							});

						//监听提交
						form.on('submit(modify)', function(data) {
							console.log(data);
							// 获得frame索引
							var index = parent.layer
								.getFrameIndex(window.name);
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