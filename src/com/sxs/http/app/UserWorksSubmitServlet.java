package com.sxs.http.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sxs.service.WorksService;
import com.sxs.util.DateUtil;

@WebServlet(name = "UWorksSubmitServlet", urlPatterns = "/app/userWorksSubmit")
public class UserWorksSubmitServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		int userId = Integer.parseInt(request.getParameter("userId"));
		int worksId = Integer.parseInt(request.getParameter("worksId"));
		String submitTime = DateUtil.dateTimeFormatByTime(System
				.currentTimeMillis());
		String docType = request.getParameter("docType");
		String contentURL = request.getParameter("contentURL");
		
		String content = "";
		if(contentURL != null && !"".equals(contentURL)){
			Part p  = request.getPart("contentURL");//作品上传
			
			if(p != null){
				content = this.getFileName(p.getHeader("content-disposition"));
				String savePath = request.getServletContext().getRealPath("/");
				savePath = savePath +"/images/works/users/"+userId+"/"+worksId+"/";
				p.write(savePath+content);
			}
		}
		
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("worksId", worksId);
		map.put("docType", docType);
		map.put("contentURL", content);
		map.put("submitTime", submitTime);
		map.put("isSubmit", 1);
		
		String str = WorksService.submitWorks(map);
		response.getWriter().print(str);
	}

	/*
	 * private String getFileName(Part part) { String header =
	 * part.getHeader("Content-Disposition"); String fileName =
	 * header.substring(header.indexOf("filename=\"") + 10,
	 * header.lastIndexOf("\"")); return fileName; }
	 */
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
