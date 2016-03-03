package com.sxs.mapping;

import java.util.List;
import java.util.Map;

import com.sxs.util.Constant;
import com.sxs.util.DBUtil;


public class IndexObjectDAO {
    /**
     * ��ù����������ͼƬ���
     * @return
     */
    public static List<Map> getNowIndexData(){
	List result = null ; 
	String sql ="select dataId,indexTitle,type,CONCAT('"+Constant.getConfig("serverImageURL")+"',indexPic) as indexPic from "
		+ "indexobject where DATE_FORMAT( startTime, '%Y-%m-%d')<=DATE_FORMAT( now(), '%Y-%m-%d') "
		+ "and DATE_FORMAT( endTime, '%Y-%m-%d')>=DATE_FORMAT( now(), '%Y-%m-%d')";
	System.out.println(sql);
	result = DBUtil.executeQuery(sql);
	return result ;
    }

}
