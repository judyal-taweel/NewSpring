package com.Relation.SpringJpaRelation.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/")
    public String homePage() throws IOException{
//        Song song = new Song();
//        song.jsonSongs();
        return "home";
    }

    @GetMapping("/signup")
    public String getSignupPage(){
        return "signup";
    }

    @GetMapping("/login")
    public String getLoginPge(){
        return "logIn";
    }

    @GetMapping("/profile")
    public String getProfilePage(Model model){
        UserDetails userDetails= (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        model.addAttribute("username",userDetails.getUsername());
        return "profile";
    }

    @PostMapping("/login")
    public RedirectView tryLogin(@RequestParam String username,@RequestParam String password){
        Users user = new Users(username,password);
        user= userRepository.save(user);

        Authentication authentication= new UsernamePasswordAuthenticationToken(user,null,new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/");
    }

    @PostMapping("/signup")
    public RedirectView trySignUp(@RequestParam String firstName,
                                  @RequestParam String lastName,
                                  @RequestParam String username,
                                  @RequestParam String password){
        Users newUser = new Users(firstName,lastName,username,password);
        newUser = userRepository.save(newUser);

        Authentication authentication= new UsernamePasswordAuthenticationToken(newUser,null,new ArrayList<>());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new RedirectView("/");
    }

}
