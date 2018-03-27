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
		<!-- 优先使用 IE 最新版本和 Chrome -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
		
		<title>首页</title>
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
	</head>
	<body>
		<div class="clearfix nav">
			<a class="logo" href="javascript:;"></a>
			<ul class="clearfix nav-wrap">
				<li><a class="nav-item nav-active" href="index.jsp">首页</a></li>
				<li><a class="nav-item" href="mall!toMall.do">二手商城</a></li>
				<li><a class="nav-item" href="mall!toPublish.do">发布信息</a></li>
				<li><a class="nav-item" href="mall!toCart.do">购物车</a></li>
				<li><a class="nav-item" href="index!toUs.jsp">关于我们</a></li>
			</ul>
		</div>
		
		<div id="container">
		</div>
		
		<div class="new-wrap">
			<p class="newfood-tit">最新发布</p>
			<div class="newfood-box clearfix" id="newfood-table">
				<ul class="newfood-wrap clearfix newfood-show">
					<s:iterator value="#list">
						<div url="mall!addToCart.do?goodsId=${id}" class="ms-wrap ms-right goods">
							<span class="ms-pic">
								<img src="${picPath}" width="255px" height="255px"/>
							</span>
							<h2 class="ms-tit">${title}</h2>
							<p class="ms-txt">价格：${price}元</p>
						</div>
					</s:iterator>
				</ul>
			</div>
		</div>
		<div class="company-wrap">
			<p class="company-tit">网站简介</p>
			<dl class="clearfix company-dl">
				<dt class="company-dt">
					<img src="images/pic1.png"/>
				</dt>
				<dd class="company-dd">
					<br>
					<br>
					<br>
					<br>
					<p>随着计算机技术以及互联网+的普及与发展，网络购物已经成为日常生活中不可分割的一部分。在支付宝支付、
					微信支付等便捷支付手段下，网购更是成为大学课余生活的热点，而闲置下来的物品缺少一个交易的渠道。但是现存的网络二手物品交易并不完善，
					特别是针对大学校园的二手物品交易，几乎是一个空白。根据郑州大学软件与应用科技学院学科特点，建立起针对性的二手书交易平台，更加实用与人性化。</p>
				</dd>
			</dl>
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
	<script src="js/jquery-1.11.0.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function(){
			$("#class"+"${type}").addClass("table-active");
		});
		$(".goods").click(function(){
			$.post($(this).attr("url"),{},function(result){
				alert(result);
			});
		});
	</script>
</html>