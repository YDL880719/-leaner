package com.sxs.service;

import com.sxs.mapping.CityObjectDAO;

public class CityService {

	//获取定位的城市列表
    public static String getCityList(){
    	return CityObjectDAO.getCityList();	
    }
    
}
