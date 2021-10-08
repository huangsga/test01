package com.infotools.system.Entity;

public class BodyInfo {
      private Integer body_id;
      private String bodysystem;
      private String organ;
      private String ill_name;
      private String ill_reason;
      private String ill_details;
      private String ill_advice;
      private String ill_cure;

    public String getBodysystem() {
        return bodysystem;
    }

    public void setBodysystem(String bodysystem) {
        this.bodysystem = bodysystem;
    }

    public String getIll_advice() {
        return ill_advice;
    }

    public void setIll_advice(String ill_advice) {
        this.ill_advice = ill_advice;
    }

    public String getIll_cure() {
        return ill_cure;
    }

    public void setIll_cure(String ill_cure) {
        this.ill_cure = ill_cure;
    }

    public Integer getBody_id() {
        return body_id;
    }

    public void setBody_id(Integer body_id) {
        this.body_id = body_id;
    }

    public String getSystem() {
        return bodysystem;
    }

    public void setSystem(String system) {
        this.bodysystem = bodysystem;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getIll_name() {
        return ill_name;
    }

    public void setIll_name(String ill_name) {
        this.ill_name = ill_name;
    }

    public String getIll_reason() {
        return ill_reason;
    }

    public void setIll_reason(String ill_reason) {
        this.ill_reason = ill_reason;
    }

    public String getIll_details() {
        return ill_details;
    }

    public void setIll_details(String ill_details) {
        this.ill_details = ill_details;
    }

    public String getAdvice() {
        return ill_advice;
    }

    public void setAdvice(String advice) {
        this.ill_advice = ill_advice;
    }

    public String getCure() {
        return ill_cure;
    }

    public void setCure(String cure) {
        this.ill_cure = ill_cure;
    }

}
