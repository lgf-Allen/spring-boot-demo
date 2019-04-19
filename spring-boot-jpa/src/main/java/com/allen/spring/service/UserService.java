/**
 *
 */
package com.allen.spring.service;

import com.allen.spring.service.domain.UserDomain;

/**
 * @author first
 *
 */
public interface UserService {

    UserDomain findById(Long id);
}
