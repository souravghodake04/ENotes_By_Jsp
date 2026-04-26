package com.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.User.Post;

public class PostDAO {
	private Connection con;

	public PostDAO(Connection con) {
		super();
		this.con = con;
	}

	public boolean AddNotes(String ti, String co, int ui) {

		boolean f = false;
		try {
			String query = "Insert into post(title,content,uid)values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, ti);
			ps.setString(2, co);
			ps.setInt(3, ui);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Post> getData(int uid) {

		List<Post> list = new ArrayList<>();
		Post po = null;
		try {
			String qu = "SELECT * FROM post WHERE uid=? order by id DESC";
			PreparedStatement ps = con.prepareStatement(qu);
			ps.setInt(1, uid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				po = new Post();

				po.setId(rs.getInt(1));
				po.setTitle(rs.getString(2));
				po.setContent(rs.getString(3));
				po.setPdate(rs.getTimestamp(4));

				list.add(po);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Post getDateById(int noteId) {
		Post p = null;
		try {
			String qu = "Select * from post where id=?";
			PreparedStatement ps = con.prepareStatement(qu);
			ps.setInt(1, noteId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				p = new Post();
				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setContent(rs.getString(3));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public boolean PostUpdate(int nid, String ti, String co) {
		boolean b = false;
		try {
			String qu = "update post set title=?,content=? where id=?";
			PreparedStatement ps = con.prepareStatement(qu);
			ps.setString(1, ti);
			ps.setString(2, co);
			
			ps.setInt(3, nid);
			
			int i = ps.executeUpdate();
			if (i == 1) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean DeleteNotes(int nid) {
		boolean b = true;
		try {
			String qu = "delete from post where id=?";
			PreparedStatement ps = con.prepareStatement(qu);
			ps.setInt(1, nid);
			int x = ps.executeUpdate();
			if (x == 1) {
				b = true;
			}
		} catch (Exception e) {

		}
		return b;
	}
}
