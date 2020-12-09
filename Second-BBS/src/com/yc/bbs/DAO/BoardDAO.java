package com.yc.bbs.DAO;

import java.sql.SQLException;
import java.util.List;

import com.yc.common.util.DBHelper;

public class BoardDAO {
	
	/**
	 * 查询首页的分类
	 */
	
	public List<?>query(){
		String sql="SELECT\n" +
				"	a.*, b.*, c.title,\n" +
				"	c.uid,\n" +
				"	c.publishtime\n" +
				"FROM\n" +
				"	tbl_board a\n" +
				"LEFT JOIN(\n" +
				"	SELECT\n" +
				"		boardid,\n" +
				"		count(*)cnt\n" +
				"	FROM\n" +
				"		tbl_topic\n" +
				"	GROUP BY\n" +
				"		boardid\n" +
				")b ON a.id = b.boardid\n" +
				"LEFT JOIN(\n" +
				"	SELECT\n" +
				"		*\n" +
				"	FROM\n" +
				"		tbl_topic a\n" +
				"	WHERE\n" +
				"		a.id IN(\n" +
				"			SELECT\n" +
				"				MAX(id)\n" +
				"			FROM\n" +
				"				tbl_topic\n" +
				"			GROUP BY\n" +
				"				boardid\n" +
				"		)\n" +
				")c ON a.id = c.\n" +
				" boardid";
		try {
			return DBHelper.selectListMap(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			
			return null;
		}
	}

}
