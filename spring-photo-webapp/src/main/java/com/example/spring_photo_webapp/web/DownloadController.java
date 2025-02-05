package com.example.spring_photo_webapp.web;

import com.example.spring_photo_webapp.model.Photo;
import com.example.spring_photo_webapp.service.PhotosService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {

    private final PhotosService photosService; // Constructor injection same as done in Photos controller

    public DownloadController(PhotosService photosService) {
        this.photosService = photosService;
    }


    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id){

        Photo photo = photosService.get(id);
        if (photo == null){throw new ResponseStatusException(HttpStatus.NOT_FOUND);}

        byte[] data = photo.getData(); // Download the file

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition build = ContentDisposition.builder("attachment")
                .filename(photo.getFileName()) // Get the file name
                .build();
        headers.setContentDisposition(build); // Set it as header

        return new ResponseEntity<>(data , headers , HttpStatus.OK); // Send it back to the browser
    }
}
