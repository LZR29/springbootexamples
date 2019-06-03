package com.lzr.mongodb.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

/**
 * @author linzerong
 * @create 2019-06-03 16:06
 */
@Document
public class User implements Serializable {
    private static final long serialVersionUID = -9121940030587490228L;
    /**
     * MongoDB文档编号，主键
     */
    @Id
    private Long id;
    /**
     * 在MongoDB中的user_name属性
     */
    @Field("user_name")
    private String userName;

    private String note;
    /**
     * 角色表
     */
    private List<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
