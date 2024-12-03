package com.quest.case_study.playlist_manager;

public class DuplicateTrackException extends Exception{
    public DuplicateTrackException(String message){
        super(message);
    }
}
