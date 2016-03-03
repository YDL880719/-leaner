package com.sxs.http.app;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sxs.service.UserInfoService;

@WebServlet(name = "userinfoupdateServlet", urlPatterns = "/app/userinfoupdate")
@MultipartConfig
public class UserInfoUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int userId = Integer.parseInt(request.getParameter("userId"));
		String trueName = request.getParameter("trueName");
		int male = Integer.parseInt(request.getParameter("male"));
		String nickName = request.getParameter("nickName");
		String intoSchool = request.getParameter("intoSchool");
		int major = Integer.parseInt(request.getParameter("major"));

		int department = Integer.parseInt(request.getParameter("department"));
		int tearcher = Integer.parseInt(request.getParameter("tearcher"));
		int gradId = Integer.parseInt(request.getParameter("gradId"));
		int school = Integer.parseInt(request.getParameter("school"));
		/*
		 * Part p2 = request.getPart("icon");//头像
		 * 
		 * String iconstr= request.getParameter("icon"); String icon = "";
		 * if(iconstr != null && !"".equals(iconstr)){ Part p =
		 * request.getPart("icon");//头像 if(p != null){ icon =
		 * this.getFileName(p.getHeader("content-disposition")); String savePath
		 * = request.getServletContext().getRealPath("/"); savePath = savePath
		 * +"/images/icon/"; p.write(savePath+icon); } }
		 */
	String icon = "";
		Collection<Part> parts = request.getParts();
		if(parts.size()>0){
			Part p = request.getPart("icon");// 头像
			
			if (p != null) {
				
				icon = this.getFileName(p.getHeader("content-disposition"));
				System.out.println(icon);
				String savePath = request.getServletContext().getRealPath("/");
				System.out.println(savePath);
				savePath = savePath + "/images/icon/";
				p.write(savePath + icon);
			
			}
		}
		/*String icon = "";
		Part p = request.getPart("icon");// 头像

		if (p != null) {

			icon = this.getFileName(p.getHeader("content-disposition"));
			System.out.println(icon);
			String savePath = request.getServletContext().getRealPath("/");
			System.out.println(savePath);
			savePath = savePath + "/images/icon/";
			String str = savePath + icon;
			File file = new File(str);
			if(file != null){
				p.write(savePath + icon);
			}else{
				System.out.println("touxiangmeiyou");
			}
			

		}*/
		

		//
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("trueName", trueName);
		map.put("male", male);
		map.put("nickName", nickName);
		map.put("intoSchool", intoSchool);
		map.put("major", major);
		map.put("icon", icon);
		map.put("department", department);
		map.put("tearcher", tearcher);
		map.put("gradId", gradId);
		map.put("school", school);
		String str = UserInfoService.UIupdate(map);
		response.getWriter().print(str);

	}

	private String getFileName(String header) {
		/**
		 * String[] tempArr1 =
		 * header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数组里面的内容稍有区别
		 * 火狐或者google浏览器下：
		 * tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
		 * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
		 */
		String[] tempArr1 = header.split(";");
		/**
		 * 火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
		 * IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
		 */
		String[] tempArr2 = tempArr1[2].split("=");
		// 获取文件名，兼容各种浏览器的写法
		String fileName = tempArr2[1].substring(
				tempArr2[1].lastIndexOf("\\") + 1).replaceAll("\"", "");
		return fileName;
	}

}
