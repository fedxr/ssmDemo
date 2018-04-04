package com.record.service;

import com.record.model.User;

import java.util.List;

public interface IUserService {

    public List<User> selectAllUser();

    public List<User> selectUserByUserId(long userId);

    public User selectUserByUserName(String userName);

}