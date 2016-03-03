package com.sxs.http.app;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxs.service.ClassService;

@WebServlet(name = "doexerciseServlet", urlPatterns = "/app/doExercise")
public class DoExerciseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		int exeId = Integer.parseInt(request.getParameter("exeId"));
		long userId = Long.parseLong(request.getParameter("userId"));
		//int exeId,long userId ,String answer,int isCommit
		String answer = URLDecoder.decode(request.getParameter("answer"),"UTF-8");
		System.out.println(answer);
		int isCommit = Integer.parseInt(request.getParameter("isCommit"));
		int sel = ClassService.selectExerciseById(exeId, userId);
		String str = "";
		if(sel>0){
			str = ClassService.updateExerciseById_stu(exeId, userId, answer, isCommit);
		}else{
			str = ClassService.insertExercise_stu(exeId, userId, answer, isCommit);
		}
		
		response.getWriter().print(str);
	}

}
