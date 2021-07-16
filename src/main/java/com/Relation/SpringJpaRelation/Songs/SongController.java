package com.Relation.SpringJpaRelation.Songs;

import com.Relation.SpringJpaRelation.Albums.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collections;
import java.util.List;

@Controller
public class SongController {
    @Autowired
  private  SongRepository songRepository;

    @GetMapping("/songs")
   public String getSongs(Model model){
        model.addAttribute("songs",songRepository.findAll());
        return "songs";}

//    @PostMapping("/songs")
//  public   Song createSong(@RequestBody Song song){return songRepository.save(song); }
@PostMapping("/songs")
public RedirectView createSong(@RequestParam String song_title,
                               @RequestParam int song_length,
                               @RequestParam Album album)
{
    Song songModel = new Song(song_title,song_length,album);
    Song savedSong = songRepository.save(songModel);
    return new RedirectView("/songs");
}


    @RequestMapping(value="/songs/{id}",method= RequestMethod.GET)
    public String getSong(Model model, @PathVariable (value ="id") Long id){
        List<Song> songById=songRepository.findAllById(Collections.singleton(1L));
        model.addAttribute("songs", songById);
        return "songs";
    }
}
