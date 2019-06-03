package com.lzr.mongodb.bean;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author linzerong
 * @create 2019-06-03 16:04
 */
@Document
public class Role implements Serializable {
    private static final long serialVersionUID = -4662869363398321636L;
    private Long id;
    @Field("role_name")
    private String roleName;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
