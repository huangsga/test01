package com.infotools.system.Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EventInfo {
    private Integer event_id;
    private String event_title;
    private String event_details;
    private String event_address;
    private Date date_time;
    private Integer dead_num;
    private Integer cure_num;
    private Integer confirmed_num;
    private String event_abstract;

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

    public String getEvent_details() {
        return event_details;
    }

    public void setEvent_details(String event_details) {
        this.event_details = event_details;
    }

    public String getEvent_address() {
        return event_address;
    }

    public void setEvent_address(String event_address) {
        this.event_address = event_address;
    }

    public String getDate_time() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String time=sdf.format(date_time);
        return time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public Integer getDead_num() {
        return dead_num;
    }

    public void setDead_num(Integer dead_num) {
        this.dead_num = dead_num;
    }

    public Integer getCure_num() {
        return cure_num;
    }

    public void setCure_num(Integer cure_num) {
        this.cure_num = cure_num;
    }

    public Integer getConfirmed_num() {
        return confirmed_num;
    }

    public void setConfirmed_num(Integer confirmed_num) {
        this.confirmed_num = confirmed_num;
    }

    public String getEvent_abstract() {
        return event_abstract;
    }

    public void setEvent_abstract(String event_abstract) {
        this.event_abstract = event_abstract;
    }

}