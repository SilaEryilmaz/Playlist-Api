package com.bootcampweek4.playlist.config;


import com.couchbase.client.java.Cluster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class IndexConfiguration {

    private final Cluster couchbaseCluster;
    private final CouchbaseProperties couchbaseProperties;

    public IndexConfiguration(Cluster couchbaseCluster, CouchbaseProperties couchbaseProperties) {
        this.couchbaseCluster = couchbaseCluster;
        this.couchbaseProperties = couchbaseProperties;
    }
    @Bean
    public void createIndexes() {

        // couchbaseCluster.query("CREATE INDEX playlistId ON `Playlist`(Playlist.id);");
        //  couchbaseCluster.query("CREATE INDEX playlistUserId ON `Playlist`(Playlist.userId);");

    }

}
