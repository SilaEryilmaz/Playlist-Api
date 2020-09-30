package com.bootcampweek4.playlist.models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Playlist {


    private String id;
    private String name;
    private String description;
    private int followersCount;
    private List<Track> tracks;
    private int trackCount;
    private String userId;

    public Playlist(String name, String description, int followersCount, String userId) {

        if(userId==null) {
            throw new IllegalStateException();
        }
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.followersCount = 0;
        this.tracks = new ArrayList<Track>();
        this.trackCount = 0;
        this.userId = userId;
    }

    public Playlist() {
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.description = "";
        this.userId = null;
        this.followersCount = 0;
        this.trackCount = 0;
        this.tracks = new ArrayList<Track>();
    }

    public void addTrack(Track track) {
        this.tracks.add(track);
        this.trackCount++;
    }

    public void removeTrack(String trackId){
        try {
            this.tracks.removeIf(track -> track.getId().equals(trackId));
            this.trackCount--;
        }
        catch(Exception e){
            throw new IllegalArgumentException("silinemedi");
        }
    }
}
