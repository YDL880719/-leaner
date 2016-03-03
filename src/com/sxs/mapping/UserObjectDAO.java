package com.sxs.mapping;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sxs.util.DBUtil;
import com.sxs.util.DateUtil;

public class UserObjectDAO {
    /**
     * 该方法用于用户登录
     * @author long 
     * @param phone
     * @param pwd
     * @return 
     * userLogin
     * TODO
     * @param  
     * @param  @return    
     * @return String
     */
    public static String userLogin(String phone,String pwd){
	JSONObject jo = new JSONObject();
	try{
	    String login = "select *  from userlogin where mobile='"+phone+"' and password='"+pwd+"' and isTrue=1";
	    List list = DBUtil.executeQuery(login);

	    if(list==null||list.size()==0){
		jo.put("status", "101");//用户名和密码错误
		return jo.toJSONString();
	    }else{
		Map m = (Map)list.get(0);
		if(m.get("school")==null||m.get("school").toString().equals("0")){
		    jo.put("status", "303");//没有学校
		    jo.put("user", m);
		    return jo.toJSONString();
		}else{		
		    jo.put("status", "200");
		    jo.put("user", m);
		    return jo.toJSONString();
		}
	    }
	}catch(Exception ex){
	    jo.put("status", "500");
	    return jo.toJSONString();
	}
    }
    /**
     * 该方法用于用户注册
     * @author long 
     * @param phone
     * @param pwd
     * @return 
     * userRegister
     * TODO
     * @param  
     * @param  @return    
     * @return String
     */
    public static String userRegister(String phone,String pwd){
	JSONObject jo = new JSONObject();
	try{
	    String lastLoginTime = DateUtil.dateTimeFormatByTime(System.currentTimeMillis());
	    String ishave = "select *  from userlogin where mobile='"+phone+"' and isTrue=1";//查询该手机号是否已经存在
	    String insertsql = "insert  into userlogin(mobile,password,lastLoginTime,isTrue) "
		    + "values ("+phone+","+pwd+",'"+lastLoginTime+"',1)";//新增SQL语句
	    String login = "select *  from userlogin where mobile='"+phone+"' and password='"+pwd+"' and isTrue=1";

	    List list = DBUtil.executeQuery(ishave);

	    if(list==null||list.size()==0){
		//手机号没有注册过可以进行新增操作
		int reinsert = DBUtil.execute(insertsql);
		if(reinsert == 505){
		    System.out.println("出现错误");
		    jo.put("status", "505");//
		}else{
		    System.out.println("插入成功");
		    jo.put("status", "200");//
		    List userlist = DBUtil.executeQuery(login);
		    Map m = (Map)userlist.get(0);
		    jo.put("user", m);
		}
		return jo.toJSONString();
	    }else{
		//手机号已经注册
		jo.put("status", "500");
		return jo.toJSONString();
	    }
	}catch(Exception ex){
	    jo.put("status", "500");
	    return jo.toJSONString();
	}
    }
    /**
     * 该方法用于注册后完善学校信息
     * @author long 
     * @param phone
     * @param pwd
     * @return 
     * userRegister
     * TODO
     * @param  
     * @param  @return    
     * @return String
     */
    public static String regToAddSch(int userId,int schoolId,int groupId){
	JSONObject jo = new JSONObject();
	try{
	    String submitTime = DateUtil.dateTimeFormatByTime(System
		    .currentTimeMillis());
	    String updatesch = "update userlogin set school="+schoolId+" where userId = "+userId;
	    String groupselect = "select * from groupinfo where groupId="+groupId;
	    String groupupdate = "update usergroup set istrue= 0,outtime ='"+submitTime+"' where userId="+userId+" and istrue=1";
	    String groupinsert = "insert into usergroup (userId,groupId,istrue,jointime) "
		    + "values('"+userId+"','"+groupId+"','1','"+submitTime+"')";
	    String ugselect = "select * from usergroup where userId="+userId;
	    int reupdate = DBUtil.execute(updatesch);
	    if(reupdate == 505){
		System.out.println("出现错误");
		jo.put("status", "505");//
	    }else{
		List list = DBUtil.executeQuery(groupselect);
		if(list == null || list.size()==0){
		    System.out.println("没有符合输入的圈子信息："+groupId);
		    jo.put("status", "506");
		}else{
		    int gupdate = DBUtil.execute(groupupdate);
		    if(gupdate == 505){
			System.out.println("更新用户圈子关系表出错");
		    }
		    int ginsert = DBUtil.execute(groupinsert);
		    List uglist = DBUtil.executeQuery(ugselect);
		    if(uglist == null || uglist.size()==0){
			System.out.println("用户和圈子关系绑定失败");
			jo.put("status", "507");
		    }else{
			Map map = (Map )uglist.get(0);
			jo.put("usergroup", map);
		    }
		    System.out.println("插入成功");
		    jo.put("status", "200");//

		}

	    }
	    return jo.toJSONString();
	}catch(Exception ex){
	    jo.put("status", "500");
	    return jo.toJSONString();
	}
    }
}
