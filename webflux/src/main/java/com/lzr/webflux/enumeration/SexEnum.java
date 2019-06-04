package com.lzr.webflux.enumeration;

public enum SexEnum {
    /**
     * 男，女性别
     */
    MALE(1,"男"),
    FEMALE(0,"女");
    private int code;
    private String name;

    public static SexEnum getSexEnum(int code){
        SexEnum[] enums = SexEnum.values();
        for(SexEnum sexEnum : enums){
            if(sexEnum.getCode() == code){
                return sexEnum;
            }
        }
        return null;
    }

    SexEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
