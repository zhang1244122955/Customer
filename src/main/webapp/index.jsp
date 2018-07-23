<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台登录</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="/Customer/resources/css/font.css">
<link rel="stylesheet" href="/Customer/resources/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="/Customer/resources/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="/Customer/resources/js/xadmin.js"></script>

</head>
<body>
	<!-- 顶部开始 -->
	<div class="container">
		<div class="logo">
			<a href="./index.jsp">Ailin</a>
		</div>
		<div class="left_open">
			<i title="展开左侧栏" class="iconfont">&#xe699;</i>
		</div>
		
		<ul class="layui-nav right" lay-filter="">
			<li class="layui-nav-item"><a href="javascript:;">${user.name}</a>
				<dl class="layui-nav-child">
					<!-- 二级菜单 -->
					<dd>
						<a href="./login.jsp">退出</a>
					</dd>
				</dl></li>
			<li class="layui-nav-item to-index"><a href="/Customer/test">前台首页</a></li>
		</ul>

	</div>
	<!-- 顶部结束 -->
	<!-- 中部开始 -->
	<!-- 左侧菜单开始 -->
	<div class="left-nav">
		<div id="side-nav">
			<ul id="nav">
				<li id="1" ailin="1,2,3,4,5,6,7,8,21"><a href="javascript:;">
						<i class="iconfont">&#xe723;</i> <cite>营销管理</cite> <i
						class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li id="11" ailin="1,2,3,4,5,21"><a
							_href="/Customer/chancepage?page=1"> <i class="iconfont">&#xe6a7;</i>
								<cite>销售机会管理</cite>

						</a></li>
						<li id="12" ailin="3,6,7,8"><a _href="/Customer/showAll">
								<i class="iconfont">&#xe6a7;</i> <cite>客户开发计划</cite>

						</a></li>
					</ul></li>
				<li id="2" ailin="18"><a href="javascript:;"> <i
						class="iconfont">&#xe6b8;</i> <cite>客户管理</cite> <i
						class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">

						<li id="21" ailin="18"><a _href="/Customer/findCustomer">
								<i class="iconfont">&#xe6a7;</i> <cite>客户信息管理</cite>
						</a></li>

						<li id="22" ailin="18"><a _href="/Customer/customerWastagepage">
								<i class="iconfont">&#xe6a7;</i> <cite>客户流失管理</cite>
						</a></li>
					</ul></li>
				<li id="3" ailin="13,14,15,16"><a href="javascript:;"> <i
						class="iconfont">&#xe6ab;</i> <cite>服务管理</cite> <i
						class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li id="31" ailin="14"><a _href="/Customer/showAllServe">
								<i class="iconfont">&#xe6a7;</i> <cite>服务创建</cite>
						</a></li>
						<li id="32" ailin="16"><a
							_href="/Customer/showNoAssigneServe"> <i class="iconfont">&#xe6a7;</i>
								<cite>服务分配</cite>
						</a></li>
						<li id="33" ailin="15"><a _href="/Customer/showNoDealServe">
								<i class="iconfont">&#xe6a7;</i> <cite>服务处理</cite>
						</a></li>
						<li id="34" ailin="15"><a _href="/Customer/showNoSersatisfy">
								<i class="iconfont">&#xe6a7;</i> <cite>服务反馈</cite>
						</a></li>

						<li id="35" ailin="16"><a _href="/Customer/showFileServe">
								<i class="iconfont">&#xe6a7;</i> <cite>服务归档</cite>
						</a></li>
					</ul></li>
				<li id="4" ailin="10,11,12"><a href="javascript:;"> <i
						class="iconfont">&#xe6b5;</i> <cite>订单管理</cite> <i
						class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li id="41" ailin="10"><a _href="/Customer/showOrdersById">
								<i class="iconfont">&#xe6a7;</i> <cite>订单创建</cite>
						</a></li>
						<li id="42" ailin="11"><a _href="/Customer/dealOrdersShow">
								<i class="iconfont">&#xe6a7;</i> <cite>订单处理</cite>
						</a></li>
						<li id="43" ailin="12"><a _href="/Customer/ordersExam"> <i
								class="iconfont">&#xe6a7;</i> <cite>订单审核</cite>
						</a></li>
						<li id="44" ailin="12"><a _href="/Customer/showAllFinshOrders">
								<i class="iconfont">&#xe6a7;</i> <cite>订单归档</cite>
						</a></li>
					</ul></li>
				<li id="5" ailin="22"><a href="javascript:;"> <i
						class="iconfont">&#xe6ce;</i> <cite>统计报表</cite> <i
						class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li id="51" ailin="22"><a _href="admin-list.jsp"> <i
								class="iconfont">&#xe6a7;</i> <cite>客户服务分析</cite>
						</a></li>
						<li id="52" ailin="22"><a _href="/Customer/selectAllCustAna"> <i
								class="iconfont">&#xe6a7;</i> <cite>订单构成分析</cite>
						</a></li>
						<li id="53" ailin="22"><a _href="ServeReport.jsp"> <i
								class="iconfont">&#xe6a7;</i> <cite>客户服务分析</cite>
						</a></li>
						<li id="54" ailin="22"><a _href="admin-rule.jsp"> <i
								class="iconfont">&#xe6a7;</i> <cite>客户流失分析</cite>
						</a></li>
					</ul></li>

				<li id="6" ailin=""><a href="javascript:;"> <i
						class="iconfont">&#xe726;</i> <cite>用户管理</cite> <i
						class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">

						<li id="61" ailin=""><a _href="/Customer/findUsers"> <i
								class="iconfont">&#xe6a7;</i> <cite>用户管理</cite>
						</a></li>

						<li id="62" ailin="19"><a _href="/Customer/findRoles"> <i
								class="iconfont">&#xe6a7;</i> <cite>角色管理</cite>
						</a></li>
					</ul></li>
				<li id="7" ailin="20,21"><a href="javascript:;"> <i
						class="iconfont">&#xe6b3;</i> <cite>新闻管理</cite> <i
						class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li id="71" ailin="21"><a _href="/Customer/file/broadcast">
								<i class="iconfont">&#xe6a7;</i> <cite>轮播管理</cite>
						</a></li>
						<li id="72" ailin="20"><a _href="/Customer/news?page=1">
								<i class="iconfont">&#xe6a7;</i> <cite>新闻管理</cite>
						</a></li>
					</ul></li>
				<li id="8" ailin=""><a href="javascript:;"> <i
						class="iconfont">&#xe6b4;</i> <cite>系统管理</cite> <i
						class="iconfont nav_right">&#xe697;</i>
				</a>
					<ul class="sub-menu">
						<li id="81" ailin=""><a _href="unicode.jsp"> <i
								class="iconfont">&#xe6a7;</i> <cite>自定义设置</cite>
						</a></li>
						<li id="82" ailin=""><a _href="unicode.jsp"> <i
								class="iconfont">&#xe6a7;</i> <cite>数据库管理</cite>
						</a></li>
						<li id="83" ailin=""><a _href="unicode.jsp"> <i
								class="iconfont">&#xe6a7;</i> <cite>数据库连接设置</cite>
						</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!-- <div class="x-slide_left"></div> -->
	<!-- 左侧菜单结束 -->
	<!-- 右侧主体开始 -->
	<div class="page-content">
		<div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
			<ul class="layui-tab-title">
				<li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
			</ul>
			<div class="layui-tab-content">
				<table>
					<c:forEach items="${users }" var="users">
						<tr>
							<td>${users.userid }</td>
						</tr>

					</c:forEach>
				</table>
				<div class="layui-tab-item layui-show">
					<iframe src='./welcome.jsp' frameborder="0" scrolling="yes"
						class="x-iframe"></iframe>
				</div>
			</div>
		</div>
	</div>
	<div class="page-content-bg"></div>
	<!-- 右侧主体结束 -->
	<!-- 中部结束 -->
	<!-- 底部开始 -->
	<div class="footer">
		<div class="copyright">Copyright ©2017 x-admin v2.3 All Rights
			Reserved</div>
	</div>
	<!-- 底部结束 -->



	<script src="resources/js/jquery-1.7.1.min.js" charset="utf-8"></script>
	<script src="resources/js/amq_jquery_adapter.js"></script>
	<script src="resources/js/amq.js"></script>

	<script>
	
	$(function() {
		//监听自己的消息队列
		var amq = org.activemq.Amq;
		amq.init({
			uri : 'amq',
			logging : false,
			timeout : 20
		});
		

		window.onbeforeunload = function() {

			amq.removeListener(${user.userid}, 'queue://'+${user.userid})
		};
		
		layui.use('layim', function(layim){
			  //基础配置
			  layim.config({
				title:"我的消息"
				,isgroup: false//是否开启群组
			   	,init: {
			   		url: 'init' //接口地址（返回的数据格式见下文）
			   		  ,type: 'post' //默认get，一般可不填
			   		  ,data: {
			   			  userid : ${user.userid}
			   		  } //额外参数
			   	} //获取主面板列表信息，下文会做进一步介绍
			   	
			    
			    //获取群员接口（返回的数据格式见下文）
			    ,members: {
			      url: '' //接口地址（返回的数据格式见下文）
			      ,type: 'get' //默认get，一般可不填
			      ,data: {} //额外参数
			    }
			    
			    //上传图片接口（返回的数据格式见下文），若不开启图片上传，剔除该项即可
			    ,uploadImage: {
			      url: '' //接口地址
			      ,type: 'post' //默认post
			    } 
			    
			    //上传文件接口（返回的数据格式见下文），若不开启文件上传，剔除该项即可
			    ,uploadFile: {
			      url: '' //接口地址
			      ,type: 'post' //默认post
			    }
			    //扩展工具栏，下文会做进一步介绍（如果无需扩展，剔除该项即可）
			    ,tool: [{
			      alias: 'code' //工具别名
			      ,title: '代码' //工具名称
			      ,icon: '&#xe64e;' //工具图标，参考图标文档
			    }]
			    
			    ,msgbox: layui.cache.dir + 'css/modules/layim/html/msgbox.html' //消息盒子页面地址，若不开启，剔除该项即可
			    ,find: layui.cache.dir + 'css/modules/layim/html/find.html' //发现页面地址，若不开启，剔除该项即可
			    ,chatLog: layui.cache.dir + 'css/modules/layim/html/chatlog.html' //聊天记录页面地址，若不开启，剔除该项即可
			  	
			  });
			  layim.on('sendMessage', function(res){
					  //发送消息
					  amq.sendMessage("queue://"+res.to.id,res.mine.id+"!**!"+res.mine.username+"!**!"+res.mine.content)
					  
			  });
			  var myHandler = {
						rcvMessage : function(message) {
							//接收到消息后，自己的业务处理逻辑
							//截取操作字符串
							arr=message.data.split("!**!");
							if(arr[0]=="notice"){
								show(arr[1])
							}else{
								layim.getMessage({
									  username: arr[1] //消息来源用户名
									  ,avatar: "/Customer/resources/images/Ailin.png" //消息来源用户头像
									  ,id: arr[0] //消息的来源ID（如果是私聊，则是用户id，如果是群聊，则是群组id）
									  ,type: "friend" //聊天窗口来源类型，从发送消息传递的to里面获取
									  ,content: arr[2] //消息内容
									  //,cid: 0 //消息id，可不传。除非你要对消息进行一些操作（如撤回）
									  ,mine: false //是否我发送的消息，如果为true，则会显示在右方
									  ,fromid: arr[0] //消息的发送者id（比如群组中的某个消息发送者），可用于自动解决浏览器多窗口时的一些问题
									  ,timestamp: (new Date()).valueOf() //服务端时间戳毫秒数。注意：如果你返回的是标准的 unix 时间戳，记得要 *1000
									})
							}
						}
					};
					amq.addListener(${user.userid}, 'queue://'+${user.userid}, myHandler.rcvMessage);
			  
		});
	})
	
	
	function show(msg){
		 
		//示范一个公告层
	       layer.open({
	        type: 1
	        ,title: false //不显示标题栏
	        ,offset: [ //为了演示，随机坐标
		          Math.random()*($(window).height()-300)
		          ,Math.random()*($(window).width()-390)
		        ] 
	        ,closeBtn: false
	        ,area: '300px;'
	        ,shade: 0.3
	        ,btn: ['我知道了']
	        ,btnAlign: 'c'
	        ,moveType: 1 //拖拽模式，0或者1
	        ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">'+msg+'</div>'
	        
	      }); 
	}
	
	
	for (var i=1;$("#"+i).attr("ailin") != undefined;i++) {
		$.ajax({
			type : "POST",
			url : "powerjudge",
			data : {
				"id" : "#"+i,
				"power" : ${role.power},
				"pos" : $("#"+i).attr("ailin")
			},
			success : function(data) {


				var str = data.split(',');
				$(str[0]).attr("style",str[1]);
			}
		});
		for (var j=1;$("#"+i+j).attr("ailin") != undefined;j++){


			$.ajax({
				type : "POST",
				url : "powerjudge",
				data : {
					"id" : "#"+i+j,
					"power" : ${role.power},
					"pos" : $("#"+i+j).attr("ailin")
				},
				success : function(data) {


					var str = data.split(',');
					$(str[0]).attr("style",str[1]);
				}
			});
		}
	}
	
	
	
		//百度统计可去掉
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