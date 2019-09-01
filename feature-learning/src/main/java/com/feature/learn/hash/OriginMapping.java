package com.feature.learn.hash;

/**
 *
 * @author wangxc
 * @date: 2019-08-31 20:00
 *
 */
public class OriginMapping {
	public String originVal;
	public int hashCode;

	public String getOriginVal() {
		return originVal;
	}

	public void setOriginVal(String originVal) {
		this.originVal = originVal;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public OriginMapping(String originVal, int hashCode) {
		this.originVal = originVal;
		this.hashCode = hashCode;
	}
}
