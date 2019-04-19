package com.allen.spring.controller.impl;

import com.allen.spring.controller.UserController;
import com.allen.spring.controller.vo.UserVO;
import com.allen.spring.service.UserService;
import com.allen.spring.service.domain.UserDomain;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.net.URLDecoder;
import java.util.Objects;

@RestController
@RequestMapping(path = "/users")
public class UserControllerImpl implements UserController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserControllerImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping
    @Override
    public UserVO validate(@RequestParam(value = "id") @NotNull Long id) {
        LOGGER.info("Request parameter id is {}", id);
        UserDomain userDomain = userService.findById(id);
        UserVO userVO = new UserVO();
        if (Objects.nonNull(userDomain)) {
            userVO = objectMapper.convertValue(userDomain, UserVO.class);
        }
        return userVO;
    }

}
