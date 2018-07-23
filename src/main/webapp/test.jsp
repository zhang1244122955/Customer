
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
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
</head>

<body>

	<div class="layui-row">
		<div class="layui-col-md3">&nbsp</div>
		<div class="layui-col-md6">
			<div class="layui-carousel" id="test10">
				<div carousel-item="">
					<div>
						<img src="${list.get(0).path}" href="${list.get(0).href}"
							title="${list.get(0).title}">
					</div>
					<div>
						<img src="${list.get(1).path}" href="${list.get(1).href}"
							title="${list.get(1).title}">
					</div>
					<div>
						<img src="${list.get(2).path}" href="${list.get(2).href}"
							title="${list.get(2).title}">
					</div>
					<div>
						<img src="${list.get(3).path}" href="${list.get(3).href}"
							title="${list.get(3).title}">
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md3">&nbsp</div>

	</div>

	<div class="layui-row">
		<div class="layui-col-md3">&nbsp</div>
		<div class="layui-col-md6">
			<ul class="layui-timeline">

				<c:forEach items="${news}" var="newss">
					<li class="layui-timeline-item"><i
						class="layui-icon layui-timeline-axis"></i>
						<div class="layui-timeline-content layui-text">
							<h3 class="layui-timeline-title">${newss.newsdate}</h3>
							<p>
								${newss.newstitle}
							</p>
						</div>
					</li>
				</c:forEach>
				
			</ul>
		</div>
		<div class="layui-col-md3">&nbsp</div>
	</div>


	<script src="//res.layui.com/layui/dist/layui.js" charset="utf-8"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
		layui.use([ 'carousel', 'form' ], function() {
			var carousel = layui.carousel, form = layui.form;

			//图片轮播
			carousel.render({
				elem : '#test10',
				width : '778px',
				height : '440px',
				interval : 5000
			});

		});
	</script>

</body>

</html>