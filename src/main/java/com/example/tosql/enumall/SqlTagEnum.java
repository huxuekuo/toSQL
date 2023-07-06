package com.example.tosql.enumall;

public enum SqlTagEnum {


    START("^[<].*[>]$", ""),
    END("^[<//].*[>]$", "");

    private String tag;
    private String desc;

    SqlTagEnum(String tag, String desc) {
        this.tag = tag;
        this.desc = desc;
    }

    public String getTag() {
        return tag;
    }

    public String getDesc() {
        return desc;
    }
}
