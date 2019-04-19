package com.web.insurance.entity;

import com.web.insurance.AbstractModel;

public class Comment extends AbstractModel {

    private int id;

    private int productId;

    private String account;

    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", productId=" + productId +
                ", account='" + account + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
