<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="mywebproject.LoginDao"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String name=request.getParameter("name");
String pwd=request.getParameter("pwd");
LoginDao dao=new LoginDao();
boolean flag=dao.login(name,pwd);
if(flag)
{
	%>
	<a href="success.jsp"><font color="pink" size="8px">登陆成功点此进入</font></a>
	<%
}
else
{
	%>
	<a href="login.jsp"><font color="pink" size="8px">您输入的用户名或密码错误点此返回上一级</font></a>
	<%
}
%>
</body>
</html>