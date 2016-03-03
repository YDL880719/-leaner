package com.sxs.mapping;

import java.util.List;
import java.util.Map;

import com.sxs.util.Constant;
import com.sxs.util.DBUtil;

public class ExerciseObjectDAO {

    /**
     * 该方法用于获取作业列表
     * @author long 
     * @param classId
     * @param userId
     * @return 
     * getExerciseObjectDAOByClass
     * TODO
     * @param  
     * @param  @return    
     * @return List<Map>
     * 
     * 返回的是作业标题、状态、分值
     */
    public static List<Map> getExerciseObjectDAOByClass(int classId,long userId){
	//CONCAT('"+Constant.getConfig("serverImageURL")+"',exeContent) as exeContent,isAble,exeSort,exeClass, 
	String sql = "select exeId,exeTitle,case  when (SELECT userId from userexercise where exeId = exe.exeId and userId = "+userId+" ) is not null "
		+ "THEN (SELECT isCommit from userexercise where exeId = exe.exeId and userId = "+userId+" ) else 0 end isCommit "
			+ ", case  when (SELECT userId from userexercise where exeId = exe.exeId and userId = "+userId+" and isAssess = 1) is not null "
		+ "THEN (SELECT score from userexercise where exeId = exe.exeId and userId = "+userId+" and isAssess = 1 ) "
			+ "else 0 end score from exercise exe"
		+ " WHERE exe.exeClass = "+classId+" order by exeSort asc";
	List list = DBUtil.executeQuery(sql);	
	return list;
    }
    /**
     * 该方法用户获取作业内容详情
     * @author long 
     * @param exeId
     * @param userId
     * @return 
     * getExerciseById
     * TODO
     * @param  
     * @param  @return    }
     * @return List<Map>
     * 
     * 返回作业标题、内容、回答、是否提交、老师评价、老师是否评价、作业得分
     */
    public static List<Map> getExerciseById(int exeId,long userId){

	String sql ="select exeId,exeTitle,CONCAT('"+Constant.getConfig("exerciseURL")+"',exeContent) as exeContent,"
		+ "case  when (SELECT userId from userexercise where exeId = exe.exeId and userId = "+userId+" ) is not null "
		+ "THEN (SELECT answer from userexercise where exeId = exe.exeId and userId ="+userId+" ) else 0 end answer,case  when (SELECT userId from userexercise where exeId = exe.exeId and userId = "+userId+"  ) is not null "
		+ "THEN (SELECT isCommit from userexercise where exeId = exe.exeId and userId ="+userId+" ) else 0 end isCommit,case  when (SELECT userId from userexercise where exeId = exe.exeId and userId = "+userId+"  ) is not null "
		+ "THEN (SELECT score from userexercise where exeId = exe.exeId and userId ="+userId+" ) else 0 end score,case  when (SELECT userId from userexercise where exeId = exe.exeId and userId = "+userId+"  ) is not null "
		+ "THEN (SELECT isAssess from userexercise where exeId = exe.exeId and userId ="+userId+" ) else 0 end isAssess,case  when (SELECT userId from userexercise where exeId = exe.exeId and userId = "+userId+"  ) is not null "
		+ "THEN (SELECT assessContent from userexercise where exeId = exe.exeId and userId ="+userId+" ) else 0 end assessContent from exercise exe where exe.exeId="+exeId;
	List list = DBUtil.executeQuery(sql);	
	return list;
    }
    /**
     * 该方法用于学生更新作业的回答
     * 1、保存
     * 2、提交
     * @author long 
     * @param exeId
     * @param userId
     * @param answer
     * @return 
     * updateExerciseById
     * TODO
     * @param  
     * @param  @return    
     * @return int
     */
    public static int updateExerciseById_stu(int exeId,long userId ,String answer,int isCommit){
	int re = 0;
	String sql = "update userexercise set answer ='"+answer+"',isCommit = "+isCommit+" where exeId = "+exeId+" and userId="+userId ;
	re = DBUtil.execute(sql);	
	return re;
    }
    /**
     * 该方法用于   通过ID的userID获取 一条记录
     * @author long 
     * @param exeId
     * @param userId
     * @return 
     * selectExerciseById
     * TODO
     * @param  
     * @param  @return    
     * @return int
     */
    public static int selectExerciseById(int exeId,long userId){
	int re = 0;
	String sql = "select * from userexercise where exeId ="+exeId+" and userId="+userId ;
	System.out.println(sql);
	List list = DBUtil.executeQuery(sql);
	if(list.size()>0){
	    re = list.size();
	}
	return re;
    }
    /**
     * 该方法用于新增一条作业评论记录
     * @author long 
     * @param exeId
     * @param userId
     * @param answer
     * @param isCommit
     * @return 
     * insertExercise
     * TODO
     * @param  
     * @param  @return    
     * @return int
     */
    public static int insertExercise_stu(int exeId,long userId ,String answer,int isCommit){
	int re = 0;
	String sql = "insert  into userexercise(exeId,userId,answer,isCommit) "
		+ "values ("+exeId+","+userId+",'"+answer+"',"+isCommit+")" ;
	re = DBUtil.execute(sql);	
	return re;
    }

