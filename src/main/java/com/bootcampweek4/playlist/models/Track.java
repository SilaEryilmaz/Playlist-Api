package com.bootcampweek4.playlist.models;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class Track {

    private String id;
    private String name;
    private String length;
    private String artist;

    public Track(String id, String name, String length, String artist) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.artist = artist;
    }
}
