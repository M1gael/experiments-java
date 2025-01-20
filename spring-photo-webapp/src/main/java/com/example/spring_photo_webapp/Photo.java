package com.example.spring_photo_webapp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;

public class Photo {

    private String id;

    @NotEmpty
    private String fileName;

    @JsonIgnore
    private byte[] data;
    // Default constructor (needed by frameworks like Jackson)
    public Photo() {
    }


    // Parameterized constructor
    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    // Getter for id
    public String getId() {
        return id;
    }

    // Setter for id
    public void setId(String id) {
        this.id = id;
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
