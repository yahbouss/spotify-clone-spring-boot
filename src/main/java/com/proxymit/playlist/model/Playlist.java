package com.proxymit.playlist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.*;

@Data
@Getter
@Setter
@Document(collection = "Playlist")
public class Playlist {
    @Id
    @Field(value = "_id")
    private ObjectId _id;
    @Field(value = "playlistName")
    private String playlistName;
    @Field(value = "playlistSongs")
//    @DBRef
    private List<Song> playlistSongs;

    @PersistenceConstructor
    public Playlist(ObjectId _id, String playlistName, List<Song> playlistSongs){
        this._id=_id;
        this.playlistName=playlistName;
        this.playlistSongs=playlistSongs;
    }

    public Playlist(String name){
        this._id=ObjectId.get();
        this.playlistName=name;
        this.playlistSongs = new ArrayList<Song>();
    }

    public void addSong(Song song){
        this.playlistSongs.add(song);
    }

//    public void removeSong(String name){
//        this.playlistSongs.
//        this.playlistSongs.remove(song);
//    }

}
