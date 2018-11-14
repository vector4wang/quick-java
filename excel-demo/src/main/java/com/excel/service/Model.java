package com.excel.service;

import com.sargeraswang.util.ExcelUtil.ExcelCell;

/**
 * @author vector
 * @Data 2018/8/1 0001
 * @Description TODO
 */
public class Model {

	@ExcelCell(index = 0)
	private String line;

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	@Override
	public String toString() {
		return "Model{" + "line='" + line + '\'' + '}';
	}
}
