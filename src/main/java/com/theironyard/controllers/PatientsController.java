package com.theironyard.controllers;

import com.theironyard.enitites.Patient;
import com.theironyard.enitites.Practitioner;
import com.theironyard.services.PatientRepository;
import com.theironyard.services.PractitionerRepository;
import com.theironyard.utils.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

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
        model.addAttribute(patients.findAll());
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName, String password) throws Exception {
        Practitioner practitioner = practitioners.findByUserName(userName);
        if (practitioner == null) {
            practitioner = new Practitioner(userName, PasswordStorage.createHash(password));
            practitioners.save(practitioner);
        }
        else if (!PasswordStorage.verifyPassword(password, practitioner.getPasswordHash())) {
            throw new Exception("Incorrect password");
        }
        session.setAttribute("userName", userName);

        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/create-patient", method = RequestMethod.POST)
    public String createPatient(HttpSession session, String name, int age, String diagnosis, String acuPoints, String herbRx, String treatmentDate) {
        String userName = (String) session.getAttribute("userName");
        Practitioner practitioner = practitioners.findByUserName(userName);
        Patient patient = new Patient(name, age, diagnosis, acuPoints, herbRx, treatmentDate);
        patients.save(patient);
        return "redirect:/";

    }

    @RequestMapping(path = "/delete-patient", method = RequestMethod.POST)
    public String deletePatient(HttpSession session, Integer id) {
        patients.delete(id);
        return "redirect:/";
    }

}


