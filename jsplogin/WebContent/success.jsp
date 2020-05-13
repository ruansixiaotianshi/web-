<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>仲夏</title>
</head>
<body>
<body style="background: url(4.jpg)" align="center">
<font color="white" size="5px">仲夏欢迎您的加入</font><br><br>
<font color="pink" size="5px">人类的悲欢并不相同，我只是觉得他们吵闹</font><br><br>


<form action="UpLoadServet" method="post" enctype="multipart/form-data">
<font color="white" size="5px">文件上传功能(将你的照片，音乐，视频或者文档等经过上传分享到我的电脑)</font><br><br>
学号：<input name="sno"><br><br>
姓名：<input name="sname"><br><br>
上传文件：<input type="file" name="spicture"><br><br>
<input type="submit" value="上传"><br><br>
<font color="white" size="5px">文件下载功能(可以下载我在tomcat服务器上传的文件)</font><br><br>
</form>
<font color="#B2DFEE" size="5px">tomcat服务器文件</font><br><br>
<a href="DownLoadServlet?filename=测试.txt"><font color="green" size="4px">测试文档</font></a><br>
<a href="DownLoadServlet?filename=1.jpg"><font color="green" size="4px">照片1</font></a><br>
<a href="DownLoadServlet?filename=2.jpg"><font color="green" size="4px">照片2</font></a><br>
<a href="DownLoadServlet?filename=3.jpg"><font color="green" size="4px">照片3</font></a><br>
<a href="DownLoadServlet?filename=4.jpg"><font color="green" size="4px">照片4</font></a><br><br>
<a href="zhuce.jsp"><font color="white" size="5px">点此回到首页</font></a>


</body>
</html>