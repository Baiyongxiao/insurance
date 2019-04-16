package com.web.insurance.enums;

public enum ProductStatusEnum implements IEnum {
    UP(1,"上线"),DOWN(2,"下线");

    private Integer id;

    private String name;

    ProductStatusEnum(Integer id, String name) {
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
