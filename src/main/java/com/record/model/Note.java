package com.record.model;

import java.util.Date;

public class Note {
    private long id;
    private long userId;
    private int weekCount;
    private String userName;
    private String regDate;
    private String job;
    private String newJob;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getWeekCount() {
        return weekCount;
    }

    public void setWeekCount(int weekCount) {
        this.weekCount = weekCount;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getJob() {
        return job;
    }

    public void setJob( String job) {
        this.job = job;
    }

    public String getNewJob() {
        return newJob;
    }

    public void setNewJob( String newJob) {
        this.newJob = newJob;
    }
}