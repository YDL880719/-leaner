package com.sxs.service;

import java.util.Map;

import com.sxs.mapping.UserInfoObjectDAO;

public class UserInfoService {

	//用户信息完善新增操作
    public static String UIinsert(Map map){
    	return UserInfoObjectDAO.UIinsert(map);	
    }
    //用于用户信息更新操作
    public static String UIupdate(Map map){
    	return UserInfoObjectDAO.UIupdate(map);	
    }
    //用于用户信息更新操作
    public static String UIget(int userId){
    	return UserInfoObjectDAO.UIget(userId);	
    }
}
