package com.sxs.mapping;

import java.util.List;
import java.util.Map;

import com.sxs.util.Constant;
import com.sxs.util.DBUtil;

public class ClassObjectDAO {

    public static List<Map> getNowIndexData(){
	List data = null ;	
	String sql ="select classId,className,classTitle,classSort,CONCAT('"+Constant.getConfig("serverImageURL")+"',listPic) as listPic,"
		+ "listTitle from classobject where isRecommand=1 and isAble=1 order by classSort asc";	
	System.out.println (sql);
	data = DBUtil.executeQuery(sql);
	return data;
    }

    public static List<Map> getNowIndexDataByUser(int schoolId){
 	List data = null ;	
 	String sql ="select classId,className,classTitle,classSort,CONCAT('"+Constant.getConfig("serverImageURL")+"',listPic) as listPic,"
 		+ "listTitle from classobject where isRecommand=1 and isAble=1 and classId in "
 		+ "(select classId from schoolclass where schoolId="+schoolId+")"
 		+ "order by classSort asc";	
 	System.out.println (sql);
 	data = DBUtil.executeQuery(sql);
 	return data;
     }
    public static List<Map> getAllData(int schoolId){
   	List data = null ;	
   	String sql ="select classId,className,classTitle,classSort,CONCAT('"+Constant.getConfig("serverImageURL")+"',listPic) as listPic,"
   		+ "listTitle from classobject where  isAble=1 and classId in (select classId from schoolclass where schoolId="+schoolId
   		+")order by classSort asc";	
   	System.out.println (sql);
   	data = DBUtil.executeQuery(sql);
   	return data;
       }

    public static List<Map> getClassData(int classId){
	List data = null ;	
	String sql ="select classId,className,classTitle,classSort,CONCAT('"+Constant.getConfig("serverImageURL")+"',topPic) as topPic,"
		+ "classDes from classobject where  classId="+classId+" order by classSort asc";	
	System.out.println (sql);
	data = DBUtil.executeQuery(sql);
	return data;
    }
    
    /*
select a.*,
case when  exists (select contentId from contentread  where contentId IN (select contentId from content  where classId=a.classId))   
		 then case when (select contentId from content  where classId=a.classId and contentId not in( select contentId from contentread where  userid=1) ) is not NULL then 2 else 1 end
		 else 3  end isCompleted
 from classobject a,schoolclass b where  a.classId=b.classId and b.schoolId=1
   */
    
    public static List<Map> getClassAllDataForUser(int schoolId,int userId){
	List data = null ;
	String sql="select a.classId,a.className,a.classTitle,a.listTitle,CONCAT('"+Constant.getConfig("serverImageURL")+"',topPic) as topPic,"
		+"(select count(contentId) from contentread where  userid="+userId+" and contentId IN (select contentId from content  where classId=a.classId)) as readerCount,"
		+"(select count(contentId) from content where classId=a.classId) as tatolContent,"
		+ "case when  exists (select contentId from contentread  where userId="+userId+" and "
		+ " contentId IN (select contentId from content  where classId=a.classId))  "
		 +"then case when (select contentId from content  where classId=a.classId and"
		 + " contentId not in( select contentId from contentread where  userid="+userId+")) "
		 + "is not NULL then 2 else 1 end "
		 +" else 3  end isCompleted  from classobject a,schoolclass b where  a.classId=b.classId and b.schoolId="+schoolId;
	System.out.println(sql);
	data = DBUtil.executeQuery(sql);
	return data;
	
    }
    
    public static List<Map> getClassAllDataForUserNotStart(int schoolId,int userId){
	List data = null ;
	String sql="select a.classId,a.className,a.classTitle,a.listTitle,CONCAT('"+Constant.getConfig("serverImageURL")+"',topPic) as topPic,"
		+"(select count(contentId) from contentread where  userid=1 and contentId IN (select contentId from content  where classId=a.classId)) as readerCount,"
		+"(select count(contentId) from content where classId=a.classId) as tatolContent"
		+"  from classobject a,schoolclass b where  a.classId=b.classId and b.schoolId="+schoolId+" "
		+ "and  not exists (select contentId from contentread  where userId="+userId+" and contentId IN (select contentId from content  where classId=a.classId)) ";
	System.out.println(sql);
	data = DBUtil.executeQuery(sql);
	return data;
	
    }
    public static List<Map> getClassAllDataForUserStart(int schoolId,int userId){
	List data = null ;
	String sql="select a.classId,a.className,a.classTitle,a.listTitle,CONCAT('"+Constant.getConfig("serverImageURL")+"',topPic) as topPic,"
		+"(select count(contentId) from contentread where  userid=1 and contentId IN (select contentId from content  where classId=a.classId)) as readerCount,"
		+"(select count(contentId) from content where classId=a.classId) as tatolContent"
		+"  from classobject a,schoolclass b where  a.classId=b.classId and b.schoolId="+schoolId+" "
		+ "and exists (select contentId from contentread  where userId="+userId+" and  contentId IN (select contentId from content  where classId=a.classId)) "
		+" and (select contentId from content  where classId=a.classId and contentId not in( select contentId from contentread where  userid="+userId+")) is not NULL ";
	System.out.println(sql);
	data = DBUtil.executeQuery(sql);
	return data;
	
    }
    public static List<Map> getClassAllDataForUserCompleted(int schoolId,int userId){
	List data = null ;
	String sql="select a.classId,a.className,a.classTitle,a.listTitle,CONCAT('"+Constant.getConfig("serverImageURL")+"',topPic) as topPic,"
		+"(select count(contentId) from contentread where  userid=1 and contentId IN (select contentId from content  where classId=a.classId)) as readerCount,"
		+"(select count(contentId) from content where classId=a.classId) as tatolContent"
		+"  from classobject a,schoolclass b where  a.classId=b.classId and b.schoolId="+schoolId+" "
		+ "and exists (select contentId from contentread  where userId="+userId+" and  contentId IN (select contentId from content  where classId=a.classId)) "
		+" and (select contentId from content  where classId=a.classId and contentId not in( select contentId from contentread where  userid="+userId+")) is  NULL ";
	System.out.println(sql);
	data = DBUtil.executeQuery(sql);
	return data;
	
    }
    
}
