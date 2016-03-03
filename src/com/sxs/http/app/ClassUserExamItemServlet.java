package com.sxs.http.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxs.service.ClassService;
import com.sxs.service.IndexService;
import com.sxs.util.DateUtil;

@WebServlet(name = "userexamitemServlet", urlPatterns = "/app/userExam")
public class ClassUserExamItemServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		int examId = Integer.parseInt(request.getParameter("examId"));
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		long userId = Long.parseLong(request.getParameter("userId"));
		int itemSort = Integer.parseInt(request.getParameter("itemSort"));
		int mark = Integer.parseInt(request.getParameter("mark"));//0表示下一题1：表示上一题
		String answer = request.getParameter("answer");
		if(!"".endsWith(answer)){
			int ma = ClassService.selectUserexamitem(itemId, userId);
			String commitTime = DateUtil.dateTimeFormatByTime(System.currentTimeMillis());
			int re = 0;
			if(ma>0){
				re = ClassService.updateUserexamitem(examId,itemId, userId, answer, commitTime);
			}else{
				re = ClassService.insertUserexamitem(examId,itemId, userId, answer, commitTime);
			}
			if(re == 1){
				System.out.println("--------------用户回答插入成功！-------------");
			}
		}
		String str = ClassService.getExamByexamId(examId, userId,itemSort,mark);
		response.getWriter().print(str);
	}

}
