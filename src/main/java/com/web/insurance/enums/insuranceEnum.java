package com.web.insurance.enums;

public enum insuranceEnum {
    CHE(1,"车险"),LVYOU(2,"旅游险"),YIWAI(3,"意外险"),JIANKANG(4,"健康险"),
    SHAOER(5,"少儿险"),SHOU(6,"寿险"),ZHONGJI(7,"重疾险"),CAICHAN(8,"财产险"),OTHER(9,"其他险种");

    private int id;

    private String name;

    insuranceEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
