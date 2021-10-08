package com.infotools.system.Entity;

import java.util.Date;

public class ViewEventData1 {
    private String event_abstract;
    private String event_details;
    private String click_num;
    private String share_num;
    private Date pub_time;

    public String getEvent_abstract() {
        return event_abstract;
    }

    public void setEvent_abstract(String event_abstract) {
        this.event_abstract = event_abstract;
    }

    public String getEvent_details() {
        return event_details;
    }

    public void setEvent_details(String event_details) {
        this.event_details = event_details;
    }

    public String getClick_num() {
        return click_num;
    }

    public void setClick_num(String click_num) {
        this.click_num = click_num;
    }

    public String getShare_num() {
        return share_num;
    }

    public void setShare_num(String share_num) {
        this.share_num = share_num;
    }

    public Date getPub_time() {
        return pub_time;
    }

    public void setPub_time(Date pub_time) {
        this.pub_time = pub_time;
    }
}
