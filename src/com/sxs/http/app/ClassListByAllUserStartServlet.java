package com.sxs.http.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxs.service.ClassService;
import com.sxs.service.IndexService;

@WebServlet(name = "userStudyStart", urlPatterns = "/app/userStudyStart")
public class ClassListByAllUserStartServlet  extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	response.setContentType("text/json;charset=UTF-8");
	int schoolId = Integer.parseInt(request.getParameter("schoolId"));
	int userId = Integer.parseInt(request.getParameter("userId"));
	String str = ClassService.getClassAllDataForUserStart(schoolId, userId);
	response.getWriter().print(str);
    }
}
