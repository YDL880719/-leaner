package com.sxs.http.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxs.service.IndexService;

@WebServlet(name = "indexServlet", urlPatterns = "/app/index")
public class IndexServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		String schoolId = request.getParameter("schoolId");
		int id = 0;
		String str = null;
		if (schoolId != null && !"".equals(schoolId)) {
			id = Integer.parseInt(schoolId);
			str = IndexService.getIndexData(id);
		} else {
			str = IndexService.getIndexData();
		}
		// str = IndexService.getIndexData();
		response.getWriter().print(str);
	}
}
