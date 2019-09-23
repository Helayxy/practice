package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import vo.Vote;

public class VoteDao {
	private Connection conn = null;

	public void initConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/vote", "root", "root");
	}

	// 返回所有教师及其得票数
	public ArrayList getAllVotes() throws Exception {
		ArrayList al = new ArrayList();
		initConnection();
		String sql = "select t_id,t_name,t_vote from vote";
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			Vote vote = new Vote();
			vote.setTeacherno(rs.getString("t_id"));
			vote.setTeachername(rs.getString("t_name"));
			vote.setVotenumber(rs.getInt("t_vote"));
			al.add(vote);
		}
		closeConnection();
		return al;
	}

	// 修改某些老师的票数
	public void updateVotes(String[] teacherno) throws Exception {
		initConnection();
		String sql = "update vote set t_vote=t_vote+1 where t_id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		for (int i = 0; i < teacherno.length; i++) {
			ps.setString(1, teacherno[i]);
			ps.executeUpdate();
		}
		closeConnection();
	}

	public void closeConnection() throws Exception {
		conn.close();
	}
}
