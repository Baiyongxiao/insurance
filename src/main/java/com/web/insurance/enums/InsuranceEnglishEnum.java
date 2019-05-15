package com.web.insurance.enums;

public enum InsuranceEnglishEnum implements IEnum {
    CHE(1,"car"),LVYOU(2,"travel"),YIWAI(3,"accident"),JIANKANG(4,"healthy"),
    SHAOER(5,"children"),SHOU(6,"life"),ZHONGJI(7,"illness"),CAICHAN(8,"property"),OTHER(9,"other");

    private Integer id;

    private String name;

    InsuranceEnglishEnum(Integer id, String name) {
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
