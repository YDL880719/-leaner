package com.sxs.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sxs.mapping.ExerciseObjectDAO;

public class ExerciseService {
    
    public static String getExerciseByUser(long userId){
	JSONObject jo = new JSONObject();
	List list =ExerciseObjectDAO.getExerciseByUser(userId);
	jo.put("classList", list);
	return jo.toJSONString();
    }
    
    public static String getExerciseByUserByReaded(long userId,int status){
	JSONObject jo = new JSONObject();
	List list =ExerciseObjectDAO.getExerciseByUserByReaded(userId,status);
	jo.put("classList", list);
	return jo.toJSONString();
    }

    public static String getExerciseByUserNotReader(long userId){
  	JSONObject jo = new JSONObject();
  	List list =ExerciseObjectDAO.getExerciseByUserNotReader(userId);
  	jo.put("classList", list);
  	return jo.toJSONString();
      }
}
