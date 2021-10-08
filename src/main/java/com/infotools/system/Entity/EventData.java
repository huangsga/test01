package com.infotools.system.Entity;


import java.text.SimpleDateFormat;
import java.util.Date;

public class EventData {
    private Integer event_id;
    private String event_title;
    private String event_abstract;
    private String event_img_url;
    private String event_details;
    private String click_num;
    private String share_num;
    private String link;
    private Date pub_time;



    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getEvent_abstract() {
        return event_abstract;
    }

    public void setEvent_abstract(String event_abstract) {
        this.event_abstract = event_abstract;
    }

    public String getEvent_img_url() {
        return event_img_url;
    }

    public void setEvent_img_url(String event_img_url) {
        this.event_img_url = event_img_url;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPub_time() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf.format(pub_time);
        return time;
    }

    public void setPub_time(Date pub_time) {
        this.pub_time = pub_time;
    }
}


