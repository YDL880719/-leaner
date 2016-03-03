package com.sxs.mapping;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sxs.util.DBUtil;
import com.sxs.util.DateUtil;

public class DMGObjectDAO {
    /**
     * 通过学校ID获取院系、专业、班级圈信息
     * @author long 
     * @param schoolId
     * @return 
     * getDMGBySchoolId
     * TODO
     * @param  
     * @param  @return    
     * @return String
     */
    public static String getDMGBySchoolId(int schoolId){
	JSONObject jo = new JSONObject();
	try{
	    String Dsql = "select * from departmentinfo where schId="+schoolId;
	    String Msql = "select * from majorinfo where schId="+schoolId;
	    String GRsql= "select * from grades where schoolId="+schoolId;
	    String Gsql = "select g.* from groupinfo g,teacherinfo t where g.teacherId = t.teacherId and t.schId="+schoolId;
	    List Dlist = DBUtil.executeQuery(Dsql);
	    List Mlist = DBUtil.executeQuery(Msql);
	    List GRlist = DBUtil.executeQuery(GRsql);
//	    List Glist = DBUtil.executeQuery(Gsql);

	    jo.put("status", "200");
	    jo.put("department", Dlist);
	    jo.put("major", Mlist);
	    jo.put("grades", GRlist);
	    return jo.toJSONString();
	}catch(Exception ex){
	    jo.put("status", "500");
	    return jo.toJSONString();
	}
    }

}
