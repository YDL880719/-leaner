package com.sxs.service;

import com.sxs.mapping.DMGObjectDAO;

public class DMGService {

    //更新添加学校信息
    public static String getDMGBySchoolId(int schoolId){
    	return DMGObjectDAO.getDMGBySchoolId(schoolId);	
    }
}
