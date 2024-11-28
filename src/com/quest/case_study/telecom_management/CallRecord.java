package com.quest.case_study.telecom_management;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CallRecord implements Serializable {
    private CallType type;
    private double duration;
    private LocalDateTime timestamp;

    public CallRecord(CallType type, double duration) {
        this.type = type;
        this.duration = duration;
        this.timestamp = LocalDateTime.now();
    }

    public CallType getType() {
        return type;
    }

    public double getDuration() {
        return duration;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Type: "+ type + ", Duration: "+ duration + " mins, Timestamp: "+ timestamp.format(formatter);
    }
}
