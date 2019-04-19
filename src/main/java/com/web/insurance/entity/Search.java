package com.web.insurance.entity;

import com.web.insurance.AbstractModel;

public class Search extends AbstractModel {

    private int id;

    private int productId;

    private String account;

    private String word;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Search{" +
                "id=" + id +
                ", productId=" + productId +
                ", account='" + account + '\'' +
                ", word='" + word + '\'' +
                '}';
    }
}
