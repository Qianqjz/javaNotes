package com.design.dynamicproxy;

public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("添加用户");
    }
}
