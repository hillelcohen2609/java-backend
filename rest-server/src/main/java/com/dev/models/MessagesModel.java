package com.dev.models;


import com.dev.objects.Messages;

import java.text.SimpleDateFormat;

public class MessagesModel {
    private int id;
    private String title;
    private String content;
    private String sendDate;
    private String senderUsername;

    public MessagesModel(Messages message) {
        this.id = message.getId();
        this.content = message.getContent();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.sendDate = simpleDateFormat.format(message.getSendDate());
        this.title = message.getTitle();
        this.senderUsername = message.getSender().getUsername();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }
}
