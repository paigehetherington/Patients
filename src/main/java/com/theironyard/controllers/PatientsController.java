package com.theironyard.controllers;

import com.theironyard.services.PatientRepository;
import com.theironyard.services.PractitionerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;

/**
 * Created by vajrayogini on 3/10/16.
 */
@Controller
public class PatientsController {

    @Autowired
    PractitionerRepository practitioners;

    @Autowired
    PatientRepository patients;

    @PostConstruct
    public void init() {

    }


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }

}


