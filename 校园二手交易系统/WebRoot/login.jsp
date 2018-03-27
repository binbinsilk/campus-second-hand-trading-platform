<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>登录</title>
	<link rel="stylesheet" type="text/css" href="css/style1.css">
	<script src="js/jquery-1.11.0.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/placeholderfriend.js"></script>

  </head>
  
  <body>
   <!--内容-->
	<div class="content_bg">
		<!--logo-->
		<div class="head_logo">
			<div class="f_l">
				<img src="images/pic1.png" height="100" width="142">
			</div>
			<div class="f_l l_m10">
				<h1 style="height:100px;line-height: 100px;">校园二手交易平台</h1>
			</div>
			<div class="qfd"></div>
		</div>
		<!--logo结束-->
		<!--登录内容-->
		<div class="login_con">
		<form id="loginForm" action="index!login.do" method="post">
			<!--登录表单-->
			<div class="login_form">
				<!--手机号-->
				<div class="login_inpWrap" id="login_tel" onmouseover="changeOver('login_tel')" 
					onmouseout="changeOut('login_tel')" onclick="changeOver('login_tel')">
					<div class="f_l login_user_pic login_picBox">
						<img src="images/user.png" height="37" width="33">
					</div>
					<div class="f_l login_textBox">
						<input type="text" name="account" placeholder="请输入用户名">
					</div>
					<div class="qfd"></div>
				</div>
				<!--手机号结束-->
				<!--密码-->
				<div class="login_inpWrap" id="login_pwd" onmouseover="changeOver('login_pwd')" 
					onmouseout="changeOut('login_pwd')" onclick="changeOver('login_pwd')">
					<div class="f_l login_pwd_pic login_picBox">
						<img src="images/pwd.png" height="38" width="28">
					</div>
					<div class="f_l login_textBox">
						<input type="password" name="password" placeholder="请输入密码">
					</div>
					<div class="qfd"></div>
				</div>
					<span id="errorMsg"
						style='text-align:center;color:Red;font-weight:bold;'>${errorMsg}</span>
				<!--密码结束-->
				<!--登录-->
				<div class="login_btnWrap">
					<button class="reg_btn" onclick="reg()" type="button">注册</button>
					<button class="login_btn" type="submit">登录</button>
				</div>
				<!--登录结束-->
			</div>
			</form>
			<!--登录表单结束-->
		</div>
		<!--登录内容结束-->
	</div>
	<!--内容结束-->
	<script type="text/javascript">
		function changeOver(border){
			var line = document.getElementById(border);
			line.style.borderColor="#f04848";
		}
		function changeOut(border){
			var line = document.getElementById(border);
			line.style.borderColor="#dbdbdb";
		}
		$(".login_inp").click(function() {
			this.val("");
		});
		function reg(){
			window.location.href="index!toReg.do";
		}
	</script>
  </body>
</html>