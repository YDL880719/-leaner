package com.sxs.http.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxs.service.DMGService;
import com.sxs.service.ExerciseService;

@WebServlet(name = "uesrExerciseNotReaded", urlPatterns = "/app/uesrExerciseNotReaded")
public class UserExerciseNotReadedServlet extends HttpServlet  {
    //通过学院ID获取院系、专业、班级圈信息
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/json;charset=UTF-8");
	long userId = Long.parseLong(request.getParameter("userId"));
	String str  = ExerciseService.getExerciseByUserNotReader(userId);
	response.getWriter().print(str);

    }
}
