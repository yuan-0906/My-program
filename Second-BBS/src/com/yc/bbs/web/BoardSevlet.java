package com.yc.bbs.web;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yc.bbs.DAO.BoardDAO;
import com.yc.common.web.BaseServlet;

@WebServlet("/board.s")
public class BoardSevlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BoardDAO bDao=new BoardDAO();
	
	public void  query(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		write(response,bDao.query());
		
		
	}



}
