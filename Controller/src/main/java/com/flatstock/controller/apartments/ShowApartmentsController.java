package com.flatstock.controller.apartments;


import com.flatstock.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.io.*;
import static com.flatstock.model.Apartment.*;

@Controller
@Scope("request")
public class ShowApartmentsController {

    public static final String APARTMENTS_PATH = "/apartments";

    @Autowired
    ApartmentService apartmentService;

    @RequestMapping(value=APARTMENTS_PATH)
    public ModelAndView showApartments() throws IOException {
        return new ModelAndView(APARTMENTS, APARTMENTS, apartmentService.getAllApartments());
    }

}
