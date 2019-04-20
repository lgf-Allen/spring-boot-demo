/**
 *
 */
package com.allen.spring.dao.repository;

import com.allen.spring.dao.bean.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author first
 *
 */
public interface UserRepository extends UserCustom, JpaRepository<UserPO, Long> {

    Optional<UserPO> findById(Long id);
}
