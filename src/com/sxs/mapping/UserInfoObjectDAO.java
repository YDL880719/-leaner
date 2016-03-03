package com.sxs.mapping;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sxs.util.Constant;
import com.sxs.util.DBUtil;
import com.sxs.util.DateUtil;

public class UserInfoObjectDAO {
	/**
	 * 该方法用于用户信息完善主要是完善用户真实姓名、性别、你车、入学时间、院系、专业、教师、组别信息
	 * 
	 * @author long
	 * @param map
	 * @return UIinsert TODO
	 * @param
	 * @param @return
	 * @return String
	 */
	public static String UIinsert(Map map) {
		JSONObject jo = new JSONObject();
		int userId = Integer.parseInt(map.get("userId").toString());
		String trueName = (String) map.get("trueName");
		int male = Integer.parseInt(map.get("male").toString());
		String nickName = (String) map.get("nickName");
		String intoSchool = (String) map.get("intoSchool");
		int major = Integer.parseInt(map.get("major").toString());
		String icon = (String) map.get("icon");// 头像
		int department = Integer.parseInt(map.get("department").toString());
		int tearcher = Integer.parseInt(map.get("tearcher").toString());
		int gradId = Integer.parseInt(map.get("gradId").toString());
		int school = Integer.parseInt(map.get("school").toString());
		try {
			String UIinsert = "insert into userinfo (userId,trueName,male,nickName,intoSchool,major,icon,department,tearcher,groupId,school) "
					+ "values ('"
					+ userId
					+ "','"
					+ trueName
					+ "','"
					+ male
					+ "','"
					+ nickName
					+ "','"
					+ intoSchool
					+ "','"
					+ major
					+ "','"
					+ icon
					+ "','"
					+ department
					+ "','"
					+ tearcher
					+ "','"
					+ gradId + "','" + school + "')";// 新增SQL语句
			System.out.println(UIinsert);
			int reinsert = DBUtil.executeByKey(UIinsert);
			if (reinsert == 505) {
				System.out.println("出现错误");
				jo.put("status", "505");//
			} else {
				System.out.println("插入成功");
				jo.put("status", "200");//
				String UIselect = "select ui.userId,ui.trueName,ui.male,ui.nickName,ui.school,ui.intoSchool,ui.major,ui.tearcher,ui.department,ui.groupId,CONCAT('"
						+ Constant.getConfig("iconURL")+"/"
						+ "',icon) as icon,si.schName,di.depName,mi.majName,gi.groupName,ti.teacherName from userinfo ui, schoolinfo si,departmentinfo di,majorinfo mi,groupinfo gi,teacherinfo ti "
				+ "where ui.school = si.schId and ui.department =di.depId and ui.major = mi.majId and ui.tearcher = ti.teacherId and ui.groupId = gi.groupId and ui.userId="+userId;
				List uilist = DBUtil.executeQuery(UIselect);
				Map m = (Map) uilist.get(0);
				jo.put("userinfo", m);
			}
			return jo.toJSONString();
		} catch (Exception ex) {
			jo.put("status", "500");
			return jo.toJSONString();
		}
	}

	/**
	 * 该方法用户更新用户基本信息，
	 * 
	 * @author long
	 * @param map
	 * @return UIupdate TODO
	 * @param
	 * @param @return
	 * @return String
	 */
	public static String UIupdate(Map map) {
		JSONObject jo = new JSONObject();
		int userId = Integer.parseInt(map.get("userId").toString());
		String trueName = (String) map.get("trueName");
		int male = Integer.parseInt(map.get("male").toString());
		String nickName = (String) map.get("nickName");
		String intoSchool = (String) map.get("intoSchool");
		int school = Integer.parseInt(map.get("school").toString());
		int major = Integer.parseInt(map.get("major").toString());
		String icon = (String) map.get("icon");// 头像
		int department = Integer.parseInt(map.get("department").toString());
		int tearcher = Integer.parseInt(map.get("tearcher").toString());
		int group = Integer.parseInt(map.get("gradId").toString());
		try {
			String UIupdate = "update userinfo set male='" + male
					+ "',nickName='" + nickName + "',intoSchool ='"
					+ intoSchool + "',major='" + major + "'" + ",icon='" + icon
					+ "',department='" + department + "',tearcher='" + tearcher
					+ "',groupId='" + group + "',school='" + school
					+ "',trueName='" + trueName + "'  where userId =" + userId;
			String UIselect = "select * from userinfo where userId=" + userId;
			System.out.println(UIupdate);
			String UIselect2 ="select ui.userId,ui.trueName,ui.male,ui.nickName,ui.school,ui.intoSchool,ui.major,ui.tearcher,ui.department,ui.groupId,CONCAT('"
					+ Constant.getConfig("iconURL")+"/"
					+ "',icon) as icon,si.schName,di.depName,mi.majName,gi.groupName,ti.teacherName from userinfo ui, schoolinfo si,departmentinfo di,majorinfo mi,groupinfo gi,teacherinfo ti "
			+ "where ui.school = si.schId and ui.department =di.depId and ui.major = mi.majId and ui.tearcher = ti.teacherId and ui.groupId = gi.groupId and ui.userId="+userId;
			int reinsert = DBUtil.execute(UIupdate);
			if (reinsert == 505) {
				System.out.println("出现错误");
				jo.put("status", "505");//
			} else {
				System.out.println("更新成功");
				jo.put("status", "200");//
				List uilist = DBUtil.executeQuery(UIselect2);
				System.out.println(UIselect2);
				Map m = (Map) uilist.get(0);
				jo.put("userinfo", m);
			}
			return jo.toJSONString();
		} catch (Exception ex) {
			jo.put("status", "500");
			return jo.toJSONString();
		}
	}

	public static String UIget(int userId) {
		JSONObject jo = new JSONObject();
		try {

			String UIget = 
			"select ui.userId,ui.trueName,ui.male,ui.nickName,ui.school,ui.intoSchool,ui.major,ui.tearcher,ui.department,ui.groupId,CONCAT('"
					+ Constant.getConfig("iconURL")+"/"
					+ "',icon) as icon,si.schName,di.depName,mi.majName,gi.groupName,ti.teacherName from userinfo ui, schoolinfo si,departmentinfo di,majorinfo mi,groupinfo gi,teacherinfo ti "
			+ "where ui.school = si.schId and ui.department =di.depId and ui.major = mi.majId and ui.tearcher = ti.teacherId and ui.groupId = gi.groupId and ui.userId="+userId;
			System.out.println(UIget);
			List uilist = DBUtil.executeQuery(UIget);
			if (uilist.size() == 0 || uilist == null) {
				System.out.println("出现错误");
				jo.put("status", "505");//
			} else {
				Map m = (Map) uilist.get(0);
				jo.put("userinfo", m);
			}
			return jo.toJSONString();
		} catch (Exception ex) {
			jo.put("status", "500");
			return jo.toJSONString();
		}
	}

}
