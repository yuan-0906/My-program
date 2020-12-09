package com.yc.bbs.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.yc.common.util.DBHelper;

public class TopicDAO {
	
	public List<Map<String, Object>> selectByBid(String bid) throws SQLException{
		
		String sql="select * from tbl_topic a\n" +
				"LEFT JOIN tbl_user b on a.uid=b.id\n" +
				"left join (select topicid,count(*) cnt from tbl_reply\n" +
				"where topicid=1 GROUP BY topicid )c on a.id=c.topicid \n" +
				"WHERE a.boardid=?";
		
		return DBHelper.selectListMap(sql, bid);
		
	}
	
	public List<Map<String, Object>>selectByIdWithReply(String id) throws SQLException{
		String sql="select * from (select * from tbl_topic where id=? \n" +
				"								UNION ALL select * from tbl_reply \n" +
				"								 where topicid=? ) a\n" +
				"	join tbl_user b on a.uid=b.id;";
		
		
		return DBHelper.selectListMap(sql, id,id);
	}
	
	public void insert(String title,String content,Object uid,String boardid) throws SQLException {
		
		String sql="insert into tbl_topic values(null,?,?,now(),null,?,?)";
		
		DBHelper.update(sql, title,content,uid,boardid);
				
	}

}
