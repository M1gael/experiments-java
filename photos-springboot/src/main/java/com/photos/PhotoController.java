package com.photos;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class PhotoController {


    private final PhotoService photoService;


    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("photos" , photoService.getAllPhotos());
        return "home";
    }


    @PostMapping("/upload")
    public String uploadPhoto(@RequestParam("file")MultipartFile file , @RequestParam("description") String description){

        photoService.savePhoto(file, description);
        return "redirect:/";
    }


    @GetMapping("/photo/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getPhoto(@PathVariable Long id){

        Photo photo = photoService.getPhoto(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(photo.getContentType()))
                .body(photo.getData());
    }
}
