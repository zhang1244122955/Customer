<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div class="layui-row">
		<div class="layui-col-xs3">
			<div class="grid-demo grid-demo-bg1">&nbsp</div>
		</div>
		<div class="layui-col-xs6">
			<form class="layui-form" action="/Customer/modifyCustomer">
				<div class="grid-demo">

					<div class="layui-row">
						<div class="layui-col-xs12">
							<div class="grid-demo grid-demo-bg1">
								<div class="layui-form-item">
									<label class="layui-form-label"><span class="x-red">*</span>客户名称</label>
									<div class="layui-input-block">
										<input type="text" name="custname" lay-verify="required"
											autocomplete="off" placeholder="" class="layui-input"
											id="custname" value="${customer.custname}">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="layui-row">
						<div class="layui-col-xs12">
							<div class="grid-demo grid-demo-bg1">
								<div class="layui-form-item">
									<label class="layui-form-label"><span class="x-red">*</span>客户住址</label>
									<div class="layui-input-block">
										<input type="text" name="custaddress" lay-verify="required"
											autocomplete="off" placeholder="" class="layui-input"
											id="custaddress" value="${customer.custaddress}">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="layui-row">
						<div class="layui-col-xs12">
							<div class="grid-demo">
								<div class="layui-form-item">

									<label class="layui-form-label"><span class="x-red">*</span>经理人</label>
									<div class="layui-input-block">
										<select name="userid" lay-verify="required" lay-search=""
											class="layui-input" id="userid">
											<option value="${customer.userid}">${customer.userid}</option>
											<c:forEach items="${list}" var="user">
												<option value="${user.userid}">${user.name}</option>
											</c:forEach>

										</select>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
				<div class="layui-row">
					<div class="layui-col-xs12">
						<div class="grid-demo">
							<div class="layui-form-item">

								<label class="layui-form-label"><span class="x-red">*</span>合作等级</label>
								<div class="layui-input-block">
									<select name="custlevel" lay-verify="required" lay-search=""
										class="layui-input" id="custlevel"
										value="${customer.custlevel}">
										<option value="普通合作伙伴">普通合作伙伴</option>
										<option value="战略合作伙伴">战略合作伙伴</option>

									</select>
								</div>
							</div>

						</div>
					</div>
				</div>
				<div class="layui-row">
					<div class="layui-col-xs12">
						<div class="grid-demo grid-demo-bg1">
							<div class="layui-form-item">
								<label class="layui-form-label"><span class="x-red">*</span>传真</label>
								<div class="layui-input-block">
									<input type="text" name="custfax" lay-verify="required"
										autocomplete="off" placeholder="" class="layui-input"
										id="custfax" value="${customer.custfax}">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="layui-row">
					<div class="layui-col-xs12">
						<div class="grid-demo grid-demo-bg1">
							<div class="layui-form-item" style="display: none">
								<label class="layui-form-label"><span class="x-red">*</span>客户编号</label>
								<div class="layui-input-block">
									<input type="text" name="custid" lay-verify="required"
										autocomplete="off" placeholder="" class="layui-input"
										id="custid" value="${customer.custid}">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="layui-row">
					<div class="layui-col-xs12">
						<div class="grid-demo grid-demo-bg1">
							<div class="layui-form-item">
								<label class="layui-form-label"></label>
								<button type="submit" class="layui-btn" lay-submit=""
									lay-filter="add" id="btn">保存</button>
							</div>
						</div>
					</div>
				</div>
		</div>

		</form>
	</div>

	<div class="layui-col-xs3">
		<div class="grid-demo">&nbsp</div>
	</div>
	</div>

	<script type="text/javascript">
		layui
				.use(
						[ 'form', 'layer' ],
						function() {
							$ = layui.jquery;
							var form = layui.form, layer = layui.layer;

							//自定义验证规则
							form
									.verify({

										phone : [
												/^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/,
												'手机号格式不正确' ]
									});

							//监听提交
							form.on('submit(add)', function(data) {

								console.log(data);
								// 获得frame索引
								var index = parent.layer
										.getFrameIndex(window.name);
								//关闭当前frame
								parent.layer.close(index);
								return true;
							});
						})
	</script>

</body>

</html>