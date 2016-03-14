package com.theironyard.enitites;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    LocalDateTime treatmentDate;


    public Patient(String name, int age, String diagnosis, String acuPoints, String herbRx, LocalDateTime treatmentDate, Practitioner practitioner) {
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.acuPoints = acuPoints;
        this.herbRx = herbRx;
        this.treatmentDate = treatmentDate;
        this.practitioner = practitioner;
    }

    public Patient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getAcuPoints() {
        return acuPoints;
    }

    public void setAcuPoints(String acuPoints) {
        this.acuPoints = acuPoints;
    }

    public String getHerbRx() {
        return herbRx;
    }

    public void setHerbRx(String herbRx) {
        this.herbRx = herbRx;
    }

    public LocalDateTime getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(LocalDateTime treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public Practitioner getPractitioner() {
        return practitioner;
    }

    public void setPractitioner(Practitioner practitioner) {
        this.practitioner = practitioner;
    }

    @ManyToOne
    Practitioner practitioner;
}
