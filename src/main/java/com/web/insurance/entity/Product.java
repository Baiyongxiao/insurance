package com.web.insurance.entity;

import com.web.insurance.AbstractModel;

/**
 * 进行投票的产品
 */

public class Product extends AbstractModel {

    private int id;

    /**
     * 保险产品的分类与枚举insurance对应
     */
    private String classification;

    private String name;

    private String content;

    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
