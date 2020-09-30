package com.bootcampweek4.playlist.models;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Track {

    private String id;
    private String name;
    private String length;
    private String artist;


    public Track(String name, String length, String artist) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.length = length;
        this.artist = artist;
    }

    public Track() {
        this.id = UUID.randomUUID().toString();
        this.name = "";
        this.length = "";
        this.artist = "";
    }
}
