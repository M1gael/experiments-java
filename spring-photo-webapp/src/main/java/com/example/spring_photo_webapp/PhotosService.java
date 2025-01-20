package com.example.spring_photo_webapp;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//@Component works same as Service just not as readable
@Service
public class PhotosService { // For the simple purpose of handling our database

    private Map<String , Photo> db = new HashMap<>(){{
        put("1" , new Photo("1" , "hello.jpg"));
    }};
}
