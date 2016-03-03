package com.sxs.http.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxs.service.UserService;

@WebServlet(name = "regschServlet", urlPatterns = "/app/regToAddSch")
public class UserRegSchServlet extends HttpServlet  {

    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		int schoolId = Integer.parseInt(request.getParameter("schoolId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		int groupId = Integer.parseInt(request.getParameter("groupId"));//加入的圈子名称
//		String groupName = request.getParameter("groupName");//加入的圈子名称
		String str  = UserService.regToAddSch(userId, schoolId,groupId);
		response.getWriter().print(str);
	
    }
}
