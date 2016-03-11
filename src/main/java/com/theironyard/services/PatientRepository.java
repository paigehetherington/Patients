package com.theironyard.services;

import com.theironyard.enitites.Patient;
import com.theironyard.enitites.Practitioner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vajrayogini on 3/10/16.
 */
public interface PatientRepository extends CrudRepository<Patient, Integer> {
Patient findByPractitioner(Practitioner practitioner);
}
