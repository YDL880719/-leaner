package com.sxs.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sxs.entity.UserAction;



public class Constant {

    public static Properties p;

    static{
	p = new Properties();  
	String fileName="/properties/config.properties";
	InputStream in = Constant.class.getResourceAsStream(fileName);
	try {
	    p.load(in);
	    in.close();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}  

    }
    public static String getConfig(String key){
	try{
	    if(p.containsKey(key)){  

		return  p.getProperty(key);  
	    } 
	}
	catch(Exception e){
	    e.printStackTrace();
	}

	return "";
    }
    public static void  main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
	System.out.println(Constant.getConfig("UserAction"));
	String className = Constant.getConfig("UserAction");
	Class c = Class.forName(className);
	String json ="{'uactid':'11111','uactopr':'uuuuuu'}";
	UserAction u = JSONObject.parseObject(json, c);
	System.out.println(u.getUactid()+"----------"+u.getUactopr());
    }
}
