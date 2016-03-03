package com.sxs.http.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxs.service.ContentService;

@WebServlet(name = "docontentServlet", urlPatterns = "/app/doContent")
public class ClassContentDoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		int contentId = Integer.parseInt(request.getParameter("contentId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		String str = ContentService.doContentById(contentId,userId);
		response.getWriter().print(str);
	}

}
