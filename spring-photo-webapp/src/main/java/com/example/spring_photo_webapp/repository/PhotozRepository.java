package com.example.spring_photo_webapp.repository;

import com.example.spring_photo_webapp.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotozRepository extends CrudRepository<Photo, Integer>{ // predefined sql statements
}
