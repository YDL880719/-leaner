package com.sxs.http.app.util;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sxs.entity.UserAction;
import com.sxs.util.Constant;


public class RequestGet {
    /**
     * 获取post参数
     * @param is
     * @param charset
     * @return
     */
    public static String getContent(InputStream is, String charset) {
	String pageString = null;
	InputStreamReader isr = null;
	BufferedReader br = null;
	StringBuffer sb = null;
	try {
	    isr = new InputStreamReader(is, charset);
	    br = new BufferedReader(isr);
	    sb = new StringBuffer();
	    String line = null;
	    //System.out.println("---******-");
	    while ((line = br.readLine()) != null) {
		System.out.println("-----");
		sb.append(line + "\n");
	    }
	    pageString = sb.toString();
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (is != null){
		    is.close();
		}
		if(isr!=null){
		    isr.close();
		}
		if(br!=null){
		    br.close();
		}
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    sb = null;
	}
	return pageString;
    }

    public static <T> T toChangeJson(String str){
	Object o  = null;
	if(str==null&&str.length()==0){
	    return null;
	}
	JSONObject jo = JSONObject.parseObject(str);
	String type = jo.getString("classType");
	String name = jo.getString("className");
	String ob = jo.getString("classObject");
	if(type.equalsIgnoreCase("object")){
	    if(name==null){
		return null;
	    }else{
		try {
		    Class  c = Class.forName( Constant.getConfig(name));
		    o  = JSON.parseObject(ob, c);
		    System.out.println("1:"+o.toString());
		} catch (ClassNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	    
	}else{
	    return (T)ob;
	}
	return (T)o;

    }
    public static void main(String[]args){
	String str ="{\"classType\":\"object\",\"className\":\"list\",\"classObject\":[{\"2222\":2222,\"3333\":3333,\"1111\":1111},{\"2222\":2222,\"3333\":3333,\"1111\":1111},{\"2222\":2222,\"3333\":3333,\"1111\":1111}]}";
	String json ="{'classType':'object1','className':'UserAction','classObject':{'uactid':'11111','uactopr':'uuuuuu'}}";
	String o  = toChangeJson(json);
	
	System.out.println(o.toString());
    }
}
