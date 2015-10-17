package com.syears.data.models.person;
import org.springframework.data.annotation.Id;
public class STAnimalSignEntity {
    @Id
	private String animalsignid;

    private String animalsignname;

    public String getAnimalsignid() {
        return animalsignid;
    }

    public void setAnimalsignid(String animalsignid) {
        this.animalsignid = animalsignid == null ? null : animalsignid.trim();
    }

    public String getAnimalsignname() {
        return animalsignname;
    }

    public void setAnimalsignname(String animalsignname) {
        this.animalsignname = animalsignname == null ? null : animalsignname.trim();
    }
}