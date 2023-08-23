package com.springpedro.course.services;

import com.springpedro.course.entities.User;
import com.springpedro.course.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired // Faz a Injeção de dependencias de forma automatica e trasnparente
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);

        return obj.get();
    }

    public User insert(User userObj) {
        return repository.save(userObj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
