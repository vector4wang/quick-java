package com.excel.service;

import com.sargeraswang.util.ExcelUtil.ExcelCell;

/**
 * @author vector
 * @Data 2018/8/1 0001
 * @Description TODO
 */
public class OutVo {
	@ExcelCell(index = 0)
	private String name;
	@ExcelCell(index = 1)
	private String engName;
	@ExcelCell(index = 2)
	private String tel;
	@ExcelCell(index = 3)
	private String email;
	@ExcelCell(index = 4)
	private String org;
	@ExcelCell(index = 5)
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
