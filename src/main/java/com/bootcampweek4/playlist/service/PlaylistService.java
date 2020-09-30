package com.bootcampweek4.playlist.service;

import com.bootcampweek4.playlist.models.Playlist;
import com.bootcampweek4.playlist.models.Track;
import com.bootcampweek4.playlist.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlaylistService {


    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {

        this.playlistRepository = playlistRepository;
    }


    public void createPlaylist(Playlist playlist) {

        playlistRepository.create(playlist.getId(), playlist);
    }

    public Playlist findById(String playlistId) {

        Playlist playlist = playlistRepository.findById(playlistId);
        return playlist;
    }

    public List<Playlist> findAllByUserId(String userId) {

        return playlistRepository.findAllPlaylistByUserId(userId);
    }

    public void deletePlaylist(String id) {

        playlistRepository.delete(id);

    }

    public void addTrack(String id, Track track){

        playlistRepository.addTrack(id,track);
    }

    public void deleteTrack(String id, String trackId){

        playlistRepository.deleteTrack(id,trackId);
    }

}




