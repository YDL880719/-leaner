package com.sxs.service;

import com.sxs.mapping.UserObjectDAO;

public class UserService {

	//登录
    public static String login(String phone,String pwd){
    	return UserObjectDAO.userLogin(phone, pwd);	
    }
    //注册
    public static String register(String phone,String pwd){
    	return UserObjectDAO.userRegister(phone, pwd);	
    }
    //更新添加学校信息
    public static String regToAddSch(int userId,int schoolId,int groupId){
    	return UserObjectDAO.regToAddSch(userId, schoolId,groupId);	
    }
}
