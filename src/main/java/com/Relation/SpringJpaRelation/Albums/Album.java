package com.Relation.SpringJpaRelation.Albums;
import com.Relation.SpringJpaRelation.Songs.Song;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long album_id;

    private String album_title;
    private String album_artist;
    private String album_duration;
    private String album_img;
    private int album_length;


    @OneToMany(mappedBy = "album")
    private List<Song> song;

    public Album(String album_title, String album_artist, String album_duration, String album_img, int album_length) {
        this.album_title = album_title;
        this.album_artist = album_artist;
        this.album_duration = album_duration;
        this.album_img = album_img;
        this.album_length = album_length;
    }

    public Album() {

    }

    public List<Song> getSong() {
        return song;
    }

    public void setSong(List<Song> song) {
        this.song = song;
    }

    public Long getAlbum_id() {
        return album_id;
    }

    public String getAlbum_title() {
        return album_title;
    }

    public void setAlbum_title(String album_title) {
        this.album_title = album_title;
    }

    public String getAlbum_artist() {
        return album_artist;
    }

    public void setAlbum_artist(String album_artist) {
        this.album_artist = album_artist;
    }

    public String getAlbum_duration() {
        return album_duration;
    }

    public void setAlbum_duration(String album_duration) {
        this.album_duration = album_duration;
    }

    public int getAlbum_length() {
        return album_length;
    }

    public void setAlbum_length(int album_length) {
        this.album_length = album_length;
    }

    public String getAlbum_img() {
        return album_img;
    }

    public void setAlbum_img(String album_img) {
        this.album_img = album_img;
    }
}
