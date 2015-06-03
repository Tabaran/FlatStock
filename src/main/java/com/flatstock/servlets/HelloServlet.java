package com.flatstock.servlets;

import com.flatstock.dao.ApartmentDao;
import com.flatstock.dao.ApartmentDaoImpl;
import com.flatstock.model.IApartment;
import com.flatstock.utils.db.ConnectionProvider;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/s")
public class HelloServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException
    {
        // Do required initialization
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        ApartmentDao apartment = new ApartmentDaoImpl();
        ConnectionProvider provider = new ConnectionProvider();

        out.println("<h1>" + provider.getConnection() + "</h1>");
    }

    public void destroy()
    {
        // do nothing.
    }
}