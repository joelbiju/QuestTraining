package com.quest.case_study.playlist_manager;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create User");
            System.out.println("2. Manage Playlists (Add, Remove, Display)");
            System.out.println("3. Test Track Equals Method");
            System.out.println("4. Test Duplicate Track Handling");
            System.out.println("5. Sort Tracks in Playlist");
            System.out.println("6. Shuffle Playlist");
            System.out.println("7. Merge Playlists");
            System.out.println("8. Rate Tracks");
            System.out.println("9. Manage Favorites");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();

                    try {
                        userManager.addUser(username);
                        System.out.println("User created successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    managePlaylists(scanner, userManager);
                    break;
                }
                case 3: {
                    trackEqualsCheck(scanner);
                    break;
                }
                case 4: {
                    duplicateErrorHandling(scanner, userManager);
                    break;
                }
                case 5: {
                    sortPlaylist(scanner, userManager);
                    break;
                }
                case 6: {
                    shufflePlaylist(scanner, userManager);
                    break;
                }
                case 7: {
                    mergePlaylists(scanner, userManager);
                    break;
                }
                case 8: {
                    rateTracks(scanner, userManager);
                    break;
                }
                case 9: {
                    manageFavourites(scanner, userManager);
                    break;
                }
                case 10: {
                    System.out.println("Exiting...");
                    return;
                }
                default: {
                    System.out.println("Invalid choice!");
                }
            }
        }
    }

    private static void manageFavourites(Scanner scanner, UserManager userManager){
        User user = checkUser(scanner, userManager);
        if (user == null) return;
        UserOperationImpl userOps = new UserOperationImpl(user);
        System.out.print("Enter track ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter track title: ");
        String title = scanner.nextLine();

        // Search for the track in all playlists of the user
        Track track = null;
        boolean trackFound = false;
        for (Playlist playlist : user.getPlaylists().values()) {
            for (Track t : playlist.getTracks()) {
                if (t.getId() == id || t.getTitle().equalsIgnoreCase(title)) {
                    track = t;
                    trackFound = true;
                    break;
                }
            }
            if (trackFound) break;  // Break if track is found
        }
        if (track == null) {
            System.out.println("Track not found in any playlist.");
            return;
        }

        System.out.println("Track found: " + track);

        //ask to mark or unmark
        System.out.println("Choose an option:");
        System.out.println("1. Mark as favorite");
        System.out.println("2. Unmark as favorite");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline character

        switch (choice) {
            case 1:
                try {
                    userOps.markAsFavourites(track);
                    System.out.println("Track marked as favorite.");
                } catch (DuplicateTrackException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

            case 2:
                userOps.unmarkAsFavourites(track);
                System.out.println("Track unmarked as favorite.");
                break;

            default:
                System.out.println("Invalid choice.");
                return;
        }
        //print favourite tracks
        System.out.println("Your favorite tracks:");
        userOps.displayFavouriteTracks();
    }

    private static void rateTracks(Scanner scanner, UserManager userManager) {
        User user = checkUser(scanner, userManager);
        if (user == null) return;

        UserOperationImpl userOps = new UserOperationImpl(user);
        System.out.print("Enter playlist name: ");
        String playlistName = scanner.nextLine();
        Playlist playlist = userOps.getPlaylist(playlistName);

        if (playlist == null) {
            System.out.println("Playlist not found.");
            return;
        }

        System.out.print("Enter track ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        System.out.print("Enter track title: ");
        String title = scanner.nextLine();
        System.out.print("Enter rating (1 to 5): ");
        int rating = scanner.nextInt();

        // Search for the track in the playlist
        Track trackToRate = null;
        for (Track track : playlist.getTracks()) {
            if (track.getId() == id || track.getTitle().equalsIgnoreCase(title)) {
                trackToRate = track;
                break;
            }
        }

        if (trackToRate != null) {
            // If track is found, update its rating
            try {
                trackToRate.setRating(rating);  // Directly set rating as an integer
                System.out.println("Track rating updated to " + rating);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            // If track is not found, add a new track with the provided rating
            Track newTrack = new Track(id, title, "Artist", 3.5);
            try {
                newTrack.setRating(rating);  // Directly set rating as an integer
                playlist.addTrack(newTrack);
                System.out.println("Track added and rated.");
            } catch (IllegalArgumentException | DuplicateTrackException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void mergePlaylists(Scanner scanner, UserManager userManager) {
        User user = checkUser(scanner, userManager);
        if (user == null) return;

        UserOperationImpl userOps = new UserOperationImpl(user);
        System.out.print("Enter first playlist name: ");
        String playlist1 = scanner.nextLine();
        System.out.print("Enter second playlist name: ");
        String playlist2 = scanner.nextLine();
        System.out.print("Enter new playlist name: ");
        String newPlaylistName = scanner.nextLine();
        try {
            Playlist newPlaylist = userOps.mergePlaylists(playlist1, playlist2, newPlaylistName);
            System.out.println("Playlists merged into: " + newPlaylist.getName());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void shufflePlaylist(Scanner scanner, UserManager userManager) {
        User user = checkUser(scanner, userManager);
        if (user == null) return;

        UserOperationImpl userOps = new UserOperationImpl(user);
        System.out.print("Enter playlist name: ");
        String playlistName = scanner.nextLine();
        Playlist playlist = userOps.getPlaylist(playlistName);

        if (playlist == null) {
            System.out.println("Playlist not found.");
            return;
        }

        userOps.getPlaylist(playlistName).shuffleTracks();
        System.out.println("Playlist shuffled.");
        userOps.getPlaylist(playlistName).displayTracks();
    }

    private static void sortPlaylist(Scanner scanner, UserManager userManager) {
        User user = checkUser(scanner, userManager);
        if (user == null) return;

        UserOperationImpl userOps = new UserOperationImpl(user);
        System.out.print("Enter playlist name: ");
        String playlistName = scanner.nextLine();
        Playlist playlist = userOps.getPlaylist(playlistName);

        if (playlist == null) {
            System.out.println("Playlist not found.");
            return;
        }

        System.out.println("Sort by: 1. Duration 2. Title");
        int choice = scanner.nextInt();

        if (choice == 1) {
            userOps.getPlaylist(playlistName).sortTracksByDuration();
            System.out.println("Playlist sorted by duration.");
        } else if (choice == 2) {
            userOps.getPlaylist(playlistName).sortTracksByTitle();
            System.out.println("Playlist sorted by title.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void duplicateErrorHandling(Scanner scanner, UserManager userManager) {
        User user = checkUser(scanner, userManager);
        if (user == null) return;

        UserOperationImpl userOps = new UserOperationImpl(user);
        String playlistName = scanner.nextLine();
        Playlist playlist = userOps.getPlaylist(playlistName);

        if (playlist == null) {
            System.out.println("Playlist not found.");
            return;
        }
        System.out.print("Enter track ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        System.out.print("Enter track title: ");
        String title = scanner.nextLine();

        Track track = new Track(id, title, "Artist", 3.5);

        try {
            playlist.addTrack(track);
            System.out.println("Track added to playlist.");
        } catch (DuplicateTrackException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Check for duplicates using the findDuplicates method
        List<Track> duplicates = playlist.findDuplicates();
        if (duplicates.isEmpty()) {
            System.out.println("No duplicates found in the playlist.");
        } else {
            System.out.println("Duplicate tracks in the playlist:");
            duplicates.forEach(System.out::println);
        }
    }

    private static void trackEqualsCheck(Scanner scanner) {
        System.out.print("Enter first track ID: ");
        int id1 = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        System.out.print("Enter first track title: ");
        String title1 = scanner.nextLine();

        System.out.print("Enter second track ID: ");
        int id2 = scanner.nextInt();
        scanner.nextLine();  // Consume newline character
        System.out.print("Enter second track title: ");
        String title2 = scanner.nextLine();

        Track track1 = new Track(id1, title1, "Artist", 3.5);
        Track track2 = new Track(id2, title2, "Artist", 4.0);

        if (track1.equals(track2)) {
            System.out.println("The tracks are equal.");
        } else {
            System.out.println("The tracks are not equal.");
        }
    }

    private static void managePlaylists(Scanner scanner, UserManager userManager) {
        User user = checkUser(scanner, userManager);
        if (user == null) return;

        UserOperationImpl userOps = new UserOperationImpl(user);

        while (true) {
            System.out.println("Playlist Menu:");
            System.out.println("1. Create Playlist");
            System.out.println("2. Delete Playlist");
            System.out.println("3. Display All Playlists");
            System.out.println("4. Exit Playlist Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1: {
                    System.out.print("Enter playlist name: ");
                    String name = scanner.nextLine();

                    try {
                        userOps.createPlaylist(name);
                        System.out.println("Playlist created successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter playlist name to delete: ");
                    String pname = scanner.nextLine();

                    userOps.deletePlaylist(pname);
                    System.out.println("Playlist deleted successfully.");
                    break;
                }
                case 3:
                    userOps.displayAllPlaylist();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    //helper method to check user
    private static User checkUser(Scanner scanner, UserManager userManager) {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        User user = userManager.getUser(username);

        if (user == null) {
            System.out.println("User not found.");
            return null;
        }
        return user;
    }
}
