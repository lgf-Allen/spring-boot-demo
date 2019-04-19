/**
 *
 */
package com.allen.spring.dao.repository;

import com.allen.spring.dao.bean.UserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author first
 *
 */
@Repository
//@RepositoryDefinition(domainClass = UserPO.class, idClass = Long.class)
public interface UserRepository extends UserCustom, JpaRepository<UserPO, Long> {

    Optional<UserPO> findById(Long id);
}
