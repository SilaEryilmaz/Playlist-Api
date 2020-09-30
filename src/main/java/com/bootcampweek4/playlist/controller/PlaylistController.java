package com.bootcampweek4.playlist.controller;

import com.bootcampweek4.playlist.models.Playlist;
import com.bootcampweek4.playlist.models.Track;
import com.bootcampweek4.playlist.service.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;


    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity<Void> createPlaylist(@RequestBody Playlist playlist) {
        playlistService.createPlaylist(playlist);
        return ResponseEntity.ok().build();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Playlist> findById(@PathVariable ("id") String id) {
        Playlist playlist = playlistService.findById(id);
        return ResponseEntity.ok().body(playlist);
    }


    @GetMapping
    public ResponseEntity<List<Playlist>> findAllPlaylists(@RequestParam("userId") String userId) {
        List<Playlist> playlists = playlistService.findAllByUserId(userId);
        return ResponseEntity.ok(playlistService.findAllByUserId(userId));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePlayList(@PathVariable String id) {

        playlistService.deletePlaylist(id);
        return ResponseEntity.ok().build();

    }

    @PostMapping("{id}/tracks")
    public ResponseEntity<Void> addTrack(@PathVariable String id, @RequestBody Track track) {

            playlistService.addTrack(id, track);
            return ResponseEntity.ok().build();

        }



    @DeleteMapping("{id}/tracks")
    public ResponseEntity<Void> deleteTrack(@PathVariable String id, @RequestBody String trackId) {

            playlistService.deleteTrack(id, trackId);
            return ResponseEntity.ok().build();


    }

}
