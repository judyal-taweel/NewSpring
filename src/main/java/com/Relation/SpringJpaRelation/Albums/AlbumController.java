package com.Relation.SpringJpaRelation.Albums;

import com.Relation.SpringJpaRelation.Songs.Song;
import com.Relation.SpringJpaRelation.Songs.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.List;
@Controller
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private SongRepository songRepository;
    @GetMapping("/")
    public String getAllAlbum(Model model){
        Album albumModel1 = new Album("Moonlight","maichle","5:30","https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.RMdFUfNe1i78pwWbJg81KAHaHa%26pid%3DApi&f=1",7);
        Album albumModel2 = new Album("Spring","jones","6:02","https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.mJ4hrNKMi7lHaXdcbkVwiAHaHa%26pid%3DApi&f=1",6);
        Album albumModel3 = new Album("Sun Raise","john","4:15","https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse3.mm.bing.net%2Fth%3Fid%3DOIP.BIlkqO504KYHLj__I7ufQgHaHa%26pid%3DApi&f=1",15);
        List albumModels = Arrays.asList(new Album[]{albumModel1, albumModel2, albumModel3});
        albumRepository.saveAll(albumModels);
        model.addAttribute("albums", albumRepository.findAll());
        return "index";
    }
    @GetMapping("/albums")
    public String getalbum(Model model){

        model.addAttribute("albums", albumRepository.findAll());
        return "albums";
    }

    //    @GetMapping("/")
//    public String getAlbums(Model model){
//        model.addAttribute("albums",albumRepository.findAll());
//        return "albums";
//    }
    @PostMapping("/albums")
    public RedirectView createAlbum(@RequestParam String album_title,@RequestParam String album_artist, @RequestParam String album_duration, @RequestParam String album_img, @RequestParam int album_length){
        Album albumModel = new Album(album_title,album_artist,album_duration,album_img,album_length);
        albumRepository.save(albumModel);
        return new RedirectView("/albums");

    }
    @RequestMapping(value="/album/song/{id}",method= RequestMethod.GET)
    public String getAlbum(Model model, @PathVariable (value ="id") Long id){
        Album album = albumRepository.getById(id);
        model.addAttribute("songs",album.getSong());
        return "albumsongs";
    }

    @RequestMapping(value="/album/{id}",method= RequestMethod.GET)
    public String getone(Model model, @PathVariable (value ="id") Long id){
        Album albumbyId=albumRepository.getById(id);
        model.addAttribute("albums",albumbyId);
        return "albums";
    }
}