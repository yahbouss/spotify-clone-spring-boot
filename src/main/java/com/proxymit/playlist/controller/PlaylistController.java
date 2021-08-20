package com.proxymit.playlist.controller;


import com.proxymit.playlist.model.DataParser;
import com.proxymit.playlist.model.Playlist;
import com.proxymit.playlist.model.Song;
import com.proxymit.playlist.repository.PlaylistRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@ResponseBody
@Controller
@RequestMapping("/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistRepository playlistRepository;

    @GetMapping("/getAll")
    public List<Playlist> getAll(){
        return this.playlistRepository.findAll();
    }

    @PostMapping("/getPL")
    public List<Playlist> getPlay(@RequestBody DataParser data){
        System.out.println(data.name);
        return this.playlistRepository.getByPlaylistName(data.name);
    }

    @PostMapping("/create")
    public ObjectId createPl(@RequestBody DataParser data){
        Playlist playlist = new Playlist(data.name);
        this.playlistRepository.insert(playlist);
        return playlist.get_id();
    }

    @PostMapping("/remove")
    public void removePl(@RequestBody DataParser data){
        this.playlistRepository.removePlaylistByPlaylistName(data.name);
    }

    @PostMapping("/addSong")
    public void addSong(@RequestBody DataParser data){
        Playlist pl = this.playlistRepository.getByPlaylistName(data.name).get(0);
        Song song = new Song(data.songName, data.songUrl, data.songLength, data.songArtist);
        pl.addSong(song);
        this.playlistRepository.save(pl);
    }

//    @PostMapping("/removeSong")
//    public void removeSong(@RequestBody DataParser data){
//        Playlist pl = this.playlistRepository.getByPlaylistName(data.name).get(0);
//        Song song = new Song(data._id, data.songName, data.songUrl, data.songLength, data.songArtist);
//        pl.removeSong(song);
//        this.playlistRepository.save(pl);
//    }
}
