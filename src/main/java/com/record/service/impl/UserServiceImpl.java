package com.record.service.impl;

import com.record.dao.UserDao;
import com.record.model.User;
import com.record.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDao userDao;

    public List<User> selectAllUser() {
        return this.userDao.selectAllUser();
    }

    public List<User> selectUserByUserId(long userId) {
        return this.userDao.selectUserByUserId(userId);
    }

    public User selectUserByUserName(String userName) {
        return this.userDao.selectUserByUserName(userName);
    }
}