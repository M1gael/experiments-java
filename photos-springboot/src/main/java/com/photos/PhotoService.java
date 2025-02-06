package com.photos;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;

    public Photo savePhoto(MultipartFile file , String description ){
        Photo photo = new Photo();
        photo.setName(file.getOriginalFilename());
        photo.setContentType(file.getContentType());
        try {photo.setData(file.getBytes());} catch (IOException e){}
        photo.setDescription(description);
        photo.setUploadtime(LocalDateTime.now()); // All these methods in the photos class were created automatically by lombok because we used the @Data annotation

        return photoRepository.save(photo);
    }


    public Photo getPhoto(Long id){
        return photoRepository.findById(id).orElseThrow(() -> new RuntimeException("Photo not found"));
    }


    public List<Photo> getAllPhotos(){
        return photoRepository.findAll();
    }
}
