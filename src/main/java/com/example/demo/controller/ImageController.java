package com.example.demo.controller;

import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @RequestMapping("/image-url")
    public ImageUrlDto hello(@RequestParam String bucket, @RequestParam String image) {
        ServingUrlOptions options = ServingUrlOptions.Builder
                .withGoogleStorageFileName(String.format("/gs/%s/%s", bucket, image));
        return new ImageUrlDto(ImagesServiceFactory.getImagesService().getServingUrl(options));
    }


}

class ImageUrlDto {
    String url;

    public ImageUrlDto(String url) {
        this.url = url;
    }
}