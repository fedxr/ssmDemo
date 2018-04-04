package com.record.controller;

import javax.servlet.http.HttpServletRequest;

import com.record.model.Note;
import com.record.model.User;
import com.record.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.record.service.NoteService;
import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin2.message.Message;
import sun.plugin2.message.Serializer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    public static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private IUserService userService;

    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(required = true, value = "userId") String userId1) throws IOException {
        List<User> user;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        long userId = Long.parseLong(userId);
        long userId = Long.valueOf(userId1);
        if (userId == 0) {
            user = this.userService.selectAllUser();
        } else {
            user = this.userService.selectUserByUserId(userId);
        }
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }
}