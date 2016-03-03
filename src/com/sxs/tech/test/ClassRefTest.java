package com.sxs.tech.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.alibaba.fastjson.JSONObject;
import com.sxs.util.Constant;
import com.sxs.util.Tools;

public class ClassRefTest {
    
    public static void main(String[]args) throws ClassNotFoundException{
	String className = Constant.getConfig("UserAction");
	Class c = Class.forName(className);
	Map map = new HashMap();
	String json ="{'uactid':'11111','uactopr':'uuuuuu','classType':'object','className':'UserAction'}";
	JSONObject jo =(JSONObject) JSONObject.parse(json);
	jo.remove("classType");
	jo.remove("className");
	System.out.println(jo.toJSONString());
	map.put("uactid", "111111");
	map.put("uactopr", "uuuuuu");
	
	Random random = new Random();
	int max=75;
	int min=1;
		
        int s = random.nextInt(75);
        System.out.println(Tools.getRondom());
    }

}
