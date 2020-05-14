<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册界面</title>
</head>
<body style="background: url(1.jpg)" align="center">
<font color="purple" size="5px">注册新用户</font><br><br>
<form action="jiancha.jsp" method="post">
用户名：  <input type="text" name="name" placeholder="用户名不超过六位"><br><br>
    密码：  <input type="password" name="pwd" placeholder="密码不少于四位"><br><br>
确认密码: <input type="password" name="pwd1" placeholder="密码不少于四位"><br><br>
<input type="submit" value="注册"><br><br>
<a href="login.jsp"><font color="blue">已有账号点此登录</font></a>
</form>
</body>
</html>