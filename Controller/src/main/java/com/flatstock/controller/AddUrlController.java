package com.flatstock.controller;

import com.flatstock.service.AccessService;
import com.flatstock.service.impl.AccessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.flatstock.controller.AddUrlController.*;

@WebServlet(ADD_URL_PATH)
public class AddUrlController extends HttpServlet {

    public static final String ADD_URL_PATH = "/addUrl";
    public static final String URL = "url";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccessService service = new AccessServiceImpl();
        service.addUrl(request.getParameter(URL));
        response.sendRedirect("/access");
    }
}
