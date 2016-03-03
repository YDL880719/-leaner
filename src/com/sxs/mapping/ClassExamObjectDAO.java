package com.sxs.mapping;

import java.util.List;
import java.util.Map;

import com.sxs.util.DBUtil;
import com.sxs.util.Tools;

public class ClassExamObjectDAO {

    /**
     * 评测列表
     * @author long 
     * @param classId
     * @param userId
     * @return 
     * getExamObjectDAOByClass
     * TODO
     * @param  
     * @param  @return    
     * @return List<Map>
     */
    public static List<Map> getExamObjectDAOByClass(int classId,long userId){
	/*select examId,classId,examTitle,examContent,examSort,
case  when (SELECT userId from userexam where examId = exam.examId and userId = 1 and isCompleted = 1) is not null 
THEN 1 else 0 end isCompleted , case  when (SELECT examScore from userexam where examId = exam.examId and userId = 1  and isAssess = 1) is not null 
THEN (SELECT examScore from userexam where examId = exam.examId and userId =  1  and isAssess = 1 ) else 0 end examScore  , 
case  when (SELECT isAssess from userexam where examId = exam.examId and userId = 1  and isAssess = 1) is not null 
THEN 1 else 0 end isAssess from classexam exam 
WHERE exam.classId = 1  order by exam.examSort asc
    	String sql ="select examId,classId,examTitle,examContent,examSort,"
    			+ "case  when (SELECT userId from userexam where examId = exam.examId and userId = "+userId+" and isAssess = 1) is not null "
    			+ " THEN 1 else 0 end isReader , case  when (SELECT examScore from userexam where examId = exam.examId and userId = "+userId+"  and isAssess = 1) is not null "
    			+ "THEN (SELECT examScore from userexam where examId = exam.examId and userId =  "+userId+"  ) else 0 end examScore from classexam exam "
    			+ "WHERE exam.classId = "+classId+"  order by exam.examSort asc";	*/
	String sql = "select examId,classId,examTitle,examContent,examSort,"
		+ "case  when (SELECT userId from userexam where examId = exam.examId and userId =  "+userId+"  and isCompleted = 1) is not null "
		+ "THEN 1 else 0 end isCompleted , case  when (SELECT examScore from userexam where examId = exam.examId and userId =  "+userId+"   and isAssess = 1) is not null "
		+ "THEN (SELECT examScore from userexam where examId = exam.examId and userId =  "+userId+"   and isAssess = 1 ) else 0 end examScore  ,"
		+ "case  when (SELECT isAssess from userexam where examId = exam.examId and userId = "+userId+"   and isAssess = 1) is not null "
		+ "THEN 1 else 0 end isAssess from classexam exam "
		+ "WHERE exam.classId = "+classId+"  order by exam.examSort asc";
	List list = DBUtil.executeQuery(sql);	
	return list;
    }
    /**
     * 该方法用于获取一道题
     * @author long 
     * @param examId
     * @param userId
     * @return 
     * getExamByexamId
     * TODO
     * @param  
     * @param  @return    
     * @return List<Map>
     */
    public static List<Map> getExamByexamId(int examId,long userId,int itemSort,int mark){
	String sql ="";

	if(mark == 0){//下一题
	    sql = "select examId,ItemId,itemTitle,itemContent,itemAnswer,itemSort, "
		    + "case  when (SELECT answer from userexamitem where itemId = examitem.ItemId and userId = "+userId+") is not null "
		    + "THEN (SELECT answer from userexamitem where itemId = examitem.ItemId and userId = "+userId+")  else '' end answer ,"
		    + "case  when (SELECT answer from userexamitem where itemId = examitem.ItemId and userId = "+userId+") is not null "
		    + "THEN (SELECT isTrue from userexamitem where itemId = examitem.ItemId and userId = "+userId+")  else 0 end isTrue "
		    + "from examitem where examId = "+examId+" and itemSort > "+itemSort+" order by itemSort asc limit 1";
	}
	if(mark == 1){//上一题
	    sql = "select examId,ItemId,itemTitle,itemContent,itemAnswer, itemSort,"
		    + "case  when (SELECT answer from userexamitem where itemId = examitem.ItemId and userId = "+userId+") is not null "
		    + "THEN (SELECT answer from userexamitem where itemId = examitem.ItemId and userId = "+userId+")  else '' end answer ,"
		    + "case  when (SELECT answer from userexamitem where itemId = examitem.ItemId and userId = "+userId+") is not null "
		    + "THEN (SELECT isTrue from userexamitem where itemId = examitem.ItemId and userId = "+userId+")  else 0 end isTrue "
		    + "from examitem where examId = "+examId+" and itemSort < "+itemSort+" order by itemSort desc limit 1";
	}
	List list = DBUtil.executeQuery(sql);	
	return list;
    }
    /**
     * 该方法用于获取一道评测题的选项
     * @author long 
     * @param itemId
     * @return 
     * getItemAnswerByItemId
     * TODO
     * @param  
     * @param  @return    
     * @return List<Map>
     */
    public static List<Map> getItemAnswerByItemId(int itemId){
	String sql ="select * from itemanswer where itemId ="+itemId+" order by answerMark";		
	List list = DBUtil.executeQuery(sql);	
	return list;
    }
    /**
     * 该方法用于获取所有评测列表
     * @author long 
     * @param examId
     * @param userId
     * @return 
     * getExamListByexamId
     * TODO
     * @param  
     * @param  @return    
     * @return List<Map>
     */
    public static List<Map> getExamListByexamId(int examId,long userId ){
    	String sql1 = "select examId,ItemId,itemTitle,itemContent,itemAnswer,itemSort, "
    			+ "case  when (SELECT answer from userexamitem where itemId = examitem.ItemId and userId = "+userId+") is not null "
    			+ "THEN (SELECT answer from userexamitem where itemId = examitem.ItemId and userId = "+userId+")  else '' end answer ,"
    			+ "case  when (SELECT answer from userexamitem where itemId = examitem.ItemId and userId = "+userId+") is not null "
    			+ "THEN (SELECT isTrue from userexamitem where itemId = examitem.ItemId and userId = "+userId+")  else 0 end isTrue "
    			+ "from examitem where examId = "+examId+" order by itemSort ";
    	List list1 = DBUtil.executeQuery(sql1);	
    	
	int s = Tools.getRondom();
	if(list1.size()<=s){
		s=0;
	}
	String sql = "select examId,ItemId,itemTitle,itemContent,itemAnswer,itemSort, "
		+ "case  when (SELECT answer from userexamitem where itemId = examitem.ItemId and userId = "+userId+") is not null "
		+ "THEN (SELECT answer from userexamitem where itemId = examitem.ItemId and userId = "+userId+")  else '' end answer ,"
		+ "case  when (SELECT answer from userexamitem where itemId = examitem.ItemId and userId = "+userId+") is not null "
		+ "THEN (SELECT isTrue from userexamitem where itemId = examitem.ItemId and userId = "+userId+")  else 0 end isTrue "
		+ "from examitem where examId = "+examId+" order by itemSort limit "+s+",5 ";
	System.out.println(sql);
	List list = DBUtil.executeQuery(sql);	
	return list;
    }
    /**
     * 该方法用于回答一个问题
     * @author long 
     * @param itemId
     * @param userId
     * @param answer
     * @param commitTime
     * @param isTrue
     * @return 
     * insertUserexamitem
     * TODO
     * @param  
     * @param  @return    
     * @return int
     */
    public static int insertUserexamitem(int examId,int itemId,long userId,String answer,String commitTime){
	String sql =
		"insert into userexamitem (itemId,userId,answer,commitTime,isTrue) "
			+ "values ("+itemId+","+userId+",'"+answer+"','"+commitTime+"',case  when (select score from itemanswer where itemId = "+itemId+"  and answerMark = '"+answer+"') is not null THEN "
					+ "(select score from itemanswer where itemId = "+itemId+"  and answerMark = '"+answer+"' )else 0 end )";
	System.out.println(sql);
	int s = DBUtil.execute(sql);	
	return s;
    }
    /**
     * 更新用户答案
     * @author long 
     * @param itemId
     * @param userId
     * @param answer
     * @param commitTime
     * @return 
     * updateUserexamitem
     * TODO
     * @param  
     * @param  @return    
     * @return int
     */
    /*"update userexamitem set answer='"+answer+"',commitTime='"+commitTime+"' ,isTrue="
	+ " case  when (SELECT itemAnswer from examitem where itemAnswer = '"+answer+"' and examId = "+examId+" and itemId ="+itemId+" ) is not null THEN 1 else 0 end "
	+ " where itemId = "+itemId+" and userId = "+userId;*/
    public static int updateUserexamitem(int examId,int itemId,long userId,String answer,String commitTime){
	String sql ="update userexamitem set answer='"+answer+"',isTrue="
			+ " case  when (select score from itemanswer where itemId = "+itemId+"  and answerMark = '"+answer+"') is not null THEN "
					+ "(select score from itemanswer where itemId = "+itemId+"  and answerMark = '"+answer+"') else 0 end ,commitTime='"+commitTime+"'"
			+ " where itemId = "+itemId+" and userId = "+userId;
	System.out.println("sql -- update  ----"+sql);
	int s = DBUtil.execute(sql);	
	return s;
    }
    /**
     * 查看用户有没有回答过答案
     * @author long 
     * @param itemId
     * @param userId
     * @param answer
     * @param commitTime
     * @return 
     * selectUserexamitem
     * TODO
     * @param  
     * @param  @return    
     * @return List
     */
    public static List selectUserexamitem(int itemId,long userId){
	String sql ="select * from userexamitem where itemId = "+itemId+" and userId = "+userId;

	List list = DBUtil.executeQuery(sql);		
	return list;
    }
    /**
     * 查找指定的评测ID以及用户ID是否存在教师评价记录
     * @author long 
     * @param examId
     * @param userId
     * @return 
     * selectUserexam
     * TODO
     * @param  
     * @param  @return    
     * @return List
     */
    public static List selectUserexam(int examId,long userId){
	String sql =
		"select * from userexam where examId = "+examId+" and userId = "+userId;
	List list = DBUtil.executeQuery(sql);		
	return list;
    }
    /**
     * 该方法用于插入一条评论记录
     * 1、插入时间，用户完成评测时
     * 2、插入数据：examId，userId,isAssess,isCompleted
     * @author long 
     * @param examId
     * @param itemId
     * @param userId
     * @param answer
     * @param commitTime
     * @return 
     * insertUserexam
     * TODO
     * @param  
     * @param  @return    
     * @return int
     */
    public static int insertUserexam(int examId,long userId,int examScore,String assessContent,int isAssess,int isCompleted){
	String sql =
		"insert into userexam (examId,userId,examScore,assessContent,isAssess,isCompleted) "
			+ "values ("+examId+","+userId+","+examScore+",'"+assessContent+"',"+isAssess+","+isCompleted+")";
	System.out.println(sql);
	int s = DBUtil.execute(sql);	
	return s;
    }
    /**
     * 该方法用于更新一条用户评测数据
     * 1、用户评测完成之后数据更新
     * 2、教师评价完之后更新
     * @author long 
     * @param examId
     * @param userId
     * @param examScore
     * @param assessContent
     * @param isAssess
     * @param isCompleted
     * @return 
     * updateUserexam
     * TODO
     * @param  
     * @param  @return    
     * @return int
     */
    public static int updateUserexam(int examId,long userId,int examScore,String assessContent,int isAssess,int isCompleted){
	String sql =
		"update userexam set examScore="+examScore+",assessContent='"+assessContent+"' ,isAssess="+isAssess+", isCompleted="+isCompleted+" where examId = "+examId+" and userId = "+userId;
	System.out.println("sql -- update  ----"+sql);
	int s = DBUtil.execute(sql);	
	return s;
    }
  
  
    
    

}
