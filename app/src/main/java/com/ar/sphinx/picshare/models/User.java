package com.ar.sphinx.picshare.models;

public class User {

	private String email;
	private String phone;
	private String user_id;
	private String username;

	public User(String email, String phone, String user_id, String username) {
		this.email = email;
		this.phone = phone;
		this.user_id = user_id;
		this.username = username;
	}

	public User() {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User{" + "email='" + email + '\'' + ", phone='" + phone + '\'' +
				", user_id='" + user_id + '\'' + ", username='" + username + '\'' + '}';
	}
}
