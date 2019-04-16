package com.web.insurance.enums;

public enum InsuranceEnum implements IEnum {
    CHE(1,"车险"),LVYOU(2,"旅游险"),YIWAI(3,"意外险"),JIANKANG(4,"健康险"),
    SHAOER(5,"少儿险"),SHOU(6,"寿险"),ZHONGJI(7,"重疾险"),CAICHAN(8,"财产险"),OTHER(9,"其他险种");

    private Integer id;

    private String name;

    InsuranceEnum(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
