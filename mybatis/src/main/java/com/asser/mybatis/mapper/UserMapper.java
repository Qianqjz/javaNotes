package com.asser.mybatis.mapper;

import com.asser.mybatis.po.User;

public interface UserMapper {
	public User findUserById(int id) throws Exception;
	public void insertUser(User user) throws Exception;
	public User findUserByUserName(String userName) throws Exception;
}