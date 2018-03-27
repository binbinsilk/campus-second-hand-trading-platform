<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/form.css" />
</head>

<body>
	<form action="index!reg.do" id="form" method="post" class="white-pink">
		<h1>
			校园二手交易平台<span>请在下面填写您的注册信息</span>
		</h1>
		<label> <span>账号:</span><input id="account" type="text" name="account"
			placeholder="输入账号" required/></label> 
		<label> <span>密码:</span> <input id="password" type="text" name="password"
			placeholder="输入密码" required/> </label>
		<label> <span>姓名:</span> <input id="userName" type="text" name="userName"
			placeholder="输入姓名" required/> </label>
		<label> <span>&nbsp;</span> <input type="submit"
			class="button" value="注册" /> </label>
	</form>
</body>
</html>
