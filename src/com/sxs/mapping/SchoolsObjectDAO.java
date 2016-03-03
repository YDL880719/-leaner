package com.sxs.mapping;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.sxs.util.DBUtil;

public class SchoolsObjectDAO {

	/**
	 * 该方法用于定位获取学校列表
	 * @author long 
	 * @param city
	 * @return 
	 * getSchoolsByCity
	 * TODO
	 * @param  
	 * @param  @return    
	 * @return String
	 */
    public static List getSchoolsByCity(String city){
		 JSONObject jo = new JSONObject();
		 List list = new ArrayList();
		 try{
		    String schoolsql = "select a.*  from schoolinfo a,city b where a.cityId =b.cityId and b.cityName like '%"+city+"%' ";
		    list = DBUtil.executeQuery(schoolsql);
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
