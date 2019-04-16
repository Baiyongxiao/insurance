package com.web.insurance.entity;

import com.web.insurance.AbstractModel;
import com.web.insurance.enums.IEnum;
import com.web.insurance.enums.InsuranceEnum;
import com.web.insurance.enums.ProductStatusEnum;

/**
 * 进行投票的产品
 */

public class Product extends AbstractModel {

    private int id;

    /**
     * 保险产品的分类与枚举insurance对应
     */
    private Integer classification;

    private String name;

    private String content;

    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getClassification() {
        return classification;
    }
    public String getClassificationVo() {
        return IEnum.toName(InsuranceEnum.class,classification);
    }

    public void setClassification(Integer classification) {
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
    public String getStatusVo() {
        return IEnum.toName(ProductStatusEnum.class, status);
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", classification='" + classification + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                '}';
    }
}
