package com.sxs.http.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxs.service.WorksService;

@WebServlet(name = "UWorkslistServlet", urlPatterns = "/app/userWorks")
public class UserWorksListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		int userId = Integer.parseInt(request.getParameter("userId"));

		String str  = WorksService.getWorksByuserId(userId);
		response.getWriter().print(str);
    }
}
