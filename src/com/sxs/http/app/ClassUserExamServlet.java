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

@WebServlet(name = "userexamServlet", urlPatterns = "/app/userExamP")
public class ClassUserExamServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		// 该方法用于更新完成测评状态
		int examId = Integer.parseInt(request.getParameter("examId"));
		long userId = Long.parseLong(request.getParameter("userId"));
		String answer = request.getParameter("answer");
		String[] answer1 = null;
		String[] answer2 = null;

		answer1 = answer.split("\\*");
		String commitTime = DateUtil.dateTimeFormatByTime(System
				.currentTimeMillis());
		if (answer1.length > 0) {
			for (String ans : answer1) {
				answer2 = ans.split("\\:");
				if(answer2.length>=2){
					
				}else{
					int itemId = Integer.parseInt(answer2[0]);
					System.out.println(itemId + "---没有答案--" );
				}
				
				int itemId = Integer.parseInt(answer2[0]);
				String answe = answer2[1];
				System.out.println(itemId + "-----" + answe);

				int ma = ClassService.selectUserexamitem(itemId, userId);

				int re = 0;
				if (ma > 0 && !"".equals(answe)) {
					re = ClassService.updateUserexamitem(examId, itemId,
							userId, answe, commitTime);
				} else {
					re = ClassService.insertUserexamitem(examId, itemId,
							userId, answe, commitTime);
				}
				if (re == 1) {
					System.out.println("--------------用户回答插入成功！-------------");
				}
			}
		}
		int re = ClassService.selectUserexam(examId, userId);
		String str = "";
		if (re > 0) {
			int examScore = 0;
			String assessContent = "";
			int isAssess = 0;
			int isCompleted = 1;
			str = ClassService.updateUserexam(examId, userId, examScore,
					assessContent, isAssess, isCompleted);
		} else {
			int examScore = 0;
			String assessContent = "";
			int isAssess = 0;
			int isCompleted = 1;
			str = ClassService.insertUserexam(examId, userId, examScore,
					assessContent, isAssess, isCompleted);
		}
		response.getWriter().print(str);
	}

}
