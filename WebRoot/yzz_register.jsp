<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<title>用户注册-13008082</title>
	<meta charset="utf-8">
	<meta name="author" content="殷振钟-13008082">
	<style type="text/css">
	/*通用样式*/
	*{
		padding: 0;
		margin: 0;
	}
	body{
		font: 18px/28px '微软雅黑','Microsoft YaHei',Arial;
		background-color: #37A6D0;
	}
	img{
		border: none;
	}
	/*登录框样式*/
	.main{
		height: 300px;
		width: 400px;
		background-color: #FEFEFE;
		margin: 80px auto 0;
		padding: 50px;
		color: #333333;
		text-align: center;
	}
	.main h1{
		font-size: 30px;
	}
	.main input{
		height: 30px;
		line-height: 28px;
		width: 200px;
		margin: 10px auto;
		font-size:12px;
		color:grey;
	}
	.main span{
		color:red;
	}
	.main button{
		width: 322px;
		height: 50px;
	    background: url(img/register.png);
   		border: 0;
    	cursor: pointer;
    	margin: 15px auto;
	}
	.main button:hover{
		background: url(img/register_h.png);
	}
	.link{
		margin-right: -20px;
		margin-top: 10px;
		text-align: right;
	}
	.link a{
		text-decoration: none;
		font-size: 14px;
		color: #45B0FF;
	}
	.copy{
		width:100%;
		height: 40px;
		text-align:right;
		line-height:28px;
		margin-top:110px;
		color:#3799D0;
		font-size:28px;
	}
	.copy:hover{
		color:#37C4D0;
	}
	</style>
	<script type="text/javascript">
		function check(form){
			var username=document.getElementById("username").value;
			if(!/^[0-9a-zA-Z_]+$/.test(username)){
				alert('用户名不符合规范');
				return false;
			}
			var password=document.getElementById("password").value;
			if(/^[\s\n\r\t]*$/.test(password)){
				alert('密码不能为空');
				return false;
			}
			var repassword=document.getElementById("repassword").value;
			if(/^[\s\n\r\t]*$/.test(repassword)){
				alert('密码不能为空');
				return false;
			}
			if(password != repassword){
				alert('两次输入的密码不一致！');
				return false;
			}
		}
	</script>
</head>
<body>
<div class="main">
	<h1>快速注册</h1><br/>
	<form action="/WebTaskYzz/RegisterServlet" method="post" onsubmit="return check(this)">
		填写用户名 <input type="text" name="username" id="username" value="只能使用字母、数字、下划线" onblur="if (this.value=='') this.value='只能使用字母、数字、下划线';" onfocus="if (this.value=='只能使用字母、数字、下划线') this.value='';"><span>*</span><br/>
		请设置密码 <input type="password" name="password" id="password"><span>*</span><br/>
		请重复密码 <input type="password" name="repassword" id="repassword"><span>*</span><br/>
		<button type="submit" value="立即注册"></button>
	</form>
	<div class="link"><a href="login.html">已有账号，现在登陆</a></div>
</div>
<div class="copy">
<%= new pres.yinzhenzh.servlet.User().getCopy() %></div>
</body>
</html>