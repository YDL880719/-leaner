package com.sxs.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class DBUtil {

    private static DataSource datasource;

    public static Connection getCon() {
	
	if (datasource == null) {
	    try {
		getInstance();
	    } catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	try {
	    return datasource.getConnection();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    return null;
	}
    }

    /**
     * 
     * 
     * @return
     * @throws NamingException
     */
    private static DataSource getInstance() throws NamingException {
	if (datasource == null) {
	    Context initContext = new InitialContext();
	    Context envContext = (Context) initContext.lookup("java:/comp/env");
	    datasource = (DataSource) envContext.lookup("jdbc/sxs");
	}
	return datasource;
    }

    /**
     * 
     * 
     * @param sql
     * @return  执行增删改的sql
     */
    public static int execute(String sql) {
	Connection con = getCon();
	int i = 0;
	Statement st = null;

	try {
	    st = con.createStatement();
	    i = st.executeUpdate(sql);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    i = 505;

	} finally {
	    try {
		st.close();
		con.close();
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	return i;
    }

    /**
     * 
     * 
     * @param sql
     * @return  执行增删改的sql
     */
    public static int executeByKey(String sql) {
	Connection con = getCon();
	int i = 0;
	PreparedStatement  st = null;

	try {
	    st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	    i = st.executeUpdate();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    i = 505;

	} finally {
	    try {
		st.close();
		con.close();
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	return i;
    }
    /*
     * 执行一个存储过程
     */
    public void executeCall(String name) {
	Connection con = getCon();
	CallableStatement statement = null;
	try {

	    statement = con.prepareCall("call  "+name);
	    statement.executeUpdate();
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} finally {
	    try {
		statement.close();
		con.close();
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}

    }

    /**
     * 
     * @param sql
     * @return 返回一个结果集，结构List<Map>
     */
    public static List<Map<String, Object>> executeQuery(String sql) {
	List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	Connection con = getCon();
	Statement st = null;
	ResultSet rs = null;	
	try {
	    st = con.createStatement();
	    rs = st.executeQuery(sql);
	    ResultSetMetaData rm = rs.getMetaData();
	    while (rs.next()) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 1; i <= rm.getColumnCount(); i++) {
		    map.put(rm.getColumnName(i),
			    rs.getObject(rm.getColumnName(i)));
		}
		list.add(map);
	    }
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    Map<String, Object> map = new HashMap<String, Object>();
	    //map.put("status", "500");//表示查询语句出错了
	    map.put("errorCode", "202");//表示查询语句出错了
	    list.add(map);
	} finally {
	    try {
		if (rs != null) {
		    rs.close();
		}
		if (st != null) {
		    st.close();
		}
		if (con != null) {
		    con.close();
		}
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Map<String, Object> map = new HashMap<String, Object>();
		// map.put("status", "500");//表示查询语句出错了
		map.put("errorCode", "202");//表示查询语句出错了
		list.add(map);
	    }
	}
	return list;

    }

    public static void main(String[] args) {
	System.out.println(DBUtil.getCon());
    }
}
