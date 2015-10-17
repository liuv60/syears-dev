package com.syears.data.models.person;
import org.springframework.data.annotation.Id;
public class STPersonInfoEntity {
    @Id
	private String personid;

    private String fullname;

    private String surname;

    private String beifen;

    private String sex;

    private String livecity;

    private String liveaddress;

    private String ancestrycity;

    private String ancestryaddress;

    private String sbirth;

    private String mbirth;

    private Integer isdie;

    private String sdiedate;

    private String mdiedate;

    private Integer age;

    private String shengxiao;

    private String job;

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid == null ? null : personid.trim();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname == null ? null : surname.trim();
    }

    public String getBeifen() {
        return beifen;
    }

    public void setBeifen(String beifen) {
        this.beifen = beifen == null ? null : beifen.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getLivecity() {
        return livecity;
    }

    public void setLivecity(String livecity) {
        this.livecity = livecity == null ? null : livecity.trim();
    }

    public String getLiveaddress() {
        return liveaddress;
    }

    public void setLiveaddress(String liveaddress) {
        this.liveaddress = liveaddress == null ? null : liveaddress.trim();
    }

    public String getAncestrycity() {
        return ancestrycity;
    }

    public void setAncestrycity(String ancestrycity) {
        this.ancestrycity = ancestrycity == null ? null : ancestrycity.trim();
    }

    public String getAncestryaddress() {
        return ancestryaddress;
    }

    public void setAncestryaddress(String ancestryaddress) {
        this.ancestryaddress = ancestryaddress == null ? null : ancestryaddress.trim();
    }

    public String getSbirth() {
        return sbirth;
    }

    public void setSbirth(String sbirth) {
        this.sbirth = sbirth == null ? null : sbirth.trim();
    }

    public String getMbirth() {
        return mbirth;
    }

    public void setMbirth(String mbirth) {
        this.mbirth = mbirth == null ? null : mbirth.trim();
    }

    public Integer getIsdie() {
        return isdie;
    }

    public void setIsdie(Integer isdie) {
        this.isdie = isdie;
    }

    public String getSdiedate() {
        return sdiedate;
    }

    public void setSdiedate(String sdiedate) {
        this.sdiedate = sdiedate == null ? null : sdiedate.trim();
    }

    public String getMdiedate() {
        return mdiedate;
    }

    public void setMdiedate(String mdiedate) {
        this.mdiedate = mdiedate == null ? null : mdiedate.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getShengxiao() {
        return shengxiao;
    }

    public void setShengxiao(String shengxiao) {
        this.shengxiao = shengxiao == null ? null : shengxiao.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }
}