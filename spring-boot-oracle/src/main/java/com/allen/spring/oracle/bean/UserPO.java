/**
 * 
 */
package com.allen.spring.oracle.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author first
 *
 */
@Entity
@Table(name = "user_tab")
@SequenceGenerator(name = "US", sequenceName = "USER_SEQ")
public class UserPO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "US")
    private Long id;

    private String username;

    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
