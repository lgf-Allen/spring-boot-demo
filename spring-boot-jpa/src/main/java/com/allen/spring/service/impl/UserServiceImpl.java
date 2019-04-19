/**
 *
 */
package com.allen.spring.service.impl;

import com.allen.spring.dao.bean.UserPO;
import com.allen.spring.dao.repository.UserRepository;
import com.allen.spring.service.UserService;
import com.allen.spring.service.domain.UserDomain;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author first
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    /* (non-Javadoc)
     * @see com.allen.spring.service.UserService#findById(java.lang.Long)
     */
    @Override
    public UserDomain findById(Long id) {
        Optional<UserPO> optional = userRepository.findById(id);
        // 如果数据库存在UserPO
        UserDomain domain = new UserDomain();
        if(optional.isPresent()){
            UserPO userPO = optional.get();
            domain = objectMapper.convertValue(userPO , UserDomain.class);
        }
        return domain;
    }

}
