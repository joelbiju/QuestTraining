package com.quest.case_study.playlist_manager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class User {
    private String username;
    private Map<String, Playlist> playlists;
    private Set<Track> favouriteTracks;

    // Constructor to initialize the user object
    public User(String username) {
        this.username = username;
        this.playlists = new HashMap<>();
        this.favouriteTracks = new HashSet<>();
    }

    // Getters for username, playlists, and favouriteTracks
    public String getUsername() {
        return username;
    }

    public Map<String, Playlist> getPlaylists() {
        return playlists;
    }

    public Set<Track> getFavouriteTracks() {
        return favouriteTracks;
    }
}
