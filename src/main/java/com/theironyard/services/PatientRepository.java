package com.theironyard.services;


import com.theironyard.enitites.Patient;
import com.theironyard.enitites.Practitioner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by vajrayogini on 3/10/16.
 */
public interface PatientRepository extends PagingAndSortingRepository<Patient, Integer> {
    Page<Patient> findByPractitioner(Pageable pageable, Practitioner practitioner);
    Page<Patient> findAll(Pageable pageable);
    //List<Patient> findAllSortByNameStartingWithDesc(String name);
}
