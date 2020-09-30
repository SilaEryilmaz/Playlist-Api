package com.bootcampweek4.playlist.repository;

import com.bootcampweek4.playlist.models.Playlist;
import com.bootcampweek4.playlist.models.Track;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.query.QueryResult;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistRepository {

    private final Cluster couchbaseCluster;
    private final Collection playlistCollection;


    public PlaylistRepository(Cluster couchbaseCluster, Collection playlistCollection) {
        this.couchbaseCluster = couchbaseCluster;
        this.playlistCollection = playlistCollection;
    }

    public void create(String userId, Playlist playlist){
        playlistCollection.insert(userId, playlist);

    }

    public Playlist findById(String id){
        GetResult getResult = playlistCollection.get(id);
        Playlist playlist = getResult.contentAs(Playlist.class);
        return playlist;

    }

    public List<Playlist> findAllByUserId(String userId){
        String statement = String.format("Select id,name,description,followersCount,trackCount,userId,tracks from playlist where userId='%s'",userId);
        QueryResult query = couchbaseCluster.query(statement);
        return query.rowsAs(Playlist.class);

    }

    public void delete(String id){

          playlistCollection.remove(id);
    }

    public void addTrack(String id, Track addingTrack){
        Playlist playlist =  findById(id);
        
        playlist.getTracks().add(addingTrack);
        playlist.setTrackCount(playlist.getTrackCount()+1);
        playlistCollection.replace(playlist.getId(),playlist);
    }

    public void deleteTrack(String id, String trackId){
        Playlist playlist =  findById(id);

        for(Track track : playlist.getTracks()){
            if(track.getId().equals(trackId)){
                playlist.getTracks().remove(track);
            }
        }
        playlist.setTrackCount(playlist.getTrackCount()-1);
        playlistCollection.replace(playlist.getId(),playlist);
    }
}