    /*
    select a.exeId,a.exeTitle,a.exeContent,(select className from classobject where classId=a.exeClass) 
    as className,case when b.isCommit is not NULL
    then isCommit else 3 end isCommit
    from exercise a left join userexercise b on a.exeId=b.exeId  where 
    a.exeClass in 
    (select classId from groupclass where groupId =
    (select groupid from groupinfo where groupid=(select groupid from usergroup where userid=1 and istrue=1)))

     */
    /**
     * 该方法用于获取用户所有的作业列表
     * @author long 
     * @param classId
     * @param userId
     * @return 
     * getExerciseObjectDAOByClass
     * TODO
     * @param  
     * @param  @return    
     * @return List<Map>
     * 
     * 返回的是作业标题、状态、分值
     */
    public static List<Map> getExerciseByUser(long userId){
	//CONCAT('"+Constant.getConfig("serverImageURL")+"',exeContent) as exeContent,isAble,exeSort,exeClass, 
	String sql = "select a.exeId,a.exeTitle,CONCAT('"+Constant.getConfig("exerciseURL")+"',a.exeContent) as exeContent ,(select className from classobject where classId=a.exeClass) "+
		" as className,case when b.isCommit is not NULL "+
		"then isCommit else 3 end isCommit "+
		"from exercise a left join userexercise b on a.exeId=b.exeId  where "+
		"a.exeClass in "+
		"(select classId from groupclass where groupId ="+
		"(select groupid from groupinfo where groupid=(select groupid from usergroup where userid="+userId+" and istrue=1)))";
	List list = DBUtil.executeQuery(sql);	
	return list;
    }

    public static List<Map> getExerciseByUserByReaded(long userId,int status){
	//CONCAT('"+Constant.getConfig("serverImageURL")+"',exeContent) as exeContent,isAble,exeSort,exeClass, 
	String sql = "select a.exeId,a.exeTitle,CONCAT('"+Constant.getConfig("exerciseURL")+"',a.exeContent),b.isCommit,(select className from classobject where classId=a.exeClass) "
		+ "as className from exercise a,userexercise  b where a.exeId=b.exeId and b.userId="+userId+" and b.isCommit="+status;
	//CONCAT('"+Constant.getConfig("caseURL")+"',casePic) as casePic
	List list = DBUtil.executeQuery(sql);	
	return list;
    }

    public static List<Map> getExerciseByUserNotReader(long userId){
	//CONCAT('"+Constant.getConfig("serverImageURL")+"',exeContent) as exeContent,isAble,exeSort,exeClass, 
	String sql = "select a.exeId,a.exeTitle,CONCAT('"+Constant.getConfig("exerciseURL")+"',a.exeContent),(select className from classobject where classId=a.exeClass) "+
		" as className,case when b.isCommit is not NULL "+
		"then isCommit else 3 end isCommit "+
		"from exercise a left join userexercise b on a.exeId=b.exeId  where "+
		"a.exeClass in "+
		"(select classId from groupclass where groupId ="+
		"(select groupid from groupinfo where groupid=(select groupid from usergroup where userid="+userId+" and istrue=1))) and b.isCommit is null";
	List list = DBUtil.executeQuery(sql);	
	return list;
    }
}
