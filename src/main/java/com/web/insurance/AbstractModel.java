package com.web.insurance;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractModel {

    private Date createdDate;

    private Date updatedDate;

    private String createdUser;

    private String updatedUser;

    public Date getCreatedDate() {
        return createdDate;
    }
    public String getCreatedDateVo() {
        return TransformDateFormat(createdDate);
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }
    public String getUpdatedDateVo() {
        return TransformDateFormat(updatedDate);
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

    public String TransformDateFormat(Date date){
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        return format.format(date);
    }
}
