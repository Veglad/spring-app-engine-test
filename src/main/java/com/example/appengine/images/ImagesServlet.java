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

package com.example.appengine.images;

import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// [START example]
@SuppressWarnings("serial")
@WebServlet(
        name = "images",
        urlPatterns = "/images")
public class ImagesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String bucket = req.getParameter("bucket");
        String image = req.getParameter("image");
        ImagesService imagesService = ImagesServiceFactory.getImagesService();
        ServingUrlOptions options =
                ServingUrlOptions.Builder.withGoogleStorageFileName("/gs/" + bucket + "/" + image)
                        .imageSize(150)
                        .crop(true)
                        .secureUrl(true);
        String url = imagesService.getServingUrl(options);

        PrintWriter out = resp.getWriter();
        out.println("<html><body>\n");
        out.println(
                "<img src='" + url + "'/>");
        out.println("</body></html>\n");
    }
}
