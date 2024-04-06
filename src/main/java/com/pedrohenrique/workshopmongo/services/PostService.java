package com.pedrohenrique.workshopmongo.services;

import com.pedrohenrique.workshopmongo.domain.Post;
import com.pedrohenrique.workshopmongo.repository.PostRepository;
import com.pedrohenrique.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> FindByTitle(String title){
        return repository.findByTitle(title);
    }
}
