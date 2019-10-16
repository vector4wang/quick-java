package com.feature.learn.ojcp;

/**
 *
 * @author wangxc
 * @date: 2019-10-15 10:51
 *
 */
public class Question97 {
}

class DBConfiguration {
	String user;
	String password;
}

class DBHandler {
	DBConfiguration configureDB(String user, String password) {
		// insert code here
		//		return DBConfiguration;
		return null;
	}

	public static void main(String[] args) {
		DBHandler r = new DBHandler();
		DBConfiguration dbConf = r.configureDB("manager", "manager");
	}
}
