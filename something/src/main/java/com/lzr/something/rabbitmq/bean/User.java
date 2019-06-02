package com.lzr.something.rabbitmq.bean;

import java.io.Serializable;

/**
 * @author linzerong
 * @create 2019-06-02 14:54
 */
public class User implements Serializable {

    private static final long serialVersionUID = -8686894825640205778L;
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
