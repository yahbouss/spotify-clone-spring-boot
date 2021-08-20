package com.proxymit.playlist.repository;

import com.proxymit.playlist.model.Playlist;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PlaylistRepository extends MongoRepository<Playlist, ObjectId> {
    @Query
    List<Playlist> getByPlaylistName(String PlaylistName);
    @Query
    void removePlaylistByPlaylistName(String PlaylistName);
}
