package com.syears.data.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.syears.utils.ConfigUtil;
import com.syears.utils.HttpClientUtil;

import static com.syears.commons.Constants.COLLECTION_MESSAGE;

import java.net.URLEncoder;

@Document(collection = COLLECTION_MESSAGE)
public class MessageEntity {


    @Id
    private String id;

    //消息查看状态
    private Integer status;//0 未读 ，1已读  2，删除

    //用户ID
    private Long receiverId;

    //消息所属状态
    private Integer receiverPort;// 2用户端， 3商家端

    //消息详细内容
    private String data;

    //消息时间
    private Long date;

    //消息状态
    private Integer code;

    //消息标题
    private String title;

    //消息摘要
    private String des;


    public MessageEntity() {
        super();
    }


    public MessageEntity(Integer status, Long receiverId, Integer receiverPort, String data, Integer code, String title, String des) {
        super();
        this.status = status;
        this.receiverId = receiverId;
        this.receiverPort = receiverPort;
        this.data = data;
        this.code = code;
        this.title = title;
        this.des = des;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getReceiverPort() {
        return receiverPort;
    }

    public void setReceiverPort(Integer receiverPort) {
        this.receiverPort = receiverPort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getDate() {
        return date;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    /*public int sendMsg() {
        HttpClientUtil h = new HttpClientUtil();
        int result = 0;
        try {
            h.open(ConfigUtil.getString("serverUrl"), "get");
            h.addParameter("toId", receiverId.toString());
            h.addParameter("toPort", receiverPort.toString());
            h.addParameter("status", status.toString());
            h.addParameter("data", URLEncoder.encode(data, "utf-8"));
            h.addParameter("date", date.toString());
            h.addParameter("code", code.toString());
            h.setRequestHeader("Cookie", "Language=zh_CN;UserAgent=PC");
            result = h.send();
            h.getResponseBodyAsString("utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            h.close();
        }

        return result;
    }*/


}
