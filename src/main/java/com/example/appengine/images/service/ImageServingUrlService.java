/*
 * Copyright 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.appengine.images.service;

import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;

import javax.annotation.ManagedBean;


@ManagedBean
public class ImageServingUrlService {

    private final ImagesService imagesService = ImagesServiceFactory.getImagesService();

    public String getServingUrl(String bucket, String imageUrl) {
        verifyNotBlank(bucket, "bucket");
        verifyNotBlank(imageUrl, "imageUrl");

        ServingUrlOptions options = ServingUrlOptions.Builder
                .withGoogleStorageFileName("/gs/" + bucket + "/" + imageUrl)
                .secureUrl(true);
//        return imagesService.getServingUrl(options);

        throw new RuntimeException("Any error");
    }

    private void verifyNotBlank(String value, String fieldErrorName) {
        if (value == null) {
            throw new IllegalArgumentException(fieldErrorName + " must be not null");
        }

        if (value.isEmpty()) {
            throw new IllegalArgumentException(fieldErrorName + " must be not blank");
        }
    }
}
