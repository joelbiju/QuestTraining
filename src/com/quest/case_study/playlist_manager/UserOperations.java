package com.quest.case_study.playlist_manager;

public interface UserOperations {
    void createPlaylist(String name);
    void deletePlaylist(String name);
    Playlist getPlaylist(String name);
    void displayAllPlaylist();
}
