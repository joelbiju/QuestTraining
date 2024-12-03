package com.quest.case_study.playlist_manager;

public class TrackNotFoundException extends Exception {
    public TrackNotFoundException(String message) {
        super(message);
    }
}
