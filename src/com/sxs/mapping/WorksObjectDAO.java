package com.sxs.mapping;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sxs.util.Constant;
import com.sxs.util.DBUtil;
import com.sxs.util.DateUtil;

public class WorksObjectDAO {
	/**
	 * 该方法用户通过用户的ID获取用户在圈子中的作业
	 * @author long 
	 * @param userId
	 * @return 
	 * getWorksByuserId
	 * TODO
	 * @param  
	 * @param  @return    
	 * @return String
	 */
	public static String getWorksByuserId(int userId) {
		JSONObject jo = new JSONObject();
		try {
			String UGselect = "select groupid from usergroup where userid="+userId+" and istrue=1";//用户是否成功加入一个圈子
			String WLselect = "select w.worksId,w.worksTitle,w.worksDes,w.isTrue, CONCAT('"+Constant.getConfig("worksURL")+"',worksURL) as worksURL,"
					+ "case  when (SELECT userId from userworks where worksId = w.worksId and userId ="+userId+" ) is not null "
					+ "THEN (SELECT isSubmit from userworks where worksId = w.worksId and userId ="+userId+" ) else 0 end isSubmit  from works w ,groupworks gw "
					+ "where w.worksId = gw.worksId and  gw.groupId= "
					+ "(select groupid from usergroup where userId="+userId+" and istrue=1)";// 获取作品列表
			System.out.println(UGselect);
			System.out.println(WLselect);
			List ugList = DBUtil.executeQuery(UGselect);
			List wList = DBUtil.executeQuery(WLselect);
			if (ugList.size()==0 || ugList == null) {
				System.out.println("用户没有成功加入一个圈子");
				jo.put("status", "505");//
			} else {
				if (wList.size()==0 || wList == null) {
					System.out.println("该圈子没有作品");
					jo.put("status", "506");//
				} else {
					System.out.println("获取数据成功");
					jo.put("status", "200");
					jo.put("works", wList);
				}
			}
			return jo.toJSONString();
		} catch (Exception ex) {
			jo.put("status", "500");
			return jo.toJSONString();
		}
	}

	/**
	 * 该方法用于提交一个作品
	 * @author long 
	 * @param map
	 * @return 
	 * submitWorks
	 * TODO
	 * @param  
	 * @param  @return    
	 * @return String
	 */
	public static String submitWorks(Map map) {
		JSONObject jo = new JSONObject();
		int userId = Integer.parseInt(map.get("userId").toString());
		String docType = (String) map.get("docType");
		int worksId = Integer.parseInt(map.get("worksId").toString());
		String contentURL = (String) map.get("contentURL");
		String submitTime = (String) map.get("submitTime");
		int isSubmit = Integer.parseInt(map.get("isSubmit").toString());
		try {
			String Winsert = "insert into userworks (userId,worksId,docType,contentURL,submitTime,isSubmit)"
					+ "values('"+userId+"','"+worksId+"','"+docType+"','"+contentURL+"','"+submitTime+"','"+isSubmit+"')";
			System.out.println(Winsert);
			int reinsert = DBUtil.execute(Winsert);
			if (reinsert == 505) {
				System.out.println("出现错误");
				jo.put("status", "505");//
			} else {
				System.out.println("更新成功");
				jo.put("status", "200");//
			}
			return jo.toJSONString();
		} catch (Exception ex) {
			jo.put("status", "500");
			return jo.toJSONString();
		}
	}
	public static String getUserWorksById(int userId ,int worksId) {
		JSONObject jo = new JSONObject();
		try {
			String UWselect = "select  w.worksId,w.worksTitle,w.worksDes,w.isTrue, CONCAT('"+Constant.getConfig("worksURL")+"',worksURL) as worksURL,"
					+ "case  when (SELECT userId from userworks where worksId = w.worksId and userId ="+userId+" ) is not null "
					+ "THEN (SELECT isSubmit from userworks where worksId = w.worksId and userId ="+userId+" ) else 0 end isSubmit"
							+ ",CONCAT('"+Constant.getConfig("userworksURL")+userId+"/"+worksId+"/"+"',contentURL) as contentURL,uw.submitTime,uw.docType"
									+ " from works w,userworks uw where w.worksId = uw.worksId and uw.userId ="+userId+"  and w.worksId = "+worksId+"";
			System.out.println(UWselect);
			List uwList = DBUtil.executeQuery(UWselect);
			if (uwList == null ||uwList.size() == 0) {
				System.out.println("出现错误");
				jo.put("status", "505");//
			} else {
				System.out.println("数据获取成功");
				jo.put("status", "200");//
				Map map = (Map)uwList.get(0);
				jo.put("userworks", map);
				
			}
			return jo.toJSONString();
		} catch (Exception ex) {
			jo.put("status", "500");
			return jo.toJSONString();
		}
	}
}
