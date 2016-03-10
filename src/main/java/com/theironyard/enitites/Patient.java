package com.theironyard.enitites;

import javax.persistence.*;

/**
 * Created by vajrayogini on 3/10/16.
 */
@Entity
public class Patient {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    int age;
    @Column(nullable = false)
    String diagnosis;
    @Column(nullable = false)
    String acuPoints;
    @Column(nullable = false)
    String herbRx;
    @Column(nullable = false)
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
