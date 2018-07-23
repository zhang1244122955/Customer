<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="height: 100%">
   <head>
       <meta charset="utf-8">
   </head>
   <body style="height: 100%; margin: 0">
   	   <input type="text" id="li" value="${cuslist.size()}">
   	   <c:forEach items="${cuslist}" var="cusname" varStatus="cus">
   	   <input type="text" id="a${cus.index}" value="${cusname}">
   	   </c:forEach>
       <div id="container" style="height: 100%"></div>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
       <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>
       <script type="text/javascript">
			var dom = document.getElementById("container");
			var myChart = echarts.init(dom);
			var app = {};
			option = null;
			option = {
			    title: {
			        text: '客户服务统计分析'
			    },
			    tooltip: {},
			    legend: {
			        data:['客户服务量']
			    },
			    xAxis: {
				    var length=$("#li").val();
				    var arr=new Array();	
				    for(var i=0;i<length;i++){
				    	arr[i]=$("#"+i).val;
				    }
			        data: arr[length]
			    },
			    yAxis: {},
			    series: [{
			        name: '客户服务量',
			        type: 'bar',
			        data: [5, 20, 36, 10, 10, 20]
			    }]
			};;
			if (option && typeof option === "object") {
			    myChart.setOption(option, true);
			}
       </script>
   </body>
</html>