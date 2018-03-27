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
		<title>二手商城</title>
		<link rel="stylesheet" type="text/css" href="css/common.css"/>
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<link rel="stylesheet" type="text/css" href="css/jqpagination.css"/>
		<!--jq调用-->
		<script src="js/jquery-1.11.0.js" type="text/javascript"></script>
		<script src="js/jquery.jqpagination.min.js" type="text/javascript"></script>
		
	</head>
	<body>
		<div class="clearfix nav">
			<a class="logo" href="javascript:;"></a>
			<ul class="clearfix nav-wrap">
				<li><a class="nav-item" href="index.jsp">首页</a></li>
				<li><a class="nav-item nav-active" href="mall!toMall.do">二手商城</a></li>
				<li><a class="nav-item" href="mall!toPublish.do">发布信息</a></li>
				<li><a class="nav-item" href="mall!toCart.do">购物车</a></li>
				<li><a class="nav-item" href="index!toUs.jsp">关于我们</a></li>
			</ul>
		</div>
		
		<div id="container">
			
		</div>
		
		<ul class="breadnav clearfix">
			<li class="bnav-item">二手商城</li>
		</ul>
		<div class="clearfix table-wrap" id="tab-span">
			<input type="hidden" name="type" id="type" value="${type}">
			<span class="table-item" id="class"><a href="mall!toMall.do">全部商品</a></span>
			<span class="table-item" id="class1"><a href="mall!toMall.do?type=1">日常用品</a></span>
			<span class="table-item" id="class2"><a href="mall!toMall.do?type=2">电子数码</a></span>
			<span class="table-item" id="class3"><a href="mall!toMall.do?type=3">鞋类服饰</a></span>
			<span class="table-item" id="class4"><a href="mall!toMall.do?type=4">书籍资料</a></span>
			<span class="table-item" id="class5"><a href="mall!toMall.do?type=5">其他</a></span>
		</div>
		<div id="table-div">
			<div class="table-pic table-show clearfix">
				<s:iterator value="#list">
					<div url="mall!addToCart.do?goodsId=${id}" class="ms-wrap ms-right goods">
						<span class="ms-pic">
							<img src="${picPath}"  width="255px" height="255px" />
						</span>
						<h2 class="ms-tit">${title}</h2>
						<p class="ms-txt">价格：${price}元</p>
					</div>
				</s:iterator>
			</div>
			<div align="center">
				<div class="pagination ms-paging clearfix">
				  <a href="#" class="first" data-action="first">&laquo;</a>
				  <a href="#" class="previous" data-action="previous">&lsaquo;</a>
				  <input type="text" readonly="readonly" data-max-page="40" />
				  <a href="#" class="next" data-action="next">&rsaquo;</a>
				  <a href="#" class="last" data-action="last">&raquo;</a>
				</div>
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
	<script type="text/javascript">
		$(function(){
			$("#class"+"${type}").addClass("table-active");
		});
		$(".goods").click(function(){
			$.post($(this).attr("url"),{},function(result){
				alert(result);
			});
		});
		var type = $("#type").val();
		$(".pagination").jqPagination({
		  link_string : "mall!toMall.do?pageNum={page_number}&type="+type,
		  current_page: "${pageNum}", //设置当前页 默认为1
		  max_page : "${totalPages}", //设置最大页 默认为1
		  page_string : '当前第{current_page}页,共{max_page}页',
		});
	</script>
</html>