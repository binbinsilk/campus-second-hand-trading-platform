<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>购物车</title>
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
	</head>
	<body>
		<div class="clearfix nav">
			<a class="logo" href="javascript:;"></a>
			<ul class="clearfix nav-wrap">
				<li><a class="nav-item" href="index.jsp">首页</a></li>
				<li><a class="nav-item" href="mall!toMall.do">二手商城</a></li>
				<li><a class="nav-item" href="mall!toPublish.do">发布信息</a></li>
				<li><a class="nav-item nav-active" href="mall!toCart.do">购物车</a></li>
				<li><a class="nav-item" href="index!toUs.do">关于我们</a></li>
			</ul>
		</div>
		
		<div id="container">
		</div>
		<ul class="breadnav clearfix">
			<li class="bnav-item">购物车</li>
		</ul>
		
		<div class="about-wrap">
			<s:iterator value="#list" var="obj">
				<dl class="about-dl clearfix">
					<dt class="about-pic">
						<img src="${obj[1]}"/>
					</dt>
					<dd class="about-txt">
						<h3 class="about-h">${obj[2]}</h3>
						<p class="about-p">价格：${obj[3]}</p>
						<p class="about-p">发布人：${obj[4]}</p>
						<p class="about-p delete" cid="${obj[0]}">删除</p>
					</dd>
				</dl>
			</s:iterator>
		</div>
		<div class="foot">
			<div class="foot-wrap">
				<p class="foot-tit">友情链接</p>
				<ul class="foot-link clearfix">
					<li class="foot-pic">
						<a href="javascript:;"><img src="images/link6.png"/></a>
					</li>
					<li class="foot-pic">
						<a href="javascript:;"><img src="images/link5.png"/></a>
					</li>
					<li class="foot-pic">
						<a href="javascript:;"><img src="images/link4.png"/></a>
					</li>
					<li class="foot-pic">
						<a href="javascript:;"><img src="images/link3.png"/></a>
					</li>
					<li class="foot-pic">
						<a href="javascript:;"><img src="images/link2.png"/></a>
					</li>
					<li class="foot-pic">
						<a href="javascript:;"><img src="images/link1.png"/></a>
					</li>
				</ul>
				<div class="copyright">
					<p>CopyRight All rigt rederved</p>
					<p>版权所有：</p>
					<p>ICP备案号：</p>
				</div>
			</div>
		</div>
		<div class="jiesuan">
			<a href="mall!jiesuan.do?id=${session.userId}">结算</a>
		</div>
	</body>
	<!--jq调用-->
	<script src="js/jquery-1.11.0.js" type="text/javascript"></script>

	<script type="text/javascript">
		$(".delete").click(function(){
			$.post("mall!deleteCart.do",{"id":$(this).attr("cid")},function(result){
				alert(result);
				window.location.href="mall!toCart.do";
			});
		});
	</script>
</html>