package com.example.spring_photo_webapp.service;

import com.example.spring_photo_webapp.model.Photo;
import com.example.spring_photo_webapp.repository.PhotozRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@Component works same as Service just not as readable
@Service
public class PhotosService { // For the simple purpose of handling our database

    private final PhotozRepository photozRepository;

    public PhotosService(PhotozRepository photozRepository){
        this.photozRepository = photozRepository;
    }

    public Iterable<Photo> get(){
        return photozRepository.findAll();
    }

    public Photo get(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photozRepository.deleteById(id);
    }

    public Photo save(String fileName , String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photozRepository.save(photo);
        return photo;
    }
}
