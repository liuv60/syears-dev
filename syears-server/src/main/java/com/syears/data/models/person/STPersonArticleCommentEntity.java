package com.syears.data.models.person;
import org.springframework.data.annotation.Id;
public class STPersonArticleCommentEntity {
    @Id
	private String personcommentid;

    private String personarticleid;

    private String commentman;

    private String commentcontent;

    private String commentdate;

    private String commentip;

    private String answercomment;

    private Integer commentstatus;

    public String getPersoncommentid() {
        return personcommentid;
    }

    public void setPersoncommentid(String personcommentid) {
        this.personcommentid = personcommentid == null ? null : personcommentid.trim();
    }

    public String getPersonarticleid() {
        return personarticleid;
    }

    public void setPersonarticleid(String personarticleid) {
        this.personarticleid = personarticleid == null ? null : personarticleid.trim();
    }

    public String getCommentman() {
        return commentman;
    }

    public void setCommentman(String commentman) {
        this.commentman = commentman == null ? null : commentman.trim();
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent == null ? null : commentcontent.trim();
    }

    public String getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(String commentdate) {
        this.commentdate = commentdate == null ? null : commentdate.trim();
    }

    public String getCommentip() {
        return commentip;
    }

    public void setCommentip(String commentip) {
        this.commentip = commentip == null ? null : commentip.trim();
    }

    public String getAnswercomment() {
        return answercomment;
    }

    public void setAnswercomment(String answercomment) {
        this.answercomment = answercomment == null ? null : answercomment.trim();
    }

    public Integer getCommentstatus() {
        return commentstatus;
    }

    public void setCommentstatus(Integer commentstatus) {
        this.commentstatus = commentstatus;
    }
}