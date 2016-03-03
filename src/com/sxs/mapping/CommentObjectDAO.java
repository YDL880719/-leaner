package com.sxs.mapping;

import java.util.List;
import java.util.Map;

import com.sxs.util.Constant;
import com.sxs.util.DBUtil;

public class CommentObjectDAO {
    
    /**
     * 该方法用于获取评论列表
     * @author long 
     * @param classId
     * @param userId
     * @return 
     * getCommentListObjectDAOByClass
     * TODO
     * @param  
     * @param  @return    
     * @return List<Map>
     */
    public static List<Map> getCommentListObjectDAOByClass(int classId,long userId){
    	String sql ="select commId,userId,commTime,commContent ,case  when (SELECT icon  from userinfo where userId = comment.userId) is not null then (SELECT  CONCAT('"+Constant.getConfig("serverImageURL")+"',icon) as icon from userinfo where userId = comment.userId) else '' end icon,"
    			+ "case  when (SELECT  trueName from userinfo where userId = comment.userId) is not null then (SELECT  trueName from userinfo where userId = comment.userId) else '' end trueName ,"
    			+ "case  when (SELECT  nickName from userinfo where userId = comment.userId) is not null then (SELECT  nickName from userinfo where userId = comment.userId) else '' end nickName  "
    			+ " from comment where classId="+classId +" order by commTime desc";	
    	System.out.println(sql);
		List list = DBUtil.executeQuery(sql);	
		return list;
    }
    /**
     * 该方法用于发表评论
     * @author long 
     * @param userId
     * @param commTime
     * @param commContent
     * @param classId
     * @return 
     * insertComment
     * TODO
     * @param  
     * @param  @return    
     * @return int
     */
    public static int insertComment(long userId, String commTime,String commContent,int classId){
    	String sql =
    	"insert into comment (userId,commTime,commContent,classId) "
    	+ "values ("+userId+",'"+commTime+"','"+commContent+"',"+classId+")";
    	System.out.println(sql);
    	int s = DBUtil.execute(sql);	
    	return s;
    }

}
