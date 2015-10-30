package com.flatstock.controller;

import com.flatstock.model.Id;
import com.flatstock.service.UserService;
import com.flatstock.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static com.flatstock.controller.PhotoController.*;
import static com.flatstock.model.Id.*;

/**
 * Created by Valentin on 30.08.2015.
 */
//@WebServlet(GET_PHOTO_PATH)
public class PhotoController extends HttpServlet {

    public static final String GET_PHOTO_PATH = "/get_photo";
    public static final String PHOTO = "photo";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = new UserServiceImpl();
        BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
        String path = request.getParameter(PHOTO);
        response.setContentType("image/gif");
        service.showPhoto(Integer.valueOf(request.getParameter(ID)), path, output);

    }
}
