package com.yc.common.biz;

import java.sql.SQLException;

import com.yc.bbs.DAO.TopicDAO;
import com.yc.common.util.Utils;

public class TopicBiz {
	
	private TopicDAO tDao=new TopicDAO();
	
	public void add(String title,String content,
			Object uid,String boardid) throws BizException {
		//验证用户的输入
		Utils.checkNull(title, "标题不能为空！");
		Utils.checkNull(content, "内容不能为空!");
		
		try {
			tDao.insert(title, content, uid, boardid);
			
		} catch (SQLException e) {
			throw new BizException("系统繁忙，请稍后再试",e);
		}
	}

}
