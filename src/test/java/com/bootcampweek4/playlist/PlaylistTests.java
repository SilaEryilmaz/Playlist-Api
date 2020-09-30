package com.bootcampweek4.playlist;

import com.bootcampweek4.playlist.models.Playlist;
import com.bootcampweek4.playlist.models.Track;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaylistTests {


    @Test
    public void addTrackToPlaylist_WhenGivenPlaylistId() {

        //Arrange
        Playlist sut = new Playlist("MySongs", "My Fav Songs", 10, "user_sila");
        Track track = new Track("Feels Like We Only Go Backward", "3:12", "Tame Impala");

        //Act
        sut.addTrack(track);

        //Assert
        assertThat(sut.getTrackCount()).isEqualTo(1);
    }

    @Test
    public void removeTrackFromPlaylist_WhenTheGivenTrackId() {

        //Arrange
        Playlist sut = new Playlist("MySongs", "My Fav Songs", 10, "user_sila");
        Track track = new Track("Feels Like We Only Go Backward", "3:12", "Tame Impala");

        //Act
        sut.addTrack(track);
        sut.removeTrack(track.getId());

        //Assert
        assertThat(sut.getTrackCount()).isEqualTo(0);
    }

}

