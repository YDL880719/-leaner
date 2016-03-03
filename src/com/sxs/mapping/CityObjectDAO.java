package com.sxs.mapping;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sxs.util.DBUtil;

public class CityObjectDAO {
    /**
     * 该方法用于获取城市列表
     * @author long 
     * @return 
     * getCityList
     * TODO
     * @param  
     * @param  @return    
     * @return String
     */
    public static String getCityList(){
	JSONObject jo = new JSONObject();
	try{
	    String sql = "select * from city";
	    List list = DBUtil.executeQuery(sql);

	    if(list==null||list.size()==0){
		jo.put("status", "101");//没有查到城市列表
		return jo.toJSONString();
	    }else{
		jo.put("status", "200");//获取城市列表
		jo.put("citylist", list);
		return jo.toJSONString();
	    }
	}catch(Exception ex){
	    jo.put("status", "500");
	    return jo.toJSONString();
	}
    }
}
