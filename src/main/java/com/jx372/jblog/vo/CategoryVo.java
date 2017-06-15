package com.jx372.jblog.vo;

public class CategoryVo {
	private Long no;
	private Long userNo;
	private String name;
	private String reg_date;
	private String description;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", userNo=" + userNo + ", name=" + name + ", reg_date=" + reg_date
				+ ", description=" + description + "]";
	}

}
