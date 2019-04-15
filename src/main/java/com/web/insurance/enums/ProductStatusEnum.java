package com.web.insurance.enums;

public enum ProductStatusEnum {
    UP(1,"上线"),DOWN(0,"下线");

    private int id;

    private String name;

    ProductStatusEnum(int id, String name) {
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
