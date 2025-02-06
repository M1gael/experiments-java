package com.example.spring_photo_webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("PHOTOZ") // Photos class lives in the photos table
public class Photo {

    @Id
    private int id;

    @NotEmpty
    private String fileName;

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    private String contentType;

    @JsonIgnore
    private byte[] data;


    // Default constructor (needed by frameworks like Jackson)
    public Photo() {
    }


    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }


    public String getContentType() {
        return contentType;
    }


    // Getter for fileName
    public String getFileName() {
        return fileName;
    }


    // Setter for fileName
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public byte[] getData() {
        return data;
    }


    public void setData(byte[] data) {
        this.data = data;
    }


}
