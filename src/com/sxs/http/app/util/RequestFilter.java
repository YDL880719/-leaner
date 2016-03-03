package com.sxs.http.app.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.alibaba.fastjson.JSONObject;
import com.sxs.entity.UserAction;

/*@WebFilter(filterName="testFilter",urlPatterns="/*")*/
public class RequestFilter implements Filter{

    @Override
    public void destroy() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
	// TODO Auto-generated method stub
	String str = RequestGet.getContent(arg0.getInputStream(), "utf-8");
	System.out.println("接收到的参数是："+str);
	UserAction u  = RequestGet.toChangeJson(str);
	//UserAction o  = RequestGet.toChangeJson(str);
	arg2.doFilter(arg0, arg1);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
	// TODO Auto-generated method stub
	
    }
    

}
