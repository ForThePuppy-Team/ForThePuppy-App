package com.cookandroid.forthepuppy.utils.walkUtils;

import java.sql.Date;
import java.sql.Time;

public class WalkData {
    private Date date;
    private String startTime;
    private String endTime;
    private Double totalDistance;
    private long totalTime; // 테이블에서 수정 필요 double임
    private String location; // 이건 안쓸거같은...

    public WalkData(Date date, String startTime, String endTime, Double totalDistance, long totalTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
    }

    public WalkData(Date date, String startTime, String endTime, Double totalDistance, long totalTime, String location) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
