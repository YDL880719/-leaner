package com.sxs.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.sxs.mapping.GroupInfoObjectDAO;
import com.sxs.mapping.SchoolsObjectDAO;

public class SchoolsService {

	//通过定位信息获取相关学校的信息
    public static String getSchoolsByCity(String city){
    	JSONObject jo = new JSONObject();
    	List Slist = SchoolsObjectDAO.getSchoolsByCity(city);
    	List Glist = GroupInfoObjectDAO.getGroupInfo();
	    if(Slist==null||Slist.size()==0){
			jo.put("status", "101");//没有查到学校列表
	    }else{
	    	 if(Glist==null||Glist.size()==0){
	 			jo.put("status", "102");//没有查到圈子列表
	 	    }else{
	 	    	jo.put("status", "200");//成功
			    jo.put("schools", Slist);
			    jo.put("groupinfo", Glist);
	 	    }
	    }
    	
	    return jo.toJSONString();	
    }
    
}
