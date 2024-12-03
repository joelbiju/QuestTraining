package com.quest.case_study.playlist_manager;

import java.util.*;

public class Playlist implements PlaylistOperations{
    private String name;
    private List<Track> tracks;

    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    //adding a track to playlist
    @Override
    public void addTrack(Track track) throws DuplicateTrackException {
        if (tracks.contains(track)) {
            throw new DuplicateTrackException("Track already exists in the playlist");
        }
        tracks.add(track);
    }

    //removing a track from playlist
    @Override
    public void removeTrack(Track track) throws TrackNotFoundException{
        if (!tracks.contains(track)) {
            throw new TrackNotFoundException("Track not present in the playlist.");
        }
        tracks.remove(track);
    }

    //display all the tracks
    @Override
    public void displayTracks() {
        tracks.forEach(System.out::println);
    }

    @Override
    public List<Track> findDuplicates() {
        List<Track> duplicates = new ArrayList<>();
        Set<Track> seenTracks = new HashSet<>();

        for (Track track : tracks) {
            if (!seenTracks.add(track)) {
                duplicates.add(track);
            }
        }
        return duplicates;
    }

    // sorting by duration
    @Override
    public void sortTracksByDuration() {
        tracks.sort(Comparator.comparingDouble(Track::getDuration));
    }

    //sorting by title
    @Override
    public void sortTracksByTitle() {
        tracks.sort(Comparator.comparing(Track::getTitle));
    }

    //shuffling tracks
    @Override
    public void shuffleTracks() {
        Collections.shuffle(tracks);
    }


    //helper method to use in user class
    public List<Track> getTracks() {
        return tracks;
    }

    public List<Track> searchTrack(String searchQuery) {
        List<Track> result = new ArrayList<>();
        for (Track track : tracks) {
            if (track.getTitle().equalsIgnoreCase(searchQuery) || track.getArtist().equalsIgnoreCase(searchQuery)) {
                result.add(track);
            }
        }
        return result;
    }
}
