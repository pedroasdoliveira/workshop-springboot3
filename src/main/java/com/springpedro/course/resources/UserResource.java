package com.springpedro.course.resources;

import com.springpedro.course.entities.User;

import com.springpedro.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired // Faz a Injeção de dependencias de forma automatica e trasnparente
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User userObj = service.findById(id);

        return ResponseEntity.ok().body(userObj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj) {
         obj = service.insert(obj);
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }
}
