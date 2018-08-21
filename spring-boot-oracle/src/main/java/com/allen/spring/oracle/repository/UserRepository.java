/**
 * 
 */
package com.allen.spring.oracle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allen.spring.oracle.bean.UserPO;
import com.allen.spring.oracle.repository.impl.UserCustom;

/**
 * @author first
 *
 */
@Repository
public interface UserRepository extends UserCustom , JpaRepository<UserPO, Long> {

    UserPO findById(Long id);
}
