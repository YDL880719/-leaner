package com.sxs.mapping;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.sxs.util.DBUtil;

public class GroupInfoObjectDAO {

	/**
	 * 获取所有的圈子列表
	 * @author long 
	 * @param city
	 * @return 
	 * getGroupInfo
	 * TODO
	 * @param  
	 * @param  @return    
	 * @return List
	 */
    public static List getGroupInfo(){
		 JSONObject jo = new JSONObject();
		 List list = new ArrayList();
		 try{
		    String groupsql = "select *  from groupinfo";
		    list = DBUtil.executeQuery(groupsql);
		    return list;
		   /* if(list==null||list.size()==0){
				jo.put("status", "101");//没有查到学校列表
				return jo.toJSONString();
		    }else{
		    	jo.put("status", "200");//成功
			    jo.put("schools", list);
			    return jo.toJSONString();
		    }*/
		}catch(Exception ex){
		    return list;
		}
    }

}
