package com.syears.data.models.person;
import org.springframework.data.annotation.Id;
public class STPersonArticleGroupEntity {
    @Id
	private String PersonArticleGroupID;

    private String PersonArticleGroupName;

    private Integer PersonArticleGroupType;

    private Integer PersonArticleGroupStatus;

    public String getPersonArticleGroupID() {
        return PersonArticleGroupID;
    }

    public void setPersonArticleGroupID(String personarticlegroupid) {
        this.PersonArticleGroupID = personarticlegroupid == null ? null : personarticlegroupid.trim();
    }

    public String getPersonArticleGroupName() {
        return PersonArticleGroupName;
    }

    public void setPersonArticleGroupName(String personarticlegroupname) {
        this.PersonArticleGroupName = personarticlegroupname == null ? null : personarticlegroupname.trim();
    }

    public Integer getPersonArticleGroupType() {
        return PersonArticleGroupType;
    }

    public void setPersonArticleGroupType(Integer personarticlegrouptype) {
        this.PersonArticleGroupType = personarticlegrouptype;
    }

    public Integer getPersonArticleGroupStatus() {
        return PersonArticleGroupStatus;
    }

    public void setPersonArticleGroupStatus(Integer personarticlegroupstatus) {
        this.PersonArticleGroupStatus = personarticlegroupstatus;
    }
}