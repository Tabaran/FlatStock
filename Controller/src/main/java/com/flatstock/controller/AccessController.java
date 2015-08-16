package com.flatstock.controller;

import com.flatstock.model.Role;
import com.flatstock.service.AccessService;
import com.flatstock.service.impl.AccessServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.flatstock.controller.AccessController.*;

/**
 * Created by Valentin on 15.08.2015.
 */
@WebServlet(ACCESS_PATH)
public class AccessController extends HttpServlet {

    public static final String ACCESS_PATH = "/access";
    public static final String ACCESS_MAP = "accessMap";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccessService service = new AccessServiceImpl();
        request.setAttribute(ACCESS_MAP, service.getAccessMap());
        RequestDispatcher view = request.getRequestDispatcher("accessEditor.jsp");
        view.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccessService service = new AccessServiceImpl();
        Map<String, Set<Role>> accessMap =  service.getAccessMap();
        for(String url: accessMap.keySet()) {
            String[] checkedRoles = request.getParameterValues(url);
            Set<Role> roles = new HashSet<Role>();
            if(checkedRoles != null) {
                for (String r: checkedRoles){
                    roles.add(Role.fromString(r));
                }
            }
            service.updateAccess(url, roles);
        }
        response.sendRedirect(ACCESS_PATH);
    }
}
