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

package com.example.appengine.images.servlet;

import com.example.appengine.images.service.ImageServingUrlService;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "imageServingUrl", urlPatterns = "/image/serving-url")
public class ImagesServlet extends HttpServlet {

    @Inject
    ImageServingUrlService imagesService = new ImageServingUrlService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String bucket = req.getParameter("bucket");
        String image = req.getParameter("image");

        String url = imagesService.getServingUrl(bucket, image);

        PrintWriter out = resp.getWriter();
        out.print(url);
        out.close();
    }
}
