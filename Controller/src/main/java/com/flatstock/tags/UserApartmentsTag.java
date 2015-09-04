package com.flatstock.tags;

import com.flatstock.model.IApartment;
import com.flatstock.service.ApartmentService;
import com.flatstock.service.impl.ApartmentServiceImpl;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.List;

/**
 * Created by vtabaran on 9/3/2015.
 */
public class UserApartmentsTag extends SimpleTagSupport {
    private Integer userId;

    public void setUserId(String userId) {
        this.userId = Integer.valueOf(userId);
    }

    public void doTag() throws JspException, IOException {
        ApartmentService service = new ApartmentServiceImpl();
        List<IApartment> apartmentsList = service.getApartmentsByOwnerId(userId);
        JspWriter out = getJspContext().getOut();
        out.write("<table class=\"table\">");
        if(apartmentsList != null ) {
            if (apartmentsList.size() > 0) {
                out.write("<thead><tr><th>Adress</th><th>Price</th><th>Description</th><th>Floor</th></tr></thead>");
            }
            for(IApartment apartment: apartmentsList){
                out.write("<tr>");
                out.write("<td>" + apartment.getAddress() + "</td>");
                out.write("<td>" + apartment.getPrice() + "</td>");
                out.write("<td>" + apartment.getDescription() + "</td>");
                out.write("<td>" + apartment.getFloor() + "</td>");
                out.write("</tr>");
            }
        }
        out.write("</table>");
    }

}
