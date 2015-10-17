package com.syears.commons.vo.person;

public class STPersonYearAgeVO {
    private String personyearageid;

    private String personyearagename;

    private Integer personyearagestatus;

    private Integer startage;

    private Integer endage;

    public String getPersonyearageid() {
        return personyearageid;
    }

    public void setPersonyearageid(String personyearageid) {
        this.personyearageid = personyearageid == null ? null : personyearageid.trim();
    }

    public String getPersonyearagename() {
        return personyearagename;
    }

    public void setPersonyearagename(String personyearagename) {
        this.personyearagename = personyearagename == null ? null : personyearagename.trim();
    }

    public Integer getPersonyearagestatus() {
        return personyearagestatus;
    }

    public void setPersonyearagestatus(Integer personyearagestatus) {
        this.personyearagestatus = personyearagestatus;
    }

    public Integer getStartage() {
        return startage;
    }

    public void setStartage(Integer startage) {
        this.startage = startage;
    }

    public Integer getEndage() {
        return endage;
    }

    public void setEndage(Integer endage) {
        this.endage = endage;
    }
}