package com.record.dao;

import com.record.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserDaoTest {

    @Autowired
    private UserDao dao;

    @Test
    public void testSelectUser() throws Exception {
        long id = 1;
        List<User> user = dao.selectUserByUserId(id);
        System.out.println(user.get(0).getUserName());
    }

}