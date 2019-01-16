package com.example.net.roomdemo.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

public class JobInfo {
    @PrimaryKey(autoGenerate = true)
    String jobId;
    String jobAddress;
    String companyName;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
