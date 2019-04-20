package com.web.insurance;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractModel {

    private Date createdDate;

    private Date updatedDate;

    private String createdUser;

    private String updatedUser;

    private int pageNum;

    private int pageSize;

    public String getCreatedDateVo() {
        return createdDate == null ? null : formatTime(createdDate);
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDateVo() {
        return updatedDate == null ? null : formatTime(updatedDate);
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getUpdatedUser() {
        return updatedUser;
    }

    public void setUpdatedUser(String updatedUser) {
        this.updatedUser = updatedUser;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String formatTime(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    @Override
    public String toString() {
        return "AbstractModel{" +
                "createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", createdUser='" + createdUser + '\'' +
                ", updatedUser='" + updatedUser + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }
}
