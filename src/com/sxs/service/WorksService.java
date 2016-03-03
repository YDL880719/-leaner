package com.sxs.service;

import java.util.Map;

import com.sxs.mapping.WorksObjectDAO;

public class WorksService {

	//通过用户Id获取该用户在该圈子中的作品列表
    public static String getWorksByuserId(int userId){
    	return WorksObjectDAO.getWorksByuserId(userId);
    }
  //用户上传用户作品
    public static String submitWorks(Map map){
    	return WorksObjectDAO.submitWorks(map);
    }
  //已经提交的作品获取
    public static String getUserWorksById(int userId ,int worksId){
    	return WorksObjectDAO.getUserWorksById(userId,worksId);
    }
}