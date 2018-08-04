/**
 * 
 */
package com.allen.spring.boot.bean;

import java.util.Date;

/**
 * @author first
 *
 */
public class Employee {

    private String name;
    private Integer age;
    private String gender;
    private Date joinDate;
    private String address;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employee() {
        super();
    }

    public Employee(String name, Integer age, String gender, Date joinDate, String address, String phoneNumber) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.joinDate = joinDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}
