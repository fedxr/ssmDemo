package com.record.dao;

import com.record.model.User;

public interface IUserDao {

    User selectUser(long id);

}