package com.sxs.mapping;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sxs.util.Constant;
import com.sxs.util.DBUtil;
import com.sxs.util.DateUtil;

public class ClassCaseObjectDAO {
    
    /**
     * 该方法用于案例列表
     * @author long 
     * @param classId
     * @param userId
     * @return 
     * getCaseObjectDAOByClass
     * TODO
     * @param  
     * @param  @return    
     * @return List<Map>
     */
    public static List<Map> getCaseObjectDAOByClass(int classId,long userId){
    	String sql ="select caseId,caseTitle,caseType,caseMark,caseSort,CONCAT('"+Constant.getConfig("caseURL")+"',casePic) as casePic,"
    			+ "CONCAT('"+Constant.getConfig("caseURL")+"',caseUrl) as caseUrl, case  when (select caseid from classcaseread where caseid=classcase.caseId and userid="+userId+") is not null "
    			+ "then 1 else 0 end isReader from classcase where classid="+classId + " order by caseType asc";		
		List list = DBUtil.executeQuery(sql);	
		return list;
    }
	public static int caseReader(int caseId, long userId) {
		String time = DateUtil.dateFormat(new Date());
		String sql = "insert into classcaseread(caseId,userId,readTime) values("
				+ caseId + "," + userId + ",'" + time + "')";
		String selectsql = "select * from classcaseread where caseId="+caseId +" and userId="+userId;
		List list = DBUtil.executeQuery(selectsql);
		int re  = 0;
		if(list .size()>0){
			re = 1;
		}else{
			 re = DBUtil.execute(sql);
		}
		return re;
	}

}
