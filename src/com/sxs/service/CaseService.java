package com.sxs.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.sxs.mapping.CityObjectDAO;
import com.sxs.mapping.ClassCaseObjectDAO;
import com.sxs.mapping.ContentObjectDAO;

public class CaseService {

	// 案例列表
	public static String getCaseObjectDAOByClass(int classId, long userId) {
		JSONObject jo = new JSONObject();
		List list = ClassCaseObjectDAO.getCaseObjectDAOByClass(classId, userId);
		jo.put("classcase", list);
		return jo.toJSONString();

	}

	// 改变案例目录的状态
	public static String doCaseById(int caseId, long userId) {
		JSONObject jo = new JSONObject();
		int re = ClassCaseObjectDAO.caseReader(caseId, userId);
		if (re == 505) {
			System.out.println("标识更新失败");
			jo.put("status", "505");//
		} else {
			System.out.println("标识更新成功");
			jo.put("status", "200");//
		}
		return jo.toJSONString();

	}

}
