package com.infotools.system.Entity;


public class AllInfo {
    private Integer sys_id;
    private String name;
    private String category;
    private String img_url;
    private String sys_abstract;
    private String details;
    private String advice;

    public Integer getSys_id() {
        return sys_id;
    }

    public void setSys_id(Integer sys_id) {
        this.sys_id = sys_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getSys_abstract() {
        return sys_abstract;
    }

    public void setSys_abstract(String sys_abstract) {
        this.sys_abstract = sys_abstract;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}