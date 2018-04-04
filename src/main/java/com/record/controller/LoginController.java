package com.record.controller;

import com.record.model.User;
import com.record.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * index
 * Author: sunwenchao
 * Date: 2017/10/13
 * Time: 16:06
 */
@Controller
public class LoginController {

    public static Logger logger = LoggerFactory.getLogger(LoginController.class);

    protected static final String SESSION_KEY_USER = "USER";

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/login.action", method = RequestMethod.POST)
    public String indexAction(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if(StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(password)){
            User user = userService.selectUserByUserName(userName);
            if(user != null && user.getPassword().equals(password)){
                request.getSession().setAttribute(SESSION_KEY_USER, user);
                return "index";
            }
        }
        return "login";
    }
}
