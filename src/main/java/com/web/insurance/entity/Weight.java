package com.web.insurance.entity;

import com.web.insurance.AbstractModel;

public class Weight extends AbstractModel {

    private int id;

    private String account;

    private int car;

    private int travel;

    private int accident;

    private int healthy;

    private int children;

    private int life;

    private int illness;

    private int property;

    private int other;

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

    public int getCar() {
        return car;
    }

    public void setCar(int car) {
        this.car = car;
    }

    public int getTravel() {
        return travel;
    }

    public void setTravel(int travel) {
        this.travel = travel;
    }

    public int getAccident() {
        return accident;
    }

    public void setAccident(int accident) {
        this.accident = accident;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getIllness() {
        return illness;
    }

    public void setIllness(int illness) {
        this.illness = illness;
    }

    public int getProperty() {
        return property;
    }

    public void setProperty(int property) {
        this.property = property;
    }

    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }

    public int getSumWeight(){
        return car + travel + accident + healthy + children + life + illness + property + other;
    }

    public int[] getWeightNum(){
        int[] WeightNum = {car, travel, accident, healthy, children, life, illness, property, other};
        return WeightNum;
    }

    @Override
    public String toString() {
        return "Weight{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", car=" + car +
                ", travel=" + travel +
                ", accident=" + accident +
                ", healthy=" + healthy +
                ", children=" + children +
                ", life=" + life +
                ", illness=" + illness +
                ", property=" + property +
                ", other=" + other +
                '}';
    }
}
