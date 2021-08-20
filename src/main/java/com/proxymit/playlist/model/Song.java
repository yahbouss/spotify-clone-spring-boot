package com.proxymit.playlist.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Getter
@Setter
public class Song {
    @Id
    @Field(value = "_id")
    private ObjectId _id;
    @Field(value = "songName")
    private String songName;
    @Field(value = "songUrl")
    private String songUrl;
    @Field(value = "songLength")
    private String songLength;
    @Field(value = "songArtist")
    private String songArtist;



    @PersistenceConstructor
    public Song(ObjectId _id, String songName, String songUrl, String songLength, String songArtist){
        this._id = _id;
        this.songName=songName;
        this.songLength=songLength;
        this.songUrl=songUrl;
        this.songArtist=songArtist;
    }

    public Song(String songName, String songUrl, String songLength, String songArtist){
        this._id=ObjectId.get();
        this.songName=songName;
        this.songUrl=songUrl;
        this.songLength=songLength;
        this.songArtist=songArtist;
    }
}
