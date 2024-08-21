package com.aksahi.patientMicroService.Mappers;

import com.aksahi.patientMicroService.Entities.Patient;
import com.aksahi.patientMicroService.dto.PatientDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PatientMapper {
    Patient patientDTOToPatient(PatientDTO patientDtp);
    PatientDTO patientToPatientDto(Patient patient);
}
