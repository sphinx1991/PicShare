package com.ar.sphinx.picshare.models;

public class UserAccountSettings {

	private String description;
	private String display_name;
	private String followers;
	private String following;
	private String posts;
	private String profile_photo;
	private String username;

	public UserAccountSettings(String description, String display_name, String followers,
	                           String following, String posts, String profile_photo, String username) {
		this.description = description;
		this.display_name = display_name;
		this.followers = followers;
		this.following = following;
		this.posts = posts;
		this.profile_photo = profile_photo;
		this.username = username;
	}

	public UserAccountSettings(){

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getFollowers() {
		return followers;
	}

	public void setFollowers(String followers) {
		this.followers = followers;
	}

	public String getFollowing() {
		return following;
	}

	public void setFollowing(String following) {
		this.following = following;
	}

	public String getPosts() {
		return posts;
	}

	public void setPosts(String posts) {
		this.posts = posts;
	}

	public String getProfile_photo() {
		return profile_photo;
	}

	public void setProfile_photo(String profile_photo) {
		this.profile_photo = profile_photo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserAccountSettings{" + "description='" + description + '\'' + ", display_name='"
				+ display_name + '\'' + ", followers='" + followers + '\'' + ", following='"
				+ following + '\'' + ", posts='" + posts + '\'' + ", profile_photo='"
				+ profile_photo + '\'' + ", username='" + username + '\'' + '}';
	}
}
