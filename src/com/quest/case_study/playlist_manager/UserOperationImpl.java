package com.quest.case_study.playlist_manager;

import java.util.List;

public class UserOperationImpl implements UserOperations {
    private User user;

    // Constructor to initialize the User object
    public UserOperationImpl(User user) {
        this.user = user;
    }

    // Create a new playlist
    @Override
    public void createPlaylist(String name) {
        if (user.getPlaylists().containsKey(name)) {
            throw new IllegalArgumentException("Playlist with this name already exists");
        }
        user.getPlaylists().put(name, new Playlist(name));
    }

    // Delete an existing playlist
    @Override
    public void deletePlaylist(String name) {
        user.getPlaylists().remove(name);
    }

    // Get a playlist by name
    @Override
    public Playlist getPlaylist(String name) {
        return user.getPlaylists().get(name);
    }

    // Display all playlists and their tracks
    @Override
    public void displayAllPlaylist() {
        user.getPlaylists().values().forEach(Playlist::displayTracks);
    }

    // Merge two playlists into a new playlist
    public Playlist mergePlaylists(String playlist1, String playlist2, String newPlaylistName) {
        Playlist newPlaylist = new Playlist(newPlaylistName);
        Playlist p1 = user.getPlaylists().get(playlist1);
        Playlist p2 = user.getPlaylists().get(playlist2);

        if (p1 == null && p2 == null) {
            throw new IllegalArgumentException("Both playlists do not exist");
        }

        if (p1 != null) {
            for (Track track : p1.getTracks()) {
                try {
                    newPlaylist.addTrack(track);
                } catch (DuplicateTrackException ignored) {}
            }
        }
        if (p2 != null) {
            for (Track track : p2.getTracks()) {
                try {
                    newPlaylist.addTrack(track);
                } catch (DuplicateTrackException ignored) {}
            }
        }
        user.getPlaylists().put(newPlaylistName, newPlaylist);
        return newPlaylist;
    }

    // Mark a track as a favorite
    public void markAsFavourites(Track track) throws DuplicateTrackException {
        if (user.getFavouriteTracks().contains(track)) {
            throw new DuplicateTrackException("Track already found in favourites.");
        }
        user.getFavouriteTracks().add(track);
    }

    // Unmark a track as a favorite
    public void unmarkAsFavourites(Track track) {
        user.getFavouriteTracks().remove(track);
    }

    // Display all favorite tracks
    public void displayFavouriteTracks() {
        user.getFavouriteTracks().forEach(System.out::println);
    }
}
