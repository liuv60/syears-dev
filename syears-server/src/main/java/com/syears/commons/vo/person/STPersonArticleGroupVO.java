package com.syears.commons.vo.person;

public class STPersonArticleGroupVO {
    private String personarticlegroupid;

    private String personarticlegroupname;

    private Integer personarticlegrouptype;

    private Integer personarticlegroupstatus;

    public String getPersonArticleGroupID() {
        return personarticlegroupid;
    }

    public void setPersonArticleGroupID(String personarticlegroupid) {
    	System.out.println("personarticlegroupid:"+personarticlegroupid);
        this.personarticlegroupid = personarticlegroupid == null ? null : personarticlegroupid.trim();
    }

    public String getPersonArticleGroupName() {
        return personarticlegroupname;
    }

    public void setPersonArticleGroupName(String personarticlegroupname) {
        this.personarticlegroupname = personarticlegroupname == null ? null : personarticlegroupname.trim();
    }

    public Integer getPersonArticleGroupType() {
        return personarticlegrouptype;
    }

    public void setPersonArticleGroupType(Integer personarticlegrouptype) {
        this.personarticlegrouptype = personarticlegrouptype;
    }

    public Integer getPersonArticleGroupStatus() {
        return personarticlegroupstatus;
    }

    public void setPersonArticleGroupStatus(Integer personarticlegroupstatus) {
        this.personarticlegroupstatus = personarticlegroupstatus;
    }
}