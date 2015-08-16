package com.flatstock.controller;

import com.flatstock.service.AccessService;
import com.flatstock.service.impl.AccessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static com.flatstock.controller.RemoveUrlController.*;
import static com.flatstock.controller.AddUrlController.*;
import static com.flatstock.controller.AccessController.*;

/**
 * Created by Valentin on 16.08.2015.
 */
@WebServlet(REMOVE_URL_PATH)
public class RemoveUrlController extends HttpServlet {
    public static final String REMOVE_URL_PATH = "/removeUrl";


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccessService service = new AccessServiceImpl();
        service.removeUrl(request.getParameter(URL));
        response.sendRedirect(ACCESS_PATH);
    }
}
