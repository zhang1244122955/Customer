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
<script type="text/javascript">
$(function () {	
	 $.ajax({
		type : "POST",
		url : "powerjudge",
		data : {
			"id" : ".layui-form-item1",
			"power" : ${role.power},
			"pos" : $(".layui-form-item1").attr("ailin")
		},
		success : function(data) {
			var str = data.split(',');
			$(str[0]).attr("style",str[1]);
		}
	}); 
	
})
</script>
</head>

<body>
	<div class="layui-row">
		<div class="layui-col-xs3">
			<div class="grid-demo grid-demo-bg1">&nbsp</div>
		</div>
		<div class="layui-col-xs6">
			<form class="layui-form" action="/Customer/modifychance">
				<div class="grid-demo">

					<div class="layui-row">
						<div class="layui-col-xs12">
							<div class="grid-demo grid-demo-bg1">
								<div class="layui-form-item">
									<label class="layui-form-label"><span class="x-red">*</span>客户名称</label>
									<div class="layui-input-block">
										<input type="text" name="custname" value="${chance2.custname}"
											lay-verify="title" autocomplete="off" placeholder=""
											class="layui-input">
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="layui-row">
						<div class="layui-col-xs12">
							<div class="grid-demo">
								<div class="layui-form-item">

									<label class="layui-form-label"><span class="x-red">*</span>成功机率</label>
									<div class="layui-input-block">
										<select name="chsuccess" lay-verify="required" lay-search=""
											class="layui-input">
											<option value="${chance2.chsuccess}">${chance2.chsuccess}</option>
											<option value="*">*</option>
											<option value="**">**</option>
											<option value="***">***</option>
											<option value="****">****</option>
											<option value="*****">*****</option>
										</select>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="layui-row">
					<div class="layui-col-xs12">
						<div class="grid-demo grid-demo-bg1">
							<div class="layui-form-item">
								<label class="layui-form-label">概要</label>
								<div class="layui-input-block">
									<input type="text" name="choutline"
										value="${chance2.choutline}" lay-verify="title"
										autocomplete="off" placeholder="" class="layui-input">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="layui-row">
					<div class="layui-col-xs12">
						<div class="grid-demo grid-demo-bg1">
							<div class="layui-form-item">
								<label class="layui-form-label"><span class="x-red">*</span>联系人</label>
								<div class="layui-input-block">
									<input type="text" name="chcontact"
										value="${chance2.chcontact}" lay-verify="title"
										autocomplete="off" placeholder="" class="layui-input">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="layui-row">
					<div class="layui-col-xs12">
						<div class="grid-demo">
							<div class="layui-form-item">
								<label class="layui-form-label"><span class="x-red">*</span>联系人电话</label>
								<div class="layui-input-block">
									<input type="text" name="chcontactphone"
										value="${chance2.chcontactphone}" lay-verify="title"
										autocomplete="off" placeholder="" class="layui-input">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="layui-row">
					<div class="layui-col-xs12">
						<div class="grid-demo grid-demo-bg1">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">机会描述</label>
								<div class="layui-input-block">
									<textarea placeholder="请输入内容" name="chdescribe"
										value="${chance2.chdescribe}" class="layui-textarea"></textarea>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="layui-row">
					<div class="layui-col-xs12">
						<div class="grid-demo grid-demo-bg1">
							<div class="layui-form-item1" ailin="3">
								<label class="layui-form-label">指派人</label>
								<div class="layui-input-block">
									<select name="assigneeid" lay-verify="title" lay-search=""
										class="layui-input" >
										<c:if test="${empty user.name}">
										<option>点击选择指派人</option>
										<c:forEach items="${list}" var="user">
													
													<option value="${user.userid}">${user.name}</option>
												</c:forEach>
										</c:if>
										<c:if test="${not empty user.name}">
										
										<option value="${user.userid}">${user.name}</option>
												
												<c:forEach items="${list}" var="user">
													<option value="${user.userid}">${user.name}</option>
												</c:forEach>
										</c:if>
										<%-- <c:choose>
											<c:when test="${empty  assigneedname}">
												<c:forEach items="${list}" var="user">
													<option>点击选择指派人</option>
													<option value="${user.userid}">${user.name}</option>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<option disabled="disabled">${assigneedname}</option>
												
												<c:forEach items="${list}" var="user">
													<option value="${user.userid}">${user.name}</option>
												</c:forEach>
											</c:otherwise>
										</c:choose> --%>

									</select>
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="layui-row">
					<div class="layui-col-xs12">
						<div class="grid-demo grid-demo-bg1">
							<div class="layui-form-item1" ailin="3">
								<label class="layui-form-label">审核状态</label>
								
								<div class="layui-input-block" >
									<select name="chstatus" lay-verify="title" lay-search=""
										class="layui-input">
										
										<option  value="${chance2.chstatus}">${chance2.chstatus}</option>	
										<c:choose>
										<c:when test="${chance2.chstatus =='已通过'}">
										<option value="等待审核">等待审核</option>
										<option value="未通过">未通过</option>
										<option value="需要修改">需要修改</option>
										
										</c:when>
										<c:when test="${chance2.chstatus =='等待审核'}">
									
										<option value="未通过">未通过</option>
										<option value="需要修改">需要修改</option>
										<option value="已通过">已通过</option>
										</c:when>
										<c:when test="${chance2.chstatus =='需要修改'}">
										<option value="等待审核">等待审核</option>
										<option value="未通过">未通过</option>
									
										<option value="已通过">已通过</option>
										</c:when>
																
										<c:otherwise>
										<option value="等待审核">等待审核</option>
										<option value="未通过">已通过</option>
										<option value="需要修改">需要修改</option>
										</c:otherwise>
										</c:choose>		
									</select>
								</div>
								
								
								
							</div>
						</div>
					</div>
				</div>
				<div class="layui-row">
					<div class="layui-col-xs12">
						<div class="grid-demo grid-demo-bg1">
							<div class="layui-form-item" style="display: none">
								<label class="layui-form-label">机会编号</label>
								<div class="layui-input-block">
									<input type="text" name="chid" value="${chance2.chid}"
										lay-verify="title" autocomplete="off" placeholder=""
										class="layui-input">
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="layui-row">
					<div class="layui-col-xs12">
						<div class="grid-demo grid-demo-bg1">
							<div class="layui-form-item">
								<label for="L_repass" class="layui-form-label"> </label>
								<button type="submit" class="layui-btn" lay-submit=""
									lay-filter="add">保存</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

	<div class="layui-col-xs1">
		<div class="grid-demo">&nbsp</div>
	</div>
	</div>
	<script type="text/javascript">
	 //表单验证
	 layui.use([ 'form', 'layer' ], function() {
			$ = layui.jquery;
			var form = layui.form, layer = layui.layer;

			//自定义验证规则
			form.verify({
				
				phone : [ /^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/, '手机号格式不正确' ]
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
		}) 
	</script>
</body>

</html>