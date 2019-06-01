package com.lzr.springmvc_deep.bean;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author linzerong
 * @create 2019-05-30 19:49
 * 数据检验类，用来检验请求参数的正确性
 */
public class ValidatorBean {
    @NotNull(message = "id不能为空！")
    private Long id;

    @Future(message = "需要一个将来的日期！")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date date;

    @NotNull
    @DecimalMin(value = "0.1")
    @DecimalMax(value = "99999.99")
    private Double doubleValue;

    @NotNull
    @Min(value = 1,message = "最小值为1")
    @Max(value = 99999,message = "最大值为99999")
    private Integer integer;

    @Range(min = 1, max = 99999, message = "范围为1-99999")
    private Long range;

    @Email(message = "邮箱格式错误！")
    private String emile;

    @Size(min = 1,max = 9,message = "字符串长度为1-9")
    private String size;

    @NotNull(message = "用户不能为空！")
    //嵌套验证
    @Valid()
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public Long getRange() {
        return range;
    }

    public void setRange(Long range) {
        this.range = range;
    }

    public String getEmile() {
        return emile;
    }

    public void setEmile(String emile) {
        this.emile = emile;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
