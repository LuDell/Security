package com.chinaup.security.action;

import com.chinaup.security.entity.User;
import com.chinaup.security.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "user",method = RequestMethod.GET)
public class UserAct {

    private final static Logger logger = LoggerFactory.getLogger(UserAct.class);

    @Autowired
    private UserService userService;

    @RequestMapping("save")
    public String saveUser(){
        User user = new User();
        user.setName("liaohuiming");
        user.setNikeName("baby");
        user.setEmail("ios2445@163.com");
        user.setDob(new Date());

        this.userService.saveEntity(user);
        logger.debug("存储user={}",user);
        return "Hello World";
    }

    @RequestMapping("findById")
    public User findById(Integer id){
        return userService.findById(id);
    }
}
