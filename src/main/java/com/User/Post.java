package com.User;

import java.util.Date;

public class Post {
	private int id;
	private String title;
	private String content;
	private Date pdate;
	private UserDetails user;
	private int uid;

	public Post(int id, String title, String content, Date pdate, UserDetails user, int uid) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.pdate = pdate;
		this.user = user;
		this.uid=uid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

}
