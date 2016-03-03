package com.sxs.http.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxs.service.ClassService;
import com.sxs.service.IndexService;

@WebServlet(name = "examServlet", urlPatterns = "/app/classExam")
public class ClassExamServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		int examId = Integer.parseInt(request.getParameter("examId"));
		long userId = Long.parseLong(request.getParameter("userId"));
		String str = ClassService.getExamListByexamId(examId, userId);
		response.getWriter().print(str);
	}

}
