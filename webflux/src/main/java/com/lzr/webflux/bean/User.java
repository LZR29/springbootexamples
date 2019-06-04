package com.lzr.webflux.bean;

import com.lzr.webflux.enumeration.SexEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author linzerong
 * @create 2019-06-03 22:20
 */
@Document
public class User implements Serializable {

    private static final long serialVersionUID = -4501445881697015400L;

    @Id
    private Long id;

    @Field("user_name")
    private String userName;
    private String note;
    private SexEnum sex;

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

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }
}
