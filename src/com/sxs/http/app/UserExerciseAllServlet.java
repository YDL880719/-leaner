package com.sxs.http.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxs.service.DMGService;
import com.sxs.service.ExerciseService;

@WebServlet(name = "uesrExercise", urlPatterns = "/app/uesrExercise")
public class UserExerciseAllServlet extends HttpServlet  {
    //通过学院ID获取院系、专业、班级圈信息
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/json;charset=UTF-8");
	long userId = Long.parseLong(request.getParameter("userId"));
	String str  = ExerciseService.getExerciseByUser(userId);
	response.getWriter().print(str);

    }
}
