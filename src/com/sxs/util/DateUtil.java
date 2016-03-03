package com.sxs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
	
	public static String dateFormat(Date date ){
		String dateStr = null ;
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateStr = sm.format(date);
		return dateStr;
		
		
	}
	/**
	 * 字符串转日期
	 * @param str
	 * @return
	 */
	public static Date StrToDate(String str) {
	    
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Date date = null;
	    try {
	     date = format.parse(str);
	    } catch (ParseException e) {
	     e.printStackTrace();
	    }
	    return date;
	 }
	/**
	 * 字符串转日期
	 * @param str
	 * @return
	 */
	public static Date StrToDateByDay(String str) {
	    
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = null;
	    try {
	     date = format.parse(str);
	    } catch (ParseException e) {
	     e.printStackTrace();
	    }
	    return date;
	 }
	public static String dateFormatByDay(Date date ){
		String dateStr = null ;
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		dateStr = sm.format(date);
		return dateStr;
		
	}
	/**
	 * 将毫秒转换成字符串 
	 * @param d
	 * @return
	 */
	public static String dateFormatByTime(long d ){
		String dateStr = null ;
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(d);
		dateStr = sm.format(date);
		return dateStr;		
	}
	/**
	 * 将毫秒转换成字符串 yyyy-MM-dd HH:mm:ss
	 * @param d
	 * @return
	 */
	public static String dateTimeFormatByTime(long d ){
		String dateStr = null ;
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(d);
		dateStr = sm.format(date);
		return dateStr;		
	}
	
	

	
	
	/**
	 * 把日期转换成为毫秒的算法yyyy-MM-dd HH:mm:ss
	 * @param str
	 * @return
	 */
	public  static long getTimeForString(String str){
	    Date  d= StrToDate(str);
	    return d.getTime();
	}
	/**
	 * 把日期转换成为Long
	 * @param str
	 * @return
	 */
	public  static long getTimeForLong(Date date){
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		String datestr = sm.format(date);
	    return getTimeForString(datestr);
	}
	/**
	 * 把日期转换成为毫秒的算法yyyy-MM-dd
	 * @param str
	 * @return
	 */
	public static long getTimeForStringByDay(String str){
	    Date  d= StrToDateByDay(str);
	    return d.getTime();
	}
	/**
	 * 把日期转换成为毫秒的算法yyyy-MM-dd HH:mm:ss
	 * @param str
	 * @return
	 */
	public static long getTimeForStringByTime(String str){
	    Date  d= StrToDate(str);
	    return d.getTime();
	}
	public static long getTimeForDateByTime(String str){
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date date = null;
		try {
		 date = format.parse(str);
		} catch (ParseException e) {
		 e.printStackTrace();
		}
		return date.getTime();
	}
	/**
	 * 获得房屋的租期到期时间
	 * @param d
	 * @return
	 */
	public static int houseEndTime(long d ){
	    int i = 0 ;
	    return i  ;
	}
	/**
	 * 计算两个日期之间的月份差
	 * @param date1 <String>
	 * @param date2 <String>
	 * @return int
	 * @throws ParseException
	 */
	public static int getMonthSpace(String date1, String date2)
			throws ParseException {
		int result = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		
		Calendar c2 = Calendar.getInstance();
		c1.setTime(sdf.parse(date1));
		c2.setTime(sdf.parse(date2));
		result = c2.get(Calendar.MONDAY) - c1.get(Calendar.MONTH);
		return result == 0 ? 1 : Math.abs(result);

	}
	/**
	 * 计算两个日期之间的月份差
	 * @param date1 <String>
	 * @param date2 <String>
	 * @return int
	 * @throws ParseException
	 */
	public static int getMonthSpaceByMills(long date1, long date2)
			throws ParseException {
		int result = 0;
		long s = 60*60*24*1000;
		long d3 =  Math.abs(date1-date2);
		int k  =(int) (d3/s);
		int i  = k/30;
		int y = k%30;
		if(y>=15){
		    result = i + 1 ; 
		}else{
		    result =  i ;
		}
		return result ;

	}
	/**
	 * 获得某日期之后一年减一天的算法
	 * @param start
	 * @return
	 */
	public static long getYearForNetwork(long start, int addmonth){
	    Calendar c = Calendar.getInstance() ;
	    c.setTimeInMillis(start);
	    c.add(Calendar.MONTH, addmonth);
	    c.add(Calendar.DAY_OF_MONTH, -1);
	    return c.getTimeInMillis();
	}
	/**
	 * 获得某日期之后一年减一天的算法
	 * @param start
	 * @return
	 */
	public static long getYearForNetwork2(long start, int addmonth){
	    Calendar c = Calendar.getInstance() ;
	    c.setTimeInMillis(start);
	    c.add(Calendar.MONTH, addmonth);
	    c.add(Calendar.DAY_OF_MONTH, 0);
	    return c.getTimeInMillis();
	}
	/**
	 * 获得下个月1号的日期
	 * @param start
	 * @return
	 */
	
	public static long getNextDayByMonth(long start){
	    Calendar c = Calendar.getInstance() ;
	    c.setTimeInMillis(start);
	    c.set(Calendar.DAY_OF_MONTH, 1);
	    c.add(Calendar.MONDAY, 1);
	   // .println(dateFormatByTime(c.getTimeInMillis()));
	    return c.getTimeInMillis();
	}
	/**
	 * 获取下个月一号
	 * @author long 
	 * @param start
	 * @return 
	 * getNextDay
	 * TODO
	 * @param  
	 * @param  @return    
	 * @return long
	 */
	public static long getNextDay(long start){
	    Calendar c = Calendar.getInstance() ;
	    c.setTimeInMillis(start);
	    c.set(Calendar.DAY_OF_MONTH, 1);
	    c.add(Calendar.MONDAY, 1);
	   // .println(dateFormatByTime(c.getTimeInMillis()));
	    String sa = dateFormatByTime(c.getTimeInMillis());
	    return getTimeForStringByDay(sa);
	}
	/**
	 * 获取第二个月
	 * @author long 
	 * @param start
	 * @return 
	 * getNextMonth
	 * TODO
	 * @param  
	 * @param  @return    
	 * @return long
	 */
	public static long getNextMonth(long start){
	    Calendar c = Calendar.getInstance() ;
	    c.setTimeInMillis(start);
	    c.set(Calendar.DAY_OF_MONTH, 1);
	    c.add(Calendar.MONDAY, 1);
	    c.add(Calendar.MONTH,1); 
	   // .println(dateFormatByTime(c.getTimeInMillis()));
	    String sa = dateFormatByTime(c.getTimeInMillis());
	    return getTimeForStringByDay(sa);
	}
	public static void main(String []args) throws ParseException{
	  //  long s = getTimeForStringByDay("2015-08-01");
	   // getYearForNetwork(s);
	}
	
	 public static String getExtensionName(String filename) { 
	        if ((filename != null) && (filename.length() > 0)) { 
	            int dot = filename.lastIndexOf('.'); 
	            if ((dot >-1) && (dot < (filename.length() - 1))) { 
	                return filename.substring(dot + 1); 
	            } 
	        } 
	        return filename; 
	    } 

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days))+1;
	}
	/**
	 * 把日期转换成为毫秒的算法yyyy-MM-dd HH:mm:ss
	 * @param str
	 * @return
	 */
	public  static long getInstallTime(int choose){
		Long installTime = (long) 0;
		//次日安装
		if(choose == 0){
			long now = System.currentTimeMillis();
			String str_now1 = DateUtil.dateTimeFormatByTime(now);
			String str_now = DateUtil.dateFormatByTime(now);
			String str_new = str_now +" 17:00:00";
			long ti = DateUtil.getTimeForStringByTime(str_new);
			String install = "";
			if(ti >= now){
				//早于16:30包装的快带明天安装
				install = GetDateStr(1);
				installTime = getTimeForStringByDay(install);
			}else{
				install = GetDateStr(2);
				installTime = getTimeForStringByDay(install);
			}
		}else if(choose == 2 ){
			long now = System.currentTimeMillis();
			String str_now1 = DateUtil.dateTimeFormatByTime(now);
			String str_now = DateUtil.dateFormatByTime(now);
			String str_new = str_now +" 12:00:00";
			long ti = DateUtil.getTimeForStringByTime(str_new);
			String install = "";
			if(ti >= now){
				//早于16:30包装的快带明天安装
				installTime = getTimeForStringByDay(str_now);
			}else{
				install = GetDateStr(1);
				installTime = getTimeForStringByDay(install);
			}
		}
		
	    return installTime;
	}
	
	public static String GetDateStr(int AddDayCount) {
		Date dd = new Date();
		dd.setDate(dd.getDate()+AddDayCount);//获取AddDayCount天后的日期
		int  y = dd.getYear()+1900;
		int m = dd.getMonth()+1;//获取当前月份的日期
		int d = dd.getDate();
		return y+"-"+m+"-"+d;
	}
	/**
	 * 获得某日期之后几个月的时间
	 * @param start
	 * @return
	 */
	public static long getTimeForNetwork(long start,int addmonth){
	    Calendar c = Calendar.getInstance() ;
	    c.setTimeInMillis(start);
	    c.add(Calendar.MONTH, addmonth);
	    c.add(Calendar.DAY_OF_MONTH, -1);
	    return c.getTimeInMillis();
	}
	/**
	 * 该方法用户计算续费的结束时间
	 * 传值是  宽带结束时间 和 续费方式
	 * @param AddDayCount
	 * @return
	 */
	public static long getTimeForEx(long starttime,int mark) {
		int addmonth = 0;
		if(mark == 0){
			addmonth = 12;
		}else if(mark == 1){
			addmonth = 3;
		}else{
			addmonth = 1;
		}
		long retime = getTimeForNetwork(starttime,addmonth);
		return retime;
	}
	/**
	 * 获取某年某月的最后一天
	 * @author long 
	 * @param year
	 * @param month
	 * @return 
	 * getLastDayOfMonth
	 * TODO
	 * @param  
	 * @param  @return    
	 * @return String
	 */
	  public static String getLastDayOfMonth(int year,int month)
	    {
	        Calendar cal = Calendar.getInstance();
	        //设置年份
	        cal.set(Calendar.YEAR,year);
	        //设置月份
	        cal.set(Calendar.MONTH, month-1);
	        //获取某月最大天数
	        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	        //设置日历中月份的最大天数
	        cal.set(Calendar.DAY_OF_MONTH, lastDay);
	        //格式化日期
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String lastDayOfMonth = sdf.format(cal.getTime());
	         
	        return lastDayOfMonth;
	    }
}
