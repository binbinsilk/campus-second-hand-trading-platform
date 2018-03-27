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
<meta charset="UTF-8">
<title>发布信息</title>
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/form.css" />
<link href="js/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
<script src="js/uploadify/scripts/jquery.uploadify.min.js" type="text/javascript"></script>
<script type="text/javascript">
        $(function () {
            $("#uppic").uploadify({
                //指定swf文件
                swf: "js/uploadify/scripts/uploadify.swf",
                //后台处理的页面
                uploader: "mall!upload.do",
                overrideEvents:["onDialogClose","onSelectError"],
				buttonText: "上传图片",
                //在浏览窗口底部的文件类型下拉菜单中显示的文本
                fileTypeDesc: "可文件格式：",
                //允许上传的文件后缀
                fileTypeExts: "*.png;*.gif;*.jpg;*.bmp;*.jpeg",
                //设置为true将允许多文件上传
                multi: false,
                //上传完成后执行函数
                onUploadSuccess:function(file,data,response){
				    uploaded(file, data, response);
      				return;
      			}
            });
            function uploaded(file, data, response){
              $("#picPath").val(data);
			  $("#pic").attr("src",data); 	
		    }
        });
</script>
</head>
<body>
	<div class="clearfix nav">
		<a class="logo" href="javascript:;"></a>
		<ul class="clearfix nav-wrap">
			<li><a class="nav-item" href="index.jsp">首页</a></li>
			<li><a class="nav-item" href="mall!toMall.do">二手商城</a></li>
			<li><a class="nav-item nav-active" href="mall!toPublish.do">发布信息</a>
			</li>
			<li><a class="nav-item" href="mall!toCart.do">购物车</a></li>
			<li><a class="nav-item" href="index!toUs.jsp">关于我们</a></li>
		</ul>
	</div>

	<div id="container"></div>
	<form action="mall!publish.do" method="post" id="form" class="form">
	 <div align="center">
      <table width="471" border="1" align="center" class="form">
        <tbody>
          <tr>
            <th height="112" colspan="2" bgcolor="#FCFEFE" scope="col"><h1>发布信息</h1>
            <p>请在下面填写您要发布的信息</p></th>
          </tr>
          <tr>
            <td width="121" style="text-align: center">发布人 :</td>
            <td width="334">${session.userName}</td>
          </tr>
          <tr>
            <td style="text-align: center">发布标题:</td>
            <td><input id="title" type="text" name="title" placeholder="填写标题" required/></td>
          </tr>
          <tr>
            <td style="text-align: center">商品类型:</td>
            <td><select name="type" required>
				<option value="1">日常用品</option>
				<option value="2">电子数码</option>
				<option value="3">鞋类服饰</option>
				<option value="4">书籍资料</option>
				<option value="5">其他</option>
				</select></td>
          </tr>
          <tr>
            <td height="208" style="text-align: center">上传图片:</td>
            <td><input type="hidden" id="picPath" name="picPath"/>
            	<input type="file"  name="image" id="uppic" />
				<img id="pic" src="" width="255px" height="255px">
            </td>
          </tr>
          <tr>
            <td height="48" style="text-align: center">价格:</td>
            <td><input id="price" type="text" name="price"
			placeholder="填写价格" required/></td>
          </tr>
          <tr>
            <td height="82" colspan="2" style="text-align: center"><input name="submit" type="submit" class="button" id="submit" value="发布"></td>
          </tr>
        </tbody>
        </table>
  	</div>
	</form>
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
