package com.furiousgamerz.web.controllers;

import com.furiousgamerz.web.models.Publisher;
import com.furiousgamerz.web.repositories.PublisherRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublisherController {

    final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @PostMapping("/publishers")
    public Publisher createGenre(@RequestBody Publisher publisher) {
        publisherRepository.save(publisher);
        return publisher;
    }

    @GetMapping("/publishers")
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    @GetMapping("/publishers/{id}")
    public Publisher findOne(@PathVariable("id") Long id) {
        return publisherRepository.findById(id).get();
    }
}
