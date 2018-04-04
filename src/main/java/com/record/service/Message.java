package com.record.service;


public class Message {
    boolean isSuccess;
    String msg;

    public Message() {
        this.msg = "";
        this.isSuccess = false;
    }

    public Message(String msg, boolean isSuccess) {
        this.msg = msg;
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
