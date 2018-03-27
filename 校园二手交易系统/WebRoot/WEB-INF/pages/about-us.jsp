<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>关于我们</title>
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
				<li><a class="nav-item" href="mall!toCart.do">购物车</a></li>
				<li><a class="nav-item nav-active" href="index!toUs.jsp">关于我们</a></li>
			</ul>
		</div>
		
		<div id="container">
		</div>
		
		<div class="comp-wrap">
			<p class="comp-tit">网站简介</p>
			<div class="comp-txt">
				<p>随着计算机技术以及互联网+的普及与发展，网络购物已经成为日常生活中不可分割的一部分。在支付宝支付、
					微信支付等便捷支付手段下，网购更是成为大学课余生活的热点，而闲置下来的物品缺少一个交易的渠道。但是现存的网络二手物品交易并不完善，
					特别是针对大学校园的二手物品交易，几乎是一个空白。根据郑州大学软件与应用科技学院学科特点，建立起针对性的二手书交易平台，更加实用与人性化。</p>
			</div>
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
	</body>
</html>