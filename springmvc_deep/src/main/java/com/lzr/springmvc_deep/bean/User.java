package com.lzr.springmvc_deep.bean;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;

/**
 * @author linzerong
 * @create 2019-05-26 22:02
 */
public class User {
    //配合数据验证
    @NotNull(message = "id不能为空！")
    private Long id;

    private String name;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
