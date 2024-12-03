package com.quest.case_study.playlist_manager;

import java.util.Objects;

public class Track {
    private int id;
    private String title;
    private String artist;
    private double duration;
    private int rating;

    public Track(int id, String title, String artist, double duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.rating = 3;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getDuration() {
        return duration;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Track [id=" + id + ", title=" + title + ", artist=" + artist + ", duration=" + duration;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass()!=obj.getClass()) return false;
        Track track = (Track) obj;
        return this.id == track.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
