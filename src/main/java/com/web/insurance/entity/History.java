package com.web.insurance.entity;

import com.web.insurance.AbstractModel;

public class History extends AbstractModel {

    private int id;

    private int productId;

    private int classification;

    private int programId;

    private int showStatus;

    private String account;

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

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(int showStatus) {
        this.showStatus = showStatus;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", productId=" + productId +
                ", classification=" + classification +
                ", programId=" + programId +
                ", showStatus=" + showStatus +
                ", account='" + account + '\'' +
                '}';
    }
}
