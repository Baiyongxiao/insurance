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

    /**
     * 用户给该方案投的票数
     * @return
     */
    private int ticketCount;

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

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", productId=" + productId +
                ", pay='" + pay + '\'' +
                ", compensate='" + compensate + '\'' +
                ", ticketCount=" + ticketCount +
                '}';
    }
}
