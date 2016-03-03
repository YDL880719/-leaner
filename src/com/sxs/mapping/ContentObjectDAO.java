package com.sxs.mapping;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sxs.util.Constant;
import com.sxs.util.DBUtil;
import com.sxs.util.DateUtil;

public class ContentObjectDAO {

    /**
     * 该方法用于获取课程的所有内容
     * 
     * @author long
     * @param classId
     * @param userId
     * @return getContentObjectDAOByClass TODO
     * @param
     * @param @return
     * @return List<Map>
     */
    public static List<Map> getContentObjectDAOByClass(int classId, long userId) {
	String sql = "select contentId,contentTitle,contentType,contentMark,contentSort,CONCAT('"
		+ Constant.getConfig("contentURL")
		+ "',contentPic) as contentPic,"
		+ "CONCAT('"
		+ Constant.getConfig("contentURL")
		+ "',contentUrl) as contentUrl,case  when (select contentid from contentread where contentid=content.contentId and userid="
		+ userId
		+ ") is not null "
		+ "then 1 else 0 end isReader from content where classid="
		+ classId + " order by contentSort asc";
	List list = DBUtil.executeQuery(sql);
	return list;
    }

    // String
    // sql="select * from content  where classId=1 and contentId not in( select contentId from contentread)";
    public static int contentReader(int contentId, long userId) {
	String time = DateUtil.dateFormat(new Date());
	String sql = "insert into contentread(contentId,userId,readTime) values("
		+ contentId + "," + userId + ",'" + time + "')";
	String selectsql = "select * from contentread where contentId="+contentId +" and userId="+userId;
	List list = DBUtil.executeQuery(selectsql);
	int re  = 0;
	if(list .size()>0){
	    re = 1;
	}else{
	    re = DBUtil.execute(sql);
	}

	return re;
    }

    /*
     * select a.*, case when exists (select contentId from contentread where
     * contentId IN (select contentId from content where classId=a.classId))
     * then case when (select contentId from content where classId=a.classId and
     * contentId not in( select contentId from contentread)) is not NULL then 2
     * else 1 end else 3 end isCompleted from classobject a,schoolclass b where
     * a.classId=b.classId and b.schoolId=1
     */

}