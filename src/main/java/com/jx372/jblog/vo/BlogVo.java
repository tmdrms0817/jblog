package com.jx372.jblog.vo;

public class BlogVo {

	private Long userNo;
	private String title;
	private String logo;
	private String userID;

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "BlogVo [userNo=" + userNo + ", title=" + title + ", logo=" + logo + "]";
	}

}
