package com.sxs.http.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxs.service.ContentService;

@WebServlet(name = "contentListServlet", urlPatterns = "/app/classContentList")
public class ClassContentListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		int classId = Integer.parseInt(request.getParameter("classId"));
		long userId = Long.parseLong(request.getParameter("userId"));
		String str = ContentService.getContentObjectDAOByClass(classId, userId);
		response.getWriter().print(str);
	}

}
