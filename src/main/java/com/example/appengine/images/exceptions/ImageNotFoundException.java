package com.example.appengine.images.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ImageNotFoundException extends RuntimeException {

    private String imageUrl;

    public ImageNotFoundException(String imageUrl) {
        super("Image not found for url: " + imageUrl);

        this.imageUrl = imageUrl;
    }
}
