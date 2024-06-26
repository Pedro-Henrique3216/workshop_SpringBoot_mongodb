package com.pedrohenrique.workshopmongo.services;

import com.pedrohenrique.workshopmongo.domain.User;
import com.pedrohenrique.workshopmongo.dto.UserDTO;
import com.pedrohenrique.workshopmongo.repository.UserRepository;
import com.pedrohenrique.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user){
        return repository.insert(user);
    }

    public User update(User user) {
        User newUser = findById(user.getId());
        updateData(newUser, user);
        return repository.save(newUser);
    }
    public void delete(String id){
        findById(id);
        repository.deleteById(id);
    }

    public User fromDTO(UserDTO dto){
        return new User(dto.id(), dto.name(), dto.email());
    }

    public void updateData(User newUser, User user){
        if(user.getName() != null){
            newUser.setName(user.getName());
        }
        if(user.getEmail() != null){
            newUser.setEmail(user.getEmail());
        }
    }
}
