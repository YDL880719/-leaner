package com.sxs.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.sxs.mapping.ContentObjectDAO;

public class ContentService {

	public static String getContentObjectDAOByClass(int classId, long userId) {
		JSONObject jo = new JSONObject();
		List list = ContentObjectDAO
				.getContentObjectDAOByClass(classId, userId);
		jo.put("classcontent", list);
		return jo.toJSONString();

	}
	//改变课程目录的状态
	public static String doContentById(int contentId, long userId) {
		JSONObject jo = new JSONObject();
		int re  = ContentObjectDAO.contentReader(contentId, userId);
		if(re == 505){
			System.out.println("标识更新失败");
			jo.put("status", "505");//
		}else{
			System.out.println("标识更新成功");
			jo.put("status", "200");//
		}
		return jo.toJSONString();

	}

}
