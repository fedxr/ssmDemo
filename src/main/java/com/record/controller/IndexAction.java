package com.record.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * index
 * Author: sunwenchao
 * Date: 2017/10/13
 * Time: 16:06
 */
@Controller
public class IndexAction {

    public static Logger logger = LoggerFactory.getLogger(IndexAction.class);

    @RequestMapping(value = "index")
    public String indexAction() {
        return "login";
    }
}
