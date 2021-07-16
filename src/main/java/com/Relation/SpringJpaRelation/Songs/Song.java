package com.Relation.SpringJpaRelation.Songs;

import com.Relation.SpringJpaRelation.Albums.Album;
import com.Relation.SpringJpaRelation.Songs.Song;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long song_id;

    private String song_title;
    private int song_length;

    @ManyToOne
    @JoinColumn(name="album_id")
    private Album album;

    public Song(String song_title, int song_length, Album album) {
        this.song_title = song_title;
        this.song_length = song_length;
        this.album = album;
    }
    public Song(){}

    public Long getSong_id() {
        return song_id;
    }

    public String getSong_title() {
        return song_title;
    }

    public void setSong_title(String song_title) {
        this.song_title = song_title;
    }

    public int getSong_length() {
        return song_length;
    }

    public void setSong_length(int song_length) {
        this.song_length = song_length;
    }
}
