package com.example.spring_photo_webapp.web;

import java.io.IOException;
import java.util.*;

import com.example.spring_photo_webapp.model.Photo;
import com.example.spring_photo_webapp.service.PhotosService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController // Tells spring that this class is the RestController
public class PhotosController {

    private final PhotosService photosService; // This is known as constructor injection


    public PhotosController(PhotosService photosService) {
        this.photosService = photosService; // Constructor to receive a photos service and set it to the class.
    }


    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }


    @GetMapping("/photoz")
    public Iterable<Photo> get(){
        return photosService.get();
    }


    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable Integer id){
        Photo photo = photosService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }


    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable Integer id){
        photosService.remove(id);
    }


    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photosService.save(file.getOriginalFilename(), file.getContentType() ,file.getBytes());
    }

}
