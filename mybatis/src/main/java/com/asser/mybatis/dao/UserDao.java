package com.asser.mybatis.dao;

import com.asser.mybatis.po.User;

public interface UserDao {
	public User findUserById(int id) throws Exception;
	public void insertUser(User user) throws Exception;
}
