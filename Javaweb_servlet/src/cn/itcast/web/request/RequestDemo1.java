package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.Addressing;
import java.io.IOException;

@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求方式
        String method=request.getMethod();
        System.out.println(method);
        //2.获取虚拟目录
       String contextPath= request.getContextPath();
        System.out.println(contextPath);
        //3.获取servlet路径
        String  servletPath=request.getServletPath();
        System.out.println(servletPath);
        //4.获取get请求方式参数
        String queryString=request.getQueryString();
        System.out.println(queryString);
        //5.获取请求URI URL
        String requestURI=request.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL=request.getRequestURL();
        System.out.println(requestURL);
        //6.获取协议及版本
        String getProtocol=request.getProtocol();
        System.out.println(getProtocol);
        //7.获取客户机的IP地址
        String remoteAddr=request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
