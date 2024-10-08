package com.aksahi.patientMicroService.Service;

import com.aksahi.patientMicroService.dto.PatientDTO;

import java.util.List;

public interface PatientService {
    List<PatientDTO> getAllPatients();
    PatientDTO getPatientById(Long id);
    PatientDTO createPatient(PatientDTO patientDTO);
    PatientDTO updatePatient(Long id,PatientDTO patientDTO);
    void deletePatient(Long id);
}
