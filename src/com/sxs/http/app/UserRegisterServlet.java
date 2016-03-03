package com.sxs.http.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxs.service.UserService;

@WebServlet(name = "registerServlet", urlPatterns = "/app/register")
public class UserRegisterServlet extends HttpServlet  {

    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		String str  = UserService.register(phone, pwd);
		response.getWriter().print(str);
	
    }
}
