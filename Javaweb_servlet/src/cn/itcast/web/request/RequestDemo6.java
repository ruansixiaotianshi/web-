package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object msg=request.getAttribute("msg");
        System.out.println(msg);

        System.out.println("demo6666被访问了");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //演示获取请求头数据
        //1.获取所有请求头名称
        Enumeration<String> headerNames=request.getHeaderNames();
        //2.遍历
        while(headerNames.hasMoreElements()){
            String name=headerNames.nextElement();

            //根据名称，获取请求头的值
           String value= request.getHeader(name);
           System.out.println(name+"---"+value);
        }

    }
}
