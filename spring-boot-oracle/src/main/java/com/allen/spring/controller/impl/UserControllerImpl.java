package com.allen.spring.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allen.spring.controller.UserController;
import com.allen.spring.controller.vo.UserVO;
import com.allen.spring.service.UserService;
import com.allen.spring.service.domain.UserDomain;
@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping(path="/user")
    @Override
    public UserVO validate(@RequestParam(value="id") Long id) {
        UserDomain userDomain = userService.findById(id);
        return null;
    }

}
