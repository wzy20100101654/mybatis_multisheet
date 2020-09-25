package com.winter.domain;

import jdk.dynalink.linker.LinkerServices;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Person implements Serializable {
    private Integer id;
    private String personName;
    private String address;
    private String sex;
    private Date birthday;

    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", personName='" + personName + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
