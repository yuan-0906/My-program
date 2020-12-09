package com.yc.common.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.common.util.DBHelper;

@WebServlet("/user.s")
public class UserServlet extends BaseServlet {
	

	private static final long serialVersionUID = 1L;

	/**
	 * 注意：不能重写doGet和doPost
	 * @throws SQLException 
	 * @throws IOException 
	 */
	
	/*
	 * 查询所有用户信息，必须提供请求和相应参数
	 * 
	 */
	public void query(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
		
		String sql="select * from tbl_user";
		List<Map<String, Object>> ret=DBHelper.selectListMap(sql);
		write(response, ret);
	}

}
