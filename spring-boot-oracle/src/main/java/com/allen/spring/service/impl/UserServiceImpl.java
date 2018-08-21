/**
 * 
 */
package com.allen.spring.service.impl;

import org.springframework.stereotype.Service;

import com.allen.spring.service.UserService;
import com.allen.spring.service.domain.UserDomain;

/**
 * @author first
 *
 */
@Service
public class UserServiceImpl implements UserService {

    /* (non-Javadoc)
     * @see com.allen.spring.service.UserService#findById(java.lang.Long)
     */
    @Override
    public UserDomain findById(Long id) {
        return null;
    }

}
