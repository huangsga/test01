package com.infotools.system.Entity;

import javax.swing.*;
import java.util.Date;

public class UserDoubt {
    private Integer mess_id;
    private String user_name;
    private String doc_name;
    private String user_email;
    private String user_doubt;
    private String mess_details;
    private Date user_pubTime;
    private Date admin_reply;

    public Date getUser_pubTime() {
        return user_pubTime;
    }

    public void setUser_pubTime(Date user_pubTime) {
        this.user_pubTime = user_pubTime;
    }

    public Date getAdmin_reply() {
        return admin_reply;
    }

    public void setAdmin_reply(Date admin_reply) {
        this.admin_reply = admin_reply;
    }

    public String getUser_doubt() {
        return user_doubt;
    }

    public void setUser_doubt(String user_doubt) {
        this.user_doubt = user_doubt;
    }

    public Integer getMess_id() {
        return mess_id;
    }

    public void setMess_id(Integer mess_id) {
        this.mess_id = mess_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getMess_details() {
        return mess_details;
    }

    public void setMess_details(String mess_details) {
        this.mess_details = mess_details;
    }
}
