package com.example.silkroad;

import java.util.Date;

public class TextMessage
{
    private int textID;
    private int senderID;
    private int receiverID;
    private String content;
    private Date date;
    private String senderUsername;
    private String receiverUsername;

    public TextMessage(int textID, int senderID, int receiverID, String content, Date date) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.content = content;
        this.date = date;
    }

    public TextMessage(int senderID, int receiverID, String content) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.content = content;
    }

    public int getSenderID() {
        return senderID;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public String getContent() {
        return content;
    }

    public Date getDate() {
        return date;
    }

    public int getTextID() {
        return textID;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public String getReceiverUsername() {
        return receiverUsername;
    }
}
