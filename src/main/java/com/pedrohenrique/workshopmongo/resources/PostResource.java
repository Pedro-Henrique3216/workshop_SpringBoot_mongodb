package com.pedrohenrique.workshopmongo.resources;

import com.pedrohenrique.workshopmongo.domain.Post;
import com.pedrohenrique.workshopmongo.resources.util.URL;
import com.pedrohenrique.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="title", defaultValue="") String title){
        title = URL.decodeParam(title);
        List<Post> posts = service.FindByTitle(title);
        return ResponseEntity.ok().body(posts);
    }
}
