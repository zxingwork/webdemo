package com.example.webdemo;


import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LogFilter implements Filter {

    public static Map<String, Cookie> readCookieMap(HttpServletRequest request){
        Map<String, Cookie> cookieMap = new ConcurrentHashMap<>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies){
            Arrays.stream(cookies).forEach(element->cookieMap.put(element.getName(), element));
        }
        return cookieMap;
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String site = filterConfig.getInitParameter("Size");
        System.out.println("网站名称："+site);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("站点网址：http://www.runoob.com");
        Enumeration attr = request.getAttributeNames();
        while (attr.hasMoreElements()){
            System.out.println("=>"+attr.nextElement());
        }
        System.out.println(readCookieMap((HttpServletRequest) request));
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
