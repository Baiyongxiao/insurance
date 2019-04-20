package com.web.insurance.entity;

import com.web.insurance.AbstractModel;

public class Search extends AbstractModel {

    private int id;

    private String account;

    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Search{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
