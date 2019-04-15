package com.web.insurance.entity;

import com.web.insurance.AbstractModel;

/**
 * 每个产品拥有的投票方案
 */
public class Program extends AbstractModel {

    private int id;

    private int productId;

    /**
     * 你投保该产品需要付出的代价
     */
    private String pay;

    /**
     * 你应获得的保障或补偿
     */
    private String compensate;

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

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getCompensate() {
        return compensate;
    }

    public void setCompensate(String compensate) {
        this.compensate = compensate;
    }
}
