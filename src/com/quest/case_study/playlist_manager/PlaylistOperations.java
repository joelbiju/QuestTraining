package com.quest.case_study.playlist_manager;

import java.util.List;

public interface PlaylistOperations {
    void addTrack(Track track) throws DuplicateTrackException;
    void removeTrack(Track track) throws TrackNotFoundException;
    void displayTracks();
    public List<Track> findDuplicates();
    void sortTracksByDuration();
    void sortTracksByTitle();
    void shuffleTracks();
}
