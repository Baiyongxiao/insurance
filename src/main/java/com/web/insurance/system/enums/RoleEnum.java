package com.web.insurance.system.enums;

public enum RoleEnum {
    CHAOGUAN("superAdmin","超级管理员"),GUANLIYUAN("admin","管理员"),YONGHU("ordinary","普通用户");

    private String id;

    private String name;

    RoleEnum(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static String toName(String id){
        for (RoleEnum r : RoleEnum.values()) {
            if(id.equals(r.getId())){
                return r.getName();
            }
        }
        return null;
    }
}
