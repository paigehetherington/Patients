package com.theironyard.enitites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by vajrayogini on 3/10/16.
 */
@Entity
public class Patient {
    @Id
    @GeneratedValue
    int id;

    String name;
    int age;
    String diagnosis;
    String acuPoints;
    String herbRx;
    String treatmentDate;

    public Patient(String name, int age, String diagnosis, String acuPoints, String herbRx, String treatmentDate) {
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.acuPoints = acuPoints;
        this.herbRx = herbRx;
        this.treatmentDate = treatmentDate;
    }

    public Patient() {
    }

    @ManyToOne
    Practitioner practitioner;
}
