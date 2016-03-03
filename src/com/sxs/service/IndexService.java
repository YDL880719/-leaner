package com.sxs.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.sxs.mapping.ClassObjectDAO;
import com.sxs.mapping.IndexObjectDAO;

public class IndexService {

	public static String getIndexData() {
		JSONObject jo = new JSONObject();
		List result = IndexObjectDAO.getNowIndexData();
		List data = ClassObjectDAO.getNowIndexData();
		jo.put("mark", "no");
		jo.put("top", result);
		jo.put("list", data);
		return jo.toJSONString();
	}

	public static String getIndexData(int id) {
		JSONObject jo = new JSONObject();
		List result = IndexObjectDAO.getNowIndexData();
		List data = ClassObjectDAO.getNowIndexDataByUser(id);
		jo.put("mark", "yes");
		jo.put("top", result);
		jo.put("list", data);
		return jo.toJSONString();
	}

	public static String getAllClass(int schoolId) {
		JSONObject jo = new JSONObject();
		List data = ClassObjectDAO.getAllData(schoolId);
		jo.put("list", data);
		return jo.toJSONString();
	}

	public static String getClassData(int classId) {
		JSONObject jo = new JSONObject();
		List data = ClassObjectDAO.getClassData(classId);
		jo.put("classobject", data);
		return jo.toJSONString();
	}

}
